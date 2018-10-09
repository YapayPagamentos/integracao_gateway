<?php 
	
	class TransactionAirlineFlightRangeDataJson {
		public $classeDoServico;
	    public $dataDaViagem;
	    public $codigoCompanhiaAerea;
	    public $escalaPermitida;
	    public $aeroportoPartida;
	    public $dataHoraPartida;
	    public $aeroportoChegada;
	    public $dataHoraChegada;
	    public $numeroVoo;
	    public $classeTarifaria;

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