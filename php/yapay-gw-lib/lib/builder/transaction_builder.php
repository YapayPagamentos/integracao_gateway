<?php 

require_once "./yapay-gw-lib/lib/models/transaction.php";
require_once "./yapay-gw-lib/lib/models/transaction_address_data.php";
require_once "./yapay-gw-lib/lib/models/transaction_card_data.php";
require_once "./yapay-gw-lib/lib/models/transaction_charging_data.php";
require_once "./yapay-gw-lib/lib/models/transaction_data.php";
require_once "./yapay-gw-lib/lib/models/transaction_delivery_data.php";
require_once "./yapay-gw-lib/lib/models/transaction_extra_field.php";
require_once "./yapay-gw-lib/lib/models/transaction_item_data.php";
require_once "./yapay-gw-lib/lib/models/transaction_phone_data.php";
require_once "./yapay-gw-lib/lib/models/transaction_checkout_data.php";

class TransactionBuilder {
    
    private $transaction;

    public function newTransaction($storeCode, $paymentCode, $transactionNumber, $value){
	$this->transaction = new Transaction();
	$this->transaction->storeCode = $storeCode;
	$this->transaction->paymentCode = $paymentCode;
	$this->transaction->transactionData = new TransactionData();
	$this->transaction->transactionData->transactionNumber = $transactionNumber;
	$this->transaction->transactionData->value = $value;
	$this->transaction->transactionData->installments = 1;
    }

    public function withInstallments($installments){
	$this->transaction->transactionData->installments = $installments;
    }

    public function withNotificationUrl($url) {
	$this->transaction->transactionData->hintUrl = $url;
    }

    public function withResultUrl($url) {
	$this->transaction->transactionData->resultUrl = $url;
	}
	
	public function withCheckout($process, $paymentType) {
		$this->transaction->transactionCheckoutData = new TransactionCheckoutData();
		$this->transaction->transactionCheckoutData->process = $process;
		$this->transaction->transactionCheckoutData->paymentType = $paymentType;
	}

    public function withBillDueDate($dueDate) {
	$this->transaction->transactionData->billDueDate = $dueDate;
    }
    
    public function withSingleCard($cardHolderName, $cardNumber, $cvv, $expirationDate){
	$this->transaction->transactionCardData = new TransactionCardData();
	$this->transaction->transactionCardData->cardHolderName = $cardHolderName;
	$this->transaction->transactionCardData->cardNumber = $cardNumber;
	$this->transaction->transactionCardData->cvv = $cvv;
	$this->transaction->transactionCardData->expirationDate = $expirationDate;
    }

    public function withItems($arrayOfTransactionItem){
	if ($arrayOfTransactionItem != null) {
	    $myItems = array();

	    foreach ($arrayOfTransactionItem as $item) {
		$myItem = new TransactionItemData();
		$myItem->productCode = $item->productCode;
		$myItem->productCategory = $item->productCategory;
		$myItem->productName = $item->productName;
		$myItem->productAmount = $item->productAmount;
		$myItem->productUnitaryValue = $item->productUnitaryValue;
		$myItem->categoryName =  $item->categoryName;
		array_push($myItems, $myItem);
	    }
	    $this->transaction->transactionItemData = $myItems;
	}
    }

    public function withChargingData($transactionChargingData){
	$this->transaction->transactionChargingData = new TransactionChargingData();
	$this->transaction->transactionChargingData->clientCode = $transactionChargingData->clientCode;
  	$this->transaction->transactionChargingData->clientType = $transactionChargingData->clientType;
  	$this->transaction->transactionChargingData->clientName = $transactionChargingData->clientName;
  	$this->transaction->transactionChargingData->clientEmail = $transactionChargingData->clientEmail;
  	$this->transaction->transactionChargingData->clientBirthday = $transactionChargingData->clientBirthday;
  	$this->transaction->transactionChargingData->clientSex = $transactionChargingData->clientSex;
  	$this->transaction->transactionChargingData->clientDocument = $transactionChargingData->clientDocument;
  	$this->transaction->transactionChargingData->clientDocumentTwo = $transactionChargingData->clientDocumentTwo;
	
	if ($transactionChargingData->clientChargingAdressData != null) {
	    $this->transaction->transactionChargingData->clientChargingAdressData = new TransactionAddressData();
	    $this->transaction->transactionChargingData->clientChargingAdressData->street =  $transactionChargingData->clientChargingAdressData->street;
	    $this->transaction->transactionChargingData->clientChargingAdressData->number =  $transactionChargingData->clientChargingAdressData->number;
	    $this->transaction->transactionChargingData->clientChargingAdressData->complement =  $transactionChargingData->clientChargingAdressData->complement;
	    $this->transaction->transactionChargingData->clientChargingAdressData->zipCode =  $transactionChargingData->clientChargingAdressData->zipCode;
	    $this->transaction->transactionChargingData->clientChargingAdressData->district =  $transactionChargingData->clientChargingAdressData->district;
	    $this->transaction->transactionChargingData->clientChargingAdressData->city =  $transactionChargingData->clientChargingAdressData->city;
	    $this->transaction->transactionChargingData->clientChargingAdressData->state =  $transactionChargingData->clientChargingAdressData->state;
	    $this->transaction->transactionChargingData->clientChargingAdressData->country =  $transactionChargingData->clientChargingAdressData->country;
	}

	if ($transactionChargingData->clientChargingPhoneData != null) {
	    $myPhones = array();

	    foreach ($transactionChargingData->clientChargingPhoneData as $phoneData) {
		$phone = new TransactionPhoneData;
		$phone->ddd = $phoneData->ddd;
		$phone->ddi = $phoneData->ddi;
		$phone->phone = $phoneData->phone;
		$phone->phoneType = $phoneData->phoneType;
		array_push($myPhones, $phone);
	    }

	    $this->transaction->transactionChargingData->clientChargingPhoneData = $myPhones;
	}	    
    }

    public function includeExtraFields($arrayOfExtraFields){

	if($arrayOfExtraFields != null){
	    $myExtraFields = array();
	    foreach ($arrayOfExtraFields as $extraField) {
		$myExtraField = new TransactionExtraField();
		$myExtraField->key = $extraField->key;
		$myExtraField->value = $extraField->value;
		array_push($myExtraFields, $myExtraField);
	    }
	    $this->transaction->transactionExtraFields = $myExtraFields;
	}
    }

    public function withDeliveryData($deliveryData){
	$this->transaction->transactionDeliveryData = new TransactionDeliveryData();
	$this->transaction->transactionDeliveryData->name = $deliveryData->name;
	$this->transaction->transactionDeliveryData->mail = $deliveryData->mail;
	$this->transaction->transactionDeliveryData->birthday = $deliveryData->birthday;
	$this->transaction->transactionDeliveryData->sex = $deliveryData->sex;
	$this->transaction->transactionDeliveryData->document = $deliveryData->document;
	$this->transaction->transactionDeliveryData->documentTwo = $deliveryData->documentTwo;

	if ($deliveryData->deliveryAddressData != null) {
	    $this->transaction->transactionDeliveryData->deliveryAddressData = new TransactionAddressData();
	    $this->transaction->transactionDeliveryData->deliveryAddressData->street = $deliveryData->deliveryAddressData->street;
	    $this->transaction->transactionDeliveryData->deliveryAddressData->number = $deliveryData->deliveryAddressData->number;
	    $this->transaction->transactionDeliveryData->deliveryAddressData->complement = $deliveryData->deliveryAddressData->complement;
	    $this->transaction->transactionDeliveryData->deliveryAddressData->zipCode = $deliveryData->deliveryAddressData->zipCode;
	    $this->transaction->transactionDeliveryData->deliveryAddressData->district = $deliveryData->deliveryAddressData->district;
	    $this->transaction->transactionDeliveryData->deliveryAddressData->city = $deliveryData->deliveryAddressData->city;
	    $this->transaction->transactionDeliveryData->deliveryAddressData->state = $deliveryData->deliveryAddressData->state;
	    $this->transaction->transactionDeliveryData->deliveryAddressData->country = $deliveryData->deliveryAddressData->country;
	}

	if ($deliveryData->deliveryPhoneData != null) {
	    $myPhones = array();
	    foreach ($deliveryData->deliveryPhoneData as $phoneData) {
		$phone = new TransactionPhoneData;
		$phone->ddd = $phoneData->ddd;
		$phone->ddi = $phoneData->ddi;
		$phone->phone = $phoneData->phone;
		$phone->phoneType = $phoneData->phoneType;
		array_push($myPhones, $phone);
	    }

	    $this->transaction->transactionDeliveryData->deliveryPhoneData = $myPhones;
	}
	
    }

    public function build(){
	$myTransaction = $this->transaction;
	$this->transaction = null;
	return $myTransaction;
    }

}

?>
