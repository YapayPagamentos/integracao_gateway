<?php 
	
	class TransactionAirlineFlightRangeDataJson {
		var $classeDoServico;
	    var $dataDaViagem;
	    var $codigoCompanhiaAerea;
	    var $escalaPermitida;
	    var $aeroportoPartida;
	    var $dataHoraPartida;
	    var $aeroportoChegada;
	    var $dataHoraChegada;
	    var $numeroVoo;
	    var $classeTarifaria;

	    public function __construct($transactionAirlineFlightRangeData) {
       		$this->classeDoServico = $transactionAirlineFlightRangeData->serviceClass;
		    $this->dataDaViagem = $transactionAirlineFlightRangeData->tripDate;
		    $this->codigoCompanhiaAerea = $transactionAirlineFlightRangeData->companyCode;
		    $this->escalaPermitida = $transactionAirlineFlightRangeData->permitFlight;
		    $this->aeroportoPartida = $transactionAirlineFlightRangeData->departureAirport;
		    $this->dataHoraPartida = $transactionAirlineFlightRangeData->departureDate;
		    $this->aeroportoChegada = $transactionAirlineFlightRangeData->arrivalAirport;
		    $this->dataHoraChegada = $transactionAirlineFlightRangeData->arrivalDate;
		    $this->numeroVoo = $transactionAirlineFlightRangeData->flyNumber;
		    $this->classeTarifaria = $transactionAirlineFlightRangeData->rateClass;
    	}
	}

 ?>