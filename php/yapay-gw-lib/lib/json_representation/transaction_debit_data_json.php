<?php 
	
	class TransactionDebitDataJson {
		var $agencia;
	    var $agenciaDigito;
	    var $conta;
	    var $contaDigito;
	    var $tipoConta;

	    public function __construct($transactionDebitData) {
	        $this->agencia = $transactionDebitData->agency;
		    $this->agenciaDigito = $transactionDebitData->agencyDigit;
		    $this->conta = $transactionDebitData->accountNumber;
		    $this->contaDigito = $transactionDebitData->accountNumberDigit;
		    $this->tipoConta = $transactionDebitData->accountType;
    	}
	}

 ?>