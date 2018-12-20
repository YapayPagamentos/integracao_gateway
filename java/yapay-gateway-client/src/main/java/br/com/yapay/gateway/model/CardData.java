package br.com.yapay.gateway.model;

import static org.apache.commons.lang3.StringUtils.leftPad;

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
	 * Overload of {@link #CardData(String, String, int,int, String)} for OneClick
	 * purposes
	 * 
	 * @param cvv Card security code
	 */
	public CardData(String cvv) {
		this(null, null, 0, 0, cvv);
	}

	/**
	 * Overload of {@link #CardData(String, String, int,int, String)} without
	 * {@code cvv}
	 * 
	 * @param cardHolderName  Card holder name
	 * @param cardNumber      Card number
	 * @param expirationMonth Card expiration month
	 * @param expirationYear  Card expiration year
	 */

	public CardData(String cardHolderName, String cardNumber, int expirationMonth, int expirationYear) {
		this(cardHolderName, cardNumber, expirationMonth, expirationYear, null);
	}

	/**
	 * Constructor with all parameters
	 * 
	 * @param cardHolderName  Card holder name
	 * @param cardNumber      Card number
	 * @param expirationMonth Card expiration month
	 * @param expirationYear  Card expiration year
	 * @param cvv             Card security code
	 */
	public CardData(String cardHolderName, String cardNumber, int expirationMonth, int expirationYear, String cvv) {
		this.cardHolderName = cardHolderName;
		this.cardNumber = cardNumber;
		setExpirationDate(expirationMonth, expirationYear);
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

	void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	/**
	 * Setting {@code expirationDate} as MM/yyyy
	 *
	 * @param expirationMonth Card expiration month
	 * @param expirationYear  Card expiration year
	 */
	public void setExpirationDate(int expirationMonth, int expirationYear) {
		if (expirationMonth > 0 && expirationMonth < 13 && expirationYear > 1900) {
			setExpirationDate(leftPad(String.valueOf(expirationMonth), 2, "0") + "/"
					+ leftPad(String.valueOf(expirationYear), 4, "0"));
		}
	}
}
