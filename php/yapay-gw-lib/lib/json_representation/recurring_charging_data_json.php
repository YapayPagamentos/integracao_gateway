<?php 
	
	class RecurringChargingDataJson {
		var $nomeComprador;
	    var $emailComprador;
	    var $tipoCliente;
	    var $documento;
	    var $dataNascimento;
	    var $codigoCliente;
	    var $sexo;
	    var $documento2;
	    var $enderecoComprador;
	    var $numeroEnderecoComprador;
	    var $bairroComprador;
	    var $complementoComprador;
	    var $cidadeComprador;
	    var $estadoComprador;
	    var $cepComprador;
	    var $paisComprador;
	    var $telefone;

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