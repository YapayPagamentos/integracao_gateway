Usage:

Set yapay-gw-lib folder in root of your project

Import your required builder and credentials Class.

After the creation of your required object, use one of us communication class to send to gateway.

## Example using PHP:


```php
	$builder = new TransactionBuilder();
	$builder->newTransaction(youStorecode, paymentMethodCode, transactionNumber, transactionValor);
	$builder->withSingleCreditCard(cardHolderName, creditCardNumber, cvv, expirationDate);


	$chargingData = new TransactionChargingData();
	$chargingDta->clientName = "";
	$chargingDta->clientDocument = "";

	$builder->withChargingData($chargingDta);

	$communication = new RestV3("https://sandbox.gateway.yapay.com.br/checkout");

	$credential = new Credential();
	$credential->user = "yourUser";
	$credential->password = "youPassword";

	$json_builder = new TransactionJsonBuilder;

	$transaction = $json_builder->newTransaction($builder->build());

	$communication->transactionAuthorize($credential, $transaction);

	$communication->transactionQuery($credential,youStoreCode, transactionNumber);
