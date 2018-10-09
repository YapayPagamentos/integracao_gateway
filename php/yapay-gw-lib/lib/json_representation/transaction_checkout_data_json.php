<?php 
	
	class TransactionCheckoutDataJson {
		var $processar;
	    var $tipoPagamento;
	    var $multiploCartao;
	    var $multiploBoleto;
	    var $boletos;

	    public function __construct($transactionCheckoutData) {
	        $this->processar = $transactionCheckoutData->process;
		    $this->tipoPagamento = $transactionCheckoutData->paymentType;
		    $this->multiploCartao = $transactionCheckoutData->multipleCard;
		    $this->multiploBoleto = $transactionCheckoutData->multipleBill;
		    $this->boletos = $transactionCheckoutData->multipleBillData;
    	}
	}

 ?>