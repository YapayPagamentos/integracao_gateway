<?php 
	
	class TransactionCheckoutMultipleBillDataJson {
		public $valor;
    	public $vencimento;

    	public function __construct($transactionCheckoutMultipleBillData) {
        	$this->valor = $transactionCheckoutMultipleBillData->value;
        	$this->vencimento = $transactionCheckoutMultipleBillData->dueData;
   		}
	}

 ?>