using System;

namespace YapayGatewayLib.Model
{
    public class AirlineTripData
    {
        string pnr { get; set; }
        bool cardholderIsPassenger { get; set; }
        string ticketIssueDate { get; set; }
        string companyCode { get; set; }
        string departureAirport { get; set; }
        string departureDate { get; set; }
        string arrivalAirport { get; set; }
        string arrivalDate { get; set; }
    }
}
