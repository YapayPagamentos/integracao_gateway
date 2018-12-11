using System;
using Newtonsoft.Json;

namespace YapayGatewayLib.Model
{
    public class FlightRangeData
    {
       [JsonProperty(PropertyName = "classeDoServico")]
       public string serviceClass { get; set; }

       [JsonProperty(PropertyName = "dataDaViagem")]
       public string tripDate { get; set; }

       [JsonProperty(PropertyName = "codigoCompanhiaAerea")]
       public string companyCode { get; set; }

       [JsonProperty(PropertyName = "escalaPermitida")]
       public bool permitFlight { get; set; }

       [JsonProperty(PropertyName = "aeroportoPartida")]
       public string departureAirport { get; set; }

       [JsonProperty(PropertyName = "dataHoraPartida")]
       public string departureDate { get; set; }

       [JsonProperty(PropertyName = "aeroportoChegada")]
       public string arrivalAirport { get; set; }

       [JsonProperty(PropertyName = "dataHoraChegada")]
       public string arrivalDate { get; set; }

       [JsonProperty(PropertyName = "numeroVoo")]
       public string flyNumber { get; set; }

       [JsonProperty(PropertyName = "classeTarifaria")]
       public string rateClass { get; set; }
    }
}
