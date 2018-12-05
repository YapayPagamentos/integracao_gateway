using System;
using System.Collections.Generic;
using Newtonsoft.Json;

namespace YapayGatewayLib.Model
{
    public class CheckoutData
    {
        [JsonProperty(PropertyName = "processar")]
        int process { get; set; }

        [JsonProperty(PropertyName = "tipoPagamento")]
        int paymentType { get; set; }

        [JsonProperty(PropertyName = "multiploCartao")]
        int multipleCard { get; set; }

        [JsonProperty(PropertyName = "multiploBoleto")]
        int multipleBill { get; set; }

        [JsonProperty(PropertyName = "boletos")]
        List<TransactionCheckoutMultipleBillData> multipleBillData { get; set; }
    }
}
