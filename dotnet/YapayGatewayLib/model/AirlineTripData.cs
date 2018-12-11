using System;
using Newtonsoft.Json;

namespace YapayGatewayLib.Model
{
    public class AirlineTripData
    {
       [JsonProperty(PropertyName = "pnr")]
       public string pnr { get; set; }

       [JsonProperty(PropertyName = "titularCartaoEPassageiro")]
       public bool cardholderIsPassenger { get; set; }

       [JsonProperty(PropertyName = "dataEmissaoPassagem")]
       public string ticketIssueDate { get; set; }

       [JsonProperty(PropertyName = "codigoCompanhiaAerea")]
       public string companyCode { get; set; }

       [JsonProperty(PropertyName = "aeroportoPartida")]
       public string departureAirport { get; set; }

       [JsonProperty(PropertyName = "dataHoraPartida")]
       public string departureDate { get; set; }

       [JsonProperty(PropertyName = "aeroportoChegada")]
       public string arrivalAirport { get; set; }

       [JsonProperty(PropertyName = "dataHoraChegada")]
       public string arrivalDate { get; set; }
    }
}
