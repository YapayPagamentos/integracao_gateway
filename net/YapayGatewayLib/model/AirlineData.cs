using System;
using System.Collections.Generic;
using Newtonsoft.Json;

namespace YapayGatewayLib.Model
{
    public class AirlineData
    {
      [JsonProperty(PropertyName = "dadosViagem")]
      public AirlineTripData tripData { get; set; }

      [JsonProperty(PropertyName = "dadosPassageiros")]
      public List<PassengerData> passengerData { get; set; }

      [JsonProperty(PropertyName = "dadosEscalas")]
      public List<FlightRangeData> flightRange { get; set; }
    }
}
