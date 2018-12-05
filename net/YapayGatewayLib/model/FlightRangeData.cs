using System;
using Newtonsoft.Json;

namespace YapayGatewayLib.Model
{
    public class FlightRangeData
    {
        string serviceClass { get; set; }
        string tripDate { get; set; }
        string companyCode { get; set; }
        bool permitFlight { get; set; }
        string departureAirport { get; set; }
        string departureDate { get; set; }
        string arrivalAirport { get; set; }
        string arrivalDate { get; set; }
        string flyNumber { get; set; }
        string rateClass { get; set; }
    }
}
