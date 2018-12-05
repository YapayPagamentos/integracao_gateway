using System;
using System.Collections.Generic;
using Newtonsoft.Json;

namespace YapayGatewayLib.Model
{
    public class AirlineData
    {
        [JsonProperty(PropertyName = "dadosViagem")]
        AirlineTripData tripData { get; set; }

        [JsonProperty(PropertyName = "dadosPassageiros")]
        List<PassengerData> passengerData { get; set; }

        [JsonProperty(PropertyName = "dadosEscalas")]
        List<FlightRangeData> flightRange { get; set; }
    }
}
