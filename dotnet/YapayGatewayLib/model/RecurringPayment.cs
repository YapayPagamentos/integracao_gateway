using System;
using Newtonsoft.Json;

namespace YapayGatewayLib.Model
{
    public class RecurringPayment
    {
        [JsonProperty(PropertyName = "recorrencia")]
        public RecurringPaymentData recurringPaymentData { get; set; }

        [JsonProperty(PropertyName = "estabelecimento")]
        public string storeCode { get; set; }

    }
}
