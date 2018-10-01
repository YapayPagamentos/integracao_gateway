package br.com.yapay.gateway.model;

import com.google.gson.annotations.SerializedName;

public class DebitCardData {

	@SerializedName("agencia")
	private String agency;

	@SerializedName("agenciaDigito")
	private String agencyDigit;

	@SerializedName("conta")
	private String accountNumber;

	@SerializedName("contaDigito")
	private String accountNumberDigit;

	@SerializedName("tipoConta")
	private String accountType;

	public String getAgency() {
		return agency;
	}

	public void setAgency(String agency) {
		this.agency = agency;
	}

	public String getAgencyDigit() {
		return agencyDigit;
	}

	public void setAgencyDigit(String agencyDigit) {
		this.agencyDigit = agencyDigit;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountNumberDigit() {
		return accountNumberDigit;
	}

	public void setAccountNumberDigit(String accountNumberDigit) {
		this.accountNumberDigit = accountNumberDigit;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

}
