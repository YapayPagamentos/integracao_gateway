package br.com.yapay.gateway.model;

import com.google.gson.annotations.SerializedName;

public class PassengerData {

	@SerializedName("primeiroNome")
	private String firstName;

	@SerializedName("segundoNome")
	private String middleName;

	@SerializedName("sobrenome")
	private String lastName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
