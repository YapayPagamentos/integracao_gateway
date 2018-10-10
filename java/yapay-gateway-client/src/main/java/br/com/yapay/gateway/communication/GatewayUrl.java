package br.com.yapay.gateway.communication;

public enum GatewayUrl {

	SANDBOX("https://sandbox.gateway.yapay.com.br/checkout"), PRODUCTION("https://gateway.yapay.com.br/checkout");

	private String url;

	private GatewayUrl(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}


}
