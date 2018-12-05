using System;

namespace YapayGatewayLib.Model
{
    public class DebitCardData
    {
        string agency { get; set; }
        string agencyDigit { get; set; }
        string accountNumber { get; set; }
        string accountNumberDigit { get; set; }
        string accountType { get; set; }
    }
}
