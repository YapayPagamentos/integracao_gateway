<?php 
	
	class TransactionAirlinePassengerDataJson {
		var $primeiroNome;
	    var $segundoNome;
	    var $sobrenome;

	    public function __construct($transactionAirlinePassengerData) {
        	$this->primeiroNome = $transactionAirlinePassengerData->firstName;
		    $this->segundoNome = $transactionAirlinePassengerData->middleName;
		    $this->sobrenome = $transactionAirlinePassengerData->lastName;
    	}
	}

 ?>