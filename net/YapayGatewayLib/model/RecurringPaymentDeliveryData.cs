using System;
using Newtonsoft.Json;

namespace YapayGatewayLib.Model
{
    public class RecurringPaymentDeliveryData
    {
        [JsonProperty(PropertyName = "nomeEntrega")]
        string deliveryName { get; set; }

        [JsonProperty(PropertyName = "emailEntrega")]
        string deliveryMail { get; set; }

        [JsonProperty(PropertyName = "enderecoEntrega")]
        string deliveryStreet { get; set; }

        [JsonProperty(PropertyName = "numeroEnderecoEntrega")]
        string deliveryNumber { get; set; }

        [JsonProperty(PropertyName = "bairroEntrega")]
        string deliveryDistrict { get; set; }

        [JsonProperty(PropertyName = "complementoEntrega")]
        string deliveryComplement { get; set; }

        [JsonProperty(PropertyName = "cidadeEntrega")]
        string deliveryCity { get; set; }

        [JsonProperty(PropertyName = "estadoEntrega")]
        string deliveryState { get; set; }

        [JsonProperty(PropertyName = "cepEntrega")]
        string deliveryZipCode { get; set; }

        [JsonProperty(PropertyName = "paisEntrega")]
        string deliveryCountry { get; set; }

        [JsonProperty(PropertyName = "telefone")]
        PhoneData phone { get; set; }
    }
}
