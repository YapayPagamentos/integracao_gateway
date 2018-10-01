package br.com.yapay.gateway.model;

import com.google.gson.annotations.SerializedName;

public class ExtraField {

	@SerializedName("chave")
	private Integer key;

	@SerializedName("valor")
	private String value;

	public Integer getKey() {
		return key;
	}

	public void setKey(Integer key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
