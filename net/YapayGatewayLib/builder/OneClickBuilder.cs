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

        }

        public static void WithCreditCard(string cardHoldername, string cardNumber, string cardExpiration)
        {

        }

        public static void ForEmail(string buyerEmail)
        {

        }
    }
}