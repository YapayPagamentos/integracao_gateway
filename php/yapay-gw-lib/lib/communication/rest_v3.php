<?php 
	
	class RestV3 {

		private $baseUrl;

		function __construct($baseUrl)
		{
			$this->baseUrl = $baseUrl;
		}
		
		public function transactionAuthorize($credential, $transaction){
			$curl = $this->curlInit("POST", $this->baseUrl."/api/v3/transacao", $transaction, $credential);
			$response = curl_exec($curl);
			curl_close($curl);
			return $response;
		}

		public function transactionQuery($credential, $storeCode, $transactionNumber){
			$curl = $this->curlInit("GET", $this->baseUrl."/api/v3/transacao/".$storeCode."/".$transactionNumber, null, $credential);
			$response = curl_exec($curl);
			curl_close($curl);
			return $response;
		}

		public function transactionCapture($credential, $storeCode, $transactionNumber, $value){
			$curl = $this->curlInit("PUT", $this->baseUrl."/api/v3/transacao/".$storeCode."/".$transactionNumber, null, $credential);
			$response = curl_exec($curl);
			curl_close($curl);
			return $response;
		}

		public function transactionCancel($credential, $storeCode, $transactionNumber, $value){
			$curl = $this->curlInit("PUT", $this->baseUrl."/api/v3/transacao/".$storeCode."/".$transactionNumber, null, $credential);
			$response = curl_exec($curl);
			curl_close($curl);
			return $response;
		}

		public function oneclickRegister($credential, $oneclickRegisterData){
			$curl = $this->curlInit("POST", $this->baseUrl."/api/v3/oneclick/", $oneclickRegisterData, $credential);
			$response = curl_exec($curl);
			curl_close($curl);
			return $response;
		}

		public function oneclickQuery($credential, $token){
			$curl = $this->curlInit("GET", $this->baseUrl."/api/v3/oneclick/".$token, null, $credential);
			$response = curl_exec($curl);
			curl_close($curl);
			return $response;
		}

		public function oneclickRegisterUpdate($credential, $token, $oneclickRegisterData){
			$curl = $this->curlInit("PUT", $this->baseUrl."/api/v3/oneclick/".$token."/alterar", $oneclickRegisterData, $credential);
			$response = curl_exec($curl);
			curl_close($curl);
			return $response;
		}

		public function oneclickAuthorize($credential, $token, $transaction){
			$curl = $this->curlInit("POST", $this->baseUrl."/api/v3/oneclick/".$token."/autorizar", $transaction, $credential);
			$response = curl_exec($curl);
			curl_close($curl);
			return $response;
		}

		public function recurringPaymentRegister($credential, $recurringPaymentData){
			$curl = $this->curlInit("POST", $this->baseUrl."/api/v3/recorrencia", $recurringPaymentData, $credential);
			$response = curl_exec($curl);
			curl_close($curl);
			return $response;
		}

		public function recurringPaymentQuery($credential, $storeCode, $recurringPaymentNumber){
			$curl = $this->curlInit("GET", $this->baseUrl."/api/v3/recorrencia/".$storeCode."/".$recurringPaymentNumber, null, $credential);
			$response = curl_exec($curl);
			curl_close($curl);
			return $response;
		}

		public function recurringPaymentCancel($credential, $storeCode, $recurringPaymentNumber){
			$curl = $this->curlInit("PUT", $this->baseUrl."/api/v3/recorrencia/".$storeCode."/".$recurringPaymentNumber, null, $credential);
			$response = curl_exec($curl);
			curl_close($curl);
			return $response;
		}

		private function curlInit($requestType, $url, $data, $credential){
			$ch = curl_init($url);
			curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
			curl_setopt($ch, CURLOPT_CUSTOMREQUEST, $requestType);
			curl_setopt($ch, CURLOPT_POSTFIELDS, http_build_query($data));
			curl_setopt($ch, CURLOPT_USERPWD, $credential->user . ":" . $credential->password);
			curl_setopt($ch, CURLOPT_HTTPHEADER, array("Content-Type: application/json"));
			return $ch;
		}

	}

 ?>