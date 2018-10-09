<?php 
	
	class TransactionAirlineTripDataJson {
		public $pnr;
	    public $titularCartaoEPassageiro;
	    public $dataEmissaoPassagem;
	    public $codigoCompanhiaAerea;
	    public $aeroportoPartida;
	    public $dataHoraPartida;
	    public $aeroportoChegada;
	    public $dataHoraChegada;

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