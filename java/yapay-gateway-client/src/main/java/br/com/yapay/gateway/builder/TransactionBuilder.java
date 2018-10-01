package br.com.yapay.gateway.builder;

import br.com.yapay.gateway.restv3.model.CreditCardData;
import br.com.yapay.gateway.restv3.model.Transaction;
import br.com.yapay.gateway.restv3.model.TransactionData;

public class TransactionBuilder {

	private static Transaction transaction;

	public static void newTransaction(String storeCode, Integer paymentCode, Long transactionNumber, Long value) {
		transaction = new Transaction();
		transaction.setTransactionData(new TransactionData());
		transaction.setStoreCode(storeCode);
		transaction.setPaymentCode(paymentCode);
		transaction.getTransactionData().setTransactionNumber(transactionNumber);
		transaction.getTransactionData().setValue(value);
	}
	
	public static void withInstallments(Integer installments) {
		transaction.getTransactionData().setInstallments(installments);
	}
	
	public static void withSingleCreditCard(String cardHolderName, String cardNumber, String cvv, String expirationDate) {
		transaction.setCreditCard(new CreditCardData());
		transaction.getCreditCard().setCardHolderName(cardHolderName);
		transaction.getCreditCard().setCardNumber(cardNumber);
		transaction.getCreditCard().setCvv(cvv);
		transaction.getCreditCard().setExpirationDate(expirationDate);
	}

}
