<?php 
	
	class RecurringChargingDataJson {
		public $nomeComprador;
	    public $emailComprador;
	    public $tipoCliente;
	    public $documento;
	    public $dataNascimento;
	    public $codigoCliente;
	    public $sexo;
	    public $documento2;
	    public $enderecoComprador;
	    public $numeroEnderecoComprador;
	    public $bairroComprador;
	    public $complementoComprador;
	    public $cidadeComprador;
	    public $estadoComprador;
	    public $cepComprador;
	    public $paisComprador;
	    public $telefone;

	    public function __construct($recurringChargingData) {
	        $this->nomeComprador = $recurringChargingData->buyerName;
		    $this->emailComprador = $recurringChargingData->buyerMail;
		    $this->tipoCliente = $recurringChargingData->clientType;
		    $this->documento = $recurringChargingData->document;
		    $this->dataNascimento = $recurringChargingData->birthday;
		    $this->codigoCliente = $recurringChargingData->clientCode;
		    $this->sexo = $recurringChargingData->clientSex;
		    $this->documento2 = $recurringChargingData->documentTwo;
		    $this->enderecoComprador = $recurringChargingData->clientAddressStreet;
		    $this->numeroEnderecoComprador = $recurringChargingData->clientAddressNumber;
		    $this->bairroComprador = $recurringChargingData->clientAddressDistrict;
		    $this->complementoComprador = $recurringChargingData->clientAddressComplement;
		    $this->cidadeComprador = $recurringChargingData->clientAddressCity;
		    $this->estadoComprador = $recurringChargingData->clientAddressState;
		    $this->cepComprador = $recurringChargingData->clientAddressZipcode;
		    $this->paisComprador = $recurringChargingData->clientAddressCountry;
		    $this->telefone = $recurringChargingData->clientPhone;
    	}
	}

 ?>