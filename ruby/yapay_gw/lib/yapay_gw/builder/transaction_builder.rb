require_relative '../models/transaction'
require_relative '../models/transaction_data'
require_relative '../models/transaction_card_data'
require_relative '../models/transaction_item_data'
require_relative '../models/transaction_charging_data'
require_relative '../models/transaction_phone_data'
require_relative '../models/transaction_extra_field'
require_relative '../models/transaction_adress_data'
require_relative '../models/transaction_delivery_data'

module Builder
    class TransactionBuilder
        def self.new_transaction(store_code, payment_code, transaction_number, value)
            @transaction = Transaction.new
            @transaction.store_code = store_code
            @transaction.payment_code = payment_code
            @transaction.transaction_data = TransactionData.new
            @transaction.transaction_data.transaction_number = transaction_number
            @transaction.transaction_data.value = value
            @transaction.transaction_data.installments = 1
            @transaction
        end

        def self.with_installments(installments)
            @transaction.transaction_data.installments = installments
            @transaction
        end

        def self.with_single_credit_card(card_holder_name, card_number, cvv, expiration_date)
            @transaction.transaction_card_data = TransactionCardData.new
            @transaction.transaction_card_data.card_holder_name = card_holder_name
            @transaction.transaction_card_data.card_number = card_number
            @transaction.transaction_card_data.cvv = cvv
            @transaction.transaction_card_data.expiration_date = expiration_date
            @transaction
        end

        def self.with_items(array_of_transaction_item)
            items_array = Array.new
            Array(array_of_transaction_item).each do |transaction_item|
                item = TransactionItemData.new
                item.product_code = transaction_item.product_code
                item.product_category = transaction_item.product_category
                item.product_name = transaction_item.product_name
                item.product_amount = transaction_item.product_amount
                item.product_unitary_value = transaction_item.product_unitary_value
                item.category_name = transaction_item.category_name
                items_array.push item
            end
            @transaction.transaction_item_data = items_array
            @transaction
        end

        def self.with_charging_data(transaction_charging_data)
            @transaction.transaction_charging_data = TransactionChargingData.new
            @transaction.transaction_charging_data.client_code = transaction_charging_data.client_code
            @transaction.transaction_charging_data.client_type = transaction_charging_data.client_type
            @transaction.transaction_charging_data.client_name = transaction_charging_data.client_name
            @transaction.transaction_charging_data.client_email = transaction_charging_data.client_email
            @transaction.transaction_charging_data.client_birthday = transaction_charging_data.client_birthday
            @transaction.transaction_charging_data.client_sex = transaction_charging_data.client_sex
            @transaction.transaction_charging_data.client_document = transaction_charging_data.client_document
            @transaction.transaction_charging_data.client_document_two = transaction_charging_data.client_document_two
            
            unless transaction_charging_data.client_charging_adress_data.nil?
                client_adress_data = TransactionAdressData.new
                client_adress_data.street = transaction_charging_data.client_charging_adress_data.street
                client_adress_data.number = transaction_charging_data.client_charging_adress_data.number
                client_adress_data.complement = transaction_charging_data.client_charging_adress_data.complement
                client_adress_data.zip_code = transaction_charging_data.client_charging_adress_data.zip_code
                client_adress_data.district = transaction_charging_data.client_charging_adress_data.district
                client_adress_data.city = transaction_charging_data.client_charging_adress_data.city
                client_adress_data.state = transaction_charging_data.client_charging_adress_data.state
                client_adress_data.country = transaction_charging_data.client_charging_adress_data.country
                @transaction.transaction_charging_data.client_charging_adress_data = client_adress_data
            end
            
            unless transaction_charging_data.client_charging_phone_data.nil?
                charging_phones = Array.new
                Array(transaction_charging_data.client_charging_phone_data).each do |charging_phone_data|
                    phone = TransactionPhoneData.new
                    phone.ddi = charging_phone_data.ddi
                    phone.ddd = charging_phone_data.ddd
                    phone.phone = charging_phone_data.phone
                    phone.type = charging_phone_data.type
                    charging_phones.push phone
                end
                @transaction.transaction_charging_data.client_charging_phone_data = charging_phones
            end

            @transaction
        end

        def self.include_extra_fields(array_of_extra_fields)
            extra_fields = Array.new
            Array(array_of_extra_fields).each do |extra_field_item|
                extra_field = TransactionExtraField.new
                extra_field.key = extra_field_item.key
                extra_field.value = extra_field_item.value
                extra_fields.push extra_field
            end
            @transaction.transaction_extra_fields = extra_fields  
            @transaction
        end

        def self.with_delivery_data(delivery_data)
            unless delivery_data.nil?
                transaction_delivery_data = TransactionDeliveryData.new
                transaction_delivery_data.name = delivery_data.name
                transaction_delivery_data.mail = delivery_data.mail
                transaction_delivery_data.birthday = delivery_data.birthday
                transaction_delivery_data.sex = delivery_data.sex
                transaction_delivery_data.document = delivery_data.document
                transaction_delivery_data.document_two = delivery_data.document_two

                unless delivery_data.delivery_address_data.nil?
                    delivery_adress_data = TransactionAdressData.new
                    delivery_adress_data.street = delivery_data.delivery_address_data.street
                    delivery_adress_data.number = delivery_data.delivery_address_data.number
                    delivery_adress_data.complement = delivery_data.delivery_address_data.complement
                    delivery_adress_data.zip_code = delivery_data.delivery_address_data.zip_code
                    delivery_adress_data.district = delivery_data.delivery_address_data.district
                    delivery_adress_data.city = delivery_data.delivery_address_data.city
                    delivery_adress_data.state = delivery_data.delivery_address_data.state
                    delivery_adress_data.country = delivery_data.delivery_address_data.country
                    transaction_delivery_data.delivery_address_data = delivery_adress_data
                end

                unless delivery_data.delivery_phone_data.nil?
                    delivery_phones = Array.new
                    Array(delivery_data.delivery_phone_data).each do |phone_data|
                        phone = TransactionPhoneData.new
                        phone.ddi = phone_data.ddi
                        phone.ddd = phone_data.ddd
                        phone.phone = phone_data.phone
                        phone.type = phone_data.type
                        delivery_phones.push phone
                    end
                    transaction_delivery_data.delivery_phone_data = delivery_phones
                end
                
                @transaction.transaction_delivery_data = transaction_delivery_data
            end
            @transaction
        end
    end
end