package br.com.yapay.gateway.model;

import com.google.gson.annotations.SerializedName;

/**
 * Model of recurring payments registering
 * 
 * @author Adriano Santos
 *
 */
public class RecurringPayment extends RequestModel {

	@SerializedName("recorrencia")
	private RecurringPaymentData recurringPaymentData;

	@SerializedName("estabelecimento")
	private String storeCode;

	/**
	 * @deprecated JSON bind eyes only
	 */
	@Deprecated
	RecurringPayment() {
		super(null);
	}

	private RecurringPayment(Builder builder) {
		super(builder.credential);
		setResourcePath(builder.resourcePath);
		this.recurringPaymentData = builder.getRecurringPaymentData();
		this.storeCode = builder.storeCode;
	}

	/**
	 * Class containing rules of recurring payment building
	 * 
	 * @author Adriano Santos
	 *
	 */
	public static class Builder {
		private final Credential credential;
		private String resourcePath;

		private String storeCode;

		private Long paymentCode;
		private Long recurringPaymentNumber;
		private Long value;
		private Integer frequency;
		private String notificationUrl;
		private boolean processImmediately;
		private Integer billingAmount;
		private String billingFirstDate;
		private String freeFieldOne;
		private String freeFieldTwo;
		private String freeFieldThree;
		private String freeFieldFour;
		private String freeFieldFive;
		private CardData card;
		private RecurringPaymentChargingData chargingData;
		private RecurringPaymentDeliveryData deliveryData;

		private Builder(Credential credential, Long recurringPaymentNumber) {
			this(credential, null, recurringPaymentNumber, null);
		}

		private Builder(Credential credential, Long recurringPaymentNumber, Long value) {
			this(credential, null, recurringPaymentNumber, value);
		}

		private Builder(Credential credential, Long paymentCode, Long recurringPaymentNumber, Long value) {
			this.credential = credential;
			this.resourcePath = "/api/v3/recorrencia/";
			this.paymentCode = paymentCode;
			this.recurringPaymentNumber = recurringPaymentNumber;
			this.value = value;
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

		public Builder withPaymentCode(Long paymentCode) {
			this.paymentCode = paymentCode;
			return this;
		}

		public Builder withRecurringPaymentNumber(Long recurringPaymentNumber) {
			this.recurringPaymentNumber = recurringPaymentNumber;
			return this;
		}

		public Builder withValue(Long value) {
			this.value = value;
			return this;
		}

		public Builder withFrequency(Frequency frequency) {
			return withFrequency(frequency.code);
		}

		public Builder withFrequency(Integer frequency) {
			this.frequency = frequency;
			return this;
		}

		public Builder withNotificationUrl(String notificationUrl) {
			this.notificationUrl = notificationUrl;
			return this;
		}

		public Builder withProcessImmediately() {
			this.processImmediately = true;
			return this;
		}

		public Builder withBillingAmount(Integer billingAmount) {
			this.billingAmount = billingAmount;
			return this;
		}

		public Builder withBillingFirstDate(String billingFirstDate) {
			this.billingFirstDate = billingFirstDate;
			return this;
		}

		public Builder withFreeFieldOne(String freeFieldOne) {
			this.freeFieldOne = freeFieldOne;
			return this;
		}

		public Builder withFreeFieldTwo(String freeFieldTwo) {
			this.freeFieldTwo = freeFieldTwo;
			return this;
		}

		public Builder withFreeFieldThree(String freeFieldThree) {
			this.freeFieldThree = freeFieldThree;
			return this;
		}

		public Builder withFreeFieldFour(String freeFieldFour) {
			this.freeFieldFour = freeFieldFour;
			return this;
		}

		public Builder withFreeFieldFive(String freeFieldFive) {
			this.freeFieldFive = freeFieldFive;
			return this;
		}

		public Builder withCard(String cardHolderName, String cardNumber, String expirationDate) {
			return withCard(cardHolderName, cardNumber, expirationDate, null);
		}

		public Builder withCard(String cardHolderName, String cardNumber, String expirationDate, String cvv) {
			return withCard(new CardData(cardHolderName, cardNumber, expirationDate, cvv));
		}

		public Builder withCard(CardData card) {
			this.card = card;
			return this;
		}

		public Builder withChargingData(String clientName, String clientEmail, String clientDocument) {
			return withChargingData(new RecurringPaymentChargingData(clientName, clientEmail, clientDocument));
		}

		public Builder withChargingData(String clientName, String clientEmail, String clientBirthday,
				String clientGenre, String clientDocument, String clientDocumentTwo, AddressData clientAddress,
				PhoneData clientPhone) {
			RecurringPaymentChargingData data = new RecurringPaymentChargingData(clientName, clientEmail,
					clientBirthday, clientGenre, clientDocument, clientDocumentTwo, clientPhone);
			if (clientAddress != null) {
				data.setClientAddress(clientAddress.getStreet(), clientAddress.getNumber(),
						clientAddress.getComplement(), clientAddress.getZipCode(), clientAddress.getDistrict(),
						clientAddress.getCity(), clientAddress.getState(), clientAddress.getCountry());
			}
			return withChargingData(data);
		}

		public Builder withChargingData(RecurringPaymentChargingData chargingData) {
			this.chargingData = chargingData;
			return this;
		}

		public Builder withChargingDataAddress(String street, String number, String complement, String zipCode,
				String district, String city, String state, String country) {
			if (this.chargingData != null) {
				this.chargingData.setClientAddress(street, number, complement, zipCode, district, city, state, country);
			}
			return this;
		}

		public Builder withChargingDataAddress(String street, String number, String zipCode, String district,
				String city, String state) {
			if (this.chargingData != null) {
				this.chargingData.setClientAddress(street, number, zipCode, district, city, state);
			}
			return this;
		}

		public Builder withChargingDataAddress(AddressData clientAddress) {
			if (clientAddress != null) {
				return withChargingDataAddress(clientAddress.getStreet(), clientAddress.getNumber(),
						clientAddress.getComplement(), clientAddress.getZipCode(), clientAddress.getDistrict(),
						clientAddress.getCity(), clientAddress.getState(), clientAddress.getCountry());
			}
			return this;
		}

		public Builder withChargingDataPhone(String ddd, String number) {
			return withChargingDataPhone(new PhoneData(ddd, number));
		}

		public Builder withChargingDataPhone(String ddi, String ddd, String number) {
			return withChargingDataPhone(new PhoneData(ddi, ddd, number));
		}

		public Builder withChargingDataPhone(PhoneData clientPhone) {
			if (this.chargingData != null) {
				this.chargingData.setPhone(clientPhone);
			}
			return this;
		}

		public Builder withDeliveryData(String deliveryName, String deliveryMail) {
			return withDeliveryData(new RecurringPaymentDeliveryData(deliveryName, deliveryMail));
		}

		public Builder withDeliveryData(RecurringPaymentDeliveryData deliveryData) {
			this.deliveryData = deliveryData;
			return this;
		}

		public Builder withDeliveryDataAddress(String street, String number, String complement, String zipCode,
				String district, String city, String state, String country) {
			if (this.deliveryData != null) {
				this.deliveryData.setDeliveryAddress(street, number, complement, zipCode, district, city, state,
						country);
			}
			return this;
		}

		public Builder withDeliveryDataAddress(String street, String number, String zipCode, String district,
				String city, String state) {
			if (this.deliveryData != null) {
				this.deliveryData.setDeliveryAddress(street, number, zipCode, district, city, state);
			}
			return this;
		}

		public Builder withDeliveryDataAddress(AddressData deliveryAddress) {
			if (deliveryData != null) {
				return withDeliveryDataAddress(deliveryAddress.getStreet(), deliveryAddress.getNumber(),
						deliveryAddress.getComplement(), deliveryAddress.getZipCode(), deliveryAddress.getDistrict(),
						deliveryAddress.getCity(), deliveryAddress.getState(), deliveryAddress.getCountry());
			}
			return this;
		}

		public Builder withDeliveryDataPhone(String ddd, String number) {
			return withDeliveryDataPhone(new PhoneData(ddd, number));
		}

		public Builder withDeliveryDataPhone(String ddi, String ddd, String number) {
			return withDeliveryDataPhone(new PhoneData(ddi, ddd, number));
		}

		public Builder withDeliveryDataPhone(PhoneData deliveryPhone) {
			if (this.deliveryData != null) {
				this.deliveryData.setPhone(deliveryPhone);
			}
			return this;
		}

		/**
		 * Recurring payment build with specified properties
		 * 
		 * @return Instance of recurring payment
		 */
		public RecurringPayment build() {
			return new RecurringPayment(this);
		}

		private RecurringPaymentData getRecurringPaymentData() {
			RecurringPaymentData data = new RecurringPaymentData();
			data.setBillingAmount(billingAmount);
			data.setBillingFirstDate(billingFirstDate);
			data.setCard(card);
			data.setChargingData(chargingData);
			data.setDeliveryData(deliveryData);
			data.setFreeFieldFive(freeFieldFive);
			data.setFreeFieldFour(freeFieldFour);
			data.setFreeFieldThree(freeFieldThree);
			data.setFreeFieldTwo(freeFieldTwo);
			data.setFreeFieldOne(freeFieldOne);
			data.setFrequency(frequency);
			data.setNotificationUrl(notificationUrl);
			data.setPaymentCode(paymentCode);
			data.setProcessImmediately(processImmediately);
			data.setRecurringPaymentNumber(recurringPaymentNumber);
			data.setValue(value);

			return data;
		}
	}

	public static enum Frequency {
		MONTHLY(3), BIMONTHLY(4), QUARTERLY(5), SEMIANNUALLY(6), ANNUALLY(7);

		private final int code;

		private Frequency(int code) {
			this.code = code;
		}
	}

	/**
	 * Getting builder with minimum parameters
	 * 
	 * @param credential             Authentication info
	 * @param recurringPaymentNumber Payment identification
	 * @return Recurring payment builder
	 */
	public static Builder getBuilder(Credential credential, Long recurringPaymentNumber) {
		return new Builder(credential, recurringPaymentNumber);
	}

	/**
	 * Getting builder to construct recurring transaction with {@code value}
	 * 
	 * @param credential             Authentication info
	 * @param recurringPaymentNumber Payment identification
	 * @param value                  Recurrence value
	 * @return Recurring payment builder
	 */
	public static Builder getBuilder(Credential credential, Long recurringPaymentNumber, Long value) {
		return new Builder(credential, recurringPaymentNumber, value);
	}

	/**
	 * Getting builder to construct recurring register
	 * 
	 * @param credential             Authentication info
	 * @param paymentCode            Payment identification
	 * @param recurringPaymentNumber Recurrence identification
	 * @param value                  Recurrence value
	 * @return Recurring payment builder
	 */
	public static Builder getBuilder(Credential credential, Long paymentCode, Long recurringPaymentNumber, Long value) {
		return new Builder(credential, paymentCode, recurringPaymentNumber, value);
	}

	public RecurringPaymentData getRecurringPaymentData() {
		return recurringPaymentData;
	}

	void setRecurringPaymentData(RecurringPaymentData recurringPaymentData) {
		this.recurringPaymentData = recurringPaymentData;
	}

	@Override
	public String getStoreCode() {
		return storeCode;
	}

	void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}

	@Override
	public Long getModelReference() {
		if (this.recurringPaymentData == null) {
			return null;
		}
		return this.recurringPaymentData.getRecurringPaymentNumber();
	}

	@Override
	public Long getValue() {
		if (this.recurringPaymentData == null) {
			return null;
		}
		return this.recurringPaymentData.getValue();
	}
}
