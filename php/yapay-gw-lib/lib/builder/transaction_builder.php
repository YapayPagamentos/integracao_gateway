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
			
		}

		public function withChargingData($transactionChargingData){
			
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