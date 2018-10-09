<?php 
	
	class TransactionAirlineTripDataJson {
		var $pnr;
	    var $titularCartaoEPassageiro;
	    var $dataEmissaoPassagem;
	    var $codigoCompanhiaAerea;
	    var $aeroportoPartida;
	    var $dataHoraPartida;
	    var $aeroportoChegada;
	    var $dataHoraChegada;

	    public function __construct($transactionAirlineTripData) {
        	$this->pnr = $transactionAirlineTripData->pnr;
		    $this->titularCartaoEPassageiro = $transactionAirlineTripData->cardholderIsPassenger;
		    $this->dataEmissaoPassagem = $transactionAirlineTripData->ticketIssueDate;
		    $this->codigoCompanhiaAerea = $transactionAirlineTripData->companyCode;
		    $this->aeroportoPartida = $transactionAirlineTripData->departureAirport;
		    $this->dataHoraPartida = $transactionAirlineTripData->departureDate;
		    $this->aeroportoChegada = $transactionAirlineTripData->arrivalAirport;
		    $this->dataHoraChegada = $transactionAirlineTripData->arrivalDate;
    	}
	}

 ?>