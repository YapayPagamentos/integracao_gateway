<?php 
	
	class OneclickRegisterDataJson {
		var $codigoEstabelecimento;
	    var $nomeTitularCartaoCredito;
	    var $numeroCartaoCredito;
	    var $dataValidadeCartao;
	    var $emailComprador;
	    var $formaPagamento;

		public function __construct($oneClickRegisterData) {
		   $this->codigoEstabelecimento = $oneClickRegisterData->storeCode;
		   $this->nomeTitularCartaoCredito = $oneClickRegisterData->cardHolderName;
		   $this->numeroCartaoCredito = $oneClickRegisterData->cardNumber;
		   $this->dataValidadeCartao = $oneClickRegisterData->expirationDate;
		   $this->emailComprador = $oneClickRegisterData->buyerEmail;
		   $this->formaPagamento = $oneClickRegisterData->paymentCode;
	    }
	}

 ?>