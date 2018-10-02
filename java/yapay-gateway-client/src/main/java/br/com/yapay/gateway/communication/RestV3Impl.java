package br.com.yapay.gateway.communication;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;

import br.com.yapay.gateway.model.Credential;
import br.com.yapay.gateway.model.OneClickRegisterData;
import br.com.yapay.gateway.model.RecurringPayment;
import br.com.yapay.gateway.model.Transaction;

public class RestV3Impl implements RestV3 {

	@Override
	public String transactionAuthorize(Credential credential, Transaction transaction) {
		HttpClient client = this.httpClientBuilder(credential);
		
		return null;
	}

	@Override
	public String transactionConsult(Credential credential, String storeCode, Long transactionNumber) {
		HttpClient client = this.httpClientBuilder(credential);
		
		
		return null;
	}

	@Override
	public String transactionCapture(Credential credential, String storeCode, Long transactionNumber, Long value) {
		HttpClient client = this.httpClientBuilder(credential);
		
		return null;
	}

	@Override
	public String transactionCancel(Credential credential, String storeCode, Long transactionNumber, Long value) {
		HttpClient client = this.httpClientBuilder(credential);
		
		return null;
	}

	@Override
	public String oneClickRegister(Credential credential, OneClickRegisterData registerData) {
		HttpClient client = this.httpClientBuilder(credential);
		
		return null;
	}

	@Override
	public String oneClickConsult(Credential credential, String token) {
		HttpClient client = this.httpClientBuilder(credential);
		
		return null;
	}

	@Override
	public String oneClickRegisterUpdate(Credential credential, OneClickRegisterData registerData) {
		HttpClient client = this.httpClientBuilder(credential);
		
		return null;
	}

	@Override
	public String oneClickAuthorize(Credential credential, String token, Transaction transaction) {
		HttpClient client = this.httpClientBuilder(credential);
		
		return null;
	}

	@Override
	public String recurringPaymentRegister(Credential credential, RecurringPayment recurringPayment) {
		HttpClient client = this.httpClientBuilder(credential);
		
		return null;
	}

	@Override
	public String recurringPaymentConsult(Credential credential, String storeCode, Long recurringPaymentNumber) {
		HttpClient client = this.httpClientBuilder(credential);
		
		return null;
	}

	@Override
	public String recurringPaymentCancel(Credential credential, String storeCode, Long recurringPaymentNumber) {
		HttpClient client = this.httpClientBuilder(credential);
		
		return null;
	}

	private HttpClient httpClientBuilder(Credential gatewayCredential) {
		HttpClient client = HttpClientBuilder.create().setDefaultCredentialsProvider(credentialSetup(gatewayCredential))
				.build();
		return client;
	}

	private CredentialsProvider credentialSetup(Credential gatewayCredential) {
		CredentialsProvider credentialProviders = new BasicCredentialsProvider();
		UsernamePasswordCredentials credentials = new UsernamePasswordCredentials(gatewayCredential.getUser(),
				gatewayCredential.getPassword());
		credentialProviders.setCredentials(AuthScope.ANY, credentials);
		return credentialProviders;
	}

}
