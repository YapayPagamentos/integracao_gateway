<?php 
	
	class TransactionDataJson {
		public $numeroTransacao;
		public $valor;
		public $valorDesconto;
		public $taxaEmbarque;
		public $parcelas;
		public $tipoParcelamento;
		public $urlCampainha;
		public $urlResultado;
		public $urlRedirecionamentoNaoPago;
		public $idioma;
		public $ip;
		public $browser;
		public $origemTransacao;
		public $campoLivre1;
		public $campoLivre2;
		public $campoLivre3;
		public $campoLivre4;
		public $campoLivre5;
		public $dataVencimentoBoleto;
		public $pais;
		public $moeda;
		public $pagamentoRecorrente;

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