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
			$this->recurringPayment = new RecurringPayment();
			$this->recurringPayment->storeCode = $storeCode;
			$this->recurringPayment->recurringPaymentData = new RecurringPaymentData();
			$this->recurringPayment->recurringPaymentData->paymentCode = $paymentCode;
			$this->recurringPayment->recurringPaymentData->recurringPaymentNumber = $recurringPaymentNumber;
			$this->recurringPayment->recurringPaymentData->value = $value;
			$this->recurringPayment->recurringPaymentData->modality = 1;
		}

		public function withFrequencyOf($frequency){
			$this->recurringPayment->recurringPaymentData->frequency = $frequency;
		}

		public function setNotificationUrl($notificationUrl){
			$this->recurringPayment->recurringPaymentData->notificationUrl = $notificationUrl;
		}

		public function processImmediately($processImmediately){
			$this->recurringPayment->recurringPaymentData->processImmediately = $processImmediately;
		}

		public function billingOptions($billingAmount, $billingFirstDate, $billDueDate){
			$this->recurringPayment->recurringPaymentData->billingAmount = $billingAmount;
			$this->recurringPayment->recurringPaymentData->$billingFirstDate = $billingFirstDate;
			$this->recurringPayment->recurringPaymentData->$billDueDate = $billDueDate;
		}

		public function withFreeFields($freeFieldOne, $freeFieldTwo, $freeFieldThree, $freeFieldFour, $freeFieldFive){
			$this->recurringPayment->recurringPaymentData->freeFieldOne = $freeFieldOne;
			$this->recurringPayment->recurringPaymentData->freeFieldTwo = $freeFieldTwo;
			$this->recurringPayment->recurringPaymentData->freeFieldThree = $freeFieldThree;
			$this->recurringPayment->recurringPaymentData->freeFieldFour = $freeFieldFour;
			$this->recurringPayment->recurringPaymentData->freeFieldFive = $freeFieldFive;
		}

		public function withCharging($recurringChargingData){
			
		}

		public function withCreditCatd($creditCardData){
			
		}

		public function withDebitCard($debitCardData){
			
		}

		public function withDelivery($recurringShippingData){
			
		}

		public function build(){
			$myRecurringPayment = $this->recurringPayment;
			$this->recurringPayment = null;
			return $myRecurringPayment;
		}
	}

 ?>