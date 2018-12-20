package br.com.yapay.gateway.model;

import java.math.BigDecimal;

import com.google.gson.annotations.SerializedName;

/**
 * Card class with properties to multiple card integration
 * 
 * @author Adriano Santos
 *
 */
public class MultipleCardData extends CardData {

	@SerializedName("codigoFormaPagamento")
	private Integer paymentCode;

	@SerializedName("parcelas")
	private Integer installments;

	@SerializedName("valor")
	private Long valueLong;

	/**
	 * @deprecated JSON bind eyes only
	 */
	@Deprecated
	MultipleCardData() {
	}

	/**
	 * Constructor with minimum requested parameters for common cards
	 * 
	 * @param cardHolderName  Card holder name
	 * @param cardNumber      Card number
	 * @param expirationMonth Card expiration month
	 * @param expirationYear  Card expiration year
	 * @param cvv             Card security code
	 * 
	 * @see CardData#CardData(String, String, int, int, String)
	 */
	public MultipleCardData(String cardHolderName, String cardNumber, int expirationMonth, int expirationYear,
			String cvv) {
		super(cardHolderName, cardNumber, expirationMonth, expirationYear, cvv);
		installments = 1;
	}

	public Integer getPaymentCode() {
		return paymentCode;
	}

	public void setPaymentCode(Integer paymentCode) {
		this.paymentCode = paymentCode;
	}

	public Integer getInstallments() {
		return installments;
	}

	public void setInstallments(Integer installments) {
		this.installments = installments;
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
}
