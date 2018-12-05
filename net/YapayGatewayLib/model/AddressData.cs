using System;
using Newtonsoft.Json;

namespace YapayGatewayLib.Model
{
    public class AddressData
    {
        [JsonProperty(PropertyName = "logradouro")]
        string street { get; set; }

        [JsonProperty(PropertyName = "numero")]
        string number { get; set; }

        [JsonProperty(PropertyName = "complemento")]
        string complement { get; set; }

        [JsonProperty(PropertyName = "cep")]
        string zipCode { get; set; }

        [JsonProperty(PropertyName = "bairro")]
        string district { get; set; }

        [JsonProperty(PropertyName = "cidade")]
        string city { get; set; }

        [JsonProperty(PropertyName = "estado")]
        string state { get; set; }

        [JsonProperty(PropertyName = "pais")]
        string country { get; set; }
    }
}
