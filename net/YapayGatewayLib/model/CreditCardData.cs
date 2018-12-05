using System;
using Newtonsoft.Json;

namespace YapayGatewayLib.Model
{
    public class CreditCardData
    {
        string cardHolderName { get; set; }
        string cardNumber { get; set; }
        string cvv { get; set; }
        string expirationDate { get; set; }
        int paymentCode { get; set; }
        int installments { get; set; }
        long value { get; set; }
    }
}
