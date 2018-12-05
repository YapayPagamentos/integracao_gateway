using System;
using Newtonsoft.Json;

namespace YapayGatewayLib.Model
{
    public class FlightRangeData
    {
        [JsonProperty(PropertyName = "classeDoServico")]
        string serviceClass { get; set; }

        [JsonProperty(PropertyName = "dataDaViagem")]
        string tripDate { get; set; }

        [JsonProperty(PropertyName = "codigoCompanhiaAerea")]
        string companyCode { get; set; }

        [JsonProperty(PropertyName = "escalaPermitida")]
        bool permitFlight { get; set; }

        [JsonProperty(PropertyName = "aeroportoPartida")]
        string departureAirport { get; set; }

        [JsonProperty(PropertyName = "dataHoraPartida")]
        string departureDate { get; set; }

        [JsonProperty(PropertyName = "aeroportoChegada")]
        string arrivalAirport { get; set; }

        [JsonProperty(PropertyName = "dataHoraChegada")]
        string arrivalDate { get; set; }

        [JsonProperty(PropertyName = "numeroVoo")]
        string flyNumber { get; set; }

        [JsonProperty(PropertyName = "classeTarifaria")]
        string rateClass { get; set; }
    }
}
