<?php 
	
	class TransactionPhoneDataJson {
		public $ddi;
	    public $ddd;
	    public $telefone;
	    public $tipoTelefone;


	    public function __construct($transactionPhoneData) {
	       	$this->ddi = $transactionPhoneData->ddi;
		    $this->ddd = $transactionPhoneData->ddd;
		    $this->telefone = $transactionPhoneData->phone;
		    $this->tipoTelefone = $transactionPhoneData->phoneType;
    	}

	}

 ?>