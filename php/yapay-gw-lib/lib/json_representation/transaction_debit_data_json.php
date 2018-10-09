<?php 
	
	class TransactionDebitDataJson {
		public $agencia;
	    public $agenciaDigito;
	    public $conta;
	    public $contaDigito;
	    public $tipoConta;

	    public function __construct($transactionDebitData) {
	        $this->agencia = $transactionDebitData->agency;
		    $this->agenciaDigito = $transactionDebitData->agencyDigit;
		    $this->conta = $transactionDebitData->accountNumber;
		    $this->contaDigito = $transactionDebitData->accountNumberDigit;
		    $this->tipoConta = $transactionDebitData->accountType;
    	}
	}

 ?>