<?php 
	
	require_once "../yapay-gw-lib/lib/models/oneclick_register_data.php";

	class OneclickBuilder {

		private $oneClickRegisterData;
		
		public function registerNewOneClick($storeCode, $paymentCode){
			$this->oneClickRegisterData = new OneclickRegisterData();
			$this->oneClickRegisterData->storeCode = $storeCode;
			$this->oneClickRegisterData->paymentCode = $paymentCode;
		}

		public function withCreditCard($cardHolderName, $cardNumber, $expirationDate){
			$this->oneClickRegisterData->cardHolderName = $cardHolderName;
			$this->oneClickRegisterData->cardNumber = $cardNumber;
			$this->oneClickRegisterData->expirationDate = $expirationDate;
		}

		public function forEmail($buyerEmail){
			$this->oneClickRegisterData->buyerEmail = $buyerEmail;
		}

		public function build(){
			$myOneClickRegisterData = $this->oneClickRegisterData;
			$this->oneClickRegisterData = null;
			return $myOneClickRegisterData;
		}

	}

 ?>