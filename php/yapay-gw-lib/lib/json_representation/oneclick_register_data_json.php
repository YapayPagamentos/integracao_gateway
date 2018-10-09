<?php 
	
	class OneclickRegisterDataJson {
		public $codigoEstabelecimento;
	    public $nomeTitularCartaoCredito;
	    public $numeroCartaoCredito;
	    public $dataValidadeCartao;
	    public $emailComprador;
	    public $formaPagamento;

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