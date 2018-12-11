package br.com.yapay.gateway.builder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import br.com.yapay.gateway.model.Transaction;

public class TransactionBuilderTest {
	
	
	private TransactionBuilder builder;
	
	@Before
	public void configure() {
		builder = new TransactionBuilder();
	}

	@Test
	public void itShouldInitializeANewTransaction() {
		builder.newTransaction("15000000", new Integer(123), new Long(123), new Long(150));
		Transaction transaction = builder.build();

		assertNotNull(transaction);
		assertEquals("15000000", transaction.getStoreCode());
		assertEquals(new Integer(123), transaction.getPaymentCode());
		assertNotNull(transaction.getTransactionData());
		assertEquals(new Long(123), transaction.getTransactionData().getTransactionNumber());
		assertEquals(new Long(150), transaction.getTransactionData().getValue());
	}

	@Test
	public void youNeedToBeAbleToSetInstallmentsForTransaction() {
		builder.newTransaction("15000000", new Integer(123), new Long(123), new Long(150));
		builder.withInstallments(new Integer(3));
		Transaction transaction = builder.build();

		assertEquals(new Integer(3), transaction.getTransactionData().getInstallments());
	}

	@Test
	public void youShouldBeAbleToSetCreditCardInfo() {
		builder.newTransaction("15000000", new Integer(123), new Long(123), new Long(150));
		builder.withSingleCreditCard("IVAN SIMIONATO", "123456789", "123", "10/2020");
		Transaction transaction = builder.build();

		assertNotNull(transaction.getCreditCard());
		assertEquals("IVAN SIMIONATO", transaction.getCreditCard().getCardHolderName());
		assertEquals("123456789", transaction.getCreditCard().getCardNumber());
		assertEquals("123", transaction.getCreditCard().getCvv());
		assertEquals("10/2020", transaction.getCreditCard().getExpirationDate());
	}
	
	@Test
	public void youShouldBeAbleToSetDebitCardInfo() {
		builder.newTransaction("15000000", new Integer(123), new Long(123), new Long(150));
		builder.withSingleDebitCard("12", "X", "123456789", "7", "T");
		Transaction transaction = builder.build();
		
		assertNotNull(transaction.getDebitCard());
		assertEquals("12", transaction.getDebitCard().getAgency());
		assertEquals("X", transaction.getDebitCard().getAgencyDigit());
		assertEquals("123456789", transaction.getDebitCard().getAccountNumber());
		assertEquals("7", transaction.getDebitCard().getAccountNumberDigit());
		assertEquals("T", transaction.getDebitCard().getAccountType());
	}
	
	

}
