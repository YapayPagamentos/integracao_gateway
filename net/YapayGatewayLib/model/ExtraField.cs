using System;
using Newtonsoft.Json;

namespace YapayGatewayLib.Model
{
    public class ExtraField
    {
        [JsonProperty(PropertyName = "chave")]
        int key{get; set;}

        [JsonProperty(PropertyName = "valor")]
        string value{get; set;}
    }
}
