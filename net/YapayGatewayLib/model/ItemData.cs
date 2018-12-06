using System;
using Newtonsoft.Json;

namespace YapayGatewayLib.Model
{
    public class ItemData
    {
	[JsonProperty(PropertyName = "codigoProduto")]
	public string productCode{get;set;}

 	[JsonProperty(PropertyName = "codigoCategoria")]
	public string productCategory{get;set;}

 	[JsonProperty(PropertyName = "nomeProduto")]
	public string productName{get;set;}

 	[JsonProperty(PropertyName = "quantidadeProduto")]
    public int productAmount{get;set;}

 	[JsonProperty(PropertyName = "valorUnitarioProduto")]
	public long productUnitaryValue{get;set;}

 	[JsonProperty(PropertyName = "nomeCategoria")]
	public string categoryName{get;set;}

    }
}
