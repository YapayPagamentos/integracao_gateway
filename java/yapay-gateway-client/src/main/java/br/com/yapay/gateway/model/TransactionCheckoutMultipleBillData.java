package br.com.yapay.gateway.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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

	public TransactionCheckoutMultipleBillData(Long value, LocalDate dueDate) {
		this.value = value;
		setDueDate(dueDate);
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

	void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	/**
	 * Setting due date from {@link LocalDate}
	 * 
	 * @param dueDate Due date
	 */
	public void setDueDate(LocalDate dueDate) {
		String dueDateStr = dueDate == null ? null : dueDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		setDueDate(dueDateStr);
	}
}
