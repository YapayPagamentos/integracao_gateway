package br.com.yapay.gateway.model;

import com.google.gson.annotations.SerializedName;

public class RecurringPaymentDeliveryData {

	@SerializedName("nomeEntrega")
	private String deliveryName;
	
	@SerializedName("emailEntrega")
	private String deliveryMail;
	
	@SerializedName("enderecoEntrega")
	private String deliveryStreet;
	
	@SerializedName("numeroEnderecoEntrega")
	private String deliveryNumber;
	
	@SerializedName("bairroEntrega")
	private String deliveryDistrict;
	
	@SerializedName("complementoEntrega")
	private String deliveryComplement;
	
	@SerializedName("cidadeEntrega")
	private String deliveryCity;
	
	@SerializedName("estadoEntrega")
	private String deliveryState;
	
	@SerializedName("cepEntrega")
	private String deliveryZipCode;
	
	@SerializedName("paisEntrega")
	private String deliveryCountry;
	
	@SerializedName("telefone")
	private PhoneData phone;

	public String getDeliveryName() {
		return deliveryName;
	}

	public void setDeliveryName(String deliveryName) {
		this.deliveryName = deliveryName;
	}

	public String getDeliveryMail() {
		return deliveryMail;
	}

	public void setDeliveryMail(String deliveryMail) {
		this.deliveryMail = deliveryMail;
	}

	public String getDeliveryStreet() {
		return deliveryStreet;
	}

	public void setDeliveryStreet(String deliveryStreet) {
		this.deliveryStreet = deliveryStreet;
	}

	public String getDeliveryNumber() {
		return deliveryNumber;
	}

	public void setDeliveryNumber(String deliveryNumber) {
		this.deliveryNumber = deliveryNumber;
	}

	public String getDeliveryDistrict() {
		return deliveryDistrict;
	}

	public void setDeliveryDistrict(String deliveryDistrict) {
		this.deliveryDistrict = deliveryDistrict;
	}

	public String getDeliveryComplement() {
		return deliveryComplement;
	}

	public void setDeliveryComplement(String deliveryComplement) {
		this.deliveryComplement = deliveryComplement;
	}

	public String getDeliveryCity() {
		return deliveryCity;
	}

	public void setDeliveryCity(String deliveryCity) {
		this.deliveryCity = deliveryCity;
	}

	public String getDeliveryState() {
		return deliveryState;
	}

	public void setDeliveryState(String deliveryState) {
		this.deliveryState = deliveryState;
	}

	public String getDeliveryZipCode() {
		return deliveryZipCode;
	}

	public void setDeliveryZipCode(String deliveryZipCode) {
		this.deliveryZipCode = deliveryZipCode;
	}

	public String getDeliveryCountry() {
		return deliveryCountry;
	}

	public void setDeliveryCountry(String deliveryCountry) {
		this.deliveryCountry = deliveryCountry;
	}

	public PhoneData getPhone() {
		return phone;
	}

	public void setPhone(PhoneData phone) {
		this.phone = phone;
	}

}
