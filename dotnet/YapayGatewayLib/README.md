Usage:

Install this dependency through NuGet https://www.nuget.org/packages/YapayGatewayLib.

Import your required builder and credentials Class.

After the creation of your required object, use one of us communication class to send to gateway.


```c#

Credential credential = new Credential();
           credential.user = "youCredential";
           credential.password = "yourPassword";

TransactionBuilder.NewTransaction(youStoreCode, paymentCode, transactionNumber, transactionValue);
TransactionBuilder.WithSingleCard(cardHoldername, cardNumber, cvv, expirationDate);
TransactionBuilder.WithCharging(chargingData);

Transaction transaction = TransactionBuilder.build();

 RestV3 restCommunication = new RestV3(new BaseURL().sandbox);

restCommunication.TransactionAuthorize(credential, transaction);
