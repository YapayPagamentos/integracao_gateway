using System;
using Newtonsoft.Json;

namespace YapayGatewayLib.Model
{
    public class AirlineTripData
    {
        [JsonProperty(PropertyName = "pnr")]
        string pnr { get; set; }

        [JsonProperty(PropertyName = "titularCartaoEPassageiro")]
        bool cardholderIsPassenger { get; set; }

        [JsonProperty(PropertyName = "dataEmissaoPassagem")]
        string ticketIssueDate { get; set; }

        [JsonProperty(PropertyName = "codigoCompanhiaAerea")]
        string companyCode { get; set; }

        [JsonProperty(PropertyName = "aeroportoPartida")]
        string departureAirport { get; set; }

        [JsonProperty(PropertyName = "dataHoraPartida")]
        string departureDate { get; set; }

        [JsonProperty(PropertyName = "aeroportoChegada")]
        string arrivalAirport { get; set; }

        [JsonProperty(PropertyName = "dataHoraChegada")]
        string arrivalDate { get; set; }
    }
}
