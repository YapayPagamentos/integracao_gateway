using System;
using System.Collections.Generic;
using Newtonsoft.Json;

namespace YapayGatewayLib.Model
{
    public class ChargingData
    {
       [JsonProperty(PropertyName = "codigoCliente")]
       public int clientCode { get; set; }

       [JsonProperty(PropertyName = "tipoCliente")]
       public int clientType { get; set; }

       [JsonProperty(PropertyName = "nome")]
       public string clientName { get; set; }

       [JsonProperty(PropertyName = "email")]
       public string clientEmail { get; set; }

       [JsonProperty(PropertyName = "dataNascimento")]
       public string clientBirthday { get; set; }

       [JsonProperty(PropertyName = "sexo")]
       public string clientSex { get; set; }

       [JsonProperty(PropertyName = "documento")]
       public string clientDocument { get; set; }

       [JsonProperty(PropertyName = "documento2")]
       public string clientDocumentTwo { get; set; }

       [JsonProperty(PropertyName = "endereco")]
       public AddressData clientChargingAdress { get; set; }

       [JsonProperty(PropertyName = "telefone")]
       public List<PhoneData> clientChargingPhone { get; set; }
    }
}
