package br.com.yapay.gateway.communication;

import br.com.yapay.gateway.model.Credential;
import br.com.yapay.gateway.model.OneClickRegisterData;
import br.com.yapay.gateway.model.RecurringPayment;
import br.com.yapay.gateway.model.Transaction;

public class RestV3Impl implements RestV3 {

	@Override
	public String transactionAuthorize(Credential credential, Transaction transaction) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String transactionConsult(Credential credential, String storeCode, Long transactionNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String transactionCapture(Credential credential, String storeCode, Long transactionNumber, Long value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String transactionCancel(Credential credential, String storeCode, Long transactionNumber, Long value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String oneClickRegister(Credential credential, OneClickRegisterData registerData) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String oneClickConsult(Credential credential, String token) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String oneClickRegisterUpdate(Credential credential, OneClickRegisterData registerData) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String oneClickAuthorize(Credential credential, String token, Transaction transaction) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String recurringPaymentRegister(Credential credential, RecurringPayment recurringPayment) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String recurringPaymentConsult(Credential credential, String storeCode, Long recurringPaymentNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String recurringPaymentCancel(Credential credential, String storeCode, Long recurringPaymentNumber) {
		// TODO Auto-generated method stub
		return null;
	}

}
