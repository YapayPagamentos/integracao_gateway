<?php 
	
	class TransactionCardDataJson {
		var $nomePortador;
	    var $numeroCartao;
	    var $codigoSeguranca;
	    var $dataValidade;
	    var $codigoFormaPagamento;
	    var $parcelas;
	    var $valor;

	    public function __construct($transactionCardData) {
			$this->nomePortador = $transactionCardData->cardHolderName;
			$this->numeroCartao = $transactionCardData->cardNumber;
			$this->codigoSeguranca = $transactionCardData->cvv;
			$this->dataValidade = $transactionCardData->expirationDate;
			$this->codigoFormaPagamento = $transactionCardData->paymentCode;
			$this->parcelas = $transactionCardData->installments;
			$this->valor = $transactionCardData->value;
    	}

	}

 ?>