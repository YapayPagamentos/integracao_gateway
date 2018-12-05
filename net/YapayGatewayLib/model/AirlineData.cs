using System;
using System.Collections.Generic;

namespace YapayGatewayLib.Model
{
    public class AirlineData
    {
        AirlineTripData tripData { get; set; }
        List<PassengerData> passengerData { get; set; }
        List<FlightRangeData> flightRange { get; set; }
    }
}
