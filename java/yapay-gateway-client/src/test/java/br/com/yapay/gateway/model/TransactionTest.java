package br.com.yapay.gateway.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TransactionTest {

	private Credential credential;

	@Before
	public void setUp() {
		credential = new Credential("yapay_usr_test", "yapay_pwd_test", "4223161508040");
	}

	@Test
	public void testToJsonRegularPunctualAuthorization() {
		Transaction authorization = Transaction.getBuilder(credential, 170, 333L, 60_60L).addItem("Umbrella", 3, 20_00L)
				.withCharging("Test Buyer", "common@email.com", "91234567890")
				.withChargingAddress("R. Itapaiúna", "2434", "05707-001", "Jardim Morumbi", "São Paulo", "SP")
				.addChargingPhone("11", "35440500").withCard("TEST BUYER", "4444333322221111", 12, 2022, "123").build();

		assertEquals(
				"{\"codigoEstabelecimento\":\"4223161508040\",\"codigoFormaPagamento\":170,\"transacao\":{\"numeroTransacao\":333,\"valor\":6060,\"parcelas\":1,\"idioma\":1},\"dadosCartao\":{\"nomePortador\":\"TEST BUYER\",\"numeroCartao\":\"4444333322221111\",\"codigoSeguranca\":\"123\",\"dataValidade\":\"12/2022\"},\"itensDoPedido\":[{\"codigoProduto\":\"1\",\"codigoCategoria\":\"1\",\"nomeProduto\":\"Umbrella\",\"quantidadeProduto\":3,\"valorUnitarioProduto\":2000}],\"dadosCobranca\":{\"codigoCliente\":1,\"tipoCliente\":1,\"nome\":\"Test Buyer\",\"email\":\"common@email.com\",\"documento\":\"91234567890\",\"endereco\":{\"logradouro\":\"R. Itapaiúna\",\"numero\":\"2434\",\"cep\":\"05707-001\",\"bairro\":\"Jardim Morumbi\",\"cidade\":\"São Paulo\",\"estado\":\"SP\",\"pais\":\"BRA\"},\"telefone\":[{\"ddi\":\"55\",\"ddd\":\"11\",\"telefone\":\"35440500\",\"tipoTelefone\":1}]}}",
				authorization.toJson());
	}

}
