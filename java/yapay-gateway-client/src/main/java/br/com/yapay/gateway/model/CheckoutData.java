package br.com.yapay.gateway.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

/**
 * Class containing Checkout Yapay info
 * 
 * @author Adriano Santos
 *
 */
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
	private List<TransactionCheckoutMultipleBillData> multipleBillDataList;

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

	public List<TransactionCheckoutMultipleBillData> getMultipleBillDataList() {
		return multipleBillDataList;
	}

	public void setMultipleBillDataList(List<TransactionCheckoutMultipleBillData> multipleBillDataList) {
		this.multipleBillDataList = multipleBillDataList;
	}

	public void addMultipleBillData(BigDecimal value, LocalDate dueDate) {
		addMultipleBillData(new TransactionCheckoutMultipleBillData(value, dueDate));
	}

	public void addMultipleBillData(TransactionCheckoutMultipleBillData multipleBillData) {
		if (this.multipleBillDataList == null) {
			this.multipleBillDataList = new ArrayList<>();
		}
		this.multipleBillDataList.add(multipleBillData);
	}
}
