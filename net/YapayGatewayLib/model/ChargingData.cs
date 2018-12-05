using System;
using System.Collections.Generic;

namespace YapayGatewayLib.Model
{
    public class ChargingData
    {
        int clientCode { get; set; }
        int clientType { get; set; }
        string clientName { get; set; }
        string clientEmail { get; set; }
        string clientBirthday { get; set; }
        string clientSex { get; set; }
        string clientDocument { get; set; }
        string clientDocumentTwo { get; set; }
        AddressData clientChargingAdress { get; set; }
        List<PhoneData> clientChargingPhone { get; set; }
    }
}
