using System;
using YapayGatewayLib.Model;

namespace YapayGatewayLib.Builder
{
    public class OneClickBuilder
    {

        private static OneClickRegisterData registerData;

        public static OneClickRegisterData build()
        {
            OneClickRegisterData newRegisterData = registerData;
            registerData = null;

            return newRegisterData;
        }


        public static void NewOneClickRegister(string storeCode, long paymentCode)
        {
            registerData = new OneClickRegisterData();
            registerData.storeCode = storeCode;
            registerData.paymentCode = paymentCode;
        }

        public static void WithCreditCard(string cardHoldername, string cardNumber, string cardExpiration)
        {
            registerData.cardHolderName = cardHoldername;
            registerData.cardNumber = cardNumber;
            registerData.expirationDate = cardExpiration;
        }

        public static void ForEmail(string buyerEmail)
        {
            registerData.buyerEmail = buyerEmail;
        }
    }
}