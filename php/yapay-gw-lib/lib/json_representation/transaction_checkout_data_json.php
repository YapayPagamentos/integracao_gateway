<?php 
	
	class TransactionCheckoutDataJson {
		public $processar;
	    public $tipoPagamento;
	    public $multiploCartao;
	    public $multiploBoleto;
	    public $boletos;

	    public function __construct($transactionCheckoutData) {
	        $this->processar = $transactionCheckoutData->process;
		    $this->tipoPagamento = $transactionCheckoutData->paymentType;
		    $this->multiploCartao = $transactionCheckoutData->multipleCard;
		    $this->multiploBoleto = $transactionCheckoutData->multipleBill;
		    $this->boletos = $transactionCheckoutData->multipleBillData;
    	}
	}

 ?>