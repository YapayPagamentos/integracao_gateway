package br.com.yapay.gateway.restv3.model;

import com.google.gson.annotations.SerializedName;

public class AddressData {

	@SerializedName("logradouro")
	private String street;

	@SerializedName("numbero")
	private String number;

	@SerializedName("complemento")
	private String complement;

	@SerializedName("cep")
	private String zipCode;

	@SerializedName("bairro")
	private String district;

	@SerializedName("cidade")
	private String city;

	@SerializedName("estado")
	private String state;

	@SerializedName("pais")
	private String country;

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
