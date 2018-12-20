<?php 

	require_once "../yapay-gw-lib/lib/json_representation/transaction_json.php";
	require_once "../yapay-gw-lib/lib/json_representation/transaction_data_json.php";
	require_once "../yapay-gw-lib/lib/json_representation/transaction_card_data_json.php";
	require_once "../yapay-gw-lib/lib/json_representation/transaction_debit_data_json.php";
	require_once "../yapay-gw-lib/lib/json_representation/transaction_item_data_json.php";
	require_once "../yapay-gw-lib/lib/json_representation/transaction_extra_field_json.php";

	class TransactionJsonBuilder{
		

		public function newTransaction($transaction){
			$jsonTransaction = new TransactionJson($transaction);
			$jsonTransaction->transacao = $this->newTransactionData($transaction->transactionData);
			$jsonTransaction->dadosCartao = $this->newTransactionCardData($transaction->transactionCardData);
			$jsonTransaction->dadosDebito = $this->newTransactionDebitData($transaction->transactionDebitData);
			$jsonTransaction->itensDoPedido = $this->newTransactionItemData($transaction->transactionItemData);
			$jsonTransaction->camposExtras = $this->newTransactionExtraFields($transaction->transactionExtraFields);

			return $jsonTransaction;
		}

		public function newTransactionData($transactionData){
			$jsonTransactionData = new TransactionDataJson($transactionData);

			return $jsonTransactionData;
		}

		public function newTransactionCardData($transactionCardData){
			$jsonTransactionCardData = new TransactionCardDataJson($transactionCardData);

			return $jsonTransactionCardData;
		}

		public function newTransactionDebitData($transactionDebitData){
			$jsonTransactionDebitData = new TransactionDebitDataJson($transactionDebitData);

			return $jsonTransactionDebitData;
		}

		public function newTransactionItemData($transactionItemData){
			$jsonArrayOfItems = array();

			foreach ($transactionItemData as $originalItem) {
				$jsonRepresentationOfItem = new TransactionItemDataJson($originalItem);
				array_push($jsonArrayOfItems, $jsonRepresentationOfItem);
			}

			return $jsonArrayOfItems;
		}

		public function newTransactionExtraFields($transactionExtraFields){
			$jsonArrayOfExtraFields = array();

			foreach ($transactionExtraFields as $originalExtraField) {
				$jsonRepresentationOfExtraField = new TransactionExtraFieldJson($originalExtraField);
				array_push($jsonArrayOfExtraFields, $jsonRepresentationOfExtraField);
			}

			return $jsonArrayOfExtraFields;
		}


	}

 ?>