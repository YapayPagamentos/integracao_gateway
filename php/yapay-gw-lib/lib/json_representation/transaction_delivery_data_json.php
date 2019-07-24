<?php 

require_once "yapay-gw-lib/lib/json_representation/transaction_address_data_json.php";	
require_once "yapay-gw-lib/lib/json_representation/transaction_phone_data_json.php";	

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
	$this->email = $transactionDeliveryData->mail;
	$this->dataNascimento = $transactionDeliveryData->birthday;
	$this->sexo = $transactionDeliveryData->sex;
	$this->documento = $transactionDeliveryData->document;
	$this->documento2 = $transactionDeliveryData->documentTwo;
	if($transactionDeliveryData->deliveryAddressData) {
	    $this->endereco = new TransactionAddressDataJson($transactionDeliveryData->deliveryAddressData);
	}
	if($transactionDeliveryData->deliveryPhoneData && is_array($transactionDeliveryData->deliveryPhoneData)) {
	    $phoneList = array();
	    foreach($transactionDeliveryData->deliveryPhoneData as $phone) {
		if($phone) {
		    array_push($phoneList, new TransactionPhoneDataJson($phone));
		}
	    }
	    $this->telefone = $phoneList;
	}
    }
}

?>
