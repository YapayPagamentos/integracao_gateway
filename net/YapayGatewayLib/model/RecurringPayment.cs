using System;
using Newtonsoft.Json;

namespace YapayGatewayLib.Model
{
    public class RecurringPayment
    {
        RecurringPaymentData recurringPaymentData { get; set; }
        string storeCode { get; set; }

    }
}
