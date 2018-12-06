using System;
using YapayGatewayLib.Model;

namespace YapayGatewayLib.Builder
{
    public class RecurringPaymentBuilder
    {

        private static RecurringPayment recurringPayment;

        public static RecurringPayment build()
        {
            RecurringPayment newRecurringPayment = recurringPayment;
            recurringPayment = null;

            return newRecurringPayment;
        }

        public static void NewRecurringPayment(string storeCode, long paymentCode, long recurringPaymentNumber, long value)
        {
            recurringPayment = new RecurringPayment();
            recurringPayment.storeCode = storeCode;
            recurringPayment.recurringPaymentData = new RecurringPaymentData();
            recurringPayment.recurringPaymentData.paymentCode = paymentCode;
            recurringPayment.recurringPaymentData.recurringPaymentNumber = recurringPaymentNumber;
            recurringPayment.recurringPaymentData.value = value;
            recurringPayment.recurringPaymentData.modality = 1;
        }

        public static void WithFrequencyOf(int frequency)
        {
            recurringPayment.recurringPaymentData.frequency = frequency;
        }

        public static void SetNotificationUrl(string notificationUrl)
        {
            recurringPayment.recurringPaymentData.notificationUrl = notificationUrl;
        }

        public static void ShouldProcessImmediately(bool processImmediately)
        {
            recurringPayment.recurringPaymentData.processImmediately = processImmediately;
        }

        public static void WithBillingOptions(int billingAmount, string billingFirstDate, string billDueDate)
        {
            recurringPayment.recurringPaymentData.billingAmount = billingAmount;
            recurringPayment.recurringPaymentData.billingFirstDate = billingFirstDate;
            recurringPayment.recurringPaymentData.billDueDate = billDueDate;
        }

        public static void WithFreeFields(string freeFieldOne, string freeFieldTwo, string freeFieldThree, string freeFieldFour, string freeFieldFive)
        {
            recurringPayment.recurringPaymentData.freeFieldOne = freeFieldOne;
            recurringPayment.recurringPaymentData.freeFieldTwo = freeFieldTwo;
            recurringPayment.recurringPaymentData.freeFieldThree = freeFieldThree;
            recurringPayment.recurringPaymentData.freeFieldFour = freeFieldFour;
            recurringPayment.recurringPaymentData.freeFieldFive = freeFieldFive;
        }

        public static void WithCreditCard(CreditCardData creditCardData)
        {
            recurringPayment.recurringPaymentData.creditCard = new CreditCardData();
            recurringPayment.recurringPaymentData.creditCard.cardHolderName = creditCardData.cardHolderName;
            recurringPayment.recurringPaymentData.creditCard.cardNumber = creditCardData.cardNumber;
            recurringPayment.recurringPaymentData.creditCard.cvv = creditCardData.cvv;
            recurringPayment.recurringPaymentData.creditCard.expirationDate = creditCardData.expirationDate;
            recurringPayment.recurringPaymentData.creditCard.installments = creditCardData.installments;
            recurringPayment.recurringPaymentData.creditCard.paymentCode = creditCardData.paymentCode;
            recurringPayment.recurringPaymentData.creditCard.value = creditCardData.value;
        }

        public static void WithDebitCard(DebitCardData debitCardData)
        {
            recurringPayment.recurringPaymentData.debitCard = new DebitCardData();
            recurringPayment.recurringPaymentData.debitCard.accountNumber = debitCardData.accountNumber;
            recurringPayment.recurringPaymentData.debitCard.accountNumberDigit = debitCardData.accountNumberDigit;
            recurringPayment.recurringPaymentData.debitCard.accountType = debitCardData.accountType;
            recurringPayment.recurringPaymentData.debitCard.agency = debitCardData.agency;
            recurringPayment.recurringPaymentData.debitCard.agencyDigit = debitCardData.agencyDigit;
        }

        public static void WithDelivery(RecurringPaymentDeliveryData deliveryData)
        {

        }

        public static void WithChargingData(RecurringPaymentChargingData chargingData)
        {

        }


    }
}