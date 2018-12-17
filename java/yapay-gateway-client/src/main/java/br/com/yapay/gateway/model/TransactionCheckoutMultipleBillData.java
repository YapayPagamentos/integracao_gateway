package br.com.yapay.gateway.model;

import com.google.gson.annotations.SerializedName;

/**
 * Class containing multiple bill info
 * 
 * @author Adriano Santos
 *
 */
public class TransactionCheckoutMultipleBillData {

	@SerializedName("valor")
	private Long value;

	@SerializedName("vencimento")
	private String dueDate;

	/**
	 * @deprecated JSON bind eyes only
	 */
	@Deprecated
	TransactionCheckoutMultipleBillData() {
	}

	public TransactionCheckoutMultipleBillData(Long value, String dueDate) {
		this.value = value;
		this.dueDate = dueDate;
	}

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
