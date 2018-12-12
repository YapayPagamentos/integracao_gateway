<?php 
	
	class RestV3 {

		private $baseUrl;

		function __construct($baseUrl)
		{
			$this->baseUrl = $baseUrl;
		}
		
		public function transactionAuthorize($credentials, $transaction){
			
		}

		public function transactionQuery($credentials, $storeCode, $transactionNumber){
			
		}

		public function transactionCapture($credentials, $storeCode, $transactionNumber, $value){
			
		}

		public function transactionCancel($credentials, $storeCode, $transactionNumber, $value){
			
		}

		public function oneclickRegister($credentials, $oneclickRegisterData){
			
		}

		public function oneclickQuery($credentials, $token){
			
		}

		public function oneclickRegisterUpdate($credentials, $token, $oneclickRegisterData){
			
		}

		public function oneclickAuthorize($credentials, $token, $transaction){
			
		}

		public function recurringPaymentRegister($credentials, $recurringPaymentData){
			
		}

		public function recurringPaymentQuery($credentials, $storeCode, $recurringPaymentNumber){
			
		}

		public function recurringPaymentCancel($credentials, $storeCode, $recurringPaymentNumber){
			
		}

		private function curlInit($requestType, $url, $data, $credential){
			$ch = curl_init($url);
			curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
			curl_setopt($ch, CURLOPT_CUSTOMREQUEST, $requestType);
			curl_setopt($ch, CURLOPT_POSTFIELDS, http_build_query($data));
			curl_setopt($ch, CURLOPT_USERPWD, $credential->user . ":" . $credential->password);
			return $ch;
		}

	}

 ?>