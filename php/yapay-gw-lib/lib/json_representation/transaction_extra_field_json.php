<?php 
	
	class TransactionExtraFieldJson {
		public $chave;
	    public $valor;

	    public function __construct($transactionExtraField) {
       		$this->chave = $transactionExtraField->key;
       		$this->valor =  $transactionExtraField->value;
    	}

	}

 ?>