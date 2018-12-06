using System;
using System.Collections.Generic;
using YapayGatewayLib.Model;

namespace YapayGatewayLib.Builder
{
    public class TransactionBuilder
    {

        private static Transaction transaction;

        public static Transaction build()
        {

            Transaction newTransaction = transaction;
            transaction = null;
            return transaction;
        }


        public static void NewTransaction(string storeCode, int paymentCode, long transactionNumber, long value)
        {
            transaction = new Transaction();
            transaction.transactionData = new TransactionData();
            transaction.storeCode = storeCode;
            transaction.paymentCode = paymentCode;
            transaction.transactionData.transactionNumber = transactionNumber;
            transaction.transactionData.value = value;
        }

        public static void WithInstallments(int installments)
        {
            transaction.transactionData.installments = installments;
        }

        public static void WithSingleCreditCard(string cardHolderName, string cardNumber, string cvv, string expirationDate)
        {
            transaction.creditCard = new CreditCardData();
            transaction.creditCard.cardHolderName = cardHolderName;
            transaction.creditCard.cardNumber = cardNumber;
            transaction.creditCard.cvv = cvv;
            transaction.creditCard.expirationDate = expirationDate;
        }

        public static void WithSingleDebitCard(string agency, string agencyDigit, string accountNumber, string accountNumberDigit, string accountType)
        {
            transaction.debitCard = new DebitCardData();
            transaction.debitCard.agency = agency;
            transaction.debitCard.agencyDigit = agencyDigit;
            transaction.debitCard.accountNumber = accountNumber;
            transaction.debitCard.accountNumberDigit = accountNumberDigit;
            transaction.debitCard.accountType = accountType;
        }

        public static void WithItems(List<ItemData> listOfItems)
        {

        }

        public static void WithExtraFields(List<ExtraField> listOfExtraFields)
        {

        }

        public static void WithDelivery(DeliveryData deliveryData)
        {

        }

        public static void WithCharging(ChargingData chargingData)
        {

        }

    }
}