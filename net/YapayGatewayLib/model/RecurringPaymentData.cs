using System;

namespace YapayGatewayLib.Model
{
    public class RecurringPaymentData
    {
	 long paymentCode{get;set;}
	 long recurringPaymentNumber{get;set;}
	 long value{get;set;}
	 int modality{get;set;}
	 int frequency{get;set;}
	 string notificationUrl{get;set;}
	 bool processImmediately{get;set;}
	 int billingAmount{get;set;}
	 string billingFirstDate{get;set;}
	 string billDueDate{get;set;}
	 string freeFieldOne{get;set;}
	 string freeFieldTwo{get;set;}
	 string freeFieldThree{get;set;}
	 string freeFieldFour{get;set;}
	 string freeFieldFive{get;set;}
	 CreditCardData creditCard{get;set;}
	 DebitCardData debitCard{get;set;}
	 RecurringPaymentChargingData chargingData{get;set;}
	 RecurringPaymentDeliveryData deliveryData{get;set;}
    }
}
