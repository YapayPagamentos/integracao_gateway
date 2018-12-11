using System;
using Newtonsoft.Json;

namespace YapayGatewayLib.Model
{
    public class ExtraField
    {
      [JsonProperty(PropertyName = "chave")]
      public int key{get; set;}

      [JsonProperty(PropertyName = "valor")]
      public string value{get; set;}
    }
}
