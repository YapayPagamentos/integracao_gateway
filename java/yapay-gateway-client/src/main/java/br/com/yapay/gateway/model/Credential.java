package br.com.yapay.gateway.model;

/**
 * Class with authentication info
 * 
 * @author Adriano Santos
 *
 */
public class Credential {

	private final String user;
	private final String password;

	private String storeCode;

	/**
	 * Overload of {@link #Credential(String, String, String)} without
	 * {@code storeCode}
	 * 
	 * @param user     Authentication user name
	 * @param password Authentication user password
	 */
	public Credential(String user, String password) {
		this(user, password, null);
	}

	/**
	 * Constructor with all parameters
	 * 
	 * @param user      Authentication user name
	 * @param password  Authentication user password
	 * @param storeCode Store identification
	 */
	public Credential(String user, String password, String storeCode) {
		this.user = user;
		this.password = password;
		this.storeCode = storeCode;
	}

	public String getUser() {
		return user;
	}

	public String getPassword() {
		return password;
	}

	public String getStoreCode() {
		return storeCode;
	}

	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}

}
