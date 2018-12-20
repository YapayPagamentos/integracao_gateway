package br.com.yapay.gateway.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class OneClickRegisterTest {

	private Credential credential;

	@Before
	public void setUp() throws Exception {
		credential = new Credential("yapay_usr_test", "yapay_pwd_test", "4223161508040");
	}

	@Test
	public void testToJson() {
		OneClickRegister register = OneClickRegister.getBuilder(credential, "common@email.com", 170)
				.withCard("TEST BUYER", "4444333322221111", 8, 2024).build();

		assertEquals(
				"{\"codigoEstabelecimento\":\"4223161508040\",\"nomeTitularCartaoCredito\":\"TEST BUYER\",\"numeroCartaoCredito\":\"4444333322221111\",\"dataValidadeCartao\":\"08/2024\",\"emailComprador\":\"common@email.com\",\"formaPagamento\":170}",
				register.toJson());
	}

}
