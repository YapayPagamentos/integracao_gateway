using System;
using Newtonsoft.Json;

namespace YapayGatewayLib.Model
{
    public class RecurringPayment
    {
        [JsonProperty(PropertyName = "recorrencia")]
        RecurringPaymentData recurringPaymentData { get; set; }

        [JsonProperty(PropertyName = "estabelecimento")]
        string storeCode { get; set; }

    }
}
