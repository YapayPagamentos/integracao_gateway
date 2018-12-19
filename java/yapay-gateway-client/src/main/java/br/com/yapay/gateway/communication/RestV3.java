package br.com.yapay.gateway.communication;

import static org.apache.commons.codec.binary.Base64.encodeBase64String;
import static org.apache.commons.lang3.StringUtils.defaultString;
import static org.apache.commons.lang3.StringUtils.isNoneBlank;
import static org.apache.commons.lang3.StringUtils.trimToNull;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Properties;

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

import br.com.yapay.gateway.model.ApiResponse;
import br.com.yapay.gateway.model.Credential;
import br.com.yapay.gateway.model.RequestModel;

/**
 * Communication with Gateway API
 * 
 * @author Adriano Santos
 *
 */
public class RestV3 implements ApiConnector {

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
		try (InputStream is = getClass()
				.getResourceAsStream("/META-INF/maven/br.com.yapay.gateway/yapay-gateway-client/pom.properties")) {
			Properties prop = new Properties();
			prop.load(is);
			String v = prop.getProperty("version");
			if (isNoneBlank(v)) {
				u += "_" + v;
			}
		} catch (Exception e) {
		}
		userAgent = u;
	}

	@Override
	public ApiResponse oneClickRegister(RequestModel register) throws ClientProtocolException, IOException {
		return postJsonAuth(register.getCredential(), communicationUrl + register.getResourcePath(), register.toJson());
	}

	@Override
	public ApiResponse oneClickQuery(RequestModel query) throws ClientProtocolException, IOException {
		return getJsonAuth(query.getCredential(),
				communicationUrl + query.getResourcePath() + query.getModelReference());
	}

	@Override
	public ApiResponse oneClickRegisterUpdate(RequestModel update) throws ClientProtocolException, IOException {
		return putJsonAuth(update.getCredential(),
				communicationUrl + update.getResourcePath() + update.getModelReference() + "/alterar", update.toJson());
	}

	@Override
	public ApiResponse oneClickAuthorize(RequestModel authorization) throws ClientProtocolException, IOException {
		return postJsonAuth(authorization.getCredential(),
				communicationUrl + authorization.getResourcePath() + authorization.getModelReference() + "/autorizar",
				authorization.toJson());
	}

	@Override
	public ApiResponse recurringPaymentRegister(RequestModel registration) throws ClientProtocolException, IOException {
		return postJsonAuth(registration.getCredential(), communicationUrl + registration.getResourcePath(),
				registration.toJson());
	}

	@Override
	public ApiResponse recurringPaymentQuery(RequestModel query) throws ClientProtocolException, IOException {
		return getJsonAuth(query.getCredential(),
				communicationUrl + query.getResourcePath() + query.getStoreCode() + "/" + query.getModelReference());
	}

	@Override
	public ApiResponse recurringPaymentCancel(RequestModel cancel) throws ClientProtocolException, IOException {
		return putJsonAuth(cancel.getCredential(), communicationUrl + cancel.getResourcePath() + cancel.getStoreCode()
				+ "/" + cancel.getModelReference() + "/cancelar", null);
	}

	@Override
	public ApiResponse transactionAuthorize(RequestModel authorization) throws ClientProtocolException, IOException {
		return postJsonAuth(authorization.getCredential(), communicationUrl + authorization.getResourcePath(),
				authorization.toJson());
	}

	@Override
	public ApiResponse transactionQuery(RequestModel query) throws ClientProtocolException, IOException {
		return getJsonAuth(query.getCredential(),
				communicationUrl + query.getResourcePath() + query.getStoreCode() + "/" + query.getModelReference());
	}

	@Override
	public ApiResponse transactionCapture(RequestModel capture) throws ClientProtocolException, IOException {
		return transactionOperation(capture, "capturar");
	}

	@Override
	public ApiResponse transactionCancel(RequestModel cancel) throws ClientProtocolException, IOException {
		return transactionOperation(cancel, "cancelar");
	}

	private ApiResponse transactionOperation(RequestModel operation, String option)
			throws ClientProtocolException, IOException {
		String valueParameter = "";
		Long value = operation.getValue();
		if (value != null && value > 0) {
			valueParameter = "?valor=" + value.toString();
		}

		return putJsonAuth(operation.getCredential(), communicationUrl + operation.getResourcePath()
				+ operation.getStoreCode() + "/" + operation.getModelReference() + "/" + option + valueParameter, null);
	}

	private ApiResponse postJsonAuth(Credential credential, String url, String data)
			throws ClientProtocolException, IOException {
		data = defaultString(data);

		HttpPost post = new HttpPost(url);

		post.setEntity(new BufferedHttpEntity(
				new InputStreamEntity(new ByteArrayInputStream(data.getBytes(CHARSET_DEFAULT)))));
		post.setHeader("Content-Type", "application/json; charset=UTF-8");

		return requestBasicAuth(post, credential);
	}

	private ApiResponse putJsonAuth(Credential credential, String url, String data)
			throws ClientProtocolException, IOException {
		data = defaultString(data);
		HttpPut put = new HttpPut(url);

		put.setEntity(new BufferedHttpEntity(
				new InputStreamEntity(new ByteArrayInputStream(data.getBytes(CHARSET_DEFAULT)))));
		put.setHeader("Content-Type", "application/json; charset=UTF-8");

		return requestBasicAuth(put, credential);
	}

	private ApiResponse getJsonAuth(Credential credential, String url) throws ClientProtocolException, IOException {
		HttpGet get = new HttpGet(url);

		return requestBasicAuth(get, credential);
	}

	private ApiResponse requestBasicAuth(HttpUriRequest request, Credential credential)
			throws ClientProtocolException, IOException {
		String encoded = String.valueOf(encodeBase64String(
				(trimToNull(credential.getUser()) + ":" + trimToNull(credential.getPassword())).getBytes()));
		request.addHeader("Authorization", " Basic " + encoded);

		return requestHttpClient(request);
	}

	private ApiResponse requestHttpClient(HttpUriRequest request) throws ClientProtocolException, IOException {
		ApiResponse result = null;

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

	private ApiResponse executeRequestHttpClient(HttpClient client, HttpUriRequest request)
			throws ClientProtocolException, IOException {
		HttpResponse response = client.execute(request);
		ApiResponse apiResponse = new ApiResponse();
		if (response == null) {
			return apiResponse;
		}
		if (response.getStatusLine() != null) {
			apiResponse.setHttpStatus(response.getStatusLine().getStatusCode());
		}
		if (response.getEntity() != null) {
			apiResponse.setRawResponseContent(EntityUtils.toString(response.getEntity()));
		}
		return apiResponse;
	}
}
