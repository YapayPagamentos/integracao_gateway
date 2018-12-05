using System;
using Newtonsoft.Json;

namespace YapayGatewayLib.Model
{
    public class RecurringPaymentChargingData
    {
        string buyerName { get; set; }
        string buyerMail { get; set; }
        int clientType { get; set; }
        string document { get; set; }
        string birthday { get; set; }
        int clientCode { get; set; }
        string clientSex { get; set; }
        string documentTwo { get; set; }
        string clientAddressStreet { get; set; }
        string clientAddressNumber { get; set; }
        string clientAddressDistrict { get; set; }
        string clientAddressComplement { get; set; }
        string clientAddressCity { get; set; }
        string clientAddressState { get; set; }
        string clientAddressZipcode { get; set; }
        string clientAddressCountry { get; set; }
        PhoneData phone { get; set; }
    }
}
