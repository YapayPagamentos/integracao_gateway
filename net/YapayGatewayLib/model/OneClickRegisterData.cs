using System;
using Newtonsoft.Json;

namespace YapayGatewayLib.Model
{
    public class OneClickRegisterData
    {
        [JsonProperty(PropertyName = "codigoEstabelecimento")]
        string storeCode { get; set; }

        [JsonProperty(PropertyName = "nomeTitularCartaoCredito")]
        string cardHolderName { get; set; }

        [JsonProperty(PropertyName = "numeroCartaoCredito")]
        string cardNumber { get; set; }

        [JsonProperty(PropertyName = "dataValidadeCartao")]
        string expirationDate { get; set; }

        [JsonProperty(PropertyName = "emailComprador")]
        string buyerEmail { get; set; }

        [JsonProperty(PropertyName = "formaPagamento")]
        long paymentCode { get; set; }
    }
}
