package br.com.yapay.gateway.model;

import com.google.gson.annotations.SerializedName;

/**
 * Class containing address info
 * 
 * @author Adriano Santos
 *
 */
public class AddressData {

	@SerializedName("logradouro")
	private String street;

	@SerializedName("numero")
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

	/**
	 * @deprecated JSON bind eyes only
	 */
	@Deprecated
	AddressData() {
	}

	/**
	 * Overload of
	 * {@link #AddressData(String, String, String, String, String, String)} without
	 * {@code district}
	 * 
	 * @param street  Street
	 * @param number  Street number
	 * @param zipCode Postal identification
	 * @param city    City
	 * @param state   State
	 */
	public AddressData(String street, String number, String zipCode, String city, String state) {
		this(street, number, zipCode, null, city, state);
	}

	/**
	 * Overload of
	 * {@link #AddressData(String, String, String, String, String, String, String, String)}
	 * without {@code complement} and with {@code country} defaulting to 'BRA'
	 * 
	 * @param street   Street
	 * @param number   Street number
	 * @param zipCode  Postal identification
	 * @param district District
	 * @param city     City
	 * @param state    State
	 */
	public AddressData(String street, String number, String zipCode, String district, String city, String state) {
		this(street, number, null, zipCode, district, city, state, "BRA");
	}

	/**
	 * Constructor with all parameters
	 * 
	 * @param street     Street
	 * @param number     Street number
	 * @param complement Address complement
	 * @param zipCode    Postal identification
	 * @param district   District
	 * @param city       City
	 * @param state      State
	 * @param country    Country
	 */
	public AddressData(String street, String number, String complement, String zipCode, String district, String city,
			String state, String country) {
		this.street = street;
		this.number = number;
		this.complement = complement;
		this.zipCode = zipCode;
		this.district = district;
		this.city = city;
		this.state = state;
		this.country = country;
	}

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
