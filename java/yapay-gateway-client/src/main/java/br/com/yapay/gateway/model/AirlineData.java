package br.com.yapay.gateway.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class AirlineData {

	@SerializedName("dadosViagem")
	private AirlineTripData tripData;

	@SerializedName("dadosPassageiros")
	private List<PassengerData> passengerData;

	@SerializedName("dadosEscalas")
	private List<FlightRangeData> flightRange;

	public AirlineTripData getTripData() {
		return tripData;
	}

	public void setTripData(AirlineTripData tripData) {
		this.tripData = tripData;
	}

	public List<PassengerData> getPassengerData() {
		return passengerData;
	}

	public void setPassengerData(List<PassengerData> passengerData) {
		this.passengerData = passengerData;
	}

}
