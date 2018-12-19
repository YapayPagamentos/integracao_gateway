package br.com.yapay.gateway.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

/**
 * Class containing delivery info
 * 
 * @author Adriano Santos
 *
 */
public class DeliveryData {

	@SerializedName("nome")
	private String name;

	@SerializedName("email")
	private String mail;

	@SerializedName("dataNascimento")
	private String birthday;

	@SerializedName("sexo")
	private String genre;

	@SerializedName("documento")
	private String document;

	@SerializedName("documento2")
	private String documentTwo;

	@SerializedName("endereco")
	private AddressData deliveryAddress;

	@SerializedName("telefone")
	private List<PhoneData> deliveryPhones;

	/**
	 * @deprecated JSON bind eyes only
	 */
	@Deprecated
	DeliveryData() {
	}

	/**
	 * Overload of {@link #DeliveryData(String, String, String, AddressData, List)}
	 * without {@code deliveryAddress} and {@code deliveryPhones}
	 * 
	 * @param name     Recipient name
	 * @param email    Recipient e-mail
	 * @param document Recipient document
	 */
	public DeliveryData(String name, String email, String document) {
		this(name, email, document, null, null);
	}

	/**
	 * Overload of
	 * {@link #DeliveryData(String, String, String, String, String, String, AddressData, List)}
	 * without {@code birthday}, {@code genre} and {@code documentTwo}
	 * 
	 * @param name            Recipient name
	 * @param email           Recipient e-mail
	 * @param document        Recipient document
	 * @param deliveryAddress Delivery address
	 * @param deliveryPhones  Delivery phones
	 */
	public DeliveryData(String name, String email, String document, AddressData deliveryAddress,
			List<PhoneData> deliveryPhones) {
		this(name, email, null, null, document, null, deliveryAddress, deliveryPhones);
	}

	/**
	 * Constructor with all parameters
	 * 
	 * @param name            Recipient name
	 * @param email           Recipient e-mail
	 * @param birthday        Recipient birth date
	 * @param genre           Recipient genre
	 * @param document        Recipient document
	 * @param documentTwo     Recipient secondary document
	 * @param deliveryAddress Delivery address
	 * @param deliveryPhones  Delivery phones
	 */
	public DeliveryData(String name, String email, LocalDate birthday, String genre, String document,
			String documentTwo, AddressData deliveryAddress, List<PhoneData> deliveryPhones) {
		this.name = name;
		mail = email;
		setBirthday(birthday);
		this.genre = genre;
		this.document = document;
		this.documentTwo = documentTwo;
		this.deliveryAddress = deliveryAddress;
		this.deliveryPhones = deliveryPhones;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
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
	 * @param birthday Recipient birth date
	 */
	public void setBirthday(LocalDate birthday) {
		String birthdayStr = birthday == null ? null : birthday.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		setBirthday(birthdayStr);
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getDocumentTwo() {
		return documentTwo;
	}

	public void setDocumentTwo(String documentTwo) {
		this.documentTwo = documentTwo;
	}

	public AddressData getDeliveryAddress() {
		return deliveryAddress;
	}

	/**
	 * Regular setter of delivery address
	 * 
	 * @param deliveryAddress Address
	 */
	public void setDeliveryAddress(AddressData deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	/**
	 * Overload of {@link #setDeliveryAddress(AddressData)} that instantiate new
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
	public void setDeliveryAddress(String street, String number, String zipCode, String district, String city,
			String state) {
		setDeliveryAddress(new AddressData(street, number, zipCode, district, city, state));
	}

	/**
	 * Overload of {@link #setDeliveryAddress(AddressData)} that instantiate new
	 * address from parameters
	 * 
	 * @param street  Street
	 * @param number  Street number
	 * @param zipCode Postal identification
	 * @param city    City
	 * @param state   State
	 * 
	 * @see AddressData#AddressData(String, String, String, String, String)
	 */
	public void setDeliveryAddress(String street, String number, String zipCode, String city, String state) {
		setDeliveryAddress(new AddressData(street, number, zipCode, city, state));
	}

	public List<PhoneData> getDeliveryPhones() {
		return deliveryPhones;
	}

	/**
	 * Regular setter of phone list
	 * 
	 * @param deliveryPhones Phones
	 */
	public void setDeliveryPhones(List<PhoneData> deliveryPhones) {
		this.deliveryPhones = deliveryPhones;
	}

	/**
	 * Overload of {@link #addDeliveryPhone(PhoneData)} that instantiate new phone
	 * from parameters
	 * 
	 * @param ddd    Long distance calling code
	 * @param number Phone number
	 * 
	 * @see PhoneData#PhoneData(String, String)
	 */
	public void addDeliveryPhone(String ddd, String number) {
		addDeliveryPhone(new PhoneData(ddd, number));
	}

	/**
	 * Overload of {@link #addDeliveryPhone(PhoneData)} that instantiate new phone
	 * from parameters
	 * 
	 * @param ddi    International calling code
	 * @param ddd    Long distance calling code
	 * @param number Phone number
	 * 
	 * @see PhoneData#PhoneData(String, String, String)
	 */
	public void addDeliveryPhone(String ddi, String ddd, String number) {
		addDeliveryPhone(new PhoneData(ddi, ddd, number));
	}

	/**
	 * Method for append phone in delivery list
	 * 
	 * @param deliveryPhone Phone
	 */
	public void addDeliveryPhone(PhoneData deliveryPhone) {
		if (this.deliveryPhones == null) {
			this.deliveryPhones = new ArrayList<>();
		}
		this.deliveryPhones.add(deliveryPhone);
	}
}
