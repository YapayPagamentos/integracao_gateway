package br.com.yapay.gateway.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

/**
 * Class containing client info
 * 
 * @author Adriano Santos
 *
 */
public class ChargingData {

	@SerializedName("codigoCliente")
	private Integer clientCode;

	@SerializedName("tipoCliente")
	private Integer clientType;

	@SerializedName("nome")
	private String clientName;

	@SerializedName("email")
	private String clientEmail;

	@SerializedName("dataNascimento")
	private String clientBirthday;

	@SerializedName("sexo")
	private String clientGenre;

	@SerializedName("documento")
	private String clientDocument;

	@SerializedName("documento2")
	private String clientDocumentTwo;

	@SerializedName("endereco")
	private AddressData clientAddress;

	@SerializedName("telefone")
	private List<PhoneData> clientPhones;

	/**
	 * @deprecated JSON bind eyes only
	 */
	@Deprecated
	ChargingData() {
	}

	/**
	 * Overload of {@link #ChargingData(String, String, String, AddressData, List)}
	 * without {@code clientAddress} and {@code clientPhones}
	 * 
	 * @param clientName     Client name
	 * @param clientEmail    Client e-mail
	 * @param clientDocument Client document
	 */
	public ChargingData(String clientName, String clientEmail, String clientDocument) {
		this(clientName, clientEmail, clientDocument, null, null);
	}

	/**
	 * Overload of
	 * {@link #ChargingData(String, String, LocalDate, String, String, String, AddressData, List)}
	 * without {@code birthday}, {@code genre} and {@code documentTwo}
	 * 
	 * @param clientName     Client name
	 * @param clientEmail    Client e-mail
	 * @param clientDocument Client document
	 * @param clientAddress  Charging address
	 * @param clientPhones   Charging phones
	 */
	public ChargingData(String clientName, String clientEmail, String clientDocument, AddressData clientAddress,
			List<PhoneData> clientPhones) {
		this(clientName, clientEmail, null, null, clientDocument, null, clientAddress, clientPhones);
	}

	/**
	 * Overload of
	 * {@link #ChargingData(Integer, Integer, String, String, LocalDate, String, String, String, AddressData, List)}
	 * with {@code clientCode} and {@code clientType} defaulting to 1
	 * 
	 * @param clientName        Client name
	 * @param clientEmail       Client e-mail
	 * @param clientBirthday    Client birth date
	 * @param clientGenre       Client genre
	 * @param clientDocument    Client document
	 * @param clientDocumentTwo Client secondary document
	 * @param clientAddress     Charging address
	 * @param clientPhones      Charging phones
	 */
	public ChargingData(String clientName, String clientEmail, LocalDate clientBirthday, String clientGenre,
			String clientDocument, String clientDocumentTwo, AddressData clientAddress, List<PhoneData> clientPhones) {
		this(1, 1, clientName, clientEmail, clientBirthday, clientGenre, clientDocument, clientDocumentTwo,
				clientAddress, clientPhones);
	}

	/**
	 * Constructor with all parameters
	 * 
	 * @param clientCode        Client code
	 * @param clientType        Client type
	 * @param clientName        Client name
	 * @param clientEmail       Client e-mail
	 * @param clientBirthday    Client birth date
	 * @param clientGenre       Client genre
	 * @param clientDocument    Client document
	 * @param clientDocumentTwo Client secondary document
	 * @param clientAddress     Charging address
	 * @param clientPhones      Charging phones
	 */
	public ChargingData(Integer clientCode, Integer clientType, String clientName, String clientEmail,
			LocalDate clientBirthday, String clientGenre, String clientDocument, String clientDocumentTwo,
			AddressData clientAddress, List<PhoneData> clientPhones) {
		this.clientCode = clientCode;
		this.clientType = clientType;
		this.clientName = clientName;
		this.clientEmail = clientEmail;
		setClientBirthday(clientBirthday);
		this.clientGenre = clientGenre;
		this.clientDocument = clientDocument;
		this.clientDocumentTwo = clientDocumentTwo;
		this.clientAddress = clientAddress;
		this.clientPhones = clientPhones;
	}

	public Integer getClientCode() {
		return clientCode;
	}

	public void setClientCode(Integer clientCode) {
		this.clientCode = clientCode;
	}

	public Integer getClientType() {
		return clientType;
	}

	public void setClientType(Integer clientType) {
		this.clientType = clientType;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getClientEmail() {
		return clientEmail;
	}

	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}

	public String getClientBirthday() {
		return clientBirthday;
	}

	void setClientBirthday(String clientBirthday) {
		this.clientBirthday = clientBirthday;
	}

	/**
	 * Setting birthday from {@link LocalDate}
	 * 
	 * @param clientBirthday Client birth date
	 */
	public void setClientBirthday(LocalDate clientBirthday) {
		String clientBirthdayStr = clientBirthday == null ? null
				: clientBirthday.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		setClientBirthday(clientBirthdayStr);
	}

	public String getClientGenre() {
		return clientGenre;
	}

	public void setClientGenre(String clientGenre) {
		this.clientGenre = clientGenre;
	}

	public String getClientDocument() {
		return clientDocument;
	}

	public void setClientDocument(String clientDocument) {
		this.clientDocument = clientDocument;
	}

	public String getClientDocumentTwo() {
		return clientDocumentTwo;
	}

	public void setClientDocumentTwo(String clientDocumentTwo) {
		this.clientDocumentTwo = clientDocumentTwo;
	}

	public AddressData getClientAddress() {
		return clientAddress;
	}

	/**
	 * Regular setter of charging address
	 * 
	 * @param clientAddress Address
	 */
	public void setClientAddress(AddressData clientAddress) {
		this.clientAddress = clientAddress;
	}

	/**
	 * Overload of {@link #setClientAddress(AddressData)} that instantiate new
	 * address from parameters
	 * 
	 * @param street   Street
	 * @param number   Street number
	 * @param zipCode  Postal identification
	 * @param district District
	 * @param city     City
	 * @param state    State
	 * 
	 * @see AddressData#AddressData(String, String, String, String, String, String)
	 */
	public void setClientAddress(String street, String number, String zipCode, String district, String city,
			String state) {
		setClientAddress(new AddressData(street, number, zipCode, district, city, state));
	}

	/**
	 * Overload of {@link #setClientAddress(AddressData)} that instantiate new
	 * address from parameters
	 * 
	 * @param street  Street
	 * @param number  Street number
	 * @param zipCode Postal identification
	 * @param city    City
	 * @param state   State
	 * 
	 * @see AddressData#AddressData( String, String, String, String, String)
	 */
	public void setClientAddress(String street, String number, String zipCode, String city, String state) {
		setClientAddress(new AddressData(street, number, zipCode, city, state));
	}

	public List<PhoneData> getClientPhones() {
		return clientPhones;
	}

	/**
	 * Regular setter of phone list
	 * 
	 * @param clientPhones Phones
	 */
	public void setClientPhones(List<PhoneData> clientPhones) {
		this.clientPhones = clientPhones;
	}

	/**
	 * Overload of {@link #addClientPhone(PhoneData)} that instantiate new phone
	 * from parameters
	 * 
	 * @param ddd    Long distance calling code
	 * @param number Phone number
	 * 
	 * @see PhoneData#PhoneData(String, String)
	 */
	public void addClientPhone(String ddd, String number) {
		addClientPhone(new PhoneData(ddd, number));
	}

	/**
	 * Overload of {@link #addClientPhone(PhoneData)} that instantiate new phone
	 * from parameters
	 * 
	 * @param ddi    International calling code
	 * @param ddd    Long distance calling code
	 * @param number Phone number
	 * 
	 * @see PhoneData#PhoneData(String, String, String)
	 */
	public void addClientPhone(String ddi, String ddd, String number) {
		addClientPhone(new PhoneData(ddi, ddd, number));
	}

	/**
	 * Method for append phone in client list
	 * 
	 * @param clientPhone Phone
	 */
	public void addClientPhone(PhoneData clientPhone) {
		if (this.clientPhones == null) {
			this.clientPhones = new ArrayList<>();
		}
		this.clientPhones.add(clientPhone);
	}
}
