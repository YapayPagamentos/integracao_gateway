using System;
using Newtonsoft.Json;

namespace YapayGatewayLib.Model
{
    public class PhoneData
    {
      [JsonProperty(PropertyName = "ddi")]
      public string ddi { get; set; }

      [JsonProperty(PropertyName = "ddd")]
      public string ddd { get; set; }

      [JsonProperty(PropertyName = "telefone")]
      public string phone { get; set; }

      [JsonProperty(PropertyName = "tipoTelefone")]
      public int phoneType { get; set; }
    }
}
