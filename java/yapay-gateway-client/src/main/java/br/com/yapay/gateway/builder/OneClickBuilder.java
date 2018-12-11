package br.com.yapay.gateway.builder;

import br.com.yapay.gateway.model.Credential;
import br.com.yapay.gateway.model.OneClickRegisterData;

public class OneClickBuilder {

	private OneClickRegisterData oneClickData;

	private String storeCode;

	public OneClickBuilder() {

	}

	public OneClickBuilder(Credential credential) {
		this.storeCode = credential.getStoreCode();
	}

	public OneClickRegisterData build() {
		OneClickRegisterData newOneClickRegisterData = oneClickData;
		oneClickData = null;
		return newOneClickRegisterData;
	}

	public void newOneClickRegister(Long paymentCode) {
		this.newOneClickRegister(null, paymentCode);
		oneClickData.setStoreCode(storeCode);
	}

	public void newOneClickRegister(String storeCode, Long paymentCode) {
		oneClickData = new OneClickRegisterData();
		oneClickData.setPaymentCode(paymentCode);
		oneClickData.setStoreCode(storeCode);
	}

	public void withCreditCard(String cardHolderName, String cardNumber, String cardExpiration) {
		oneClickData.setCardHolderName(cardHolderName);
		oneClickData.setCardNumber(cardNumber);
		oneClickData.setExpirationDate(cardExpiration);
	}

	public void forEmail(String buyerEmail) {
		oneClickData.setBuyerEmail(buyerEmail);
	}

}
