<?php 

	require_once "models/transaction.php";
	require_once "models/transaction_data.php";
	require_once "models/transaction_card_data.php";
	
	class TransactionBuilder {
		
		private $transaction;

		public function newTransaction($storeCode, $paymentCode, $transactionNumber, $value){
			$transaction = new Transaction();
			$transaction->storeCode = $storeCode;
			$transaction->paymentCode = $paymentCode;
			$transaction->transactionData = new TransactionData();
			$transaction->transactionData->transactionNumber = $transactionNumber;
			$transaction->transactionData->value = $value;
			$transaction->transactionData->installments = 1;
		}

		public function withInstallments($installments){
			$transaction->transactionData->installments = $installments;
		}

		public function withSingleCreditCard($cardHolderName, $cardNumber, $cvv, $expirationDate){
			$transaction->transactionCardData = new TransactionCardData();
			$transaction->transactionCardData->cardHolderName = $cardHolderName;
			$transaction->transactionCardData->cardNumber = $cardNumber;
			$transaction->transactionCardData->cvv = $cvv;
			$transaction->transactionCardData->expirationDate = $expirationDate;
		}

		public function withItems($arrayOfTransactionItem){
			
		}

		public function withChargingData($transactionChargingData){
			
		}

		public function includeExtraFields($arrayOfExtraFields){
			
		}

		public function withDeliveryData($deliveryData){
			
		}

	}

 ?>