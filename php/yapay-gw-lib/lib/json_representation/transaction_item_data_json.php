<?php 
	
	class TransactionItemDataJson {
		var $codigoProduto;
	    var $codigoCategoria;
	    var $nomeProduto;
	    var $quantidadeProduto;
	    var $valorUnitarioProduto;
	    var $nomeCategoria;

		public function __construct($transactionItemData) {
	       $this->codigoProduto = $transactionItemData->productCode;
		   $this->codigoCategoria = $transactionItemData->productCategory;
		   $this->nomeProduto = $transactionItemData->productName;
		   $this->quantidadeProduto = $transactionItemData->productAmount;
		   $this->valorUnitarioProduto = $transactionItemData->productUnitaryValue;
		   $this->nomeCategoria = $transactionItemData->categoryName;
	    }

	}

 ?>