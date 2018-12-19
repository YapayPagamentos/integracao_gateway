package br.com.yapay.gateway.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.google.gson.annotations.SerializedName;

/**
 * Recurring payment detail info
 * 
 * @author Adriano Santos
 *
 */
public class RecurringPaymentData {

	@SerializedName("formaPagamento")
	private Integer paymentCode;

	@SerializedName("numeroRecorrencia")
	private Long recurringPaymentNumber;

	@SerializedName("valor")
	private Long value;

	@SerializedName("modalidade")
	private Integer modality = 1;

	@SerializedName("periodicidade")
	private Integer frequency = 3;

	@SerializedName("urlNotificacao")
	private String notificationUrl;

	@SerializedName("processarImediatamente")
	private Boolean processImmediately;

	@SerializedName("quantidadeCobrancas")
	private Integer installments = 0;

	@SerializedName("dataPrimeiraCobranca")
	private String startDate;

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
	private CardData card;

	@SerializedName("dadosCobranca")
	private RecurringPaymentChargingData chargingData;

	@SerializedName("dadosEntrega")
	private RecurringPaymentDeliveryData deliveryData;

	public Integer getPaymentCode() {
		return paymentCode;
	}

	public void setPaymentCode(Integer paymentCode) {
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

	public Integer getInstallments() {
		return installments;
	}

	public void setInstallments(Integer installments) {
		this.installments = installments;
	}

	public String getStartDate() {
		return startDate;
	}

	void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * Setting start date from {@link LocalDate}
	 * 
	 * @param startDate Start date
	 */
	public void setStartDate(LocalDate startDate) {
		String startDateStr = startDate == null ? null : startDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		setStartDate(startDateStr);
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

	public CardData getCard() {
		return card;
	}

	public void setCard(CardData card) {
		this.card = card;
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
