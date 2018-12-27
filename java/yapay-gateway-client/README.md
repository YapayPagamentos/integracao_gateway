# Gateway Client

Gateway Client is a Java Library designed to facilitate the communication with [Yapay Gateway API](https://www.yapay.com.br/gateway-de-pagamento/). The customers are able to create, query, cancel and confirm their e-commerce sales with ease.

In order to know more about the offered services or subscribe to one of the plans available, [Go To Yapay](https://www.yapay.com.br). For general guidance check the [Documentation](https://gateway.dev.yapay.com.br/#/).


### Download

Gradle:

```gradle
dependencies {
       compile "br.com.yapay.gateway:yapay-gateway-client:1.0.5"
}
```

Maven:

```xml
<dependency>
  <groupId>br.com.yapay.gateway</groupId>
  <artifactId>yapay-gateway-client</artifactId>
  <version>1.0.5</version>
</dependency>
```

### Usage
- Transaction authorization:
 
```java
String storeCode = "9999999999999";
String storeLogin = "login";
String storePassword = "password";
Credential credential = new Credential(storeLogin, storePassword, storeCode);

Long orderId = 9L;
Transaction transaction = Transaction.getBuilder(credential, orderId)
                         .withPaymentCode(170)
                         .withValue(BigDecimal.TEN)
                         .withCard("CARD HOLDER NAME", "4444333322221111", 12, 2022, "123")
                         .withCharging("Buyer Name", "buyer@email.com", "123.456.789-00")
                         .withChargingAddress("R Itapaiuna", "2434", "05707-001", "Jardim Morumbi", "Sao Paulo", "SP")
                         .addChargingPhone("11", "55551234")
                         .addItem("Hot Wheels", 10, BigDecimal.ONE)
                         .build();

ApiConnector apiConn = new RestV3(GatewayUrl.SANDBOX);

ApiResponse response = apiConn.transactionAuthorize(transaction);
ApiResponseContent content = response.getResponseContent();

System.out.println("Message: " + content.getSaleMessage());
System.out.println("Status: " + content.getTransactionStatus());

```

- Transaction query:

```java
Transaction transaction = Transaction.getBuilder(credential, orderId).build();
ApiConnector apiConn = new RestV3(GatewayUrl.SANDBOX);

ApiResponse response = apiConn.transactionQuery(transaction);
ApiResponseContent content = response.getResponseContent();

System.out.println("Message: " + content.getSaleMessage());
System.out.println("Status: " + content.getTransactionStatus());

```

- Transaction refund:

```java
Transaction transaction = Transaction.getBuilder(credential, orderId).build();
ApiConnector apiConn = new RestV3(GatewayUrl.SANDBOX);

ApiResponse response = apiConn.transactionCancel(transaction);
ApiResponseContent content = response.getResponseContent();

System.out.println("Message: " + content.getSaleMessage());
System.out.println("Status: " + content.getTransactionStatus());

```

- Transaction confirmation:

```java
Transaction transaction = Transaction.getBuilder(credential, orderId).build();
ApiConnector apiConn = new RestV3(GatewayUrl.SANDBOX);

ApiResponse response = apiConn.transactionCapture(transaction);
ApiResponseContent content = response.getResponseContent();

System.out.println("Message: " + content.getSaleMessage());
System.out.println("Status: " + content.getTransactionStatus());

```
