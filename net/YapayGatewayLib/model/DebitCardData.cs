using System;
using Newtonsoft.Json;

namespace YapayGatewayLib.Model
{
    public class DebitCardData
    {
         [JsonProperty(PropertyName = "agencia")]
        string agency { get; set; }

         [JsonProperty(PropertyName = "agenciaDigito")]
        string agencyDigit { get; set; }

         [JsonProperty(PropertyName = "conta")]
        string accountNumber { get; set; }

         [JsonProperty(PropertyName = "contaDigito")]
        string accountNumberDigit { get; set; }

         [JsonProperty(PropertyName = "tipoConta")]
        string accountType { get; set; }
    }
}
