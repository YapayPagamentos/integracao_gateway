package br.com.yapay.gateway.model;

import com.google.gson.annotations.SerializedName;

/**
 * Class containing key-value pair of transaction
 * 
 * @author Adriano Santos
 *
 */
public class ExtraField {

	@SerializedName("chave")
	private Integer key;

	@SerializedName("valor")
	private String value;

	/**
	 * @deprecated JSON bind eyes only
	 */
	@Deprecated
	ExtraField() {
	}

	/**
	 * Constructor with required fields
	 * 
	 * @param key   Pair key
	 * @param value Pair value
	 */
	public ExtraField(int key, String value) {
		this.key = key;
		this.value = value;
	}

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
