package br.com.yapay.gateway.model;

import com.google.gson.Gson;

public class ApiResponse {

	private int httpStatus;
	private String rawResponseContent;
	private ApiResponseContent responseContent;

	public int getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(int httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getRawResponseContent() {
		return rawResponseContent;
	}

	public void setRawResponseContent(String rawResponseContent) {
		this.rawResponseContent = rawResponseContent;
		try {
			this.responseContent = new Gson().fromJson(rawResponseContent, ApiResponseContent.class);
		} catch (Exception e) {
		}
	}

	public ApiResponseContent getResponseContent() {
		return responseContent;
	}

	@Override
	public String toString() {
		return "HTTP Status " + httpStatus + " " + rawResponseContent;
	}
}
