using System;

namespace YapayGatewayLib.Model
{
    public class RecurringPaymentDeliveryData
    {
        string deliveryName { get; set; }
        string deliveryMail { get; set; }
        string deliveryStreet { get; set; }
        string deliveryNumber { get; set; }
        string deliveryDistrict { get; set; }
        string deliveryComplement { get; set; }
        string deliveryCity { get; set; }
        string deliveryState { get; set; }
        string deliveryZipCode { get; set; }
        string deliveryCountry { get; set; }
        PhoneData phone { get; set; }
    }
}
