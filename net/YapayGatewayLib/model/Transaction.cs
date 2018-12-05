using System;
using System.Collections.Generic;
using Newtonsoft.Json;

namespace YapayGatewayLib.Model
{
    public class Transaction
    {
        string storeCode { get; set; }
        int paymentCode { get; set; }
        TransactionData transactionData { get; set; }
        CheckoutData checkout { get; set; }
        CreditCardData creditCard { get; set; }
        List<CreditCardData> multipleCard { get; set; }
        DebitCardData debitCard { get; set; }
        List<ItemData> items { get; set; }
        ChargingData charging { get; set; }
        DeliveryData delivery { get; set; }
        AirlineData airline { get; set; }
        List<ExtraField> extraFields { get; set; }
    }
}
