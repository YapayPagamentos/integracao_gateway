<?php 
	
	class RecurringPaymentDataJson {
		var $formaPagamento;
	    var $numeroRecorrencia
	    var $valor;
	    var $modalidade;
	    var $periodicidade;
	    var $urlNotificacao;
	    var $processarImediatamente;
	    var $quantidadeCobrancas;
	    var $dataPrimeiraCobranca;
	    var $vencimentoBoleto;
	    var $campoLivre1;
	    var $campoLivre2;
	    var $campoLivre3;
	    var $campoLivre4;
	    var $campoLivre5;
	    var $dadosCobranca;
	    var $dadosCartao;
	    var $dadosDebito;
	    var $dadosEntrega;

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