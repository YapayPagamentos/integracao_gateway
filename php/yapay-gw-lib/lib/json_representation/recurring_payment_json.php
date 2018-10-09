<?php 
	
	class RecurringPaymentJson {
		public $recorrencia;
    	public $estabelecimento;

    	public function __construct($recurringPayment) {
        	$this->recorrencia = $recurringPayment->recurringPaymentData;
        	$this->estabelecimento = $recurringPayment->storeCode;
    	}
	}

 ?>