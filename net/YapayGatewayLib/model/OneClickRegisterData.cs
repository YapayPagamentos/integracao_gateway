using System;

namespace YapayGatewayLib.Model
{
    public class OneClickRegisterData
    {
	string storeCode{get;set;}
	string cardHolderName{get;set;}
	string cardNumber{get;set;}
	string expirationDate{get;set;}
	string buyerEmail{get;set;}
	long paymentCode{get;set;}
    }
}
