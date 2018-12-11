package br.com.yapay.gateway.builder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import br.com.yapay.gateway.model.OneClickRegisterData;

public class OneClickBuilderTest {
	
	private OneClickBuilder builder;
	
	@Before
	public void configure() {
		builder = new OneClickBuilder();
	}

	@Test
	public void itShouldInitializeAOneClickRegisterData() {
		builder.newOneClickRegister("15000000", new Long(123));
		OneClickRegisterData registerData = builder.build();
		
		assertNotNull(registerData);
		assertEquals("15000000", registerData.getStoreCode());
		assertEquals(new Long(123), registerData.getPaymentCode());
	}

	@Test
	public void itShouldPermitIncludeACreditCard() {
		builder.newOneClickRegister("15000000", new Long(123));
		builder.withCreditCard("IVAN SIMIONATO", "123456789", "10/2020");
		OneClickRegisterData registerData = builder.build();

		assertEquals("IVAN SIMIONATO", registerData.getCardHolderName());
		assertEquals("123456789", registerData.getCardNumber());
		assertEquals("10/2020", registerData.getExpirationDate());
	}
	
	@Test
	public void youShouldBeAbleToSetBuyerEmail() {
		builder.newOneClickRegister("15000000", new Long(123));
		builder.withCreditCard("IVAN SIMIONATO", "123456789", "10/2020");
		builder.forEmail("ivan.simionato@yapay.com.br");
		OneClickRegisterData registerData = builder.build();
		
		assertEquals("ivan.simionato@yapay.com.br", registerData.getBuyerEmail());
	}

}
