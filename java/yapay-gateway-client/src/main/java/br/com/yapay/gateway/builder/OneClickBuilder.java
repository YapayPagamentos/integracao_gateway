package br.com.yapay.gateway.builder;

import br.com.yapay.gateway.model.OneClickRegisterData;

public class OneClickBuilder{

	private static OneClickRegisterData oneClickData;

	public static OneClickRegisterData build() {
		OneClickRegisterData newOneClickRegisterData = oneClickData;
		oneClickData = null;
		return newOneClickRegisterData;
	}

	public static void newOneClickRegister(String storeCode, Long paymentCode) {
		oneClickData = new OneClickRegisterData();
		oneClickData.setPaymentCode(paymentCode);
		oneClickData.setStoreCode(storeCode);
	}
	
	public static void withCreditCard(String cardHolderName, String cardNumber, String cardExpiration) {
		oneClickData.setCardHolderName(cardHolderName);
		oneClickData.setCardNumber(cardNumber);
		oneClickData.setExpirationDate(cardExpiration);
	}
	
	public static void forEmail(String buyerEmail) {
		oneClickData.setBuyerEmail(buyerEmail);
	}

}
