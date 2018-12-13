package br.com.yapay.gateway.model;

import com.google.gson.annotations.SerializedName;

/**
 * Card info for single cards integration
 * 
 * @author Adriano Santos
 *
 */
public class CardData {

	@SerializedName("nomePortador")
	private String cardHolderName;

	@SerializedName("numeroCartao")
	private String cardNumber;

	@SerializedName("codigoSeguranca")
	private String cvv;

	@SerializedName("dataValidade")
	private String expirationDate;

	/**
	 * @deprecated JSON bind eyes only
	 */
	@Deprecated
	CardData() {
	}

	/**
	 * Constructor with minimum requested parameters
	 * 
	 * @param cardHolderName Card holder name
	 * @param cardNumber     Card number
	 * @param expirationDate Card expiration date
	 * @param cvv            Card security code
	 */
	public CardData(String cardHolderName, String cardNumber, String expirationDate, String cvv) {
		this.cardHolderName = cardHolderName;
		this.cardNumber = cardNumber;
		this.expirationDate = expirationDate;
		this.cvv = cvv;
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

}
