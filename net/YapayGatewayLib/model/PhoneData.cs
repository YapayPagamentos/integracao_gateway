using System;
using Newtonsoft.Json;

namespace YapayGatewayLib.Model
{
    public class PhoneData
    {
        [JsonProperty(PropertyName = "ddi")]
        string ddi { get; set; }

        [JsonProperty(PropertyName = "ddd")]
        string ddd { get; set; }

        [JsonProperty(PropertyName = "telefone")]
        string phone { get; set; }

        [JsonProperty(PropertyName = "tipoTelefone")]
        int phoneType { get; set; }
    }
}
