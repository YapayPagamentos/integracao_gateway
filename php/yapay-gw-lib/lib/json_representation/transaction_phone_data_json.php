<?php 
	
	class TransactionPhoneDataJson {
		var $ddi;
	    var $ddd;
	    var $telefone;
	    var $tipoTelefone;


	    public function __construct($transactionPhoneData) {
	       	$this->ddi = $transactionPhoneData->ddi;
		    $this->ddd = $transactionPhoneData->ddd;
		    $this->telefone = $transactionPhoneData->phone;
		    $this->tipoTelefone = $transactionPhoneData->phoneType;
    	}

	}

 ?>