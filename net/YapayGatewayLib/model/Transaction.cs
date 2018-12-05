using System;
using System.Collections.Generic;
using Newtonsoft.Json;

namespace YapayGatewayLib.Model
{
    public class Transaction
    {
        [JsonProperty(PropertyName = "codigoEstabelecimento")]
        string storeCode { get; set; }

        [JsonProperty(PropertyName = "codigoFormaPagamento")]
        int paymentCode { get; set; }

        [JsonProperty(PropertyName = "transacao")]
        TransactionData transactionData { get; set; }

        [JsonProperty(PropertyName = "checkout")]
        CheckoutData checkout { get; set; }

        [JsonProperty(PropertyName = "dadosCartao")]
        CreditCardData creditCard { get; set; }

        [JsonProperty(PropertyName = "dadosMultiplosCartoes")]
        List<CreditCardData> multipleCard { get; set; }

        [JsonProperty(PropertyName = "dadosDebito")]
        DebitCardData debitCard { get; set; }

        [JsonProperty(PropertyName = "itensDoPedido")]
        List<ItemData> items { get; set; }

        [JsonProperty(PropertyName = "dadosCobranca")]
        ChargingData charging { get; set; }

        [JsonProperty(PropertyName = "dadosEntrega")]
        DeliveryData delivery { get; set; }

        [JsonProperty(PropertyName = "dadosAirline")]
        AirlineData airline { get; set; }

        [JsonProperty(PropertyName = "camposExtras")]
        List<ExtraField> extraFields { get; set; }
    }
}
