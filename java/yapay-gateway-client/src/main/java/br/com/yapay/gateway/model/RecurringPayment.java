package br.com.yapay.gateway.model;

import com.google.gson.annotations.SerializedName;

public class RecurringPayment {

	@SerializedName("recorrencia")
	private RecurringPaymentData recurringPaymentData;

	@SerializedName("estabelecimento")
	private String storeCode;

	public RecurringPaymentData getRecurringPaymentData() {
		return recurringPaymentData;
	}

	public void setRecurringPaymentData(RecurringPaymentData recurringPaymentData) {
		this.recurringPaymentData = recurringPaymentData;
	}

	public String getStoreCode() {
		return storeCode;
	}

	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}

}
