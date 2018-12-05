using System;
using Newtonsoft.Json;

namespace YapayGatewayLib.Model
{
    public class RecurringPaymentData
    {
        [JsonProperty(PropertyName = "formaPagamento")]
        long paymentCode { get; set; }

        [JsonProperty(PropertyName = "numeroRecorrencia")]
        long recurringPaymentNumber { get; set; }

        [JsonProperty(PropertyName = "valor")]
        long value { get; set; }

        [JsonProperty(PropertyName = "modalidade")]
        int modality { get; set; }

        [JsonProperty(PropertyName = "periodicidade")]
        int frequency { get; set; }

        [JsonProperty(PropertyName = "urlNotificacao")]
        string notificationUrl { get; set; }

        [JsonProperty(PropertyName = "processarImediatamente")]
        bool processImmediately { get; set; }

        [JsonProperty(PropertyName = "quantidadeCobrancas")]
        int billingAmount { get; set; }

        [JsonProperty(PropertyName = "dataPrimeiraCobranca")]
        string billingFirstDate { get; set; }

        [JsonProperty(PropertyName = "vencimentoBoleto")]
        string billDueDate { get; set; }

        [JsonProperty(PropertyName = "campoLivre1")]
        string freeFieldOne { get; set; }

        [JsonProperty(PropertyName = "campoLivre2")]
        string freeFieldTwo { get; set; }

        [JsonProperty(PropertyName = "campoLivre3")]
        string freeFieldThree { get; set; }

        [JsonProperty(PropertyName = "campoLivre4")]
        string freeFieldFour { get; set; }

        [JsonProperty(PropertyName = "campoLivre5")]
        string freeFieldFive { get; set; }

        [JsonProperty(PropertyName = "dadosCartao")]
        CreditCardData creditCard { get; set; }

        [JsonProperty(PropertyName = "dadosDebito")]
        DebitCardData debitCard { get; set; }

        [JsonProperty(PropertyName = "dadosCobranca")]
        RecurringPaymentChargingData chargingData { get; set; }

        [JsonProperty(PropertyName = "dadosEntrega")]
        RecurringPaymentDeliveryData deliveryData { get; set; }
    }
}
