<?php 

	require_once "models/transaction.php";
	require_once "models/transaction_data.php";
	require_once "models/transaction_card_data.php";
	require_once "models/transaction_item_data.php";
	require_once "models/transaction_charging_data.php";
	require_once "models/transaction_phone_data.php";
	require_once "models/transaction_extra_field.php";
	require_once "models/transaction_address_data.php";
	require_once "models/transaction_delivery_data.php";
	
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
			$this->$transaction->transactionData->installments = $installments;
		}

		public function withSingleCreditCard($cardHolderName, $cardNumber, $cvv, $expirationDate){
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
			$this->transactionExtraFields = $myExtraFields;
			}
		}

		public function withDeliveryData($deliveryData){
			
		}

		public function build(){
			$myTransaction = $this->transaction;
			$this->transaction = null;
			return $myTransaction;
		}

	}

 ?>