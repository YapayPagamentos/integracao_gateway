<?php 

require_once "yapay-gw-lib/lib/json_representation/transaction_address_data_json.php";	
require_once "yapay-gw-lib/lib/json_representation/transaction_phone_data_json.php";	

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
	if($transactionChargingData->clientChargingAdressData) {
	    $this->endereco = new TransactionAddressDataJson($transactionChargingData->clientChargingAdressData);
	}
	if($transactionChargingData->clientChargingPhoneData && is_array($transactionChargingData->clientChargingPhoneData)) {
	    $phoneList = array();
	    foreach($transactionChargingData->clientChargingPhoneData as $phone) {
		if($phone) {
		    array_push($phoneList, new TransactionPhoneDataJson($phone));
		}
	    }
	    $this->telefone = $phoneList;
	}
    }
}

?>
