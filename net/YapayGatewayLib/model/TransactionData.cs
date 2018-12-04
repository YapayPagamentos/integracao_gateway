using System;

namespace YapayGatewayLib.Model
{
    public class TransactionData
    { 
	 long transactionNumber{get; set;}
	 long value{get; set;}
	 long discountValue{get; set;}
	 long boardingFee{get; set;}
	 int installments{get; set;}
	 string installmentType{get; set;}
	 string hintUrl{get; set;}
	 string resultUrl{get; set;}
	 string unpaidRedirectUrl{get; set;}
	 int idiom{get; set;}
	 string ip{get; set;}
	 string browser{get; set;}
	 int transactionOrigin{get; set;}
	 string freeFieldOne{get; set;}
	 string freeFieldTwo{get; set;}
	 string freeFieldThree{get; set;}
	 string freeFieldFour{get; set;}
	 string freeFieldFive{get; set;}
	 string billDueDate{get; set;}
	 string country{get; set;}
	 string currency{get; set;}
     bool recurrentPayment{get; set;}
    }
}
