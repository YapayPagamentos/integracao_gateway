package br.com.yapay.gateway.restv3.model;

import com.google.gson.annotations.SerializedName;

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
	private String hintUrl;

	@SerializedName("urlResultado")
	private String resultUrl;

	@SerializedName("urlRedirecionamentoNaoPago")
	private String unpaidRedirectUrl;

	@SerializedName("idioma")
	private Integer idiom;

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

	@SerializedName("pagamentoRecorrente")
	private Boolean recurrentPayment;

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

	public String getHintUrl() {
		return hintUrl;
	}

	public void setHintUrl(String hintUrl) {
		this.hintUrl = hintUrl;
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

	public Integer getIdiom() {
		return idiom;
	}

	public void setIdiom(Integer idiom) {
		this.idiom = idiom;
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

	public void setBillDueDate(String billDueDate) {
		this.billDueDate = billDueDate;
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

	public Boolean getRecurrentPayment() {
		return recurrentPayment;
	}

	public void setRecurrentPayment(Boolean recurrentPayment) {
		this.recurrentPayment = recurrentPayment;
	}

}
