package br.com.yapay.gateway.communication;

import br.com.yapay.gateway.model.Credential;
import br.com.yapay.gateway.model.OneClickRegisterData;
import br.com.yapay.gateway.model.RecurringPayment;
import br.com.yapay.gateway.model.Transaction;

public interface RestV3 extends Communication{

	String transactionAuthorize(Credential credential, Transaction transaction);
	
	String transactionConsult(Credential credential, String storeCode, Long transactionNumber);
	
	String transactionCapture(Credential credential, String storeCode, Long transactionNumber, Long value);
	
	String transactionCancel(Credential credential, String storeCode, Long transactionNumber, Long value);
	
	String oneClickRegister(Credential credential, OneClickRegisterData registerData);
	
	String oneClickConsult(Credential credential, String token);
	
	String oneClickRegisterUpdate(Credential credential, OneClickRegisterData registerData);
	
	String oneClickAuthorize(Credential credential, String token, Transaction transaction);
	
	String recurringPaymentRegister(Credential credential, RecurringPayment recurringPayment);
	
	String recurringPaymentConsult(Credential credential, String storeCode, Long recurringPaymentNumber);
	
	String recurringPaymentCancel(Credential credential, String storeCode, Long recurringPaymentNumber);
}
