using System;
using Newtonsoft.Json;

namespace YapayGatewayLib.Model
{
    public class TransactionData
    {
        [JsonProperty(PropertyName = "numeroTransacao")]
        long transactionNumber { get; set; }

        [JsonProperty(PropertyName = "valor")]
        long value { get; set; }

        [JsonProperty(PropertyName = "valorDesconto")]
        long discountValue { get; set; }

        [JsonProperty(PropertyName = "taxaEmbarque")]
        long boardingFee { get; set; }

        [JsonProperty(PropertyName = "parcelas")]
        int installments { get; set; }

        [JsonProperty(PropertyName = "tipoParcelamento")]
        string installmentType { get; set; }

        [JsonProperty(PropertyName = "urlCampainha")]
        string hintUrl { get; set; }

        [JsonProperty(PropertyName = "urlResultado")]
        string resultUrl { get; set; }

        [JsonProperty(PropertyName = "urlRedirecionamentoNaoPago")]
        string unpaidRedirectUrl { get; set; }

        [JsonProperty(PropertyName = "idioma")]
        int idiom { get; set; }

        [JsonProperty(PropertyName = "ip")]
        string ip { get; set; }

        [JsonProperty(PropertyName = "browser")]
        string browser { get; set; }

        [JsonProperty(PropertyName = "origemTransacao")]
        int transactionOrigin { get; set; }

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

        [JsonProperty(PropertyName = "dataVencimentoBoleto")]
        string billDueDate { get; set; }

        [JsonProperty(PropertyName = "pais")]
        string country { get; set; }

        [JsonProperty(PropertyName = "moeda")]
        string currency { get; set; }

        [JsonProperty(PropertyName = "pagamentoRecorrente")]
        bool recurrentPayment { get; set; }
    }
}
