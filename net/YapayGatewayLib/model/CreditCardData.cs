using System;
using Newtonsoft.Json;

namespace YapayGatewayLib.Model
{
    public class CreditCardData
    {
        [JsonProperty(PropertyName = "nomePortador")]
        string cardHolderName { get; set; }

        [JsonProperty(PropertyName = "numeroCartao")]
        string cardNumber { get; set; }

        [JsonProperty(PropertyName = "codigoSeguranca")]
        string cvv { get; set; }

        [JsonProperty(PropertyName = "dataValidade")]
        string expirationDate { get; set; }

        [JsonProperty(PropertyName = "codigoFormaPagamento")]
        int paymentCode { get; set; }

        [JsonProperty(PropertyName = "parcelas")]
        int installments { get; set; }

        [JsonProperty(PropertyName = "valor")]
        long value { get; set; }
    }
}
