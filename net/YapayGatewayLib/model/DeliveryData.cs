using System;
using System.Collections.Generic;
using Newtonsoft.Json;

namespace YapayGatewayLib.Model
{
    public class DeliveryData
    {
        [JsonProperty(PropertyName = "nome")]
        string name { get; set; }

        [JsonProperty(PropertyName = "email")]
        string mail { get; set; }

        [JsonProperty(PropertyName = "dataNascimento")]
        string birthday { get; set; }

        [JsonProperty(PropertyName = "sexo")]
        string sex { get; set; }

        [JsonProperty(PropertyName = "documento")]
        string document { get; set; }

        [JsonProperty(PropertyName = "documento2")]
        string documentTwo { get; set; }

        [JsonProperty(PropertyName = "endereco")]
        AddressData deliveryAddress { get; set; }

        [JsonProperty(PropertyName = "telefone")]
        List<PhoneData> deliveryPhone { get; set; }
    }
}
