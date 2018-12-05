using System;
using Newtonsoft.Json;

namespace YapayGatewayLib.Model
{
    public class PassengerData
    {
    [JsonProperty(PropertyName = "primeiroNome")]
	 string firstName{get;set;}

     [JsonProperty(PropertyName = "segundoNome")]
	 string middleName{get;set;}

     [JsonProperty(PropertyName = "sobrenome")]
	 string lastName{get;set;}
    }
}
