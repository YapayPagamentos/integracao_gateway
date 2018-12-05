using System;
using System.Collections.Generic;

namespace YapayGatewayLib.Model
{
    public class DeliveryData
    {
        string name { get; set; }
        string mail { get; set; }
        string birthday { get; set; }
        string sex { get; set; }
        string document { get; set; }
        string documentTwo { get; set; }
        AddressData deliveryAddress { get; set; }
        List<PhoneData> deliveryPhone { get; set; }
    }
}
