package br.com.yapay.gateway.model;

import com.google.gson.annotations.SerializedName;

public class TransactionCheckoutMultipleBillData {
	
	@SerializedName("valor")
	private Long value;

	@SerializedName("vencimento")
	private String dueDate;

	public Long getValue() {
		return value;
	}

	public void setValue(Long value) {
		this.value = value;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

}
