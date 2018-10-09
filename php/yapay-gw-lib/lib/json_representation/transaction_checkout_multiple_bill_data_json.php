<?php 
	
	class TransactionCheckoutMultipleBillDataJson {
		var $valor;
    	var $vencimento;

    	public function __construct($transactionCheckoutMultipleBillData) {
        	$this->valor = $transactionCheckoutMultipleBillData->value;
        	$this->vencimento = $transactionCheckoutMultipleBillData->dueData;
   		}
	}

 ?>