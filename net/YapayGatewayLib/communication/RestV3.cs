using System;
using YapayGatewayLib.Model;
using System.Net.Http;
using System.Text;
using Newtonsoft.Json;

namespace YapayGatewayLib.Communication
{
    public class RestV3
    {

        public RestV3(string url)
        {
            this.url = url;
        }

        private string url;

        public string TransactionAuthorize(Credential credential, Transaction transaction)
        {

            var content = new StringContent(JsonConvert.SerializeObject(transaction), Encoding.UTF8, "application/json");

            var result = CreateHttpClient(credential).PostAsync(this.url + "/api/v3/transacao", content).Result;

            return result.Content.ReadAsStringAsync().Result;
        }

        public string TransactionQuery(Credential credential, string storeCode, long transactionNumber)
        {

            var result = CreateHttpClient(credential).GetAsync(this.url + "/api/v3/transacao/" + storeCode + "/" + transactionNumber).Result;

            return result.Content.ReadAsStringAsync().Result;
        }

        public string TransactionCapture(Credential credential, string storeCode, long transactionNumber, long value)
        {

            var result = CreateHttpClient(credential).PutAsync(this.url + "/api/v3/transacao/" + storeCode + "/" + transactionNumber, null).Result;


            return result.Content.ReadAsStringAsync().Result;
        }

        public string TransactionCancel(Credential credential, string storeCode, long transactionNumber, long value)
        {

            var result = CreateHttpClient(credential).PutAsync(this.url + "/api/v3/transacao/" + storeCode + "/" + transactionNumber, null).Result;

            return result.Content.ReadAsStringAsync().Result;
        }

        public string OneClickRegister(Credential credential, OneClickRegisterData registerData)
        {
            var content = new StringContent(JsonConvert.SerializeObject(registerData), Encoding.UTF8, "application/json");

            var result = CreateHttpClient(credential).PostAsync(this.url + "/api/v3/oneclick", content).Result;

            return result.Content.ReadAsStringAsync().Result;
        }

        public string OneClickQuery(Credential credential, string token)
        {
            var result = CreateHttpClient(credential).GetAsync(this.url + "/api/v3/oneclick/" + token).Result;

            return result.Content.ReadAsStringAsync().Result;
        }

        public string OneClickRegisterUpdate(Credential credential, string token, OneClickRegisterData registerData)
        {
            var content = new StringContent(JsonConvert.SerializeObject(registerData), Encoding.UTF8, "application/json");
            var result = CreateHttpClient(credential).PutAsync(this.url + "/api/v3/oneclick/" + token + "/alterar", content).Result;

            return result.Content.ReadAsStringAsync().Result;
        }

        public string OneClickAuthorize(Credential credential, string token, Transaction transaction)
        {
            var content = new StringContent(JsonConvert.SerializeObject(transaction), Encoding.UTF8, "application/json");

            var result = CreateHttpClient(credential).PostAsync(this.url + "/api/v3/oneclick/" + token + "/autorizar", content).Result;

            return result.Content.ReadAsStringAsync().Result;
        }

        public string RecurringPaymentRegister(Credential credential, RecurringPayment recurringPayment)
        {
            var content = new StringContent(JsonConvert.SerializeObject(recurringPayment), Encoding.UTF8, "application/json");

            var result = CreateHttpClient(credential).PostAsync(this.url + "/api/v3/recorrencia", content).Result;

            return result.Content.ReadAsStringAsync().Result;
        }

        public string RecurringPaymentQuery(Credential credential, string storeCode, long recurringPaymentNumber)
        {
            var result = CreateHttpClient(credential).GetAsync(this.url + "/api/v3/recorrencia/" + storeCode + "/" + recurringPaymentNumber).Result;

            return result.Content.ReadAsStringAsync().Result;
        }

        public string RecurringPaymentCancel(Credential credential, string storeCode, long recurringPaymentNumber)
        {

            var result = CreateHttpClient(credential).PutAsync(this.url + "/api/v3/recorrencia/" + storeCode + "/" + recurringPaymentNumber + "/cancelar", null).Result;

            return result.Content.ReadAsStringAsync().Result;
        }

        private HttpClient CreateHttpClient(Credential credential)
        {
            var byteArray = Encoding.ASCII.GetBytes(credential.user + ":" + credential.password);
            HttpClient client = new HttpClient();
            client.DefaultRequestHeaders.Authorization = new System.Net.Http.Headers.AuthenticationHeaderValue("Basic", Convert.ToBase64String(byteArray));
            return client;
        }
    }
}