using System;
using Newtonsoft.Json;

namespace YapayGatewayLib.Model
{
    public class PassengerData
    {
    [JsonProperty(PropertyName = "primeiroNome")]
	public string firstName{get;set;}

    [JsonProperty(PropertyName = "segundoNome")]
	public string middleName{get;set;}

    [JsonProperty(PropertyName = "sobrenome")]
	public string lastName{get;set;}
    }
}
