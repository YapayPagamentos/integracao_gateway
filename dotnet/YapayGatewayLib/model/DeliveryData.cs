using System;
using System.Collections.Generic;
using Newtonsoft.Json;

namespace YapayGatewayLib.Model
{
    public class DeliveryData
    {
      [JsonProperty(PropertyName = "nome")]
      public string name { get; set; }

      [JsonProperty(PropertyName = "email")]
      public string mail { get; set; }

      [JsonProperty(PropertyName = "dataNascimento")]
      public string birthday { get; set; }

      [JsonProperty(PropertyName = "sexo")]
      public string sex { get; set; }

      [JsonProperty(PropertyName = "documento")]
      public string document { get; set; }

      [JsonProperty(PropertyName = "documento2")]
      public string documentTwo { get; set; }

      [JsonProperty(PropertyName = "endereco")]
      public AddressData deliveryAddress { get; set; }

      [JsonProperty(PropertyName = "telefone")]
      public List<PhoneData> deliveryPhone { get; set; }
    }
}
