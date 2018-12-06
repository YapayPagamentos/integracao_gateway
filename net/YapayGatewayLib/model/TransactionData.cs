using System;
using Newtonsoft.Json;

namespace YapayGatewayLib.Model
{
    public class TransactionData
    {
        [JsonProperty(PropertyName = "numeroTransacao")]
        public long transactionNumber { get; set; }

        [JsonProperty(PropertyName = "valor")]
        public long value { get; set; }

        [JsonProperty(PropertyName = "valorDesconto")]
        public long discountValue { get; set; }

        [JsonProperty(PropertyName = "taxaEmbarque")]
        public long boardingFee { get; set; }

        [JsonProperty(PropertyName = "parcelas")]
        public int installments { get; set; }

        [JsonProperty(PropertyName = "tipoParcelamento")]
        public string installmentType { get; set; }

        [JsonProperty(PropertyName = "urlCampainha")]
        public string hintUrl { get; set; }

        [JsonProperty(PropertyName = "urlResultado")]
        public string resultUrl { get; set; }

        [JsonProperty(PropertyName = "urlRedirecionamentoNaoPago")]
        public string unpaidRedirectUrl { get; set; }

        [JsonProperty(PropertyName = "idioma")]
        public int idiom { get; set; }

        [JsonProperty(PropertyName = "ip")]
        public string ip { get; set; }

        [JsonProperty(PropertyName = "browser")]
        public string browser { get; set; }

        [JsonProperty(PropertyName = "origemTransacao")]
        public int transactionOrigin { get; set; }

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

        [JsonProperty(PropertyName = "dataVencimentoBoleto")]
        public string billDueDate { get; set; }

        [JsonProperty(PropertyName = "pais")]
        public string country { get; set; }

        [JsonProperty(PropertyName = "moeda")]
        public string currency { get; set; }

        [JsonProperty(PropertyName = "pagamentoRecorrente")]
        public bool recurrentPayment { get; set; }
    }
}
