<?php 
	
	class TransactionDataJson {
		var $numeroTransacao;
		var $valor;
		var $valorDesconto;
		var $taxaEmbarque;
		var $parcelas;
		var $tipoParcelamento;
		var $urlCampainha;
		var $urlResultado;
		var $urlRedirecionamentoNaoPago;
		var $idioma;
		var $ip;
		var $browser;
		var $origemTransacao;
		var $campoLivre1;
		var $campoLivre2;
		var $campoLivre3;
		var $campoLivre4;
		var $campoLivre5;
		var $dataVencimentoBoleto;
		var $pais;
		var $moeda;
		var $pagamentoRecorrente;

		public function __construct($transactionData) {
	        $this->numeroTransacao = $transactionData->transactionNumber;
			$this->valor = $transactionData->value;
			$this->valorDesconto = $transactionData->discountValue;
			$this->taxaEmbarque = $transactionData->boardingFee;
			$this->parcelas = $transactionData->installments;
			$this->tipoParcelamento = $transactionData->installmentType;
			$this->urlCampainha = $transactionData->hintUrl;
			$this->urlResultado = $transactionData->resultUrl;
			$this->urlRedirecionamentoNaoPago = $transactionData->unpaidRedirectUrl;
			$this->idioma = $transactionData->idiom;
			$this->ip = $transactionData->ip;
			$this->browser = $transactionData->browser;
			$this->origemTransacao = $transactionData->transactionOrigin;
			$this->campoLivre1 = $transactionData->freeFieldOne;
			$this->campoLivre2 = $transactionData->freeFieldTwo;
			$this->campoLivre3 = $transactionData->freeFieldThree;
			$this->campoLivre4 = $transactionData->freeFieldFour;
			$this->campoLivre5 = $transactionData->freeFieldFive;
			$this->dataVencimentoBoleto = $transactionData->billDueDate;
			$this->pais = $transactionData->country;
			$this->moeda = $transactionData->currency;
			$this->pagamentoRecorrente = $transactionData->recurrentPayment;
    	}

	}

 ?>