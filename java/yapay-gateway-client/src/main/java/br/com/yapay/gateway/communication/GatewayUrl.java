package br.com.yapay.gateway.communication;

/**
 * Enum with endpoints to Gateway API
 * 
 * @author Adriano Santos
 *
 */
public enum GatewayUrl {

	/**
	 * Test API url
	 */
	SANDBOX("https://sandbox.gateway.yapay.com.br/checkout"),

	/**
	 * Production API url
	 */
	PRODUCTION("https://gateway.yapay.com.br/checkout");

	private String url;

	private GatewayUrl(String url) {
		this.url = url;
	}

	/**
	 * Url getter
	 * 
	 * @return Endpoint pointing to specific environment
	 */
	public String getUrl() {
		return url;
	}

}
