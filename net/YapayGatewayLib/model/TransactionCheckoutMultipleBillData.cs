using System;
using Newtonsoft.Json;

namespace YapayGatewayLib.Model
{
    public class TransactionCheckoutMultipleBillData
    {
        [JsonProperty(PropertyName = "valor")]
        long value { get; set; }

        [JsonProperty(PropertyName = "vencimento")]
        string dueDate { get; set; }
    }
}
