<?php 

class TransactionAddressDataJson {
    public $logradouro;
    public $numero;
    public $complemento;
    public $cep;
    public $bairro;
    public $cidade;
    public $estado;
    public $pais;

    public function __construct($transactionAddressData) {
        $this->logradouro = $transactionAddressData->street;
	$this->numero = $transactionAddressData->number;
	$this->complemento = $transactionAddressData->complement;
	$this->cep = $transactionAddressData->zipCode;
	$this->bairro = $transactionAddressData->district;
	$this->cidade = $transactionAddressData->city;
	$this->estado = $transactionAddressData->state;
	$this->pais = $transactionAddressData->country;
    }

}

?>
