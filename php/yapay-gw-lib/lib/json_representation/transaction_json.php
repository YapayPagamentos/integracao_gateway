<?php 
	
	class TransactionJson {
		var $codigoEstabelecimento;
	    var $codigoFormaPagamento;
	    var $transacao;
	    var $checkout;
	    var $dadosCartao;
	    var $dadosMultiplosCartoes;
	    var $dadosDebito;
	    var $itensDoPedido;
	    var $dadosCobranca;
	    var $dadosEntrega;
	    var $dadosAirline;
	    var $camposExtras;


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
		    $this->dadosAirline = $transaction->transactionAirlineData;
		    $this->camposExtras = $transaction->transactionExtraFields;
    	}
	}

 ?>