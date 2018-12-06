using System;
using Newtonsoft.Json;

namespace YapayGatewayLib.Model
{
    public class CreditCardData
    {
       [JsonProperty(PropertyName = "nomePortador")]
       public string cardHolderName { get; set; }

       [JsonProperty(PropertyName = "numeroCartao")]
       public string cardNumber { get; set; }

       [JsonProperty(PropertyName = "codigoSeguranca")]
       public string cvv { get; set; }

       [JsonProperty(PropertyName = "dataValidade")]
       public string expirationDate { get; set; }

       [JsonProperty(PropertyName = "codigoFormaPagamento")]
       public int paymentCode { get; set; }

       [JsonProperty(PropertyName = "parcelas")]
       public int installments { get; set; }

       [JsonProperty(PropertyName = "valor")]
       public long value { get; set; }
    }
}
