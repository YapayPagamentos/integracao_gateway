<?php 
	
	class TransactionCardDataJson {
		public $nomePortador;
	    public $numeroCartao;
	    public $codigoSeguranca;
	    public $dataValidade;
	    public $codigoFormaPagamento;
	    public $parcelas;
	    public $valor;

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