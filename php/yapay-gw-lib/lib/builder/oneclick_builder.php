<?php 
	
	require_once "models/oneclick_register_data.php";

	class OneclickBuilder {

		private $oneClickRegisterData;
		
		public function registerNewOneClick($storeCode, $paymentCode){
			$oneClickRegisterData = new OneclickRegisterData();
			$oneClickRegisterData->storeCode = $storeCode;
			$oneClickRegisterData->paymentCode = $paymentCode;
		}

		public function withCreditCard($cardHolderName, $cardNumber, $expirationDate){
			$oneClickRegisterData->cardHolderName = $cardHolderName;
			$oneClickRegisterData->cardNumber = $cardNumber;
			$oneClickRegisterData->expirationDate = $expirationDate;
		}

		public function forEmail($buyerEmail){
			$oneClickRegisterData->buyerEmail = $buyerEmail;
		}

	}

 ?>