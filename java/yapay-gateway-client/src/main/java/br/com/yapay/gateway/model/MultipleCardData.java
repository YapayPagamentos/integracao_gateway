package br.com.yapay.gateway.model;

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
	private Long value;

	/**
	 * @deprecated JSON bind eyes only
	 */
	@Deprecated
	MultipleCardData() {
	}

	/**
	 * Constructor with minimum requested parameters for common cards
	 * 
	 * @param cardHolderName Card holder name
	 * @param cardNumber     Card number
	 * @param expirationDate Card expiration date
	 * @param cvv            Card security code
	 * 
	 * @see CardData#CardData(String, String, String, String)
	 */
	public MultipleCardData(String cardHolderName, String cardNumber, String expirationDate, String cvv) {
		super(cardHolderName, cardNumber, expirationDate, cvv);
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

	public Long getValue() {
		return value;
	}

	public void setValue(Long value) {
		this.value = value;
	}
}
