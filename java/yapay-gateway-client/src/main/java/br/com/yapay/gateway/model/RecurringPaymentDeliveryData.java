package br.com.yapay.gateway.model;

import com.google.gson.annotations.SerializedName;

/**
 * Class containing recurring payment delivery info
 * 
 * @author Adriano Santos
 *
 */
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

	/**
	 * @deprecated JSON bind eyes only
	 */
	@Deprecated
	RecurringPaymentDeliveryData() {
	}

	/**
	 * Overload of {@link #RecurringPaymentDeliveryData(String, String, PhoneData)}
	 * without {@code phone}
	 * 
	 * @param deliveryName Recipient name
	 * @param deliveryMail Recipient e-mail
	 */
	public RecurringPaymentDeliveryData(String deliveryName, String deliveryMail) {
		this(deliveryName, deliveryMail, null);
	}

	/**
	 * Constructor with non address marked parameters
	 * 
	 * @param deliveryName Recipient name
	 * @param deliveryMail Recipient e-mail
	 * @param phone        Recipient phone
	 */
	public RecurringPaymentDeliveryData(String deliveryName, String deliveryMail, PhoneData phone) {
		this.deliveryName = deliveryName;
		this.deliveryMail = deliveryMail;
		this.phone = phone;
	}

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

	public void setPhone(String ddd, String number) {
		setPhone(new PhoneData(ddd, number));
	}

	public void setPhone(String ddi, String ddd, String number) {
		setPhone(new PhoneData(ddi, ddd, number));
	}

	public void setPhone(PhoneData phone) {
		this.phone = phone;
	}

	public void setDeliveryAddress(String street, String number, String zipCode, String city, String state) {
		setDeliveryAddress(street, number, zipCode, null, city, state);
	}

	public void setDeliveryAddress(String street, String number, String zipCode, String district, String city,
			String state) {
		setDeliveryAddress(street, number, null, zipCode, district, city, state, "BRA");
	}

	public void setDeliveryAddress(String street, String number, String complement, String zipCode, String district,
			String city, String state, String country) {
		deliveryStreet = street;
		deliveryNumber = number;
		deliveryComplement = complement;
		deliveryZipCode = zipCode;
		deliveryDistrict = district;
		deliveryCity = city;
		deliveryState = state;
		deliveryCountry = country;
	}
}
