using System;
using Newtonsoft.Json;

namespace YapayGatewayLib.Model
{
    public class ItemData
    {
	[JsonProperty(PropertyName = "codigoProduto")]
	string productCode{get;set;}

	[JsonProperty(PropertyName = "codigoCategoria")]
	string productCategory{get;set;}

	[JsonProperty(PropertyName = "nomeProduto")]
	string productName{get;set;}

	[JsonProperty(PropertyName = "quantidadeProduto")]
    int productAmount{get;set;}

	[JsonProperty(PropertyName = "valorUnitarioProduto")]
	long productUnitaryValue{get;set;}

	[JsonProperty(PropertyName = "nomeCategoria")]
	string categoryName{get;set;}

    }
}
