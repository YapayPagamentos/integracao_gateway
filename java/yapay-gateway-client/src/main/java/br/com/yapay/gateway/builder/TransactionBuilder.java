package br.com.yapay.gateway.builder;

import java.util.ArrayList;
import java.util.List;

import br.com.yapay.gateway.model.CreditCardData;
import br.com.yapay.gateway.model.ExtraField;
import br.com.yapay.gateway.model.ItemData;
import br.com.yapay.gateway.model.Transaction;
import br.com.yapay.gateway.model.TransactionData;

public class TransactionBuilder implements ITransactionBuilder {

	@Override
	public Transaction build() {
		return transaction;
	}

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

	public static void withSingleCreditCard(String cardHolderName, String cardNumber, String cvv,
			String expirationDate) {
		transaction.setCreditCard(new CreditCardData());
		transaction.getCreditCard().setCardHolderName(cardHolderName);
		transaction.getCreditCard().setCardNumber(cardNumber);
		transaction.getCreditCard().setCvv(cvv);
		transaction.getCreditCard().setExpirationDate(expirationDate);
	}

	public static void withItems(List<ItemData> listOfItems) {
		List<ItemData> transactionItemList = new ArrayList<>();

		if (listOfItems != null) {
			for (ItemData item : listOfItems) {
				ItemData transactionItem = new ItemData();
				transactionItem.setCategoryName(item.getCategoryName());
				transactionItem.setProductAmount(item.getProductAmount());
				transactionItem.setProductCategory(item.getProductCategory());
				transactionItem.setProductCode(item.getProductCode());
				transactionItem.setProductName(item.getProductName());
				transactionItem.setProductUnitaryValue(item.getProductUnitaryValue());
				transactionItemList.add(transactionItem);
			}
		}

		transaction.setItems(transactionItemList);
	}

	public static void withExtraFields(List<ExtraField> listOfExtraFields) {
		List<ExtraField> transactionExtraFieldsList = new ArrayList<>();

		if (listOfExtraFields != null) {
			for (ExtraField extraField : listOfExtraFields) {
				ExtraField transactionExtraField = new ExtraField();
				transactionExtraField.setKey(extraField.getKey());
				transactionExtraField.setValue(transactionExtraField.getValue());
				transactionExtraFieldsList.add(transactionExtraField);
			}
		}

		transaction.setExtraFields(transactionExtraFieldsList);
	}

}
