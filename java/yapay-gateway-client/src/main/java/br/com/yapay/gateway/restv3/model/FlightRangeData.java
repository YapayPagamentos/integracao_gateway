package br.com.yapay.gateway.restv3.model;

import com.google.gson.annotations.SerializedName;

public class FlightRangeData {

	@SerializedName("classeDoServico")
	private String serviceClass;
	
	@SerializedName("dataDaViagem")
	private String tripDate;
	
	@SerializedName("codigoCompanhiaAerea")
	private String companyCode;
	
	@SerializedName("escalaPermitida")
	private Boolean permitFlight;
	
	@SerializedName("aeroportoPartida")
	private String departureAirport;
	
	@SerializedName("dataHoraPartida")
	private String departureDate;
	
	@SerializedName("aeroportoChegada")
	private String arrivalAirport;
	
	@SerializedName("dataHoraChegada")
	private String arrivalDate;
	
	@SerializedName("numeroVoo")
	private String flyNumber;
	
	@SerializedName("classeTarifaria")
	private String rateClass;

	public String getServiceClass() {
		return serviceClass;
	}

	public void setServiceClass(String serviceClass) {
		this.serviceClass = serviceClass;
	}

	public String getTripDate() {
		return tripDate;
	}

	public void setTripDate(String tripDate) {
		this.tripDate = tripDate;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public Boolean getPermitFlight() {
		return permitFlight;
	}

	public void setPermitFlight(Boolean permitFlight) {
		this.permitFlight = permitFlight;
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

	public String getFlyNumber() {
		return flyNumber;
	}

	public void setFlyNumber(String flyNumber) {
		this.flyNumber = flyNumber;
	}

	public String getRateClass() {
		return rateClass;
	}

	public void setRateClass(String rateClass) {
		this.rateClass = rateClass;
	}

}
