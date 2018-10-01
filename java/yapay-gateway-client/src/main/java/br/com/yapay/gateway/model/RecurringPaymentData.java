package br.com.yapay.gateway.model;

import com.google.gson.annotations.SerializedName;

public class RecurringPaymentData {

	@SerializedName("formaPagamento")
	private Long paymentCode;

	@SerializedName("numeroRecorrencia")
	private Long recurringPaymentNumber;

	@SerializedName("valor")
	private Long value;

	@SerializedName("modalidade")
	private Integer modality;

	@SerializedName("periodicidade")
	private Integer frequency;

	@SerializedName("urlNotificacao")
	private String notificationUrl;

	@SerializedName("processarImediatamente")
	private Boolean processImmediately;

	@SerializedName("quantidadeCobrancas")
	private Integer billingAmount;

	@SerializedName("dataPrimeiraCobranca")
	private String billingFirstDate;

	@SerializedName("vencimentoBoleto")
	private String billDueDate;

	@SerializedName("campoLivre1")
	private String freeFieldOne;

	@SerializedName("campoLivre2")
	private String freeFieldTwo;

	@SerializedName("campoLivre3")
	private String freeFieldThree;

	@SerializedName("campoLivre4")
	private String freeFieldFour;

	@SerializedName("campoLivre5")
	private String freeFieldFive;

	@SerializedName("dadosCartao")
	private CreditCardData creditCard;

	@SerializedName("dadosDebito")
	private DebitCardData debitCard;

	@SerializedName("dadosCobranca")
	private RecurringPaymentChargingData chargingData;

	@SerializedName("dadosEntrega")
	private RecurringPaymentDeliveryData deliveryData;

	public Long getPaymentCode() {
		return paymentCode;
	}

	public void setPaymentCode(Long paymentCode) {
		this.paymentCode = paymentCode;
	}

	public Long getRecurringPaymentNumber() {
		return recurringPaymentNumber;
	}

	public void setRecurringPaymentNumber(Long recurringPaymentNumber) {
		this.recurringPaymentNumber = recurringPaymentNumber;
	}

	public Long getValue() {
		return value;
	}

	public void setValue(Long value) {
		this.value = value;
	}

	public Integer getModality() {
		return modality;
	}

	public void setModality(Integer modality) {
		this.modality = modality;
	}

	public Integer getFrequency() {
		return frequency;
	}

	public void setFrequency(Integer frequency) {
		this.frequency = frequency;
	}

	public String getNotificationUrl() {
		return notificationUrl;
	}

	public void setNotificationUrl(String notificationUrl) {
		this.notificationUrl = notificationUrl;
	}

	public Boolean getProcessImmediately() {
		return processImmediately;
	}

	public void setProcessImmediately(Boolean processImmediately) {
		this.processImmediately = processImmediately;
	}

	public Integer getBillingAmount() {
		return billingAmount;
	}

	public void setBillingAmount(Integer billingAmount) {
		this.billingAmount = billingAmount;
	}

	public String getBillingFirstDate() {
		return billingFirstDate;
	}

	public void setBillingFirstDate(String billingFirstDate) {
		this.billingFirstDate = billingFirstDate;
	}

	public String getBillDueDate() {
		return billDueDate;
	}

	public void setBillDueDate(String billDueDate) {
		this.billDueDate = billDueDate;
	}

	public String getFreeFieldOne() {
		return freeFieldOne;
	}

	public void setFreeFieldOne(String freeFieldOne) {
		this.freeFieldOne = freeFieldOne;
	}

	public String getFreeFieldTwo() {
		return freeFieldTwo;
	}

	public void setFreeFieldTwo(String freeFieldTwo) {
		this.freeFieldTwo = freeFieldTwo;
	}

	public String getFreeFieldThree() {
		return freeFieldThree;
	}

	public void setFreeFieldThree(String freeFieldThree) {
		this.freeFieldThree = freeFieldThree;
	}

	public String getFreeFieldFour() {
		return freeFieldFour;
	}

	public void setFreeFieldFour(String freeFieldFour) {
		this.freeFieldFour = freeFieldFour;
	}

	public String getFreeFieldFive() {
		return freeFieldFive;
	}

	public void setFreeFieldFive(String freeFieldFive) {
		this.freeFieldFive = freeFieldFive;
	}

	public CreditCardData getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCardData creditCard) {
		this.creditCard = creditCard;
	}

	public DebitCardData getDebitCard() {
		return debitCard;
	}

	public void setDebitCard(DebitCardData debitCard) {
		this.debitCard = debitCard;
	}

	public RecurringPaymentChargingData getChargingData() {
		return chargingData;
	}

	public void setChargingData(RecurringPaymentChargingData chargingData) {
		this.chargingData = chargingData;
	}

	public RecurringPaymentDeliveryData getDeliveryData() {
		return deliveryData;
	}

	public void setDeliveryData(RecurringPaymentDeliveryData deliveryData) {
		this.deliveryData = deliveryData;
	}

}
