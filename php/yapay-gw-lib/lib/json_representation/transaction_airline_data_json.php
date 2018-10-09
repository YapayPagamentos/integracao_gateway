<?php 
	
	class TransactionAirlineDataJson {
	    var $dadosViagem;
	    var $dadosPassageiros;
	    var $dadosEscalas;

	    public function __construct($transactionAirlineData) {
        	$this->dadosViagem = $transactionAirlineData->tripData;
		    $this->dadosPassageiros = $transactionAirlineData->passengerData;
		    $this->dadosEscalas = $transactionAirlineData->flightRangeData;
    	}
	}

 ?>