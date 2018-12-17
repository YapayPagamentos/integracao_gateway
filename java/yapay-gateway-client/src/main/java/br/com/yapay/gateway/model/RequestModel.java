package br.com.yapay.gateway.model;

import com.google.gson.Gson;

public abstract class RequestModel {

	private final transient Gson jsonBuilder;
	private final transient Credential credential;
	private transient String resourcePath;

	protected RequestModel(Credential credential) {
		this.credential = credential;
		jsonBuilder = new Gson();
	}

	public Credential getCredential() {
		return credential;
	}

	public String getResourcePath() {
		return resourcePath;
	}

	protected void setResourcePath(String resourcePath) {
		this.resourcePath = resourcePath;
	}

	public String toJson() {
		return jsonBuilder.toJson(this);
	}

	public abstract String getStoreCode();

	public abstract Long getModelReference();

	public abstract Long getValue();

}
