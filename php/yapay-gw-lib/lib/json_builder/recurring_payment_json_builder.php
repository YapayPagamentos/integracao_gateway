<?php

	require_once "../yapay-gw-lib/lib/json_representation/recurring_payment_json.php";
	require_once "../yapay-gw-lib/lib/json_representation/recurring_payment_data_json.php";

	class RecurringPaymentJsonBuilder{
		
		public function newRecurringPayment($recurringPayment){
			$jsonRecurringPayment = new RecurringPaymentJson($recurringPayment);
			$jsonRecurringPayment->recorrencia = $this->newRecurringPaymentData($recurringPayment->recurringPaymentData);

			return $jsonRecurringPayment;
		}

		public function newRecurringPaymentData($recurringPaymentData){
			$jsonRecurringPaymentData = new RecurringPaymentJson($recurringPaymentData);

			return $jsonRecurringPaymentData;
		}
	}

 ?>