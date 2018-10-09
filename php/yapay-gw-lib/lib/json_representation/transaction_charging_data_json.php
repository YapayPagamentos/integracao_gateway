<?php 
	
	class TransactionChargingDataJson {
		var $codigoCliente;
	    var $tipoCliente;
	    var $nome;
	    var $email;
	    var $dataNascimento;
	    var $sexo;
	    var $documento;
	    var $documento2;
	    var $endereco;
	    var $telefone;

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