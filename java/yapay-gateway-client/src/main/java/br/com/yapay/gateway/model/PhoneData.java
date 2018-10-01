package br.com.yapay.gateway.model;

import com.google.gson.annotations.SerializedName;

public class PhoneData {

	@SerializedName("ddi")
	private String ddi;
	
	@SerializedName("ddd")
	private String ddd;
	
	@SerializedName("telefone")
	private String phone;
	
	@SerializedName("tipoTelefone")
	private Integer phoneType;

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
