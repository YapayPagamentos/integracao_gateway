package br.com.yapay.gateway.communication;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import br.com.yapay.gateway.model.RequestModel;

public interface ApiConnector {

	String oneClickRegister(RequestModel register) throws ClientProtocolException, IOException;

	String oneClickQuery(RequestModel query) throws ClientProtocolException, IOException;

	String oneClickRegisterUpdate(RequestModel update) throws ClientProtocolException, IOException;

	String oneClickAuthorize(RequestModel authorization) throws ClientProtocolException, IOException;

	String recurringPaymentRegister(RequestModel registration) throws ClientProtocolException, IOException;

	String recurringPaymentQuery(RequestModel query) throws ClientProtocolException, IOException;

	String recurringPaymentCancel(RequestModel cancel) throws ClientProtocolException, IOException;

	String transactionAuthorize(RequestModel authorization) throws ClientProtocolException, IOException;

	String transactionQuery(RequestModel query) throws ClientProtocolException, IOException;

	String transactionCapture(RequestModel capture) throws ClientProtocolException, IOException;

	String transactionCancel(RequestModel cancel) throws ClientProtocolException, IOException;

}
