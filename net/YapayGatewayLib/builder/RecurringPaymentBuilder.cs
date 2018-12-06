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

        }

        public static void WithFrequencyOf(int frequency)
        {

        }

        public static void SetNotificationUrl(string notificationUrl)
        {

        }

        public static void ShouldProcessImmediately(bool processImmediately)
        {

        }

        public static void WithBillingOptions(int billingAmount, string billingFirstDate, string billDueDate)
        {

        }

        public static void WithFreeFields(string freeFieldOne, string freeFieldTwo, string freeFieldThree, string freeFieldFour, string freeFieldFive)
        {

        }

        public static void WithCreditCard(CreditCardData creditCardData)
        {

        }

        public static void WithDebitCard(DebitCardData debitCardData)
        {

        }

        public static void WithDelivery(RecurringPaymentDeliveryData deliveryData)
        {

        }

        public static void WithChargingData(RecurringPaymentChargingData chargingData)
        {

        }


    }
}