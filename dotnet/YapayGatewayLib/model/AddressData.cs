using System;
using Newtonsoft.Json;

namespace YapayGatewayLib.Model
{
    public class AddressData
    {
        [JsonProperty(PropertyName = "logradouro")]
        public string street { get; set; }

        [JsonProperty(PropertyName = "numero")]
        public string number { get; set; }

        [JsonProperty(PropertyName = "complemento")]
        public string complement { get; set; }

        [JsonProperty(PropertyName = "cep")]
        public string zipCode { get; set; }

        [JsonProperty(PropertyName = "bairro")]
        public string district { get; set; }

        [JsonProperty(PropertyName = "cidade")]
        public string city { get; set; }

        [JsonProperty(PropertyName = "estado")]
        public string state { get; set; }

        [JsonProperty(PropertyName = "pais")]
        public string country { get; set; }
    }
}
