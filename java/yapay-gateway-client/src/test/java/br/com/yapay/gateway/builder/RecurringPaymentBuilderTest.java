package br.com.yapay.gateway.builder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import br.com.yapay.gateway.model.RecurringPayment;

public class RecurringPaymentBuilderTest {
	
	
	private RecurringPaymentBuilder builder;
	
	@Before
	public void configure() {
		builder = new RecurringPaymentBuilder();
	}

	@Test
	public void itShouldInitializeRecurringPayment() {
		builder.newRecurringPayment("15000000", new Long(123), new Long(12345), new Long(100));
		RecurringPayment recurringPayment = builder.build();

		assertNotNull(recurringPayment);
		assertEquals("15000000", recurringPayment.getStoreCode());
		assertNotNull(recurringPayment.getRecurringPaymentData());
		assertEquals(new Long(123), recurringPayment.getRecurringPaymentData().getPaymentCode());
		assertEquals(new Long(12345), recurringPayment.getRecurringPaymentData().getRecurringPaymentNumber());
		assertEquals(new Long(100), recurringPayment.getRecurringPaymentData().getValue());
		assertEquals(new Integer(1), recurringPayment.getRecurringPaymentData().getModality());
	}

	@Test
	public void youShouldBeAbleToSetFrequency() {
		builder.newRecurringPayment("15000000", new Long(123), new Long(12345), new Long(100));
		builder.withFrequencyOf(4);
		RecurringPayment recurringPayment = builder.build();

		assertEquals(new Integer(4), recurringPayment.getRecurringPaymentData().getFrequency());
	}

	@Test
	public void youShouldBeAbleToSetNotificationUrl() {
		builder.newRecurringPayment("15000000", new Long(123), new Long(12345), new Long(100));
		builder.setNotificationUrl("https://google.com.br");
		RecurringPayment recurringPayment = builder.build();

		assertEquals("https://google.com.br", recurringPayment.getRecurringPaymentData().getNotificationUrl());
	}
	
	@Test
	public void youShouldBeAbleToSetProcessImmediately() {
		builder.newRecurringPayment("15000000", new Long(123), new Long(12345), new Long(100));
		builder.shouldProcessImmediately(true);
		RecurringPayment recurringPayment = builder.build();
		
		assertEquals(true, recurringPayment.getRecurringPaymentData().getProcessImmediately());
	}

}
