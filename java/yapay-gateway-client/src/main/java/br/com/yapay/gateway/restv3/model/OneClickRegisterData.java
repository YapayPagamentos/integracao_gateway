package br.com.yapay.gateway.restv3.model;

import com.google.gson.annotations.SerializedName;

public class OneClickRegisterData {

	@SerializedName("codigoEstabelecimento")
	private String storeCode;
	
	@SerializedName("nomeTitularCartaoCredito")
	private String cardHolderName;
	
	@SerializedName("numeroCartaoCredito")
	private String cardNumber;
	
	@SerializedName("dataValidadeCartao")
	private String expirationDate;
	
	@SerializedName("emailComprador")
	private String buyerEmail;
	
	@SerializedName("formaPagamento")
	private Long paymentCode;

	public String getStoreCode() {
		return storeCode;
	}

	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}

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

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getBuyerEmail() {
		return buyerEmail;
	}

	public void setBuyerEmail(String buyerEmail) {
		this.buyerEmail = buyerEmail;
	}

	public Long getPaymentCode() {
		return paymentCode;
	}

	public void setPaymentCode(Long paymentCode) {
		this.paymentCode = paymentCode;
	}

}
