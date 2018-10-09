<?php 
	
	class TransactionAddressDataJson {
		var $logradouro;
	    var $numero
	    var $complemento;
	    var $cep;
	    var $bairro;
	    var $cidade;
	    var $estado;
	    var $pais;


	    public function __construct($transactionAddressData) {
        	$this->logradouro = $transactionAddressData->street;
		    $this->numer = $transactionAddressData->number;
		    $this->complemento = $transactionAddressData->complement;
		    $this->cep = $transactionAddressData->zipCode;
		    $this->bairro = $transactionAddressData->district;
		    $this->cidade = $transactionAddressData->city;
		    $this->estado = $transactionAddressData->state;
		    $this->pais = $transactionAddressData->country;
    	}

	}

 ?>