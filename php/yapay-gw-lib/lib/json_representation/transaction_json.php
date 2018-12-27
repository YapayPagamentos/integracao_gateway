<?php 
	
	class TransactionJson {
		public $codigoEstabelecimento;
	    public $codigoFormaPagamento;
	    public $transacao;
	    public $checkout;
	    public $dadosCartao;
	    public $dadosMultiplosCartoes;
	    public $dadosDebito;
	    public $itensDoPedido;
	    public $dadosCobranca;
	    public $dadosEntrega;
	    public $camposExtras;


	    public function __construct($transaction) {
        	$this->codigoEstabelecimento = $transaction->storeCode;
        	$this->codigoFormaPagamento = $transaction->paymentCode;
	        $this->transacao = $transaction->transactionData;
		    $this->checkout = $transaction->transactionCheckoutData;
		    $this->dadosCartao = $transaction->transactionCardData;
		    $this->dadosMultiplosCartoes = $transaction->transactionMultipleCardData;
		    $this->dadosDebito = $transaction->transactionDebitData;
		    $this->itensDoPedido = $transaction->transactionItemData;
		    $this->dadosCobranca = $transaction->transactionChargingData;
		    $this->dadosEntrega = $transaction->transactionDeliveryData;
		    $this->camposExtras = $transaction->transactionExtraFields;
    	}
	}

 ?>