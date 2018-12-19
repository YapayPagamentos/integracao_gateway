package br.com.yapay.gateway.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.google.gson.annotations.SerializedName;

/**
 * Transaction detail info
 * 
 * @author Adriano Santos
 *
 */
public class TransactionData {

	@SerializedName("numeroTransacao")
	private Long transactionNumber;

	@SerializedName("valor")
	private Long value;

	@SerializedName("valorDesconto")
	private Long discountValue;

	@SerializedName("taxaEmbarque")
	private Long boardingFee;

	@SerializedName("parcelas")
	private Integer installments;

	@SerializedName("tipoParcelamento")
	private String installmentType;

	@SerializedName("urlCampainha")
	private String notificationUrl;

	@SerializedName("urlResultado")
	private String resultUrl;

	@SerializedName("urlRedirecionamentoNaoPago")
	private String unpaidRedirectUrl;

	@SerializedName("idioma")
	private Integer language;

	@SerializedName("ip")
	private String ip;

	@SerializedName("browser")
	private String browser;

	@SerializedName("origemTransacao")
	private Integer transactionOrigin;

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

	@SerializedName("dataVencimentoBoleto")
	private String billDueDate;

	@SerializedName("pais")
	private String country;

	@SerializedName("moeda")
	private String currency;

	/**
	 * @deprecated JSON bind eyes only
	 */
	@Deprecated
	TransactionData() {
	}

	/**
	 * Constructor with {@code value} for convenience
	 * 
	 * @param transactionNumber Order identification
	 * @param value             Order value
	 */
	public TransactionData(Long transactionNumber, Long value) {
		this.transactionNumber = transactionNumber;
		this.value = value;
		this.language = 1;
		this.installments = 1;
	}

	/**
	 * Constructor with required {@code transactionNumber}
	 * 
	 * @param transactionNumber Order identification
	 */
	public TransactionData(Long transactionNumber) {
		this(transactionNumber, null);
	}

	public Long getTransactionNumber() {
		return transactionNumber;
	}

	public void setTransactionNumber(Long transactionNumber) {
		this.transactionNumber = transactionNumber;
	}

	public Long getValue() {
		return value;
	}

	public void setValue(Long value) {
		this.value = value;
	}

	public Long getDiscountValue() {
		return discountValue;
	}

	public void setDiscountValue(Long discountValue) {
		this.discountValue = discountValue;
	}

	public Long getBoardingFee() {
		return boardingFee;
	}

	public void setBoardingFee(Long boardingFee) {
		this.boardingFee = boardingFee;
	}

	public Integer getInstallments() {
		return installments;
	}

	public void setInstallments(Integer installments) {
		this.installments = installments;
	}

	public String getInstallmentType() {
		return installmentType;
	}

	public void setInstallmentType(String installmentType) {
		this.installmentType = installmentType;
	}

	public String getNotificationUrl() {
		return notificationUrl;
	}

	public void setNotificationUrl(String notificationUrl) {
		this.notificationUrl = notificationUrl;
	}

	public String getResultUrl() {
		return resultUrl;
	}

	public void setResultUrl(String resultUrl) {
		this.resultUrl = resultUrl;
	}

	public String getUnpaidRedirectUrl() {
		return unpaidRedirectUrl;
	}

	public void setUnpaidRedirectUrl(String unpaidRedirectUrl) {
		this.unpaidRedirectUrl = unpaidRedirectUrl;
	}

	public Integer getLanguage() {
		return language;
	}

	public void setLanguage(Integer language) {
		this.language = language;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public Integer getTransactionOrigin() {
		return transactionOrigin;
	}

	public void setTransactionOrigin(Integer transactionOrigin) {
		this.transactionOrigin = transactionOrigin;
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

	public String getBillDueDate() {
		return billDueDate;
	}

	void setBillDueDate(String billDueDate) {
		this.billDueDate = billDueDate;
	}

	/**
	 * Setting due date from {@link LocalDate}
	 * 
	 * @param billDueDate Due date
	 */
	public void setBillDueDate(LocalDate billDueDate) {
		String billDueDateStr = billDueDate == null ? null
				: billDueDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		setBillDueDate(billDueDateStr);
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

}
