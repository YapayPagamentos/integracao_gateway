package br.com.yapay.gateway.communication;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

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

	@Override
	public String transactionAuthorize(Credential credential, Transaction transaction)
			throws ClientProtocolException, IOException {
		HttpClient client = this.httpClientBuilder(credential);
		HttpResponse response = client.execute(newPost(communicationUrl +"/api/v3/transacao", jsonBuilder.toJson(transaction)));

		return new BasicResponseHandler().handleResponse(response);
	}

	@Override
	public String transactionConsult(Credential credential, String storeCode, Long transactionNumber)
			throws ClientProtocolException, IOException {
		HttpClient client = this.httpClientBuilder(credential);

		HttpResponse response = client
				.execute(newGet(communicationUrl + "/api/v3/transacao/" + storeCode + "/" + transactionNumber));

		return new BasicResponseHandler().handleResponse(response);
	}

	@Override
	public String transactionCapture(Credential credential, String storeCode, Long transactionNumber, Long value)
			throws ClientProtocolException, IOException {
		HttpClient client = this.httpClientBuilder(credential);

		HttpResponse response = client.execute(newPut(
				communicationUrl + "/api/v3/transacao/" + storeCode + "/" + transactionNumber + "/capturar", null));

		return new BasicResponseHandler().handleResponse(response);
	}

	@Override
	public String transactionCancel(Credential credential, String storeCode, Long transactionNumber, Long value)
			throws ClientProtocolException, IOException {
		HttpClient client = this.httpClientBuilder(credential);
		HttpResponse response = client.execute(newPut(
				communicationUrl + "/api/v3/transacao/" + storeCode + "/" + transactionNumber + "/cancelar", null));

		return new BasicResponseHandler().handleResponse(response);
	}

	@Override
	public String oneClickRegister(Credential credential, OneClickRegisterData registerData)
			throws ClientProtocolException, IOException {
		HttpClient client = this.httpClientBuilder(credential);
		HttpResponse response = client.execute(newPost(communicationUrl, jsonBuilder.toJson(registerData)));

		return new BasicResponseHandler().handleResponse(response);
	}

	@Override
	public String oneClickConsult(Credential credential, String token) throws ClientProtocolException, IOException {
		HttpClient client = this.httpClientBuilder(credential);
		HttpResponse response = client.execute(newGet(communicationUrl + "/api/v3/oneclick/" + token));

		return new BasicResponseHandler().handleResponse(response);
	}

	@Override
	public String oneClickRegisterUpdate(Credential credential, String token, OneClickRegisterData registerData)
			throws ClientProtocolException, IOException {
		HttpClient client = this.httpClientBuilder(credential);
		HttpResponse response = client.execute(
				newPut(communicationUrl + "/api/v3/oneclick/" + token + "/alterar", jsonBuilder.toJson(registerData)));

		return new BasicResponseHandler().handleResponse(response);
	}

	@Override
	public String oneClickAuthorize(Credential credential, String token, Transaction transaction)
			throws ClientProtocolException, IOException {
		HttpClient client = this.httpClientBuilder(credential);
		HttpResponse response = client.execute(newPost(communicationUrl + "/api/v3/oneclick/" + token + "/autorizar",
				jsonBuilder.toJson(transaction)));

		return new BasicResponseHandler().handleResponse(response);
	}

	@Override
	public String recurringPaymentRegister(Credential credential, RecurringPayment recurringPayment)
			throws ClientProtocolException, IOException {

		HttpClient client = this.httpClientBuilder(credential);
		HttpResponse response = client
				.execute(newPost(communicationUrl + "/api/v3/recorrencia", jsonBuilder.toJson(recurringPayment)));

		return new BasicResponseHandler().handleResponse(response);
	}

	@Override
	public String recurringPaymentConsult(Credential credential, String storeCode, Long recurringPaymentNumber)
			throws ClientProtocolException, IOException {
		HttpClient client = this.httpClientBuilder(credential);
		HttpResponse response = client
				.execute(newGet(communicationUrl + "/api/v3/recorrencia/" + storeCode + "/" + recurringPaymentNumber));

		return new BasicResponseHandler().handleResponse(response);
	}

	@Override
	public String recurringPaymentCancel(Credential credential, String storeCode, Long recurringPaymentNumber)
			throws ClientProtocolException, IOException {
		HttpClient client = this.httpClientBuilder(credential);
		HttpResponse response = client.execute(newPut(
				communicationUrl + "/api/v3/recorrencia/" + storeCode + "/" + recurringPaymentNumber + "/cancelar",
				null));

		return new BasicResponseHandler().handleResponse(response);
	}

	private HttpClient httpClientBuilder(Credential gatewayCredential) throws IOException {

		try (CloseableHttpClient createdClient = HttpClientBuilder.create()
				.setDefaultCredentialsProvider(credentialSetup(gatewayCredential)).build()) {
			return createdClient;
		}

	}

	private CredentialsProvider credentialSetup(Credential gatewayCredential) {
		CredentialsProvider credentialProviders = new BasicCredentialsProvider();
		UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(gatewayCredential.getUser(),
				gatewayCredential.getPassword());
		credentialProviders.setCredentials(AuthScope.ANY, credentials);
		return credentialProviders;
	}

	private HttpPost newPost(String url, String body) throws UnsupportedEncodingException {
		HttpPost httpPost = new HttpPost(url);
		StringEntity postBody = new StringEntity(body);
		httpPost.setEntity(postBody);
		httpPost.setHeader("Content-type", "application/json");
		return httpPost;
	}

	private HttpPut newPut(String url, String body) throws UnsupportedEncodingException {
		HttpPut httpPut = new HttpPut(url);
		StringEntity postBody = new StringEntity(body);
		httpPut.setEntity(postBody);
		httpPut.setHeader("Content-type", "application/json");
		return httpPut;
	}

	private HttpGet newGet(String url) {
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("Content-type", "application/json");
		return httpGet;
	}

}
