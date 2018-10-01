package br.com.yapay.gateway.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Transaction {

	@SerializedName("codigoEstabelecimento")
	private String storeCode;
	
	@SerializedName("codigoFormaPagamento")
	private Integer paymentCode;
	
	@SerializedName("transacao")
	private TransactionData transactionData;
	
	@SerializedName("checkout")
	private CheckoutData checkout;
	
	@SerializedName("dadosCartao")
	private CreditCardData creditCard;
	
	@SerializedName("dadosMultiplosCartoes")
	private List<CreditCardData> multipleCard;
	
	@SerializedName("dadosDebito")
	private DebitCardData debitCard;
	
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

	public CreditCardData getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCardData creditCard) {
		this.creditCard = creditCard;
	}

	public List<CreditCardData> getMultipleCard() {
		return multipleCard;
	}

	public void setMultipleCard(List<CreditCardData> multipleCard) {
		this.multipleCard = multipleCard;
	}

	public DebitCardData getDebitCard() {
		return debitCard;
	}

	public void setDebitCard(DebitCardData debitCard) {
		this.debitCard = debitCard;
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

}
