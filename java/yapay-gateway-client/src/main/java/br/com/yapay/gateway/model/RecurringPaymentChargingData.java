package br.com.yapay.gateway.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.google.gson.annotations.SerializedName;

/**
 * Class containing recurring payment client info
 * 
 * @author Adriano Santos
 *
 */
public class RecurringPaymentChargingData {

	@SerializedName("nomeComprador")
	private String buyerName;

	@SerializedName("emailComprador")
	private String buyerMail;

	@SerializedName("tipoCliente")
	private Integer clientType;

	@SerializedName("documento")
	private String document;

	@SerializedName("dataNascimento")
	private String birthday;

	@SerializedName("codigoCliente")
	private Integer clientCode;

	@SerializedName("sexo")
	private String clientGenre;

	@SerializedName("documento2")
	private String documentTwo;

	@SerializedName("enderecoComprador")
	private String clientAddressStreet;

	@SerializedName("numeroEnderecoComprador")
	private String clientAddressNumber;

	@SerializedName("bairroComprador")
	private String clientAddressDistrict;

	@SerializedName("complementoComprador")
	private String clientAddressComplement;

	@SerializedName("cidadeComprador")
	private String clientAddressCity;

	@SerializedName("estadoComprador")
	private String clientAddressState;

	@SerializedName("cepComprador")
	private String clientAddressZipcode;

	@SerializedName("paisComprador")
	private String clientAddressCountry;

	@SerializedName("telefone")
	private PhoneData phone;

	/**
	 * @deprecated JSON bind eyes only
	 */
	@Deprecated
	RecurringPaymentChargingData() {
	}

	/**
	 * Overload of
	 * {@link #RecurringPaymentChargingData(String, String, String, PhoneData)}
	 * without {@code phone}
	 * 
	 * @param clientName     Client name
	 * @param clientEmail    Client e-mail
	 * @param clientDocument Client document
	 */
	public RecurringPaymentChargingData(String clientName, String clientEmail, String clientDocument) {
		this(clientName, clientEmail, clientDocument, null);
	}

	/**
	 * Overload of
	 * {@link #RecurringPaymentChargingData(String, String, String, String, String, String, PhoneData)}
	 * without {@code clientBirthday}, {@code clientGenre} and
	 * {@code clientDocumentTwo}
	 * 
	 * @param clientName     Client name
	 * @param clientEmail    Client e-mail
	 * @param clientDocument Client document
	 * @param phone          Client phone
	 */
	public RecurringPaymentChargingData(String clientName, String clientEmail, String clientDocument, PhoneData phone) {
		this(clientName, clientEmail, null, null, clientDocument, null, phone);
	}

	/**
	 * Overload of
	 * {@link #RecurringPaymentChargingData(Integer, Integer, String, String, String, String, String, String, PhoneData)}
	 * with {@code clientCode} and {@code clientType} defaulting to 1
	 * 
	 * @param clientName        Client name
	 * @param clientEmail       Client e-mail
	 * @param clientBirthday    Client birth date
	 * @param clientGenre       Client genre
	 * @param clientDocument    Client document
	 * @param clientDocumentTwo Client secondary document
	 * @param phone             Client phone
	 */
	public RecurringPaymentChargingData(String clientName, String clientEmail, LocalDate clientBirthday,
			String clientGenre, String clientDocument, String clientDocumentTwo, PhoneData phone) {
		this(1, 1, clientName, clientEmail, clientBirthday, clientGenre, clientDocument, clientDocumentTwo, phone);
	}

	/**
	 * Constructor with non address marked parameters
	 * 
	 * @param clientCode        Client code
	 * @param clientType        Client type
	 * @param clientName        Client name
	 * @param clientEmail       Client e-mail
	 * @param clientBirthday    Client birth date
	 * @param clientGenre       Client genre
	 * @param clientDocument    Client document
	 * @param clientDocumentTwo Client secondary document
	 * @param phone             Client phone
	 */
	public RecurringPaymentChargingData(Integer clientCode, Integer clientType, String clientName, String clientEmail,
			LocalDate clientBirthday, String clientGenre, String clientDocument, String clientDocumentTwo,
			PhoneData phone) {
		this.clientCode = clientCode;
		this.clientType = clientType;
		buyerName = clientName;
		buyerMail = clientEmail;
		setBirthday(clientBirthday);
		this.clientGenre = clientGenre;
		document = clientDocument;
		documentTwo = clientDocumentTwo;
		this.phone = phone;

	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public String getBuyerMail() {
		return buyerMail;
	}

	public void setBuyerMail(String buyerMail) {
		this.buyerMail = buyerMail;
	}

	public Integer getClientType() {
		return clientType;
	}

	public void setClientType(Integer clientType) {
		this.clientType = clientType;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getBirthday() {
		return birthday;
	}

	void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	/**
	 * Setting birthday from {@link LocalDate}
	 * 
	 * @param birthday Client birth date
	 */
	public void setBirthday(LocalDate birthday) {
		String birthdayStr = birthday == null ? null : birthday.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		setBirthday(birthdayStr);
	}

	public Integer getClientCode() {
		return clientCode;
	}

	public void setClientCode(Integer clientCode) {
		this.clientCode = clientCode;
	}

	public String getClientGenre() {
		return clientGenre;
	}

	public void setClientGenre(String clientGenre) {
		this.clientGenre = clientGenre;
	}

	public String getDocumentTwo() {
		return documentTwo;
	}

	public void setDocumentTwo(String documentTwo) {
		this.documentTwo = documentTwo;
	}

	public String getClientAddressStreet() {
		return clientAddressStreet;
	}

	public void setClientAddressStreet(String clientAddressStreet) {
		this.clientAddressStreet = clientAddressStreet;
	}

	public String getClientAddressNumber() {
		return clientAddressNumber;
	}

	public void setClientAddressNumber(String clientAddressNumber) {
		this.clientAddressNumber = clientAddressNumber;
	}

	public String getClientAddressDistrict() {
		return clientAddressDistrict;
	}

	public void setClientAddressDistrict(String clientAddressDistrict) {
		this.clientAddressDistrict = clientAddressDistrict;
	}

	public String getClientAddressComplement() {
		return clientAddressComplement;
	}

	public void setClientAddressComplement(String clientAddressComplement) {
		this.clientAddressComplement = clientAddressComplement;
	}

	public String getClientAddressCity() {
		return clientAddressCity;
	}

	public void setClientAddressCity(String clientAddressCity) {
		this.clientAddressCity = clientAddressCity;
	}

	public String getClientAddressState() {
		return clientAddressState;
	}

	public void setClientAddressState(String clientAddressState) {
		this.clientAddressState = clientAddressState;
	}

	public String getClientAddressZipcode() {
		return clientAddressZipcode;
	}

	public void setClientAddressZipcode(String clientAddressZipcode) {
		this.clientAddressZipcode = clientAddressZipcode;
	}

	public String getClientAddressCountry() {
		return clientAddressCountry;
	}

	public void setClientAddressCountry(String clientAddressCountry) {
		this.clientAddressCountry = clientAddressCountry;
	}

	public PhoneData getPhone() {
		return phone;
	}

	public void setPhone(String ddd, String number) {
		setPhone(new PhoneData(ddd, number));
	}

	public void setPhone(String ddi, String ddd, String number) {
		setPhone(new PhoneData(ddi, ddd, number));
	}

	public void setPhone(PhoneData phone) {
		this.phone = phone;
	}

	public void setClientAddress(String street, String number, String zipCode, String city, String state) {
		setClientAddress(street, number, zipCode, null, city, state);
	}

	public void setClientAddress(String street, String number, String zipCode, String district, String city,
			String state) {
		setClientAddress(street, number, null, zipCode, district, city, state, "BRA");
	}

	public void setClientAddress(String street, String number, String complement, String zipCode, String district,
			String city, String state, String country) {
		clientAddressStreet = street;
		clientAddressNumber = number;
		clientAddressDistrict = district;
		clientAddressComplement = complement;
		clientAddressCity = city;
		clientAddressState = state;
		clientAddressZipcode = zipCode;
		clientAddressCountry = country;
	}
}
