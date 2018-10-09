<?php 
	
	class TransactionDeliveryDataJson {
		public $nome;
	    public $email;
	    public $dataNascimento;
	    public $sexo;
	    public $documento;
	    public $documento2;
	    public $endereco;
	    public $telefone;

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