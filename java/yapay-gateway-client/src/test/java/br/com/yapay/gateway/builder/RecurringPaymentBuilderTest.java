package br.com.yapay.gateway.builder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.com.yapay.gateway.model.RecurringPayment;

public class RecurringPaymentBuilderTest {

	@Test
	public void itShouldInitializeRecurringPayment() {
		RecurringPaymentBuilder.newRecurringPayment("15000000", new Long(123), new Long(12345), new Long(100));
		RecurringPayment recurringPayment = RecurringPaymentBuilder.build();

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
		RecurringPaymentBuilder.newRecurringPayment("15000000", new Long(123), new Long(12345), new Long(100));
		RecurringPaymentBuilder.withFrequencyOf(4);
		RecurringPayment recurringPayment = RecurringPaymentBuilder.build();

		assertEquals(new Integer(4), recurringPayment.getRecurringPaymentData().getFrequency());
	}

	@Test
	public void youShouldBeAbleToSetNotificationUrl() {
		RecurringPaymentBuilder.newRecurringPayment("15000000", new Long(123), new Long(12345), new Long(100));
		RecurringPaymentBuilder.setNotificationUrl("https://google.com.br");
		RecurringPayment recurringPayment = RecurringPaymentBuilder.build();

		assertEquals("https://google.com.br", recurringPayment.getRecurringPaymentData().getNotificationUrl());
	}
	
	@Test
	public void youShouldBeAbleToSetProcessImmediately() {
		RecurringPaymentBuilder.newRecurringPayment("15000000", new Long(123), new Long(12345), new Long(100));
		RecurringPaymentBuilder.shouldProcessImmediately(true);
		RecurringPayment recurringPayment = RecurringPaymentBuilder.build();
		
		assertEquals(true, recurringPayment.getRecurringPaymentData().getProcessImmediately());
	}

}
