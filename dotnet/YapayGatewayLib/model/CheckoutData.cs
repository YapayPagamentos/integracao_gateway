using System;
using System.Collections.Generic;
using Newtonsoft.Json;

namespace YapayGatewayLib.Model
{
    public class CheckoutData
    {
       [JsonProperty(PropertyName = "processar")]
       public int process { get; set; }

       [JsonProperty(PropertyName = "tipoPagamento")]
       public int paymentType { get; set; }

       [JsonProperty(PropertyName = "multiploCartao")]
       public int multipleCard { get; set; }

       [JsonProperty(PropertyName = "multiploBoleto")]
       public int multipleBill { get; set; }

       [JsonProperty(PropertyName = "boletos")]
       public List<TransactionCheckoutMultipleBillData> multipleBillData { get; set; }
    }
}
