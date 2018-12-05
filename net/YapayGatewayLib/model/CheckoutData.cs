using System;
using System.Collections.Generic;

namespace YapayGatewayLib.Model
{
    public class CheckoutData
    {
        int process { get; set; }
        int paymentType { get; set; }
        int multipleCard { get; set; }
        int multipleBill { get; set; }
        List<TransactionCheckoutMultipleBillData> multipleBillData { get; set; }
    }
}
