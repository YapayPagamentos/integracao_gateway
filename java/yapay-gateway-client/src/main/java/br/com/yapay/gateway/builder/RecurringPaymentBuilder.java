package br.com.yapay.gateway.builder;

import br.com.yapay.gateway.model.Credential;
import br.com.yapay.gateway.model.CreditCardData;
import br.com.yapay.gateway.model.DebitCardData;
import br.com.yapay.gateway.model.PhoneData;
import br.com.yapay.gateway.model.RecurringPayment;
import br.com.yapay.gateway.model.RecurringPaymentChargingData;
import br.com.yapay.gateway.model.RecurringPaymentData;
import br.com.yapay.gateway.model.RecurringPaymentDeliveryData;

public class RecurringPaymentBuilder {

	private RecurringPayment recurringPayment;

	private String storeCode;

	public RecurringPaymentBuilder() {

	}

	public RecurringPaymentBuilder(Credential credentials) {
		this.storeCode = credentials.getStoreCode();
	}

	public RecurringPayment build() {
		RecurringPayment newRecurringPayment = recurringPayment;
		recurringPayment = null;
		return newRecurringPayment;
	}

	public void newRecurringPayment(Long paymentCode, Long recurringPaymentNumber, Long value) {
		this.newRecurringPayment(null, paymentCode, recurringPaymentNumber, value);
		recurringPayment.setStoreCode(storeCode);
	}

	public void newRecurringPayment(String storeCode, Long paymentCode, Long recurringPaymentNumber, Long value) {
		recurringPayment = new RecurringPayment();
		recurringPayment.setStoreCode(storeCode);
		recurringPayment.setRecurringPaymentData(new RecurringPaymentData());
		recurringPayment.getRecurringPaymentData().setPaymentCode(paymentCode);
		recurringPayment.getRecurringPaymentData().setRecurringPaymentNumber(recurringPaymentNumber);
		recurringPayment.getRecurringPaymentData().setValue(value);
		recurringPayment.getRecurringPaymentData().setModality(1);
	}

	public void withFrequencyOf(Integer frequency) {
		recurringPayment.getRecurringPaymentData().setFrequency(frequency);
	}

	public void setNotificationUrl(String notificationUrl) {
		recurringPayment.getRecurringPaymentData().setNotificationUrl(notificationUrl);
	}

	public void shouldProcessImmediately(Boolean processImmediately) {
		recurringPayment.getRecurringPaymentData().setProcessImmediately(processImmediately);
	}

	public void withBillingOptions(Integer billingAmount, String billingFirstDate, String billDueDate) {
		recurringPayment.getRecurringPaymentData().setBillingAmount(billingAmount);
		recurringPayment.getRecurringPaymentData().setBillingFirstDate(billingFirstDate);
		recurringPayment.getRecurringPaymentData().setBillDueDate(billDueDate);
	}

	public void withFreeFields(String freeFieldOne, String freeFieldTwo, String freeFieldThree, String freeFieldFour,
			String freeFieldFive) {
		recurringPayment.getRecurringPaymentData().setFreeFieldOne(freeFieldOne);
		recurringPayment.getRecurringPaymentData().setFreeFieldTwo(freeFieldTwo);
		recurringPayment.getRecurringPaymentData().setFreeFieldThree(freeFieldThree);
		recurringPayment.getRecurringPaymentData().setFreeFieldFour(freeFieldFour);
		recurringPayment.getRecurringPaymentData().setFreeFieldFive(freeFieldFive);
	}

	public void withCreditCard(CreditCardData creditCardData) {
		recurringPayment.getRecurringPaymentData().setCreditCard(new CreditCardData());
		recurringPayment.getRecurringPaymentData().getCreditCard()
				.setCardHolderName(creditCardData.getCardHolderName());
		recurringPayment.getRecurringPaymentData().getCreditCard().setCardNumber(creditCardData.getCardNumber());
		recurringPayment.getRecurringPaymentData().getCreditCard().setCvv(creditCardData.getCvv());
		recurringPayment.getRecurringPaymentData().getCreditCard()
				.setExpirationDate(creditCardData.getExpirationDate());
		recurringPayment.getRecurringPaymentData().getCreditCard().setInstallments(creditCardData.getInstallments());
		recurringPayment.getRecurringPaymentData().getCreditCard().setPaymentCode(creditCardData.getPaymentCode());
		recurringPayment.getRecurringPaymentData().getCreditCard().setValue(creditCardData.getValue());
	}

	public void withDebitCard(DebitCardData debitCardData) {
		recurringPayment.getRecurringPaymentData().setDebitCard(new DebitCardData());
		recurringPayment.getRecurringPaymentData().getDebitCard().setAccountNumber(debitCardData.getAccountNumber());
		recurringPayment.getRecurringPaymentData().getDebitCard()
				.setAccountNumberDigit(debitCardData.getAccountNumberDigit());
		recurringPayment.getRecurringPaymentData().getDebitCard().setAccountType(debitCardData.getAccountType());
		recurringPayment.getRecurringPaymentData().getDebitCard().setAgency(debitCardData.getAgency());
		recurringPayment.getRecurringPaymentData().getDebitCard().setAgencyDigit(debitCardData.getAgencyDigit());
	}

	public void withDelivery(RecurringPaymentDeliveryData deliveryData) {
		recurringPayment.getRecurringPaymentData().setDeliveryData(new RecurringPaymentDeliveryData());
		recurringPayment.getRecurringPaymentData().getDeliveryData().setDeliveryCity(deliveryData.getDeliveryCity());
		recurringPayment.getRecurringPaymentData().getDeliveryData()
				.setDeliveryComplement(deliveryData.getDeliveryComplement());
		recurringPayment.getRecurringPaymentData().getDeliveryData()
				.setDeliveryCountry(deliveryData.getDeliveryCountry());
		recurringPayment.getRecurringPaymentData().getDeliveryData()
				.setDeliveryDistrict(deliveryData.getDeliveryDistrict());
		recurringPayment.getRecurringPaymentData().getDeliveryData().setDeliveryMail(deliveryData.getDeliveryMail());
		recurringPayment.getRecurringPaymentData().getDeliveryData().setDeliveryName(deliveryData.getDeliveryName());
		recurringPayment.getRecurringPaymentData().getDeliveryData()
				.setDeliveryNumber(deliveryData.getDeliveryNumber());
		recurringPayment.getRecurringPaymentData().getDeliveryData().setDeliveryState(deliveryData.getDeliveryState());
		recurringPayment.getRecurringPaymentData().getDeliveryData()
				.setDeliveryStreet(deliveryData.getDeliveryStreet());
		recurringPayment.getRecurringPaymentData().getDeliveryData()
				.setDeliveryZipCode(deliveryData.getDeliveryZipCode());

		if (deliveryData.getPhone() != null) {
			recurringPayment.getRecurringPaymentData().getDeliveryData().setPhone(new PhoneData());
			recurringPayment.getRecurringPaymentData().getDeliveryData().getPhone()
					.setDdd(deliveryData.getPhone().getDdd());
			recurringPayment.getRecurringPaymentData().getDeliveryData().getPhone()
					.setDdi(deliveryData.getPhone().getDdi());
			recurringPayment.getRecurringPaymentData().getDeliveryData().getPhone()
					.setPhone(deliveryData.getPhone().getPhone());
			recurringPayment.getRecurringPaymentData().getDeliveryData().getPhone()
					.setPhoneType(deliveryData.getPhone().getPhoneType());
		}
	}

	public void withChargingData(RecurringPaymentChargingData chargingData) {
		recurringPayment.getRecurringPaymentData().setChargingData(new RecurringPaymentChargingData());
		recurringPayment.getRecurringPaymentData().getChargingData().setBirthday(chargingData.getBirthday());
		recurringPayment.getRecurringPaymentData().getChargingData().setBuyerMail(chargingData.getBuyerMail());
		recurringPayment.getRecurringPaymentData().getChargingData().setBuyerName(chargingData.getBuyerName());
		recurringPayment.getRecurringPaymentData().getChargingData()
				.setClientAddressCity(chargingData.getClientAddressCity());
		recurringPayment.getRecurringPaymentData().getChargingData()
				.setClientAddressComplement(chargingData.getClientAddressComplement());
		recurringPayment.getRecurringPaymentData().getChargingData()
				.setClientAddressCountry(chargingData.getClientAddressCountry());
		recurringPayment.getRecurringPaymentData().getChargingData()
				.setClientAddressDistrict(chargingData.getClientAddressDistrict());
		recurringPayment.getRecurringPaymentData().getChargingData()
				.setClientAddressNumber(chargingData.getClientAddressNumber());
		recurringPayment.getRecurringPaymentData().getChargingData()
				.setClientAddressState(chargingData.getClientAddressState());
		recurringPayment.getRecurringPaymentData().getChargingData()
				.setClientAddressStreet(chargingData.getClientAddressStreet());
		recurringPayment.getRecurringPaymentData().getChargingData()
				.setClientAddressZipcode(chargingData.getClientAddressZipcode());
		recurringPayment.getRecurringPaymentData().getChargingData().setClientCode(chargingData.getClientCode());
		recurringPayment.getRecurringPaymentData().getChargingData().setClientSex(chargingData.getClientSex());
		recurringPayment.getRecurringPaymentData().getChargingData().setClientType(chargingData.getClientType());
		recurringPayment.getRecurringPaymentData().getChargingData().setDocument(chargingData.getDocument());
		recurringPayment.getRecurringPaymentData().getChargingData().setDocumentTwo(chargingData.getDocumentTwo());

		if (chargingData.getPhone() != null) {
			recurringPayment.getRecurringPaymentData().getChargingData().setPhone(new PhoneData());
			recurringPayment.getRecurringPaymentData().getChargingData().getPhone()
					.setDdd(chargingData.getPhone().getDdd());
			recurringPayment.getRecurringPaymentData().getChargingData().getPhone()
					.setDdi(chargingData.getPhone().getDdi());
			recurringPayment.getRecurringPaymentData().getChargingData().getPhone()
					.setPhone(chargingData.getPhone().getPhone());
			recurringPayment.getRecurringPaymentData().getChargingData().getPhone()
					.setPhoneType(chargingData.getPhone().getPhoneType());
		}
	}
}
