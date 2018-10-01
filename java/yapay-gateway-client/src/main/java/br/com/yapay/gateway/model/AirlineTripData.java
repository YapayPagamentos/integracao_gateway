package br.com.yapay.gateway.model;

import com.google.gson.annotations.SerializedName;

public class AirlineTripData {

	@SerializedName("pnr")
	private String pnr;

	@SerializedName("titularCartaoEPassageiro")
	private Boolean cardholderIsPassenger;

	@SerializedName("dataEmissaoPassagem")
	private String ticketIssueDate;

	@SerializedName("codigoCompanhiaAerea")
	private String companyCode;

	@SerializedName("aeroportoPartida")
	private String departureAirport;

	@SerializedName("dataHoraPartida")
	private String departureDate;

	@SerializedName("aeroportoChegada")
	private String arrivalAirport;

	@SerializedName("dataHoraChegada")
	private String arrivalDate;

	public String getPnr() {
		return pnr;
	}

	public void setPnr(String pnr) {
		this.pnr = pnr;
	}

	public Boolean getCardholderIsPassenger() {
		return cardholderIsPassenger;
	}

	public void setCardholderIsPassenger(Boolean cardholderIsPassenger) {
		this.cardholderIsPassenger = cardholderIsPassenger;
	}

	public String getTicketIssueDate() {
		return ticketIssueDate;
	}

	public void setTicketIssueDate(String ticketIssueDate) {
		this.ticketIssueDate = ticketIssueDate;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getDepartureAirport() {
		return departureAirport;
	}

	public void setDepartureAirport(String departureAirport) {
		this.departureAirport = departureAirport;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public String getArrivalAirport() {
		return arrivalAirport;
	}

	public void setArrivalAirport(String arrivalAirport) {
		this.arrivalAirport = arrivalAirport;
	}

	public String getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

}
