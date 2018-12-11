using System;
using Newtonsoft.Json;

namespace YapayGatewayLib.Model
{
    public class RecurringPaymentDeliveryData
    {
        [JsonProperty(PropertyName = "nomeEntrega")]
        public string deliveryName { get; set; }

        [JsonProperty(PropertyName = "emailEntrega")]
        public string deliveryMail { get; set; }

        [JsonProperty(PropertyName = "enderecoEntrega")]
        public string deliveryStreet { get; set; }

        [JsonProperty(PropertyName = "numeroEnderecoEntrega")]
        public string deliveryNumber { get; set; }

        [JsonProperty(PropertyName = "bairroEntrega")]
        public string deliveryDistrict { get; set; }

        [JsonProperty(PropertyName = "complementoEntrega")]
        public string deliveryComplement { get; set; }

        [JsonProperty(PropertyName = "cidadeEntrega")]
        public string deliveryCity { get; set; }

        [JsonProperty(PropertyName = "estadoEntrega")]
        public string deliveryState { get; set; }

        [JsonProperty(PropertyName = "cepEntrega")]
        public string deliveryZipCode { get; set; }

        [JsonProperty(PropertyName = "paisEntrega")]
        public string deliveryCountry { get; set; }

        [JsonProperty(PropertyName = "telefone")]
        public PhoneData phone { get; set; }
    }
}
