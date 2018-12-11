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
            recurringPayment.recurringPaymentData.deliveryData = new RecurringPaymentDeliveryData();
            recurringPayment.recurringPaymentData.deliveryData.deliveryCity = deliveryData.deliveryCity;
            recurringPayment.recurringPaymentData.deliveryData.deliveryComplement = deliveryData.deliveryComplement;
            recurringPayment.recurringPaymentData.deliveryData.deliveryCountry = deliveryData.deliveryCountry;
            recurringPayment.recurringPaymentData.deliveryData.deliveryDistrict = deliveryData.deliveryDistrict;
            recurringPayment.recurringPaymentData.deliveryData.deliveryMail = deliveryData.deliveryMail;
            recurringPayment.recurringPaymentData.deliveryData.deliveryName = deliveryData.deliveryName;
            recurringPayment.recurringPaymentData.deliveryData.deliveryNumber = deliveryData.deliveryNumber;
            recurringPayment.recurringPaymentData.deliveryData.deliveryState = deliveryData.deliveryState;
            recurringPayment.recurringPaymentData.deliveryData.deliveryStreet = deliveryData.deliveryStreet;
            recurringPayment.recurringPaymentData.deliveryData.deliveryZipCode = deliveryData.deliveryZipCode;

            if (deliveryData.phone != null)
            {
                recurringPayment.recurringPaymentData.deliveryData.phone = new PhoneData();
                recurringPayment.recurringPaymentData.deliveryData.phone.ddd = deliveryData.phone.ddd;
                recurringPayment.recurringPaymentData.deliveryData.phone.ddi = deliveryData.phone.ddi;
                recurringPayment.recurringPaymentData.deliveryData.phone.phone = deliveryData.phone.phone;
                recurringPayment.recurringPaymentData.deliveryData.phone.phoneType = deliveryData.phone.phoneType;
            }
        }

        public static void WithChargingData(RecurringPaymentChargingData chargingData)
        {
            recurringPayment.recurringPaymentData.chargingData = new RecurringPaymentChargingData();
            recurringPayment.recurringPaymentData.chargingData.birthday = chargingData.birthday;
            recurringPayment.recurringPaymentData.chargingData.buyerMail = chargingData.buyerMail;
            recurringPayment.recurringPaymentData.chargingData.buyerName = chargingData.buyerName;
            recurringPayment.recurringPaymentData.chargingData.clientAddressCity = chargingData.clientAddressCity;
            recurringPayment.recurringPaymentData.chargingData.clientAddressComplement = chargingData.clientAddressComplement;
            recurringPayment.recurringPaymentData.chargingData.clientAddressCountry = chargingData.clientAddressCountry;
            recurringPayment.recurringPaymentData.chargingData.clientAddressDistrict = chargingData.clientAddressDistrict;
            recurringPayment.recurringPaymentData.chargingData.clientAddressNumber = chargingData.clientAddressNumber;
            recurringPayment.recurringPaymentData.chargingData.clientAddressState = chargingData.clientAddressState;
            recurringPayment.recurringPaymentData.chargingData.clientAddressStreet = chargingData.clientAddressStreet;
            recurringPayment.recurringPaymentData.chargingData.clientAddressZipcode = chargingData.clientAddressZipcode;
            recurringPayment.recurringPaymentData.chargingData.clientCode = chargingData.clientCode;
            recurringPayment.recurringPaymentData.chargingData.clientSex = chargingData.clientSex;
            recurringPayment.recurringPaymentData.chargingData.clientType = chargingData.clientType;
            recurringPayment.recurringPaymentData.chargingData.document = chargingData.document;
            recurringPayment.recurringPaymentData.chargingData.documentTwo = chargingData.documentTwo;

            if (chargingData.phone != null)
            {
                recurringPayment.recurringPaymentData.chargingData.phone = new PhoneData();
                recurringPayment.recurringPaymentData.chargingData.phone.ddd = chargingData.phone.ddd;
                recurringPayment.recurringPaymentData.chargingData.phone.ddi = chargingData.phone.ddi;
                recurringPayment.recurringPaymentData.chargingData.phone.phone = chargingData.phone.phone;
                recurringPayment.recurringPaymentData.chargingData.phone.phoneType = chargingData.phone.phoneType;
            }

        }


    }
}