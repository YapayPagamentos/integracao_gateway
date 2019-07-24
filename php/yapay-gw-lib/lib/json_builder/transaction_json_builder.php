<?php 

require_once "../yapay-gw-lib/lib/json_representation/transaction_json.php";
require_once "../yapay-gw-lib/lib/json_representation/transaction_data_json.php";
require_once "../yapay-gw-lib/lib/json_representation/transaction_card_data_json.php";
require_once "../yapay-gw-lib/lib/json_representation/transaction_charging_data_json.php";
require_once "../yapay-gw-lib/lib/json_representation/transaction_delivery_data_json.php";
require_once "../yapay-gw-lib/lib/json_representation/transaction_item_data_json.php";
require_once "../yapay-gw-lib/lib/json_representation/transaction_extra_field_json.php";

class TransactionJsonBuilder{
    

    public function newTransaction($transaction){
	$jsonTransaction = new TransactionJson($transaction);
	$jsonTransaction->transacao = $this->newTransactionData($transaction->transactionData);
	$jsonTransaction->dadosCobranca = $this->newTransactionChargingData($transaction->transactionChargingData);
	$jsonTransaction->dadosEntrega = $this->newTransactionDeliveryData($transaction->transactionDeliveryData);
	$jsonTransaction->dadosCartao = $this->newTransactionCardData($transaction->transactionCardData);
	$jsonTransaction->itensDoPedido = $this->newTransactionItemData($transaction->transactionItemData);
	$jsonTransaction->camposExtras = $this->newTransactionExtraFields($transaction->transactionExtraFields);

	return $jsonTransaction;
    }

    public function newTransactionData($transactionData){
	$jsonTransactionData = new TransactionDataJson($transactionData);

	return $jsonTransactionData;
    }

    public function newTransactionChargingData($transactionChargingData){
	$jsonTransactionChargingData = new TransactionChargingDataJson($transactionChargingData);

	return $jsonTransactionChargingData;
    }

    public function newTransactionDeliveryData($transactionDeliveryData){
	$jsonTransactionDeliveryData = new TransactionDeliveryDataJson($transactionDeliveryData);

	return $jsonTransactionDeliveryData;
    }

    public function newTransactionCardData($transactionCardData){
	$jsonTransactionCardData = new TransactionCardDataJson($transactionCardData);

	return $jsonTransactionCardData;
    }

    public function newTransactionItemData($transactionItemData){
	$jsonArrayOfItems = array();

	foreach ($transactionItemData as $originalItem) {
	    $jsonRepresentationOfItem = new TransactionItemDataJson($originalItem);
	    array_push($jsonArrayOfItems, $jsonRepresentationOfItem);
	}

	return $jsonArrayOfItems;
    }

    public function newTransactionExtraFields($transactionExtraFields){
	$jsonArrayOfExtraFields = array();
	if(is_array($transactionExtraFields) || is_object($transactionExtraFields)) {
	    foreach ($transactionExtraFields as $originalExtraField) {
		$jsonRepresentationOfExtraField = new TransactionExtraFieldJson($originalExtraField);
		array_push($jsonArrayOfExtraFields, $jsonRepresentationOfExtraField);
	    }
	}
	return $jsonArrayOfExtraFields;
    }


}

?>
