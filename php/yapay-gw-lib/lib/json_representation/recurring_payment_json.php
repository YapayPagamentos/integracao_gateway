<?php 
	
	class RecurringPaymentJson {
		var $recorrencia;
    	var $estabelecimento;

    	public function __construct($recurringPayment) {
        	$this->recorrencia = $recurringPayment->recurringPaymentData;
        	$this->estabelecimento = $recurringPayment->storeCode;
    	}
	}

 ?>