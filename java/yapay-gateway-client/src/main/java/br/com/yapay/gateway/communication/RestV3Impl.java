package br.com.yapay.gateway.communication;

import static org.apache.commons.codec.binary.Base64.encodeBase64String;
import static org.apache.commons.lang3.StringUtils.defaultString;
import static org.apache.commons.lang3.StringUtils.trimToNull;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;

import br.com.yapay.gateway.model.Credential;
import br.com.yapay.gateway.model.OneClickRegisterData;
import br.com.yapay.gateway.model.RecurringPayment;
import br.com.yapay.gateway.model.Transaction;

public class RestV3Impl implements RestV3 {

	private final String communicationUrl;

	private final Gson jsonBuilder;

	public RestV3Impl(String url) throws ClientProtocolException, IOException {
		this.communicationUrl = url;
		this.jsonBuilder = new Gson();
	}

	private String postJsonAuth(Credential credential, String url, String data)
			throws ClientProtocolException, IOException {
		data = defaultString(data);
		HttpPost post = new HttpPost(url);

		post.setEntity(new BufferedHttpEntity(
				new InputStreamEntity(new ByteArrayInputStream(data.getBytes()), data.length())));
		post.setHeader("Accept", "application/json");
		post.setHeader("Accept-Charset", "UTF-8");
		post.setHeader("Content-Type", "application/json; charset=UTF-8");

		return requestBasicAuth(post, credential);
	}

	private String putJsonAuth(Credential credential, String url, String data)
			throws ClientProtocolException, IOException {
		data = defaultString(data);
		HttpPut put = new HttpPut(url);

		put.setEntity(new BufferedHttpEntity(
				new InputStreamEntity(new ByteArrayInputStream(data.getBytes()), data.length())));
		put.setHeader("Accept", "application/json");
		put.setHeader("Accept-Charset", "UTF-8");
		put.setHeader("Content-Type", "application/json; charset=UTF-8");

		return requestBasicAuth(put, credential);
	}

	private String getJsonAuth(Credential credential, String url) throws ClientProtocolException, IOException {
		HttpGet get = new HttpGet(url);

		get.setHeader("Accept", "application/json");
		get.setHeader("Accept-Charset", "UTF-8");

		return requestBasicAuth(get, credential);
	}

	private String requestBasicAuth(HttpUriRequest request, Credential credential)
			throws ClientProtocolException, IOException {
		String encoded = String.valueOf(encodeBase64String(
				(trimToNull(credential.getUser()) + ":" + trimToNull(credential.getPassword())).getBytes()));
		request.addHeader("Authorization", " Basic " + encoded);

		return requestHttpClient(request);
	}

	private String requestHttpClient(HttpUriRequest request) throws ClientProtocolException, IOException {
		String result = null;

		int connectionTimeout = 73_000;
		int readTimeout = 10 * connectionTimeout;
		RequestConfig config = RequestConfig.custom().setConnectTimeout(connectionTimeout).setSocketTimeout(readTimeout)
				.build();
		try (CloseableHttpClient client = HttpClientBuilder.create().setDefaultRequestConfig(config).build()) {
			result = executeRequestHttpClient(client, request);
		}
		return result;
	}

	private String executeRequestHttpClient(HttpClient client, HttpUriRequest request)
			throws ClientProtocolException, IOException {
		HttpResponse response = client.execute(request);
		return response.getEntity() == null ? null : EntityUtils.toString(response.getEntity());
	}

	@Override
	public String transactionAuthorize(Credential credential, Transaction transaction)
			throws ClientProtocolException, IOException {
		return postJsonAuth(credential, communicationUrl + "/api/v3/transacao", jsonBuilder.toJson(transaction));
	}

	@Override
	public String transactionQuery(Credential credential, Long transactionNumber)
			throws ClientProtocolException, IOException {
		return transactionQuery(credential, credential.getStoreCode(), transactionNumber);
	}

	@Override
	public String transactionQuery(Credential credential, String storeCode, Long transactionNumber)
			throws ClientProtocolException, IOException {
		return getJsonAuth(credential, communicationUrl + "/api/v3/transacao/" + storeCode + "/" + transactionNumber);
	}

	@Override
	public String transactionCapture(Credential credential, Long transactionNumber, Long value)
			throws ClientProtocolException, IOException {
		return transactionCapture(credential, credential.getStoreCode(), transactionNumber, value);
	}

	@Override
	public String transactionCapture(Credential credential, String storeCode, Long transactionNumber, Long value)
			throws ClientProtocolException, IOException {
		String valueParameter = "";

		if (value != null && value > 0) {
			valueParameter = "?valor=" + value.toString();
		}

		return putJsonAuth(credential, communicationUrl + "/api/v3/transacao/" + storeCode + "/" + transactionNumber
				+ "/capturar" + valueParameter, null);
	}

	@Override
	public String transactionCancel(Credential credential, Long transactionNumber, Long value)
			throws ClientProtocolException, IOException {
		return transactionCancel(credential, credential.getStoreCode(), transactionNumber, value);
	}

	@Override
	public String transactionCancel(Credential credential, String storeCode, Long transactionNumber, Long value)
			throws ClientProtocolException, IOException {
		String valueParameter = "";

		if (value != null && value > 0) {
			valueParameter = "?valor=" + value.toString();
		}

		return putJsonAuth(credential, communicationUrl + "/api/v3/transacao/" + storeCode + "/" + transactionNumber
				+ "/cancelar" + valueParameter, null);
	}

	@Override
	public String oneClickRegister(Credential credential, OneClickRegisterData registerData)
			throws ClientProtocolException, IOException {
		return postJsonAuth(credential, communicationUrl + "/api/v3/oneclick", jsonBuilder.toJson(registerData));
	}

	@Override
	public String oneClickQuery(Credential credential, String token) throws ClientProtocolException, IOException {
		return getJsonAuth(credential, communicationUrl + "/api/v3/oneclick/" + token);
	}

	@Override
	public String oneClickRegisterUpdate(Credential credential, String token, OneClickRegisterData registerData)
			throws ClientProtocolException, IOException {
		return putJsonAuth(credential, communicationUrl + "/api/v3/oneclick/" + token + "/alterar",
				jsonBuilder.toJson(registerData));
	}

	@Override
	public String oneClickAuthorize(Credential credential, String token, Transaction transaction)
			throws ClientProtocolException, IOException {
		return postJsonAuth(credential, communicationUrl + "/api/v3/oneclick/" + token + "/autorizar",
				jsonBuilder.toJson(transaction));
	}

	@Override
	public String recurringPaymentRegister(Credential credential, RecurringPayment recurringPayment)
			throws ClientProtocolException, IOException {
		return postJsonAuth(credential, communicationUrl + "/api/v3/recorrencia", jsonBuilder.toJson(recurringPayment));
	}

	@Override
	public String recurringPaymentQuery(Credential credential, Long recurringPaymentNumber)
			throws ClientProtocolException, IOException {
		return recurringPaymentQuery(credential, credential.getStoreCode(), recurringPaymentNumber);
	}

	@Override
	public String recurringPaymentQuery(Credential credential, String storeCode, Long recurringPaymentNumber)
			throws ClientProtocolException, IOException {
		return getJsonAuth(credential,
				communicationUrl + "/api/v3/recorrencia/" + storeCode + "/" + recurringPaymentNumber);
	}

	@Override
	public String recurringPaymentCancel(Credential credential, Long recurringPaymentNumber)
			throws ClientProtocolException, IOException {
		return recurringPaymentCancel(credential, credential.getStoreCode(), recurringPaymentNumber);
	}

	@Override
	public String recurringPaymentCancel(Credential credential, String storeCode, Long recurringPaymentNumber)
			throws ClientProtocolException, IOException {
		return putJsonAuth(credential,
				communicationUrl + "/api/v3/recorrencia/" + storeCode + "/" + recurringPaymentNumber + "/cancelar",
				null);
	}
}
