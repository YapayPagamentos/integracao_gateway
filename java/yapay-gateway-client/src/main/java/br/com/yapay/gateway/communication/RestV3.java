package br.com.yapay.gateway.communication;

import static org.apache.commons.codec.binary.Base64.encodeBase64String;
import static org.apache.commons.lang3.StringUtils.defaultString;
import static org.apache.commons.lang3.StringUtils.isNoneBlank;
import static org.apache.commons.lang3.StringUtils.trimToNull;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.Charset;

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

import br.com.yapay.gateway.model.Credential;
import br.com.yapay.gateway.model.RequestModel;

/**
 * Communication with Gateway API
 * 
 * @author Adriano Santos
 *
 */
public class RestV3 {

	private static final Charset CHARSET_DEFAULT = Charset.forName("UTF-8");

	private final String communicationUrl;
	private final String userAgent;
	private final int connectionTimeout;
	private final int readTimeout;

	/**
	 * Overload to {@link #RestV3(String)} with url wrapped by {@link GatewayUrl}
	 * 
	 * @param gatewayUrl Enum with Endpoint to API environment
	 */
	public RestV3(GatewayUrl gatewayUrl) {
		this(gatewayUrl.getUrl());
	}

	/**
	 * Overload to {@link #RestV3(String, int)} with timeout set to 1 minute
	 * 
	 * @param url Endpoint to API environment
	 */
	public RestV3(String url) {
		this(url, 60_000);
	}

	/**
	 * Constructor with text url and timeout option
	 * 
	 * @param url               Endpoint to API environment
	 * @param connectionTimeout Time in milliseconds until timeout
	 * 
	 * @see RequestConfig
	 */
	public RestV3(String url, int connectionTimeout) {
		this(url, connectionTimeout, 10 * connectionTimeout);
	}

	private RestV3(String url, int connectionTimeout, int readTimeout) {
		this.communicationUrl = url;
		this.connectionTimeout = connectionTimeout;
		this.readTimeout = readTimeout;
		String u = "YapayGatewayJava";
		try {
			String v = getClass().getPackage().getImplementationVersion();
			if (isNoneBlank(v)) {
				u += "_" + v;
			}
		} catch (Exception e) {
		}
		userAgent = u;
	}

	public String oneClickRegister(RequestModel register) throws ClientProtocolException, IOException {
		return postJsonAuth(register.getCredential(), communicationUrl + register.getResourcePath(), register.toJson());
	}

	public String oneClickQuery(RequestModel query) throws ClientProtocolException, IOException {
		return getJsonAuth(query.getCredential(),
				communicationUrl + query.getResourcePath() + query.getModelReference());
	}

	public String oneClickRegisterUpdate(RequestModel update) throws ClientProtocolException, IOException {
		return putJsonAuth(update.getCredential(),
				communicationUrl + update.getResourcePath() + update.getModelReference() + "/alterar", update.toJson());
	}

	public String oneClickAuthorize(RequestModel authorization) throws ClientProtocolException, IOException {
		return postJsonAuth(authorization.getCredential(),
				communicationUrl + authorization.getResourcePath() + authorization.getModelReference() + "/autorizar",
				authorization.toJson());
	}

	public String recurringPaymentRegister(RequestModel registration) throws ClientProtocolException, IOException {
		return postJsonAuth(registration.getCredential(), communicationUrl + registration.getResourcePath(),
				registration.toJson());
	}

	public String recurringPaymentQuery(RequestModel query) throws ClientProtocolException, IOException {
		return getJsonAuth(query.getCredential(),
				communicationUrl + query.getResourcePath() + query.getStoreCode() + "/" + query.getModelReference());
	}

	public String recurringPaymentCancel(RequestModel cancel) throws ClientProtocolException, IOException {
		return putJsonAuth(cancel.getCredential(), communicationUrl + cancel.getResourcePath() + cancel.getStoreCode()
				+ "/" + cancel.getModelReference() + "/cancelar", null);
	}

	public String transactionAuthorize(RequestModel authorization) throws ClientProtocolException, IOException {
		return postJsonAuth(authorization.getCredential(), communicationUrl + authorization.getResourcePath(),
				authorization.toJson());
	}

	public String transactionQuery(RequestModel query) throws ClientProtocolException, IOException {
		return getJsonAuth(query.getCredential(),
				communicationUrl + query.getResourcePath() + query.getStoreCode() + "/" + query.getModelReference());
	}

	public String transactionCapture(RequestModel capture) throws ClientProtocolException, IOException {
		return transactionOperation(capture, "capturar");
	}

	public String transactionCancel(RequestModel cancel) throws ClientProtocolException, IOException {
		return transactionOperation(cancel, "cancelar");
	}

	private String transactionOperation(RequestModel operation, String option)
			throws ClientProtocolException, IOException {
		String valueParameter = "";
		Long value = operation.getValue();
		if (value != null && value > 0) {
			valueParameter = "?valor=" + value.toString();
		}

		return putJsonAuth(operation.getCredential(), communicationUrl + operation.getResourcePath()
				+ operation.getStoreCode() + "/" + operation.getModelReference() + "/" + option + valueParameter, null);
	}

	private String postJsonAuth(Credential credential, String url, String data)
			throws ClientProtocolException, IOException {
		data = defaultString(data);

		HttpPost post = new HttpPost(url);

		post.setEntity(new BufferedHttpEntity(
				new InputStreamEntity(new ByteArrayInputStream(data.getBytes(CHARSET_DEFAULT)))));
		post.setHeader("Content-Type", "application/json; charset=UTF-8");

		return requestBasicAuth(post, credential);
	}

	private String putJsonAuth(Credential credential, String url, String data)
			throws ClientProtocolException, IOException {
		data = defaultString(data);
		HttpPut put = new HttpPut(url);

		put.setEntity(new BufferedHttpEntity(
				new InputStreamEntity(new ByteArrayInputStream(data.getBytes(CHARSET_DEFAULT)))));
		put.setHeader("Content-Type", "application/json; charset=UTF-8");

		return requestBasicAuth(put, credential);
	}

	private String getJsonAuth(Credential credential, String url) throws ClientProtocolException, IOException {
		HttpGet get = new HttpGet(url);

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

		request.addHeader("User-Agent", userAgent);
		request.addHeader("Accept", "application/json");
		request.addHeader("Accept-Charset", "UTF-8");

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
}
