package br.com.yapay.gateway.communication;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import br.com.yapay.gateway.model.Credential;
import br.com.yapay.gateway.model.OneClickRegisterData;
import br.com.yapay.gateway.model.RecurringPayment;
import br.com.yapay.gateway.model.Transaction;

public interface RestV3 extends Communication{

	String transactionAuthorize(Credential credential, Transaction transaction) throws ClientProtocolException, IOException;
	
	String transactionConsult(Credential credential, String storeCode, Long transactionNumber) throws ClientProtocolException, IOException;
	
	String transactionCapture(Credential credential, String storeCode, Long transactionNumber, Long value) throws ClientProtocolException, IOException;
	
	String transactionCancel(Credential credential, String storeCode, Long transactionNumber, Long value) throws ClientProtocolException, IOException;
	
	String oneClickRegister(Credential credential, OneClickRegisterData registerData) throws ClientProtocolException, IOException;
	
	String oneClickConsult(Credential credential, String token) throws ClientProtocolException, IOException;
	
	String oneClickRegisterUpdate(Credential credential, String token, OneClickRegisterData registerData) throws ClientProtocolException, IOException;
	
	String oneClickAuthorize(Credential credential, String token, Transaction transaction) throws ClientProtocolException, IOException;
	
	String recurringPaymentRegister(Credential credential, RecurringPayment recurringPayment) throws ClientProtocolException, IOException;
	
	String recurringPaymentConsult(Credential credential, String storeCode, Long recurringPaymentNumber) throws ClientProtocolException, IOException;
	
	String recurringPaymentCancel(Credential credential, String storeCode, Long recurringPaymentNumber) throws ClientProtocolException, IOException;
}
