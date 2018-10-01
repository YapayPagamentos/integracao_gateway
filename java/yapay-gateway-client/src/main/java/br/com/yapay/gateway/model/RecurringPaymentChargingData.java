package br.com.yapay.gateway.model;

import com.google.gson.annotations.SerializedName;

public class RecurringPaymentChargingData {

	@SerializedName("nomeComprador")
	private String buyerName;
	
	@SerializedName("emailComprador")
	private String buyerMail;
	
	@SerializedName("tipoCliente")
	private Integer clientType;
	
	@SerializedName("documento")
	private String document;
	
	@SerializedName("dataNascimento")
	private String birthday;
	
	@SerializedName("codigoCliente")
	private Integer clientCode;
	
	@SerializedName("sexo")
	private String clientSex;
	
	@SerializedName("documento2")
	private String documentTwo;
	
	@SerializedName("enderecoComprador")
	private String clientAddressStreet;
	
	@SerializedName("numeroEnderecoComprador")
	private String clientAddressNumber;
	
	@SerializedName("bairroComprador")
	private String clientAddressDistrict;
	
	@SerializedName("complementoComprador")
	private String clientAddressComplement;
	
	@SerializedName("cidadeComprador")
	private String clientAddressCity;
	
	@SerializedName("estadoComprador")
	private String clientAddressState;
	
	@SerializedName("cepComprador")
	private String clientAddressZipcode;
	
	@SerializedName("paisComprador")
	private String clientAddressCountry;
	
	@SerializedName("telefone")
	private PhoneData phone;

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public String getBuyerMail() {
		return buyerMail;
	}

	public void setBuyerMail(String buyerMail) {
		this.buyerMail = buyerMail;
	}

	public Integer getClientType() {
		return clientType;
	}

	public void setClientType(Integer clientType) {
		this.clientType = clientType;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public Integer getClientCode() {
		return clientCode;
	}

	public void setClientCode(Integer clientCode) {
		this.clientCode = clientCode;
	}

	public String getClientSex() {
		return clientSex;
	}

	public void setClientSex(String clientSex) {
		this.clientSex = clientSex;
	}

	public String getDocumentTwo() {
		return documentTwo;
	}

	public void setDocumentTwo(String documentTwo) {
		this.documentTwo = documentTwo;
	}

	public String getClientAddressStreet() {
		return clientAddressStreet;
	}

	public void setClientAddressStreet(String clientAddressStreet) {
		this.clientAddressStreet = clientAddressStreet;
	}

	public String getClientAddressNumber() {
		return clientAddressNumber;
	}

	public void setClientAddressNumber(String clientAddressNumber) {
		this.clientAddressNumber = clientAddressNumber;
	}

	public String getClientAddressDistrict() {
		return clientAddressDistrict;
	}

	public void setClientAddressDistrict(String clientAddressDistrict) {
		this.clientAddressDistrict = clientAddressDistrict;
	}

	public String getClientAddressComplement() {
		return clientAddressComplement;
	}

	public void setClientAddressComplement(String clientAddressComplement) {
		this.clientAddressComplement = clientAddressComplement;
	}

	public String getClientAddressCity() {
		return clientAddressCity;
	}

	public void setClientAddressCity(String clientAddressCity) {
		this.clientAddressCity = clientAddressCity;
	}

	public String getClientAddressState() {
		return clientAddressState;
	}

	public void setClientAddressState(String clientAddressState) {
		this.clientAddressState = clientAddressState;
	}

	public String getClientAddressZipcode() {
		return clientAddressZipcode;
	}

	public void setClientAddressZipcode(String clientAddressZipcode) {
		this.clientAddressZipcode = clientAddressZipcode;
	}

	public String getClientAddressCountry() {
		return clientAddressCountry;
	}

	public void setClientAddressCountry(String clientAddressCountry) {
		this.clientAddressCountry = clientAddressCountry;
	}

	public PhoneData getPhone() {
		return phone;
	}

	public void setPhone(PhoneData phone) {
		this.phone = phone;
	}

}
