<?php 
	
	class TransactionAirlinePassengerDataJson {
		public $primeiroNome;
	    public $segundoNome;
	    public $sobrenome;

	    public function __construct($transactionAirlinePassengerData) {
        	$this->primeiroNome = $transactionAirlinePassengerData->firstName;
		    $this->segundoNome = $transactionAirlinePassengerData->middleName;
		    $this->sobrenome = $transactionAirlinePassengerData->lastName;
    	}
	}

 ?>