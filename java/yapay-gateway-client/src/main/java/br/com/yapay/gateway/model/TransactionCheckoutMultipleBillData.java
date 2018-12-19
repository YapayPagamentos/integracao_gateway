package br.com.yapay.gateway.model;

import java.math.BigDecimal;
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
	private Long valueLong;

	@SerializedName("vencimento")
	private String dueDate;

	/**
	 * @deprecated JSON bind eyes only
	 */
	@Deprecated
	TransactionCheckoutMultipleBillData() {
	}

	public TransactionCheckoutMultipleBillData(BigDecimal value, LocalDate dueDate) {
		setValue(value);
		setDueDate(dueDate);
	}

	Long getValueLong() {
		return valueLong;
	}

	void setValueLong(Long value) {
		this.valueLong = value;
	}

	public void setValue(BigDecimal value) {
		this.valueLong = value == null ? null : value.multiply(new BigDecimal(100)).longValue();
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
