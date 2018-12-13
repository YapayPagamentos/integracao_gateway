package br.com.yapay.gateway.model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

/**
 * Model of punctual transactions
 * 
 * @author Adriano Santos
 *
 */
public class Transaction {

	private final transient Credential credential;

	@SerializedName("codigoEstabelecimento")
	private String storeCode;

	@SerializedName("codigoFormaPagamento")
	private Integer paymentCode;

	@SerializedName("transacao")
	private TransactionData transactionData;

	@SerializedName("checkout")
	private CheckoutData checkout;

	@SerializedName("dadosCartao")
	private CardData card;

	@SerializedName("dadosMultiplosCartoes")
	private List<MultipleCardData> multipleCards;

	@SerializedName("itensDoPedido")
	private List<ItemData> items;

	@SerializedName("dadosCobranca")
	private ChargingData charging;

	@SerializedName("dadosEntrega")
	private DeliveryData delivery;

	@SerializedName("dadosAirline")
	private AirlineData airline;

	@SerializedName("camposExtras")
	private List<ExtraField> extraFields;

	/**
	 * @deprecated JSON bind eyes only
	 */
	@Deprecated
	Transaction() {
		this.credential = null;
	}

	private Transaction(Builder builder) {
		this.credential = builder.credential;
		this.storeCode = builder.storeCode;
		this.paymentCode = builder.paymentCode;
		this.transactionData = builder.transactionData;
		this.checkout = builder.checkout;
		this.card = builder.card;
		this.multipleCards = builder.multipleCards;
		this.items = builder.items;
		this.charging = builder.charging;
		this.delivery = builder.delivery;
		this.airline = builder.airline;
		this.extraFields = builder.extraFields;
	}

	/**
	 * Class containing rules of transaction building
	 * 
	 * @author Adriano Santos
	 *
	 */
	public static class Builder {
		private final Credential credential;

		private String storeCode;
		private Integer paymentCode;
		private TransactionData transactionData;
		private CheckoutData checkout;
		private CardData card;
		private List<MultipleCardData> multipleCards;
		private List<ItemData> items;
		private ChargingData charging;
		private DeliveryData delivery;
		private AirlineData airline;
		private List<ExtraField> extraFields;

		private Builder(Credential credential, Integer paymentCode, Long transactionNumber, Long value) {
			this.credential = credential;
			this.paymentCode = paymentCode;
			this.transactionData = new TransactionData(transactionNumber, value);
			this.storeCode = credential.getStoreCode();
		}

		public Builder withStoreCode(String storeCode) {
			this.storeCode = storeCode;
			return this;
		}

		public Builder withPaymentCode(Integer paymentCode) {
			this.paymentCode = paymentCode;
			return this;
		}

		public Builder withTransactionData(TransactionData transactionData) {
			this.transactionData = transactionData;
			return this;
		}

		public Builder withCheckout(CheckoutData checkout) {
			this.checkout = checkout;
			return this;
		}

		public Builder withCard(String cardHolderName, String cardNumber, String expirationDate, String cvv) {
			return withCard(new CardData(cardHolderName, cardNumber, expirationDate, cvv));
		}

		public Builder withCard(CardData card) {
			this.card = card;
			return this;
		}

		public Builder withMultipleCards(List<MultipleCardData> multipleCards) {
			this.multipleCards = multipleCards;
			return this;
		}

		public Builder addMultipleCard(MultipleCardData card) {
			if (this.multipleCards == null) {
				this.multipleCards = new ArrayList<>();
			}
			this.multipleCards.add(card);
			return this;
		}

		public Builder withItems(List<ItemData> items) {
			this.items = items;
			return this;
		}

		public Builder addItem(String name, Integer amount, Long value) {
			ItemData item = new ItemData();
			item.setProductCategory("1");
			item.setProductCode("1");
			item.setProductAmount(amount);
			item.setProductName(name);
			item.setProductUnitaryValue(value);
			return addItem(item);
		}

		public Builder addItem(ItemData item) {
			if (this.items == null) {
				this.items = new ArrayList<>();
			}
			this.items.add(item);
			return this;
		}

		public Builder withCharging(ChargingData charging) {
			this.charging = charging;
			return this;
		}

		public Builder withDelivery(DeliveryData delivery) {
			this.delivery = delivery;
			return this;
		}

		public Builder withAirline(AirlineData airline) {
			this.airline = airline;
			return this;
		}

		public Builder withExtraFields(List<ExtraField> extraFields) {
			this.extraFields = extraFields;
			return this;
		}

		public Builder addExtraField(int key, String value) {
			return addExtraField(new ExtraField(key, value));
		}

		public Builder addExtraField(ExtraField extraField) {
			if (this.extraFields == null) {
				this.extraFields = new ArrayList<>();
			}
			this.extraFields.add(extraField);
			return this;
		}

		public Builder withInstallments(Integer installments) {
			this.transactionData.setInstallments(installments);
			return this;
		}

		/**
		 * Transaction build with specified properties
		 * 
		 * @return Instance of transaction
		 */
		public Transaction build() {
			return new Transaction(this);
		}
	}

	/**
	 * Getting builder to construct transaction
	 * 
	 * @param credential        Authentication info
	 * @param paymentCode       Payment identification
	 * @param transactionNumber Order identification
	 * @param value             Order value
	 * @return Transaction builder
	 */
	public Builder getBuilder(Credential credential, Integer paymentCode, Long transactionNumber, Long value) {
		return new Builder(credential, paymentCode, transactionNumber, value);
	}

	public String getStoreCode() {
		return storeCode;
	}

	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}

	public Integer getPaymentCode() {
		return paymentCode;
	}

	public void setPaymentCode(Integer paymentCode) {
		this.paymentCode = paymentCode;
	}

	public TransactionData getTransactionData() {
		return transactionData;
	}

	public void setTransactionData(TransactionData transactionData) {
		this.transactionData = transactionData;
	}

	public CheckoutData getCheckout() {
		return checkout;
	}

	public void setCheckout(CheckoutData checkout) {
		this.checkout = checkout;
	}

	public CardData getCard() {
		return card;
	}

	public void setCard(CardData card) {
		this.card = card;
	}

	public List<MultipleCardData> getMultipleCards() {
		return multipleCards;
	}

	public void setMultipleCards(List<MultipleCardData> multipleCards) {
		this.multipleCards = multipleCards;
	}

	public List<ItemData> getItems() {
		return items;
	}

	public void setItems(List<ItemData> items) {
		this.items = items;
	}

	public ChargingData getCharging() {
		return charging;
	}

	public void setCharging(ChargingData charging) {
		this.charging = charging;
	}

	public DeliveryData getDelivery() {
		return delivery;
	}

	public void setDelivery(DeliveryData delivery) {
		this.delivery = delivery;
	}

	public AirlineData getAirline() {
		return airline;
	}

	public void setAirline(AirlineData airline) {
		this.airline = airline;
	}

	public List<ExtraField> getExtraFields() {
		return extraFields;
	}

	public void setExtraFields(List<ExtraField> extraFields) {
		this.extraFields = extraFields;
	}

	public Credential getCredential() {
		return credential;
	}
}
