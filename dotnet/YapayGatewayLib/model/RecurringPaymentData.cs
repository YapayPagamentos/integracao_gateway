using System;
using Newtonsoft.Json;

namespace YapayGatewayLib.Model
{
    public class RecurringPaymentData
    {
       [JsonProperty(PropertyName = "formaPagamento")]
       public long paymentCode { get; set; }

       [JsonProperty(PropertyName = "numeroRecorrencia")]
       public long recurringPaymentNumber { get; set; }

       [JsonProperty(PropertyName = "valor")]
       public long value { get; set; }

       [JsonProperty(PropertyName = "modalidade")]
       public int modality { get; set; }

       [JsonProperty(PropertyName = "periodicidade")]
       public int frequency { get; set; }

       [JsonProperty(PropertyName = "urlNotificacao")]
       public string notificationUrl { get; set; }

       [JsonProperty(PropertyName = "processarImediatamente")]
       public bool processImmediately { get; set; }

       [JsonProperty(PropertyName = "quantidadeCobrancas")]
       public int billingAmount { get; set; }

       [JsonProperty(PropertyName = "dataPrimeiraCobranca")]
       public string billingFirstDate { get; set; }

       [JsonProperty(PropertyName = "vencimentoBoleto")]
       public string billDueDate { get; set; }

       [JsonProperty(PropertyName = "campoLivre1")]
       public string freeFieldOne { get; set; }

       [JsonProperty(PropertyName = "campoLivre2")]
       public string freeFieldTwo { get; set; }

       [JsonProperty(PropertyName = "campoLivre3")]
       public string freeFieldThree { get; set; }

       [JsonProperty(PropertyName = "campoLivre4")]
       public string freeFieldFour { get; set; }

       [JsonProperty(PropertyName = "campoLivre5")]
       public string freeFieldFive { get; set; }

       [JsonProperty(PropertyName = "dadosCartao")]
       public CardData card { get; set; }

       [JsonProperty(PropertyName = "dadosCobranca")]
       public RecurringPaymentChargingData chargingData { get; set; }

       [JsonProperty(PropertyName = "dadosEntrega")]
       public RecurringPaymentDeliveryData deliveryData { get; set; }
    }
}
