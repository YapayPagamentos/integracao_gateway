package br.com.yapay.gateway.restv3.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class CheckoutData {
	
	@SerializedName("processar")
	private Integer process;
	
	@SerializedName("tipoPagamento")
	private Integer paymentType;
	
	@SerializedName("multiploCartao")
	private Integer multipleCard;
	
	@SerializedName("multiploBoleto")
	private Integer multipleBill;
	
	@SerializedName("boletos")
	private List<TransactionCheckoutMultipleBillData> multipleBillData;

	public Integer getProcess() {
		return process;
	}

	public void setProcess(Integer process) {
		this.process = process;
	}

	public Integer getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(Integer paymentType) {
		this.paymentType = paymentType;
	}

	public Integer getMultipleCard() {
		return multipleCard;
	}

	public void setMultipleCard(Integer multipleCard) {
		this.multipleCard = multipleCard;
	}

	public Integer getMultipleBill() {
		return multipleBill;
	}

	public void setMultipleBill(Integer multipleBill) {
		this.multipleBill = multipleBill;
	}

	public List<TransactionCheckoutMultipleBillData> getMultipleBillData() {
		return multipleBillData;
	}

	public void setMultipleBillData(List<TransactionCheckoutMultipleBillData> multipleBillData) {
		this.multipleBillData = multipleBillData;
	}

}
