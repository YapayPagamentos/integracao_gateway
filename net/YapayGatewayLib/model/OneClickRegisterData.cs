using System;
using Newtonsoft.Json;

namespace YapayGatewayLib.Model
{
    public class OneClickRegisterData
    {
       [JsonProperty(PropertyName = "codigoEstabelecimento")]
       public string storeCode { get; set; }

       [JsonProperty(PropertyName = "nomeTitularCartaoCredito")]
       public string cardHolderName { get; set; }

       [JsonProperty(PropertyName = "numeroCartaoCredito")]
       public string cardNumber { get; set; }

       [JsonProperty(PropertyName = "dataValidadeCartao")]
       public string expirationDate { get; set; }

       [JsonProperty(PropertyName = "emailComprador")]
       public string buyerEmail { get; set; }

       [JsonProperty(PropertyName = "formaPagamento")]
       public long paymentCode { get; set; }
    }
}
