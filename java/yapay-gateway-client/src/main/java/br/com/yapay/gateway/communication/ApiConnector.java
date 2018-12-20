package br.com.yapay.gateway.communication;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import br.com.yapay.gateway.model.ApiResponse;
import br.com.yapay.gateway.model.RequestModel;

public interface ApiConnector {

	ApiResponse oneClickRegister(RequestModel register) throws ClientProtocolException, IOException;

	ApiResponse oneClickQuery(RequestModel query) throws ClientProtocolException, IOException;

	ApiResponse oneClickRegisterUpdate(RequestModel update) throws ClientProtocolException, IOException;

	ApiResponse oneClickAuthorize(RequestModel authorization) throws ClientProtocolException, IOException;

	ApiResponse recurringPaymentRegister(RequestModel registration) throws ClientProtocolException, IOException;

	ApiResponse recurringPaymentQuery(RequestModel query) throws ClientProtocolException, IOException;

	ApiResponse recurringPaymentCancel(RequestModel cancel) throws ClientProtocolException, IOException;

	ApiResponse transactionAuthorize(RequestModel authorization) throws ClientProtocolException, IOException;

	ApiResponse transactionQuery(RequestModel query) throws ClientProtocolException, IOException;

	ApiResponse transactionCapture(RequestModel capture) throws ClientProtocolException, IOException;

	ApiResponse transactionCancel(RequestModel cancel) throws ClientProtocolException, IOException;

}
