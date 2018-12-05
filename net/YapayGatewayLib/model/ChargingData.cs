using System;
using System.Collections.Generic;
using Newtonsoft.Json;

namespace YapayGatewayLib.Model
{
    public class ChargingData
    {
        [JsonProperty(PropertyName = "codigoCliente")]
        int clientCode { get; set; }

        [JsonProperty(PropertyName = "tipoCliente")]
        int clientType { get; set; }

        [JsonProperty(PropertyName = "nome")]
        string clientName { get; set; }

        [JsonProperty(PropertyName = "email")]
        string clientEmail { get; set; }

        [JsonProperty(PropertyName = "dataNascimento")]
        string clientBirthday { get; set; }

        [JsonProperty(PropertyName = "sexo")]
        string clientSex { get; set; }

        [JsonProperty(PropertyName = "documento")]
        string clientDocument { get; set; }

        [JsonProperty(PropertyName = "documento2")]
        string clientDocumentTwo { get; set; }

        [JsonProperty(PropertyName = "endereco")]
        AddressData clientChargingAdress { get; set; }

        [JsonProperty(PropertyName = "telefone")]
        List<PhoneData> clientChargingPhone { get; set; }
    }
}
