package br.com.yapay.gateway.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class DeliveryData {

	@SerializedName("nome")
	private String name;

	@SerializedName("email")
	private String mail;

	@SerializedName("dataNascimento")
	private String birthday;

	@SerializedName("sexo")
	private String genre;

	@SerializedName("documento")
	private String document;

	@SerializedName("documento2")
	private String documentTwo;

	@SerializedName("endereco")
	private AddressData deliveryAddress;

	@SerializedName("telefone")
	private List<PhoneData> deliveryPhone;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getDocumentTwo() {
		return documentTwo;
	}

	public void setDocumentTwo(String documentTwo) {
		this.documentTwo = documentTwo;
	}

	public AddressData getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(AddressData deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public List<PhoneData> getDeliveryPhone() {
		return deliveryPhone;
	}

	public void setDeliveryPhone(List<PhoneData> deliveryPhone) {
		this.deliveryPhone = deliveryPhone;
	}

}
