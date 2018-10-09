<?php 
	
	class RecurringShippingDataJson {
	    public $nomeEntrega;
	    public $emailEntrega;
	    public $enderecoEntrega;
	    public $numeroEnderecoEntrega;
	    public $bairroEntrega;
	    public $complementoEntrega;
	    public $cidadeEntrega;
	    public $estadoEntrega;
	    public $cepEntrega;
	    public $paisEntrega;
	    public $telefone;

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