<?php 
	
	class TransactionChargingDataJson {
		public $codigoCliente;
	    public $tipoCliente;
	    public $nome;
	    public $email;
	    public $dataNascimento;
	    public $sexo;
	    public $documento;
	    public $documento2;
	    public $endereco;
	    public $telefone;

	    public function __construct($transactionChargingData) {
	        $this->codigoCliente = $transactionChargingData->clientCode;
		    $this->tipoCliente = $transactionChargingData->clientType;
		    $this->nome = $transactionChargingData->clientName;
		    $this->email = $transactionChargingData->clientEmail;
		    $this->dataNascimento = $transactionChargingData->clientBirthday;
		    $this->sexo = $transactionChargingData->clientSex;
		    $this->documento = $transactionChargingData->clientDocument;
		    $this->documento2 = $transactionChargingData->clientDocumentTwo;
		    $this->endereco = $transactionChargingData->clientChargingAdressData;
		    $this->telefone = $transactionChargingData->clientChargingPhoneData;
    	}
	}

 ?>