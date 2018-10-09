<?php 
	
	class RecurringShippingDataJson {
	    var $nomeEntrega;
	    var $emailEntrega;
	    var $enderecoEntrega;
	    var $numeroEnderecoEntrega;
	    var $bairroEntrega;
	    var $complementoEntrega;
	    var $cidadeEntrega;
	    var $estadoEntrega;
	    var $cepEntrega;
	    var $paisEntrega;
	    var $telefone;

	    public function __construct($recurringShippingData) {
	       $this->nomeEntrega = $recurringShippingData->shippingName;
		   $this->emailEntrega = $recurringShippingData->shippingMail;
		   $this->enderecoEntrega = $recurringShippingData->shippingStreet;
		   $this->numeroEnderecoEntrega = $recurringShippingData->shippingNumber;
		   $this->bairroEntrega = $recurringShippingData->shippingDistrict;
		   $this->complementoEntrega = $recurringShippingData->shippingComplement;
		   $this->cidadeEntrega = $recurringShippingData->shippingCity;
		   $this->estadoEntrega = $recurringShippingData->shippingState;
		   $this->cepEntrega = $recurringShippingData->shippingZipcode;
		   $this->paisEntrega = $recurringShippingData->shippingCountry;
		   $this->telefone = $recurringShippingData->shippingPhone;
    	}

	}

 ?>