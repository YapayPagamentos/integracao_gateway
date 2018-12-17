package br.com.yapay.gateway.model;

import com.google.gson.annotations.SerializedName;

public class OneClickRegister extends RequestModel {
	private transient String tokenOneClick;

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

	/**
	 * @deprecated JSON bind eyes only
	 */
	@Deprecated
	OneClickRegister() {
		super(null);
	}

	private OneClickRegister(Builder builder) {
		super(builder.credential);
		setResourcePath(builder.resourcePath);
		this.tokenOneClick = builder.tokenOneClick;
		this.storeCode = builder.storeCode;
		this.cardHolderName = builder.cardHolderName;
		this.cardNumber = builder.cardNumber;
		this.expirationDate = builder.expirationDate;
		this.buyerEmail = builder.buyerEmail;
		this.paymentCode = builder.paymentCode;
	}

	/**
	 * Class containing rules of oneclick register building
	 * 
	 * @author Adriano Santos
	 *
	 */
	public static class Builder {
		private final Credential credential;
		private String resourcePath;

		private String tokenOneClick;
		private String storeCode;
		private String cardHolderName;
		private String cardNumber;
		private String expirationDate;
		private String buyerEmail;
		private Long paymentCode;

		private Builder(Credential credential) {
			this(credential, null, null);
		}

		private Builder(Credential credential, String buyerEmail, Long paymentCode) {
			this.credential = credential;
			this.buyerEmail = buyerEmail;
			this.paymentCode = paymentCode;
			this.resourcePath = "/api/v3/oneclick/";
			this.storeCode = credential.getStoreCode();
		}

		public Builder withResourcePath(String resourcePath) {
			this.resourcePath = resourcePath;
			return this;
		}

		public Builder withTokenOneClick(String tokenOneClick) {
			this.tokenOneClick = tokenOneClick;
			return this;
		}

		public Builder withStoreCode(String storeCode) {
			this.storeCode = storeCode;
			return this;
		}

		public Builder withCardHolderName(String cardHolderName) {
			this.cardHolderName = cardHolderName;
			return this;
		}

		public Builder withCardNumber(String cardNumber) {
			this.cardNumber = cardNumber;
			return this;
		}

		public Builder withExpirationDate(String expirationDate) {
			this.expirationDate = expirationDate;
			return this;
		}

		public Builder withBuyerEmail(String buyerEmail) {
			this.buyerEmail = buyerEmail;
			return this;
		}

		public Builder withPaymentCode(Long paymentCode) {
			this.paymentCode = paymentCode;
			return this;
		}

		public Builder withCard(CardData card) {
			return withCard(card.getCardHolderName(), card.getCardNumber(), card.getExpirationDate());
		}

		public Builder withCard(String cardHolderName, String cardNumber, String expirationDate) {
			this.cardHolderName = cardHolderName;
			this.cardNumber = cardNumber;
			this.expirationDate = expirationDate;
			return this;
		}

		/**
		 * Oneclick register build with specified properties
		 * 
		 * @return Instance of oneclick register
		 */
		public OneClickRegister build() {
			return new OneClickRegister(this);
		}
	}

	/**
	 * Getting builder with minimum parameters
	 * 
	 * @param credential Authentication info
	 * @return Oneclick register builder
	 */
	public static Builder getBuilder(Credential credential) {
		return new Builder(credential);
	}

	/**
	 * Getting builder to construct oneclick register
	 * 
	 * @param credential  Authentication info
	 * @param buyerEmail  Client e-mail
	 * @param paymentCode Payment identification
	 * @return Oneclick register builder
	 */
	public static Builder getBuilder(Credential credential, String buyerEmail, Long paymentCode) {
		return new Builder(credential, buyerEmail, paymentCode);
	}

	public String getCardHolderName() {
		return cardHolderName;
	}

	void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getBuyerEmail() {
		return buyerEmail;
	}

	void setBuyerEmail(String buyerEmail) {
		this.buyerEmail = buyerEmail;
	}

	public Long getPaymentCode() {
		return paymentCode;
	}

	void setPaymentCode(Long paymentCode) {
		this.paymentCode = paymentCode;
	}

	@Override
	public String getStoreCode() {
		return storeCode;
	}

	void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}

	@Override
	public String getModelReference() {
		return tokenOneClick;
	}

	@Override
	public Long getValue() {
		return null;
	}
}
