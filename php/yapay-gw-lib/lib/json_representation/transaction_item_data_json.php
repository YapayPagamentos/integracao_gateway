<?php 
	
	class TransactionItemDataJson {
		public $codigoProduto;
	    public $codigoCategoria;
	    public $nomeProduto;
	    public $quantidadeProduto;
	    public $valorUnitarioProduto;
	    public $nomeCategoria;

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