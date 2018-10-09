<?php 
	
	class TransactionAirlineDataJson {
	    public $dadosViagem;
	    public $dadosPassageiros;
	    public $dadosEscalas;

	    public function __construct($transactionAirlineData) {
        	$this->dadosViagem = $transactionAirlineData->tripData;
		    $this->dadosPassageiros = $transactionAirlineData->passengerData;
		    $this->dadosEscalas = $transactionAirlineData->flightRangeData;
    	}
	}

 ?>