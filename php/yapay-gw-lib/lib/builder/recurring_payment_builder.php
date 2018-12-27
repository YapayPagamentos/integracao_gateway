<?php 

	require_once "../yapay-gw-lib/lib/models/recurring_payment.php";
	require_once "../yapay-gw-lib/lib/models/recurring_payment_data.php";
	require_once "../yapay-gw-lib/lib/models/recurring_payment_charging_data.php";
	require_once "../yapay-gw-lib/lib/models/recurring_payment_shipping_data.php";
	require_once "../yapay-gw-lib/lib/models/transaction_phone_data.php";
	require_once "../yapay-gw-lib/lib/models/transaction_card_data.php";
	
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
			$this->recurringPayment->recurringPaymentData->recurringChargingData = new RecurringChargingData();
			$this->recurringPayment->recurringPaymentData->recurringChargingData->buyerName = $recurringChargingData->buyerName;
		    $this->recurringPayment->recurringPaymentData->recurringChargingData->buyerMail = $recurringChargingData->buyerMail;
		    $this->recurringPayment->recurringPaymentData->recurringChargingData->clientType = $recurringChargingData->clientType;
		    $this->recurringPayment->recurringPaymentData->recurringChargingData->document = $recurringChargingData->document;
		    $this->recurringPayment->recurringPaymentData->recurringChargingData->birthday = $recurringChargingData->birthday;
		    $this->recurringPayment->recurringPaymentData->recurringChargingData->clientCode = $recurringChargingData->clientCode;
		    $this->recurringPayment->recurringPaymentData->recurringChargingData->clientSex = $recurringChargingData->clientSex;
		    $this->recurringPayment->recurringPaymentData->recurringChargingData->documentTwo = $recurringChargingData->documentTwo;
		    $this->recurringPayment->recurringPaymentData->recurringChargingData->clientAddressStreet = $recurringChargingData->clientAddressStreet;
		    $this->recurringPayment->recurringPaymentData->recurringChargingData->clientAddressNumber = $recurringChargingData->clientAddressNumber;
		    $this->recurringPayment->recurringPaymentData->recurringChargingData->clientAddressDistrict = $recurringChargingData->clientAddressDistrict;
		    $this->recurringPayment->recurringPaymentData->recurringChargingData->clientAddressComplement = $recurringChargingData->clientAddressComplement;
		    $this->recurringPayment->recurringPaymentData->recurringChargingData->clientAddressCity = $recurringChargingData->clientAddressCity;
		    $this->recurringPayment->recurringPaymentData->recurringChargingData->clientAddressState = $recurringChargingData->clientAddressState;
		    $this->recurringPayment->recurringPaymentData->recurringChargingData->clientAddressZipcode = $recurringChargingData->clientAddressZipcode;
		    $this->recurringPayment->recurringPaymentData->recurringChargingData->clientAddressCountry = $recurringChargingData->clientAddressCountry;

		    if ($recurringChargingData->clientPhone != null) {
		    	$myPhones = array();
		    	foreach ($recurringChargingData->clientPhone as $clientPhone) {
		    		$phone = new TransactionPhoneData();
		    		$phone->ddd = $clientPhone->ddd;
		    		$phone->ddi = $clientPhone->ddi;
		    		$phone->phone = $clientPhone->phone;
		    		$phone->phoneType = $clientPhone->phoneType;
		    		array_push($myPhones, $phone);
		    	}
		    	$this->recurringPayment->recurringPaymentData->recurringChargingData->clientPhone = $myPhones;
		    }
		}

		public function withCard($creditCardData){
			$this->recurringPayment->recurringPaymentData->recurringCardData = new TransactionCardData();
			$this->recurringPayment->recurringPaymentData->recurringCardData->cardHolderName = $creditCardData->cardHolderName;
			$this->recurringPayment->recurringPaymentData->recurringCardData->cardNumber = $creditCardData->cardNumber;
			$this->recurringPayment->recurringPaymentData->recurringCardData->cvv = $creditCardData->cvv;
			$this->recurringPayment->recurringPaymentData->recurringCardData->expirationDate = $creditCardData->expirationDate;
			$this->recurringPayment->recurringPaymentData->recurringCardData->paymentCode = $creditCardData->paymentCode;
			$this->recurringPayment->recurringPaymentData->recurringCardData->installments = $creditCardData->installments;
			$this->recurringPayment->recurringPaymentData->recurringCardData->value = $creditCardData->value;
		}


		public function withDelivery($recurringShippingData){
			$this->recurringPayment->recurringPaymentData->recurringShippingData = new RecurringShippingData();
			$this->recurringPayment->recurringPaymentData->recurringShippingData->shippingName = $recurringShippingData->shippingName;
			$this->recurringPayment->recurringPaymentData->recurringShippingData->shippingMail = $recurringShippingData->shippingMail;
			$this->recurringPayment->recurringPaymentData->recurringShippingData->shippingStreet = $recurringShippingData->shippingStreet;
			$this->recurringPayment->recurringPaymentData->recurringShippingData->shippingNumber = $recurringShippingData->shippingNumber;
			$this->recurringPayment->recurringPaymentData->recurringShippingData->shippingDistrict = $recurringShippingData->shippingDistrict;
			$this->recurringPayment->recurringPaymentData->recurringShippingData->shippingComplement = $recurringShippingData->shippingComplement;
			$this->recurringPayment->recurringPaymentData->recurringShippingData->shippingCity = $recurringShippingData->shippingCity;
			$this->recurringPayment->recurringPaymentData->recurringShippingData->shippingState = $recurringShippingData->shippingState;
			$this->recurringPayment->recurringPaymentData->recurringShippingData->shippingZipcode = $recurringShippingData->shippingZipcode;
			$this->recurringPayment->recurringPaymentData->recurringShippingData->shippingCountry = $recurringShippingData->shippingCountry;
			$this->recurringPayment->recurringPaymentData->recurringShippingData->shippingPhone = $recurringShippingData->shippingPhone;
		}

		public function build(){
			$myRecurringPayment = $this->recurringPayment;
			$this->recurringPayment = null;
			return $myRecurringPayment;
		}
	}

 ?>