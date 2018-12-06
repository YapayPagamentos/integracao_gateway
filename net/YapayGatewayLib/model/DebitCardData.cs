using System;
using Newtonsoft.Json;

namespace YapayGatewayLib.Model
{
    public class DebitCardData
    {
        [JsonProperty(PropertyName = "agencia")]
        public string agency { get; set; }

        [JsonProperty(PropertyName = "agenciaDigito")]
        public string agencyDigit { get; set; }

        [JsonProperty(PropertyName = "conta")]
        public string accountNumber { get; set; }

        [JsonProperty(PropertyName = "contaDigito")]
        public string accountNumberDigit { get; set; }

        [JsonProperty(PropertyName = "tipoConta")]
        public string accountType { get; set; }
    }
}
