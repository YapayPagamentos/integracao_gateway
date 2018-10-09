<?php 
	
	class TransactionDeliveryDataJson {
		var $nome;
	    var $email;
	    var $dataNascimento;
	    var $sexo;
	    var $documento;
	    var $documento2;
	    var $endereco;
	    var $telefone;

	    public function __construct($transactionDeliveryData) {
	        $this->nome = $transactionDeliveryData->name;
		    $this->emai = $transactionDeliveryData->mail;
		    $this->dataNascimento = $transactionDeliveryData->birthday;
		    $this->sexo = $transactionDeliveryData->sex;
		    $this->documento = $transactionDeliveryData->document;
		    $this->documento2 = $transactionDeliveryData->documentTwo;
		    $this->endereco = $transactionDeliveryData->deliveryAddressData;
		    $this->telefone = $transactionDeliveryData->deliveryPhoneData;
    	}
	}

 ?>