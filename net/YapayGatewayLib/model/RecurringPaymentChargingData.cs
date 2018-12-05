using System;
using Newtonsoft.Json;

namespace YapayGatewayLib.Model
{
    public class RecurringPaymentChargingData
    {
        [JsonProperty(PropertyName = "nomeComprador")]
        string buyerName { get; set; }

        [JsonProperty(PropertyName = "emailComprador")]
        string buyerMail { get; set; }

        [JsonProperty(PropertyName = "tipoCliente")]
        int clientType { get; set; }

        [JsonProperty(PropertyName = "documento")]
        string document { get; set; }

        [JsonProperty(PropertyName = "dataNascimento")]
        string birthday { get; set; }

        [JsonProperty(PropertyName = "codigoCliente")]
        int clientCode { get; set; }

        [JsonProperty(PropertyName = "sexo")]
        string clientSex { get; set; }

        [JsonProperty(PropertyName = "documento2")]
        string documentTwo { get; set; }

        [JsonProperty(PropertyName = "enderecoComprador")]
        string clientAddressStreet { get; set; }

        [JsonProperty(PropertyName = "numeroEnderecoComprador")]
        string clientAddressNumber { get; set; }

        [JsonProperty(PropertyName = "bairroComprador")]
        string clientAddressDistrict { get; set; }

        [JsonProperty(PropertyName = "complementoComprador")]
        string clientAddressComplement { get; set; }

        [JsonProperty(PropertyName = "cidadeComprador")]
        string clientAddressCity { get; set; }

        [JsonProperty(PropertyName = "estadoComprador")]
        string clientAddressState { get; set; }

        [JsonProperty(PropertyName = "cepComprador")]
        string clientAddressZipcode { get; set; }

        [JsonProperty(PropertyName = "paisComprador")]
        string clientAddressCountry { get; set; }

        [JsonProperty(PropertyName = "telefone")]
        PhoneData phone { get; set; }
    }
}
