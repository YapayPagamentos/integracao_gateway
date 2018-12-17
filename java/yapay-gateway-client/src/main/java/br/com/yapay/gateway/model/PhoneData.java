package br.com.yapay.gateway.model;

import com.google.gson.annotations.SerializedName;

/**
 * Class containing phone info
 * 
 * @author Adriano Santos
 *
 */
public class PhoneData {

	@SerializedName("ddi")
	private String ddi;

	@SerializedName("ddd")
	private String ddd;

	@SerializedName("telefone")
	private String phone;

	@SerializedName("tipoTelefone")
	private Integer phoneType;

	/**
	 * @deprecated JSON bind eyes only
	 */
	@Deprecated
	PhoneData() {
	}

	/**
	 * Overload of {@link #PhoneData(String, String, String)} with {@code ddi}
	 * defaulting to '55'
	 * 
	 * @param number Phone number
	 * @param ddd    Long distance calling code
	 */
	public PhoneData(String ddd, String number) {
		this("55", ddd, number);
	}

	/**
	 * Overload of {@link #PhoneData(Integer, String, String, String)} with
	 * {@code type} defaulting to 1
	 * 
	 * @param number Phone number
	 * @param ddd    Long distance calling code
	 * @param ddi    International calling code
	 */
	public PhoneData(String ddi, String ddd, String number) {
		this(1, ddi, ddd, number);
	}

	/**
	 * Constructor with all parameters
	 * 
	 * @param type   Phone type
	 * @param number Phone number
	 * @param ddd    Long distance calling code
	 * @param ddi    International calling code
	 */
	public PhoneData(Integer type, String ddi, String ddd, String number) {
		phoneType = type;
		phone = number;
		this.ddd = ddd;
		this.ddi = ddi;
	}

	public String getDdi() {
		return ddi;
	}

	public void setDdi(String ddi) {
		this.ddi = ddi;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(Integer phoneType) {
		this.phoneType = phoneType;
	}

}
