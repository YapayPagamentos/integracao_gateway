<?php 
	
	class RecurringPaymentDataJson {
		public $formaPagamento;
	    public $numeroRecorrencia
	    public $valor;
	    public $modalidade;
	    public $periodicidade;
	    public $urlNotificacao;
	    public $processarImediatamente;
	    public $quantidadeCobrancas;
	    public $dataPrimeiraCobranca;
	    public $vencimentoBoleto;
	    public $campoLivre1;
	    public $campoLivre2;
	    public $campoLivre3;
	    public $campoLivre4;
	    public $campoLivre5;
	    public $dadosCobranca;
	    public $dadosCartao;
	    public $dadosDebito;
	    public $dadosEntrega;

	    public function __construct($recurringPaymentData) {
	        $this->formaPagamento = $recurringPaymentData->paymentCode;
		    $this->numeroRecorrencia = $recurringPaymentData->recurringPaymentNumber;
		    $this->valor = $recurringPaymentData->value;
		    $this->modalidade = $recurringPaymentData->modality;
		    $this->periodicidade = $recurringPaymentData->frequency;
		    $this->urlNotificacao = $recurringPaymentData->notificationUrl;
		    $this->processarImediatamente = $recurringPaymentData->processImmediately;
		    $this->quantidadeCobrancas = $recurringPaymentData->billingAmount;
		    $this->dataPrimeiraCobranca = $recurringPaymentData->billingFirstDate;
		    $this->vencimentoBoleto = $recurringPaymentData->billDueDate;
		    $this->campoLivre1 = $recurringPaymentData->freeFieldOne;
		    $this->campoLivre2 = $recurringPaymentData->freeFieldTwo;
		    $this->campoLivre3 = $recurringPaymentData->freeFieldThree;
		    $this->campoLivre4 = $recurringPaymentData->freeFieldFour;
		    $this->campoLivre5 = $recurringPaymentData->freeFieldFive;
		    $this->dadosCobranca = $recurringPaymentData->recurringChargingData;
		    $this->dadosCartao = $recurringPaymentData->recurringCardData;
		    $this->dadosDebito = $recurringPaymentData->recurringDebitData;
		    $this->dadosEntrega = $recurringPaymentData->recurringShippingData;
    	}
	}

 ?>