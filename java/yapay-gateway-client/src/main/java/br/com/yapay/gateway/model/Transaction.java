package br.com.yapay.gateway.model;

import static org.apache.commons.lang3.StringUtils.isNoneBlank;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

/**
 * Model of punctual transactions
 * 
 * @author Adriano Santos
 *
 */
public class Transaction extends RequestModel {

	private transient String tokenOneClick;

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
		super(null);
	}

	private Transaction(Builder builder) {
		super(builder.credential);
		setResourcePath(builder.resourcePath);
		this.tokenOneClick = builder.tokenOneClick;
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
		private static final String API_RESOURCE_PATH = "/api/v3/transacao/";

		private final Credential credential;

		private String resourcePath;
		private String tokenOneClick;
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

		private Builder(Credential credential, Long transactionNumber) {
			this(credential, null, transactionNumber, null);
		}

		private Builder(Credential credential, Long transactionNumber, Long value) {
			this(credential, null, transactionNumber, value);
		}

		private Builder(Credential credential, Integer paymentCode, Long transactionNumber, Long value) {
			this.credential = credential;
			this.resourcePath = API_RESOURCE_PATH;
			this.paymentCode = paymentCode;
			this.transactionData = new TransactionData(transactionNumber, value);
			this.storeCode = credential.getStoreCode();
		}

		public Builder withResourcePath(String resourcePath) {
			this.resourcePath = resourcePath;
			return this;
		}

		public Builder withStoreCode(String storeCode) {
			this.storeCode = storeCode;
			return this;
		}

		public Builder withPaymentCode(Integer paymentCode) {
			this.paymentCode = paymentCode;
			return this;
		}

		public Builder withTokenOneClick(String tokenOneClick) {
			this.tokenOneClick = tokenOneClick;
			if (API_RESOURCE_PATH.equals(this.resourcePath)) {
				this.resourcePath = "/api/v3/oneclick/";
			}
			return this;
		}

		public Builder withCardCvv(String cvv) {
			return withCard(new CardData(cvv));
		}

		public Builder withCard(String cardHolderName, String cardNumber, int expirationMonth, int expirationYear,
				String cvv) {
			return withCard(new CardData(cardHolderName, cardNumber, expirationMonth, expirationYear, cvv));
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

		public Builder withCharging(String clientName, String clientEmail, String clientDocument) {
			return withCharging(new ChargingData(clientName, clientEmail, clientDocument));
		}

		public Builder withCharging(String clientName, String clientEmail, String clientBirthday, String clientGenre,
				String clientDocument, String clientDocumentTwo, AddressData clientAddress,
				List<PhoneData> clientPhones) {
			return withCharging(new ChargingData(clientName, clientEmail, clientBirthday, clientGenre, clientDocument,
					clientDocumentTwo, clientAddress, clientPhones));
		}

		public Builder withCharging(ChargingData charging) {
			this.charging = charging;
			return this;
		}

		public Builder withChargingAddress(String street, String number, String zipCode, String district, String city,
				String state) {
			return withChargingAddress(new AddressData(street, number, zipCode, district, city, state));
		}

		public Builder withChargingAddress(String street, String number, String complement, String zipCode,
				String district, String city, String state, String country) {
			return withChargingAddress(
					new AddressData(street, number, complement, zipCode, district, city, state, country));
		}

		public Builder withChargingAddress(AddressData clientAddress) {
			if (this.charging != null) {
				this.charging.setClientAddress(clientAddress);
			}
			return this;
		}

		public Builder addChargingPhone(String ddd, String number) {
			return addChargingPhone(new PhoneData(ddd, number));
		}

		public Builder addChargingPhone(String ddi, String ddd, String number) {
			return addChargingPhone(new PhoneData(ddi, ddd, number));
		}

		public Builder addChargingPhone(PhoneData clientPhone) {
			if (this.charging != null) {
				this.charging.addClientPhone(clientPhone);
			}
			return this;
		}

		public Builder withDelivery(DeliveryData delivery) {
			this.delivery = delivery;
			return this;
		}

		public Builder withDeliveryAddress(String street, String number, String zipCode, String district, String city,
				String state) {
			return withDeliveryAddress(new AddressData(street, number, zipCode, district, city, state));
		}

		public Builder withDeliveryAddress(String street, String number, String complement, String zipCode,
				String district, String city, String state, String country) {
			return withDeliveryAddress(
					new AddressData(street, number, complement, zipCode, district, city, state, country));
		}

		public Builder withDeliveryAddress(AddressData deliveryAddress) {
			if (this.delivery != null) {
				this.delivery.setDeliveryAddress(deliveryAddress);
			}
			return this;
		}

		public Builder addDeliveryPhone(String ddd, String number) {
			return addDeliveryPhone(new PhoneData(ddd, number));
		}

		public Builder addDeliveryPhone(String ddi, String ddd, String number) {
			return addDeliveryPhone(new PhoneData(ddi, ddd, number));
		}

		public Builder addDeliveryPhone(PhoneData deliveryPhone) {
			if (this.delivery != null) {
				this.delivery.addDeliveryPhone(deliveryPhone);
			}
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

		public Builder withCheckout(CheckoutData checkout) {
			this.checkout = checkout;
			return this;
		}

		public Builder withCheckoutProcess() {
			if (this.checkout == null) {
				this.checkout = new CheckoutData();
			}
			this.checkout.setProcess(1);
			return this;
		}

		public Builder withCheckoutPaymentType(Integer paymentType) {
			if (this.checkout == null) {
				this.checkout = new CheckoutData();
			}
			this.checkout.setPaymentType(paymentType);
			return this;
		}

		public Builder withCheckoutMultipleCard() {
			if (this.checkout == null) {
				this.checkout = new CheckoutData();
			}
			this.checkout.setMultipleCard(1);
			return this;
		}

		public Builder addCheckoutMultipleBillData(Long value, String dueDate) {
			return addCheckoutMultipleBillData(new TransactionCheckoutMultipleBillData(value, dueDate));
		}

		public Builder addCheckoutMultipleBillData(TransactionCheckoutMultipleBillData multipleBillData) {
			if (this.checkout == null) {
				this.checkout = new CheckoutData();
			}
			this.checkout.setMultipleBill(1);
			this.checkout.addMultipleBillData(multipleBillData);
			return this;
		}

		public Builder withTransactionData(TransactionData transactionData) {
			this.transactionData = transactionData;
			return this;
		}

		public Builder withInstallments(Integer installments) {
			this.transactionData.setInstallments(installments);
			return this;
		}

		public Builder withTransactionNumber(Long transactionNumber) {
			this.transactionData.setTransactionNumber(transactionNumber);
			return this;
		}

		public Builder withValue(Long value) {
			this.transactionData.setValue(value);
			return this;
		}

		public Builder withDiscountValue(Long discountValue) {
			this.transactionData.setDiscountValue(discountValue);
			return this;
		}

		public Builder withBoardingFee(Long boardingFee) {
			this.transactionData.setBoardingFee(boardingFee);
			return this;
		}

		public Builder withInstallmentType(String installmentType) {
			this.transactionData.setInstallmentType(installmentType);
			return this;
		}

		public Builder withNotificationUrl(String notificationUrl) {
			this.transactionData.setNotificationUrl(notificationUrl);
			return this;
		}

		public Builder withResultUrl(String resultUrl) {
			this.transactionData.setResultUrl(resultUrl);
			return this;
		}

		public Builder withUnpaidRedirectUrl(String unpaidRedirectUrl) {
			this.transactionData.setUnpaidRedirectUrl(unpaidRedirectUrl);
			return this;
		}

		public Builder withLanguage(Integer language) {
			this.transactionData.setLanguage(language);
			return this;
		}

		public Builder withIp(String ip) {
			this.transactionData.setIp(ip);
			return this;
		}

		public Builder withBrowser(String browser) {
			this.transactionData.setBrowser(browser);
			return this;
		}

		public Builder withTransactionOrigin(Integer transactionOrigin) {
			this.transactionData.setTransactionOrigin(transactionOrigin);
			return this;
		}

		public Builder withFreeFieldOne(String freeFieldOne) {
			this.transactionData.setFreeFieldOne(freeFieldOne);
			return this;
		}

		public Builder withFreeFieldTwo(String freeFieldTwo) {
			this.transactionData.setFreeFieldTwo(freeFieldTwo);
			return this;
		}

		public Builder withFreeFieldThree(String freeFieldThree) {
			this.transactionData.setFreeFieldThree(freeFieldThree);
			return this;
		}

		public Builder withFreeFieldFour(String freeFieldFour) {
			this.transactionData.setFreeFieldFour(freeFieldFour);
			return this;
		}

		public Builder withFreeFieldFive(String freeFieldFive) {
			this.transactionData.setFreeFieldFive(freeFieldFive);
			return this;
		}

		public Builder withBillDueDate(String billDueDate) {
			this.transactionData.setBillDueDate(billDueDate);
			return this;
		}

		public Builder withCountry(String country) {
			this.transactionData.setCountry(country);
			return this;
		}

		public Builder withCurrency(String currency) {
			this.transactionData.setCurrency(currency);
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
	 * Getting builder with minimum parameters
	 * 
	 * @param credential        Authentication info
	 * @param transactionNumber Order identification
	 * @return Transaction builder
	 */
	public static Builder getBuilder(Credential credential, Long transactionNumber) {
		return new Builder(credential, transactionNumber);
	}

	/**
	 * Getting builder to construct transaction with {@code value}
	 * 
	 * @param credential        Authentication info
	 * @param transactionNumber Order identification
	 * @param value             Order value
	 * @return Transaction builder
	 */
	public static Builder getBuilder(Credential credential, Long transactionNumber, Long value) {
		return new Builder(credential, transactionNumber, value);
	}

	/**
	 * Getting builder to construct authorization transaction
	 * 
	 * @param credential        Authentication info
	 * @param paymentCode       Payment identification
	 * @param transactionNumber Order identification
	 * @param value             Order value
	 * @return Transaction builder
	 */
	public static Builder getBuilder(Credential credential, Integer paymentCode, Long transactionNumber, Long value) {
		return new Builder(credential, paymentCode, transactionNumber, value);
	}

	public Integer getPaymentCode() {
		return paymentCode;
	}

	void setPaymentCode(Integer paymentCode) {
		this.paymentCode = paymentCode;
	}

	public TransactionData getTransactionData() {
		return transactionData;
	}

	void setTransactionData(TransactionData transactionData) {
		this.transactionData = transactionData;
	}

	public CheckoutData getCheckout() {
		return checkout;
	}

	void setCheckout(CheckoutData checkout) {
		this.checkout = checkout;
	}

	public CardData getCard() {
		return card;
	}

	void setCard(CardData card) {
		this.card = card;
	}

	public List<MultipleCardData> getMultipleCards() {
		return multipleCards;
	}

	void setMultipleCards(List<MultipleCardData> multipleCards) {
		this.multipleCards = multipleCards;
	}

	public List<ItemData> getItems() {
		return items;
	}

	void setItems(List<ItemData> items) {
		this.items = items;
	}

	public ChargingData getCharging() {
		return charging;
	}

	void setCharging(ChargingData charging) {
		this.charging = charging;
	}

	public DeliveryData getDelivery() {
		return delivery;
	}

	void setDelivery(DeliveryData delivery) {
		this.delivery = delivery;
	}

	public AirlineData getAirline() {
		return airline;
	}

	void setAirline(AirlineData airline) {
		this.airline = airline;
	}

	public List<ExtraField> getExtraFields() {
		return extraFields;
	}

	void setExtraFields(List<ExtraField> extraFields) {
		this.extraFields = extraFields;
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
		if (isNoneBlank(this.tokenOneClick)) {
			return this.tokenOneClick;
		}
		if (this.transactionData == null) {
			return null;
		}
		return this.transactionData.getTransactionNumber() == null ? null
				: this.transactionData.getTransactionNumber().toString();
	}

	@Override
	public Long getValue() {
		if (this.transactionData == null) {
			return null;
		}
		return this.transactionData.getValue();
	}
}
