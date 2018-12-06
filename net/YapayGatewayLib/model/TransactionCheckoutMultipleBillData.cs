using System;
using Newtonsoft.Json;

namespace YapayGatewayLib.Model
{
    public class TransactionCheckoutMultipleBillData
    {
        [JsonProperty(PropertyName = "valor")]
        public long value { get; set; }

        [JsonProperty(PropertyName = "vencimento")]
        public string dueDate { get; set; }
    }
}
