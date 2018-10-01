package br.com.yapay.gateway.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class ChargingData {

	@SerializedName("codigoCliente")
	private Integer clientCode;

	@SerializedName("tipoCliente")
	private Integer clientType;

	@SerializedName("nome")
	private String clientName;

	@SerializedName("email")
	private String clientEmail;

	@SerializedName("dataNascimento")
	private String clientBirthday;

	@SerializedName("sexo")
	private String clientSex;

	@SerializedName("documento")
	private String clientDocument;

	@SerializedName("documento2")
	private String clientDocumentTwo;

	@SerializedName("endereco")
	private AddressData clientChargingAdress;

	@SerializedName("telefone")
	private List<PhoneData> clientChargingPhone;

	public Integer getClientCode() {
		return clientCode;
	}

	public void setClientCode(Integer clientCode) {
		this.clientCode = clientCode;
	}

	public Integer getClientType() {
		return clientType;
	}

	public void setClientType(Integer clientType) {
		this.clientType = clientType;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientEmail() {
		return clientEmail;
	}

	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}

	public String getClientBirthday() {
		return clientBirthday;
	}

	public void setClientBirthday(String clientBirthday) {
		this.clientBirthday = clientBirthday;
	}

	public String getClientSex() {
		return clientSex;
	}

	public void setClientSex(String clientSex) {
		this.clientSex = clientSex;
	}

	public String getClientDocument() {
		return clientDocument;
	}

	public void setClientDocument(String clientDocument) {
		this.clientDocument = clientDocument;
	}

	public String getClientDocumentTwo() {
		return clientDocumentTwo;
	}

	public void setClientDocumentTwo(String clientDocumentTwo) {
		this.clientDocumentTwo = clientDocumentTwo;
	}

	public AddressData getClientChargingAdress() {
		return clientChargingAdress;
	}

	public void setClientChargingAdress(AddressData clientChargingAdress) {
		this.clientChargingAdress = clientChargingAdress;
	}

	public List<PhoneData> getClientChargingPhone() {
		return clientChargingPhone;
	}

	public void setClientChargingPhone(List<PhoneData> clientChargingPhone) {
		this.clientChargingPhone = clientChargingPhone;
	}

}
