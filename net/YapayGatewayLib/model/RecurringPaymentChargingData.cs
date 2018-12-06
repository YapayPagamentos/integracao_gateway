using System;
using Newtonsoft.Json;

namespace YapayGatewayLib.Model
{
    public class RecurringPaymentChargingData
    {
       [JsonProperty(PropertyName = "nomeComprador")]
       public string buyerName { get; set; }

       [JsonProperty(PropertyName = "emailComprador")]
       public string buyerMail { get; set; }

       [JsonProperty(PropertyName = "tipoCliente")]
       public int clientType { get; set; }

       [JsonProperty(PropertyName = "documento")]
       public string document { get; set; }

       [JsonProperty(PropertyName = "dataNascimento")]
       public string birthday { get; set; }

       [JsonProperty(PropertyName = "codigoCliente")]
       public int clientCode { get; set; }

       [JsonProperty(PropertyName = "sexo")]
       public string clientSex { get; set; }

       [JsonProperty(PropertyName = "documento2")]
       public string documentTwo { get; set; }

       [JsonProperty(PropertyName = "enderecoComprador")]
       public string clientAddressStreet { get; set; }

       [JsonProperty(PropertyName = "numeroEnderecoComprador")]
       public string clientAddressNumber { get; set; }

       [JsonProperty(PropertyName = "bairroComprador")]
       public string clientAddressDistrict { get; set; }

       [JsonProperty(PropertyName = "complementoComprador")]
       public string clientAddressComplement { get; set; }

       [JsonProperty(PropertyName = "cidadeComprador")]
       public string clientAddressCity { get; set; }

       [JsonProperty(PropertyName = "estadoComprador")]
       public string clientAddressState { get; set; }

       [JsonProperty(PropertyName = "cepComprador")]
       public string clientAddressZipcode { get; set; }

       [JsonProperty(PropertyName = "paisComprador")]
       public string clientAddressCountry { get; set; }

       [JsonProperty(PropertyName = "telefone")]
       public PhoneData phone { get; set; }
    }
}
