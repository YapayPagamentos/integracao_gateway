package br.com.yapay.gateway.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class ApiResponseContent {

	@SerializedName("numeroTransacao")
	private Long transactionNumber;
	@SerializedName("codigoEstabelecimento")
	private String storeCode;
	@SerializedName("codigoFormaPagamento")
	private Long paymentCode;
	@SerializedName("valor")
	private Long valueLong;
	@SerializedName("valorDesconto")
	private Long discountValueLong;
	@SerializedName("parcelas")
	private Integer installments;
	@SerializedName("multiploCartao")
	private Integer multipleCard;
	private Integer oneClick;
	private String token;
	@SerializedName("statusTransacao")
	private Integer transactionStatus;
	@SerializedName("autorizacao")
	private String authorization;
	@SerializedName("codigoTransacaoOperadora")
	private String transactionCode;
	@SerializedName("dataAprovacaoOperadora")
	private String transactionApprovalDateStr;
	@SerializedName("numeroComprovanteVenda")
	private String transactionReceipt;
	private String nsu;
	@SerializedName("bandeira")
	private String cardBrand;
	@SerializedName("mensagemVenda")
	private String saleMessage;
	@SerializedName("urlPagamento")
	private String paymentUrl;
	@SerializedName("cartoesUtilizados")
	private List<String> cardNumberList;
	@SerializedName("erro")
	private Error errorObject;
	@SerializedName("nomeTitularCartaoCredito")
	private String cardHolderName;
	@SerializedName("numeroCartaoCredito")
	private String cardNumber;
	@SerializedName("dataValidadeCartao")
	private String cardExpirationDate;
	@SerializedName("emailComprador")
	private String clientEmail;
	@SerializedName("detalhesMultiploCartao")
	private List<ApiResponseContent> multipleCardDetailList;
	@SerializedName("recorrencia")
	private RecurrentPayment recurrentPayment;

	static class Error {
		@SerializedName("codigo")
		private String code;
		@SerializedName("mensagem")
		private String message;

		public String getCode() {
			return code;
		}

		void setCode(String code) {
			this.code = code;
		}

		public String getMessage() {
			return message;
		}

		void setMessage(String message) {
			this.message = message;
		}

		@Override
		public String toString() {
			return code + " - " + message;
		}
	}

	static class RecurrentPayment {
		@SerializedName("estabelecimento")
		private String storeCode;
		@SerializedName("numeroRecorrencia")
		private Long recurringPaymentNumber;
		@SerializedName("codigoFormaPagamento")
		private Integer paymentCode;
		@SerializedName("valor")
		private Long valueLong;
		@SerializedName("numeroCobrancaTotal")
		private Integer totalCharges;
		@SerializedName("numeroCobrancaRestantes")
		private Integer remainingCharges;
		private Integer status;
		@SerializedName("mensagem")
		private String message;
		@SerializedName("numeroPedido")
		private Long transactionNumber;
		@SerializedName("statusTransacao")
		private Integer transactionStatus;
		@SerializedName("autorizacao")
		private String authorization;
		@SerializedName("codigoTransacaoOperadora")
		private String transactionCode;
		@SerializedName("dataAprovacaoOperadora")
		private String transactionApprovalDateStr;
		@SerializedName("numeroComprovanteVenda")
		private String transactionReceipt;
		@SerializedName("mensagemVenda")
		private String saleMessage;

		String getStoreCode() {
			return storeCode;
		}

		void setStoreCode(String storeCode) {
			this.storeCode = storeCode;
		}

		Long getRecurringPaymentNumber() {
			return recurringPaymentNumber;
		}

		void setRecurringPaymentNumber(Long recurringPaymentNumber) {
			this.recurringPaymentNumber = recurringPaymentNumber;
		}

		Integer getPaymentCode() {
			return paymentCode;
		}

		void setPaymentCode(Integer paymentCode) {
			this.paymentCode = paymentCode;
		}

		Long getValueLong() {
			return valueLong;
		}

		BigDecimal getValue() {
			return valueLong == null ? BigDecimal.ZERO
					: new BigDecimal(valueLong).divide(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP);
		}

		void setValueLong(Long value) {
			this.valueLong = value;
		}

		Integer getTotalCharges() {
			return totalCharges;
		}

		void setTotalCharges(Integer totalCharges) {
			this.totalCharges = totalCharges;
		}

		Integer getRemainingCharges() {
			return remainingCharges;
		}

		void setRemainingCharges(Integer remainingCharges) {
			this.remainingCharges = remainingCharges;
		}

		Integer getStatus() {
			return status;
		}

		void setStatus(Integer status) {
			this.status = status;
		}

		String getMessage() {
			return message;
		}

		void setMessage(String message) {
			this.message = message;
		}

		Long getTransactionNumber() {
			return transactionNumber;
		}

		void setTransactionNumber(Long transactionNumber) {
			this.transactionNumber = transactionNumber;
		}

		Integer getTransactionStatus() {
			return transactionStatus;
		}

		void setTransactionStatus(Integer transactionStatus) {
			this.transactionStatus = transactionStatus;
		}

		String getAuthorization() {
			return authorization;
		}

		void setAuthorization(String authorization) {
			this.authorization = authorization;
		}

		String getTransactionCode() {
			return transactionCode;
		}

		void setTransactionCode(String transactionCode) {
			this.transactionCode = transactionCode;
		}

		String getTransactionApprovalDateStr() {
			return transactionApprovalDateStr;
		}

		void setTransactionApprovalDateStr(String transactionApprovalDateStr) {
			this.transactionApprovalDateStr = transactionApprovalDateStr;
		}

		String getTransactionReceipt() {
			return transactionReceipt;
		}

		void setTransactionReceipt(String transactionReceipt) {
			this.transactionReceipt = transactionReceipt;
		}

		String getSaleMessage() {
			return saleMessage;
		}

		void setSaleMessage(String saleMessage) {
			this.saleMessage = saleMessage;
		}
	}

	public Long getTransactionNumber() {
		return transactionNumber;
	}

	public String getStoreCode() {
		return storeCode;
	}

	public Long getPaymentCode() {
		return paymentCode;
	}

	Long getValueLong() {
		return valueLong;
	}

	public BigDecimal getValue() {
		return valueLong == null ? BigDecimal.ZERO
				: new BigDecimal(valueLong).divide(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	Long getDiscountValueLong() {
		return discountValueLong;
	}

	public BigDecimal getDiscountValue() {
		return discountValueLong == null ? BigDecimal.ZERO
				: new BigDecimal(discountValueLong).divide(new BigDecimal(100)).setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	public Integer getInstallments() {
		return installments;
	}

	public Integer getMultipleCard() {
		return multipleCard;
	}

	RecurrentPayment getRecurrentPayment() {
		return recurrentPayment;
	}

	public Integer getOneClick() {
		return oneClick;
	}

	public String getToken() {
		return token;
	}

	public Integer getTransactionStatus() {
		return transactionStatus;
	}

	public String getAuthorization() {
		return authorization;
	}

	public String getTransactionCode() {
		return transactionCode;
	}

	String getTransactionApprovalDateStr() {
		return transactionApprovalDateStr;
	}

	public LocalDateTime getTransactionApprovalDate() {
		LocalDateTime dateTime = null;
		try {
			dateTime = LocalDateTime.parse(transactionApprovalDateStr,
					DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		} catch (Exception e) {
		}
		return dateTime;
	}

	public String getTransactionReceipt() {
		return transactionReceipt;
	}

	public String getNsu() {
		return nsu;
	}

	public String getCardBrand() {
		return cardBrand;
	}

	public String getSaleMessage() {
		return saleMessage;
	}

	public String getPaymentUrl() {
		return paymentUrl;
	}

	public List<String> getCardNumberList() {
		return cardNumberList;
	}

	Error getErrorObject() {
		return errorObject;
	}

	public String getError() {
		return String.valueOf(errorObject);
	}

	public String getCardHolderName() {
		return cardHolderName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public String getCardExpirationDate() {
		return cardExpirationDate;
	}

	public String getClientEmail() {
		return clientEmail;
	}

	public List<ApiResponseContent> getMultipleCardDetailList() {
		return multipleCardDetailList;
	}

	void setTransactionNumber(Long transactionNumber) {
		this.transactionNumber = transactionNumber;
	}

	void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}

	void setPaymentCode(Long paymentCode) {
		this.paymentCode = paymentCode;
	}

	void setValueLong(Long valueLong) {
		this.valueLong = valueLong;
	}

	void setDiscountValueLong(Long discountValueLong) {
		this.discountValueLong = discountValueLong;
	}

	void setInstallments(Integer installments) {
		this.installments = installments;
	}

	void setMultipleCard(Integer multipleCard) {
		this.multipleCard = multipleCard;
	}

	void setRecurrentPayment(RecurrentPayment recurrentPayment) {
		this.recurrentPayment = recurrentPayment;
	}

	void setOneClick(Integer oneClick) {
		this.oneClick = oneClick;
	}

	void setToken(String token) {
		this.token = token;
	}

	void setTransactionStatus(Integer transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	void setAuthorization(String authorization) {
		this.authorization = authorization;
	}

	void setTransactionCode(String transactionCode) {
		this.transactionCode = transactionCode;
	}

	void setTransactionApprovalDateStr(String transactionApprovalDateStr) {
		this.transactionApprovalDateStr = transactionApprovalDateStr;
	}

	void setTransactionReceipt(String transactionReceipt) {
		this.transactionReceipt = transactionReceipt;
	}

	void setNsu(String nsu) {
		this.nsu = nsu;
	}

	void setCardBrand(String cardBrand) {
		this.cardBrand = cardBrand;
	}

	void setSaleMessage(String message) {
		this.saleMessage = message;
	}

	void setPaymentUrl(String paymentUrl) {
		this.paymentUrl = paymentUrl;
	}

	void setCardNumberList(List<String> cardNumberList) {
		this.cardNumberList = cardNumberList;
	}

	void setError(Error errorObject) {
		this.errorObject = errorObject;
	}

	void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	void setCardExpirationDate(String cardExpirationDate) {
		this.cardExpirationDate = cardExpirationDate;
	}

	void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}

	void setMultipleCardDetailList(List<ApiResponseContent> multipleCardDetailList) {
		this.multipleCardDetailList = multipleCardDetailList;
	}

	public String getRecurringStoreCode() {
		if (this.recurrentPayment == null) {
			return null;
		}
		return this.recurrentPayment.storeCode;
	}

	public Long getRecurringPaymentNumber() {
		if (this.recurrentPayment == null) {
			return null;
		}
		return this.recurrentPayment.recurringPaymentNumber;
	}

	public Integer getRecurringPaymentCode() {
		if (this.recurrentPayment == null) {
			return null;
		}
		return this.recurrentPayment.paymentCode;
	}

	public BigDecimal getRecurringValue() {
		if (this.recurrentPayment == null) {
			return null;
		}
		return this.recurrentPayment.getValue();
	}

	public Integer getRecurringTotalCharges() {
		if (this.recurrentPayment == null) {
			return null;
		}
		return this.recurrentPayment.totalCharges;
	}

	public Integer getRecurringRemainingCharges() {
		if (this.recurrentPayment == null) {
			return null;
		}
		return this.recurrentPayment.remainingCharges;
	}

	public Integer getRecurringStatus() {
		if (this.recurrentPayment == null) {
			return null;
		}
		return this.recurrentPayment.status;
	}

	public String getRecurringMessage() {
		if (this.recurrentPayment == null) {
			return null;
		}
		return this.recurrentPayment.message;
	}

	public Long getRecurringTransactionNumber() {
		if (this.recurrentPayment == null) {
			return null;
		}
		return this.recurrentPayment.transactionNumber;
	}

	public Integer getRecurringTransactionStatus() {
		if (this.recurrentPayment == null) {
			return null;
		}
		return this.recurrentPayment.transactionStatus;
	}

	public String getRecurringAuthorization() {
		if (this.recurrentPayment == null) {
			return null;
		}
		return this.recurrentPayment.authorization;
	}

	public String getRecurringTransactionCode() {
		if (this.recurrentPayment == null) {
			return null;
		}
		return this.recurrentPayment.transactionCode;
	}

	public LocalDateTime getRecurringTransactionApprovalDate() {
		if (this.recurrentPayment == null) {
			return null;
		}
		LocalDateTime dateTime = null;
		try {
			dateTime = LocalDateTime.parse(this.recurrentPayment.transactionApprovalDateStr,
					DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		} catch (Exception e) {
		}
		return dateTime;
	}

	public String getRecurringTransactionReceipt() {
		if (this.recurrentPayment == null) {
			return null;
		}
		return this.recurrentPayment.transactionReceipt;
	}

	public String getRecurringSaleMessage() {
		if (this.recurrentPayment == null) {
			return null;
		}
		return this.recurrentPayment.saleMessage;
	}
}
