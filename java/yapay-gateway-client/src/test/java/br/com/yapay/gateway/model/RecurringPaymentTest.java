package br.com.yapay.gateway.model;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.Month;

import org.junit.Before;
import org.junit.Test;

public class RecurringPaymentTest {

	private Credential credential;

	@Before
	public void setUp() throws Exception {
		credential = new Credential("yapay_usr_test", "yapay_pwd_test", "4223161508040");
	}

	@Test
	public void testToJson() {
		RecurringPayment recurring = RecurringPayment.getBuilder(credential, 170, 2L, 130_00L)
				.withNotificationUrl("http://test.com/hook").withProcessImmediately().withInstallments(2)
				.withStartDate(LocalDate.of(2022, Month.SEPTEMBER, 8))
				.withCard("TEST BUYER", "4444333322221111", 1, 2023, "123")
				.withChargingData("Test Buyer", "common@email.com", "91234567890")
				.withChargingDataPhone("11", "35440500").build();

		assertEquals(
				"{\"recorrencia\":{\"formaPagamento\":170,\"numeroRecorrencia\":2,\"valor\":13000,\"modalidade\":1,\"periodicidade\":3,\"urlNotificacao\":\"http://test.com/hook\",\"processarImediatamente\":true,\"quantidadeCobrancas\":2,\"dataPrimeiraCobranca\":\"08/09/2022\",\"dadosCartao\":{\"nomePortador\":\"TEST BUYER\",\"numeroCartao\":\"4444333322221111\",\"codigoSeguranca\":\"123\",\"dataValidade\":\"01/2023\"},\"dadosCobranca\":{\"nomeComprador\":\"Test Buyer\",\"emailComprador\":\"common@email.com\",\"tipoCliente\":1,\"documento\":\"91234567890\",\"codigoCliente\":1,\"telefone\":{\"ddi\":\"55\",\"ddd\":\"11\",\"telefone\":\"35440500\",\"tipoTelefone\":1}}},\"estabelecimento\":\"4223161508040\"}",
				recurring.toJson());
	}

}
