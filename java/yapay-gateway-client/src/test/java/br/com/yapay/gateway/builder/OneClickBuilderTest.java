package br.com.yapay.gateway.builder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.com.yapay.gateway.model.OneClickRegisterData;

public class OneClickBuilderTest {

	@Test
	public void itShouldInitializeAOneClickRegisterData() {
		OneClickBuilder.newOneClickRegister("15000000", new Long(123));
		OneClickRegisterData registerData = OneClickBuilder.build();
		
		assertNotNull(registerData);
		assertEquals("15000000", registerData.getStoreCode());
		assertEquals(new Long(123), registerData.getPaymentCode());
	}

	@Test
	public void itShouldPermitIncludeACreditCard() {
		OneClickBuilder.newOneClickRegister("15000000", new Long(123));
		OneClickBuilder.withCreditCard("IVAN SIMIONATO", "123456789", "10/2020");
		OneClickRegisterData registerData = OneClickBuilder.build();

		assertEquals("IVAN SIMIONATO", registerData.getCardHolderName());
		assertEquals("123456789", registerData.getCardNumber());
		assertEquals("10/2020", registerData.getExpirationDate());
	}
	
	@Test
	public void youShouldBeAbleToSetBuyerEmail() {
		OneClickBuilder.newOneClickRegister("15000000", new Long(123));
		OneClickBuilder.withCreditCard("IVAN SIMIONATO", "123456789", "10/2020");
		OneClickBuilder.forEmail("ivan.simionato@yapay.com.br");
		OneClickRegisterData registerData = OneClickBuilder.build();
		
		assertEquals("ivan.simionato@yapay.com.br", registerData.getBuyerEmail());
	}

}
