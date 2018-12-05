using System;
using Newtonsoft.Json;

namespace YapayGatewayLib.Model
{
    public class Credential
    {
        string user { get; set; }
        string password { get; set; }
        string storeCode { get; set; }
    }
}
