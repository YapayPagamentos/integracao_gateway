<?php 

	require_once "models/recurring_payment.php";
	require_once "models/recurring_payment_data.php";
	require_once "models/recurring_payment_charging_data.php";
	require_once "models/recurring_payment_shipping_data.php";
	require_once "models/transaction_phone_data.php";
	require_once "models/transaction_card_data.php";
	require_once "models/transaction_debit_data.php";
	
	class RecurringPaymentBuilder {
		
		private $recurringPayment;

		public function registerNewRecurringPayment($storeCode, $paymentCode, $recurringPaymentNumber, $value){
			$recurringPayment = new RecurringPayment();
			$recurringPayment->storeCode = $storeCode;
			$recurringPayment->recurringPaymentData = new RecurringPaymentData();
			$recurringPayment->recurringPaymentData->paymentCode = $paymentCode;
			$recurringPayment->recurringPaymentData->recurringPaymentNumber = $recurringPaymentNumber;
			$recurringPayment->recurringPaymentData->value = $value;
			$recurringPayment->recurringPaymentData->modality = 1;
		}

		public function withFrequencyOf($frequency){
			$recurringPayment->recurringPaymentData->frequency = $frequency;
		}

		public function setNotificationUrl($notificationUrl){
			$recurringPayment->recurringPaymentData->notificationUrl = $notificationUrl;
		}

		public function processImmediately($processImmediately){
			$recurringPayment->recurringPaymentData->processImmediately = $processImmediately;
		}

		public function billingOptions($billingAmount, $billingFirstDate, $billDueDate){
			$recurringPayment->recurringPaymentData->billingAmount = $billingAmount;
			$recurringPayment->recurringPaymentData->$billingFirstDate = $billingFirstDate;
			$recurringPayment->recurringPaymentData->$billDueDate = $billDueDate;
		}

		public function withFreeFields($freeFieldOne, $freeFieldTwo, $freeFieldThree, $freeFieldFour, $freeFieldFive){
			$recurringPayment->recurringPaymentData->freeFieldOne = $freeFieldOne;
			$recurringPayment->recurringPaymentData->freeFieldTwo = $freeFieldTwo;
			$recurringPayment->recurringPaymentData->freeFieldThree = $freeFieldThree;
			$recurringPayment->recurringPaymentData->freeFieldFour = $freeFieldFour;
			$recurringPayment->recurringPaymentData->freeFieldFive = $freeFieldFive;
		}

		public function withCharging($recurringChargingData){
			
		}

		public function withCreditCatd($creditCardData){
			
		}

		public function withDebitCard($debitCardData){
			
		}

		public function withDelivery($recurringShippingData){
			
		}
	}

 ?>