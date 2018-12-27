using System;
using System.Collections.Generic;
using YapayGatewayLib.Model;

namespace YapayGatewayLib.Builder
{
    public class TransactionBuilder
    {

        private static Transaction transaction;

        public static Transaction build()
        {

            Transaction newTransaction = transaction;
            transaction = null;
            return newTransaction;
        }


        public static void NewTransaction(string storeCode, int paymentCode, long transactionNumber, long value)
        {
            transaction = new Transaction();
            transaction.transactionData = new TransactionData();
            transaction.storeCode = storeCode;
            transaction.paymentCode = paymentCode;
            transaction.transactionData.transactionNumber = transactionNumber;
            transaction.transactionData.value = value;
        }

        public static void WithInstallments(int installments)
        {
            transaction.transactionData.installments = installments;
        }

        public static void WithSingleCard(string cardHolderName, string cardNumber, string cvv, string expirationDate)
        {
            transaction.card = new CardData();
            transaction.card.cardHolderName = cardHolderName;
            transaction.card.cardNumber = cardNumber;
            transaction.card.cvv = cvv;
            transaction.card.expirationDate = expirationDate;
        }


        public static void WithItems(List<ItemData> listOfItems)
        {
            List<ItemData> newListOfItems = new List<ItemData>();

            foreach (var item in listOfItems)
            {
                ItemData newItem = new ItemData();
                newItem.categoryName = item.categoryName;
                newItem.productAmount = item.productAmount;
                newItem.productCategory = item.productCategory;
                newItem.productCode = item.productCode;
                newItem.productName = item.productName;
                newItem.productUnitaryValue = item.productUnitaryValue;
                newListOfItems.Add(newItem);
            }

            transaction.items = newListOfItems;
        }

        public static void WithExtraFields(List<ExtraField> listOfExtraFields)
        {
            List<ExtraField> newListOfExtraFields = new List<ExtraField>();

            foreach (var extraField in listOfExtraFields)
            {
                ExtraField newExtraField = new ExtraField();
                newExtraField.key = extraField.key;
                newExtraField.value = extraField.value;
                newListOfExtraFields.Add(newExtraField);
            }

            transaction.extraFields = newListOfExtraFields;
        }

        public static void WithDelivery(DeliveryData deliveryData)
        {
            transaction.delivery = new DeliveryData();
            transaction.delivery.birthday = deliveryData.birthday;
            transaction.delivery.document = deliveryData.document;
            transaction.delivery.documentTwo = deliveryData.documentTwo;
            transaction.delivery.mail = deliveryData.mail;
            transaction.delivery.name = deliveryData.name;
            transaction.delivery.sex = deliveryData.sex;

            if (deliveryData.deliveryAddress != null)
            {
                transaction.delivery.deliveryAddress = new AddressData();
                transaction.delivery.deliveryAddress.city = deliveryData.deliveryAddress.city;
                transaction.delivery.deliveryAddress.complement = deliveryData.deliveryAddress.complement;
                transaction.delivery.deliveryAddress.country = deliveryData.deliveryAddress.country;
                transaction.delivery.deliveryAddress.district = deliveryData.deliveryAddress.district;
                transaction.delivery.deliveryAddress.number = deliveryData.deliveryAddress.number;
                transaction.delivery.deliveryAddress.state = deliveryData.deliveryAddress.state;
                transaction.delivery.deliveryAddress.street = deliveryData.deliveryAddress.street;
            }

            if (deliveryData.deliveryPhone != null && deliveryData.deliveryPhone.Count > 0)
            {
                List<PhoneData> newPhoneList = new List<PhoneData>();
                foreach (var phone in deliveryData.deliveryPhone)
                {
                    PhoneData newPhone = new PhoneData();
                    newPhone.ddd = phone.ddd;
                    newPhone.ddi = phone.ddi;
                    newPhone.phone = phone.phone;
                    newPhone.phoneType = phone.phoneType;
                    newPhoneList.Add(newPhone);
                }

                transaction.delivery.deliveryPhone = newPhoneList;
            }

        }

        public static void WithCharging(ChargingData chargingData)
        {
            transaction.charging = new ChargingData();
            transaction.charging.clientBirthday = chargingData.clientBirthday;
            transaction.charging.clientCode = chargingData.clientCode;
            transaction.charging.clientDocument = chargingData.clientDocument;
            transaction.charging.clientDocumentTwo = chargingData.clientDocumentTwo;
            transaction.charging.clientEmail = chargingData.clientEmail;
            transaction.charging.clientName = chargingData.clientName;
            transaction.charging.clientSex = chargingData.clientSex;
            transaction.charging.clientType = chargingData.clientType;

            if (chargingData.clientChargingAdress != null)
            {
                transaction.charging.clientChargingAdress = new AddressData();
                transaction.charging.clientChargingAdress.city = chargingData.clientChargingAdress.city;
                transaction.charging.clientChargingAdress.complement = chargingData.clientChargingAdress.complement;
                transaction.charging.clientChargingAdress.country = chargingData.clientChargingAdress.country;
                transaction.charging.clientChargingAdress.district = chargingData.clientChargingAdress.district;
                transaction.charging.clientChargingAdress.number = chargingData.clientChargingAdress.number;
                transaction.charging.clientChargingAdress.state = chargingData.clientChargingAdress.state;
                transaction.charging.clientChargingAdress.street = chargingData.clientChargingAdress.street;
                transaction.charging.clientChargingAdress.zipCode = chargingData.clientChargingAdress.zipCode;
            }

            if (chargingData.clientChargingPhone != null && chargingData.clientChargingPhone.Count > 0)
            {
                List<PhoneData> newPhones = new List<PhoneData>();

                foreach (var phone in chargingData.clientChargingPhone)
                {
                    PhoneData newPhone = new PhoneData();
                    newPhone.ddd = phone.ddd;
                    newPhone.ddi = phone.ddi;
                    newPhone.phone = phone.phone;
                    newPhone.phoneType = phone.phoneType;
                    newPhones.Add(newPhone);
                }

                transaction.charging.clientChargingPhone = newPhones;
            }

        }

    }
}