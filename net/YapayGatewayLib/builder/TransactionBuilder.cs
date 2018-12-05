using System;
using System.Collections.Generic;
using YapayGatewayLib.Model;

namespace YapayGatewayLib.Builder
{
    public class TransactionBuilder
    {

        public static void NewTransaction(string storeCode, int paymentCode, long transactionNumber, long value)
        {

        }

        public static void WithInstallments(int installments)
        {

        }

        public static void WithSingleCreditCard(string cardHolderName, string cardNumber, string cvv, string expirationDate)
        {

        }

        public static void WithSingleDebitCard(string agency, string agencyDigit, string accountNumber, string accountNumberDigit, string accountType)
        {

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