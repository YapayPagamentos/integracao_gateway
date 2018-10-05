package br.com.yapay.gateway.builder;

import br.com.yapay.gateway.model.CreditCardData;
import br.com.yapay.gateway.model.DebitCardData;
import br.com.yapay.gateway.model.RecurringPayment;
import br.com.yapay.gateway.model.RecurringPaymentData;

public class RecurringPaymentBuilderImpl implements RecurringPaymentBuilder {

	private static RecurringPayment recurringPayment;

	public static RecurringPayment build() {
		RecurringPayment newRecurringPayment = recurringPayment;
		recurringPayment = null;
		return newRecurringPayment;
	}

	public static void newRecurringPayment(String storeCode, Long paymentCode, Long recurringPaymentNumber,
			Long value) {
		recurringPayment = new RecurringPayment();
		recurringPayment.setStoreCode(storeCode);
		recurringPayment.setRecurringPaymentData(new RecurringPaymentData());
		recurringPayment.getRecurringPaymentData().setPaymentCode(paymentCode);
		recurringPayment.getRecurringPaymentData().setRecurringPaymentNumber(recurringPaymentNumber);
		recurringPayment.getRecurringPaymentData().setValue(value);
	}

	public static void withFrequencyOf(Integer frequency) {
		recurringPayment.getRecurringPaymentData().setFrequency(frequency);
	}

	public static void setNotificationUrl(String notificationUrl) {
		recurringPayment.getRecurringPaymentData().setNotificationUrl(notificationUrl);
	}

	public static void shouldProcessImmediately(Boolean processImmediately) {
		recurringPayment.getRecurringPaymentData().setProcessImmediately(processImmediately);
	}

	public static void withBillingOptions(Integer billingAmount, String billingFirstDate, String billDueDate) {
		recurringPayment.getRecurringPaymentData().setBillingAmount(billingAmount);
		recurringPayment.getRecurringPaymentData().setBillingFirstDate(billingFirstDate);
		recurringPayment.getRecurringPaymentData().setBillDueDate(billDueDate);
	}

	public static void withFreeFields(String freeFieldOne, String freeFieldTwo, String freeFieldThree,
			String freeFieldFour, String freeFieldFive) {
		recurringPayment.getRecurringPaymentData().setFreeFieldOne(freeFieldOne);
		recurringPayment.getRecurringPaymentData().setFreeFieldTwo(freeFieldTwo);
		recurringPayment.getRecurringPaymentData().setFreeFieldThree(freeFieldThree);
		recurringPayment.getRecurringPaymentData().setFreeFieldFour(freeFieldFour);
		recurringPayment.getRecurringPaymentData().setFreeFieldFive(freeFieldFive);
	}

	public static void withCreditCard(CreditCardData creditCardData) {
		recurringPayment.getRecurringPaymentData().setCreditCard(new CreditCardData());
		recurringPayment.getRecurringPaymentData().getCreditCard()
				.setCardHolderName(creditCardData.getCardHolderName());
		recurringPayment.getRecurringPaymentData().getCreditCard().setCardNumber(creditCardData.getCardNumber());
		recurringPayment.getRecurringPaymentData().getCreditCard().setCvv(creditCardData.getCvv());
		recurringPayment.getRecurringPaymentData().getCreditCard()
				.setExpirationDate(creditCardData.getExpirationDate());
		recurringPayment.getRecurringPaymentData().getCreditCard().setInstallments(creditCardData.getInstallments());
		recurringPayment.getRecurringPaymentData().getCreditCard().setPaymentCode(creditCardData.getPaymentCode());
		recurringPayment.getRecurringPaymentData().getCreditCard().setValue(creditCardData.getValue());
	}

	public static void withDebitCard(DebitCardData debitCardData) {
		recurringPayment.getRecurringPaymentData().setDebitCard(new DebitCardData());
		recurringPayment.getRecurringPaymentData().getDebitCard().setAccountNumber(debitCardData.getAccountNumber());
		recurringPayment.getRecurringPaymentData().getDebitCard()
				.setAccountNumberDigit(debitCardData.getAccountNumberDigit());
		recurringPayment.getRecurringPaymentData().getDebitCard().setAccountType(debitCardData.getAccountType());
		recurringPayment.getRecurringPaymentData().getDebitCard().setAgency(debitCardData.getAgency());
		recurringPayment.getRecurringPaymentData().getDebitCard().setAgencyDigit(debitCardData.getAgencyDigit());
	}
}
