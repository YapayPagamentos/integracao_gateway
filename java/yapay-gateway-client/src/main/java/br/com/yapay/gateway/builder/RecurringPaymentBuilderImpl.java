package br.com.yapay.gateway.builder;

import br.com.yapay.gateway.model.RecurringPayment;
import br.com.yapay.gateway.model.RecurringPaymentData;

public class RecurringPaymentBuilderImpl implements RecurringPaymentBuilder {

	private static RecurringPayment recurringPayment;

	public static RecurringPayment build() {
		RecurringPayment newRecurringPayment = recurringPayment;
		recurringPayment = null;
		return newRecurringPayment;
	}
	
	public static void newRecurringPayment(String storeCode, Long paymentCode, Long recurringPaymentNumber, Long value) {
		recurringPayment = new RecurringPayment();
		recurringPayment.setStoreCode(storeCode);
		recurringPayment.setRecurringPaymentData(new RecurringPaymentData());
		recurringPayment.getRecurringPaymentData().setPaymentCode(paymentCode);
		recurringPayment.getRecurringPaymentData().setRecurringPaymentNumber(recurringPaymentNumber);
		recurringPayment.getRecurringPaymentData().setValue(value);
	}
}
