using System;
using Newtonsoft.Json;

namespace YapayGatewayLib.Model
{
    public class TransactionCheckoutMultipleBillData
    {
        long value { get; set; }
        string dueDate { get; set; }
    }
}
