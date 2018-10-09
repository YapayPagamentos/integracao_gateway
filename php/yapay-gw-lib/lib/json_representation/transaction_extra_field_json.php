<?php 
	
	class TransactionExtraFieldJson {
		var $chave;
	    var $valor;

	    public function __construct($transactionExtraField) {
       		$this->chave = $transactionExtraField->key;
       		$this->valor =  $transactionExtraField->value;
    	}

	}

 ?>