package br.com.yapay.gateway.model;

import com.google.gson.annotations.SerializedName;

public class CreditCardData {

	@SerializedName("nomePortador")
	private String cardHolderName;

	@SerializedName("numeroCartao")
	private String cardNumber;

	@SerializedName("codigoSeguranca")
	private String cvv;

	@SerializedName("dataValidade")
	private String expirationDate;

	@SerializedName("codigoFormaPagamento")
	private Integer paymentCode;

	@SerializedName("parcelas")
	private Integer installments;

	@SerializedName("valor")
	private Long value;

	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
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
