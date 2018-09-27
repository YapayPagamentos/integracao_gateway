require_relative '../models/recurring_payment'
require_relative '../models/recurring_payment_data'
require_relative '../models/recurring_charging_data'
require_relative '../models/recurring_shipping_data'
require_relative '../models/transaction_phone_data'
require_relative '../models/transaction_card_data'
require_relative '../models/transaction_debit_data'

module Builder
    class RecurringPaymentBuilder
        def self.register_new_recurring_payment(store_code, payment_code, recurring_payment_number, value)
            @recurring_payment = RecurringPayment.new
            @recurring_payment.store_code = store_code
            @recurring_payment.recurring_payment_data = RecurringPaymentData.new
            @recurring_payment.recurring_payment_data.payment_code = payment_code
            @recurring_payment.recurring_payment_data.recurring_payment_number = recurring_payment_number
            @recurring_payment.recurring_payment_data.value = value
            @recurring_payment.recurring_payment_data.modality = 1
            @recurring_payment
        end

        def self.with_frequency_of(frequency)
            @recurring_payment.recurring_payment_data.frequency = frequency
            @recurring_payment
        end

        def self.set_notification_url(notification_url)
            @recurring_payment.recurring_payment_data.notification_url = notification_url
            @recurring_payment
        end

        def self.process_immediately?(process_immediately)
            @recurring_payment.recurring_payment_data.process_immediately = process_immediately
            @recurring_payment
        end

        def self.billing_options(billing_amount, billing_first_date, bill_due_date)
            @recurring_payment.recurring_payment_data.billing_amount = billing_amount
            @recurring_payment.recurring_payment_data.billing_first_date = billing_first_date
            @recurring_payment.recurring_payment_data.bill_due_date = bill_due_date
            @recurring_payment
        end

        def self.with_free_fields(free_field_one, free_field_two, free_field_three, free_field_four, free_field_five)
            @recurring_payment.recurring_payment_data.free_field_one = free_field_one
            @recurring_payment.recurring_payment_data.free_field_two = free_field_two
            @recurring_payment.recurring_payment_data.free_field_three = free_field_three
            @recurring_payment.recurring_payment_data.free_field_four = free_field_four
            @recurring_payment.recurring_payment_data.free_field_five = free_field_five
            @recurring_payment
        end

        def self.with_charging(recurring_charging_data)
            @recurring_payment.recurring_payment_data.recurring_charging_data = RecurringChargingData.new
            @recurring_payment.recurring_payment_data.recurring_charging_data.buyer_name = recurring_charging_data.buyer_name
            @recurring_payment.recurring_payment_data.recurring_charging_data.buyer_mail = recurring_charging_data.buyer_mail
            @recurring_payment.recurring_payment_data.recurring_charging_data.client_type = recurring_charging_data.client_type
            @recurring_payment.recurring_payment_data.recurring_charging_data.document = recurring_charging_data.document
            @recurring_payment.recurring_payment_data.recurring_charging_data.birthday = recurring_charging_data.birthday
            @recurring_payment.recurring_payment_data.recurring_charging_data.client_code = recurring_charging_data.client_code
            @recurring_payment.recurring_payment_data.recurring_charging_data.client_sex = recurring_charging_data.client_sex
            @recurring_payment.recurring_payment_data.recurring_charging_data.document_two = recurring_charging_data.document_two
            @recurring_payment.recurring_payment_data.recurring_charging_data.client_address_street = recurring_charging_data.client_address_street
            @recurring_payment.recurring_payment_data.recurring_charging_data.client_address_number = recurring_charging_data.client_address_number
            @recurring_payment.recurring_payment_data.recurring_charging_data.client_address_district = recurring_charging_data.client_address_district
            @recurring_payment.recurring_payment_data.recurring_charging_data.client_address_complement = recurring_charging_data.client_address_complement
            @recurring_payment.recurring_payment_data.recurring_charging_data.client_address_city = recurring_charging_data.client_address_city
            @recurring_payment.recurring_payment_data.recurring_charging_data.client_address_state = recurring_charging_data.client_address_state
            @recurring_payment.recurring_payment_data.recurring_charging_data.client_address_zipcode = recurring_charging_data.client_address_zipcode
            @recurring_payment.recurring_payment_data.recurring_charging_data.client_address_country = recurring_charging_data.client_address_country

            unless recurring_charging_data.client_phone.nil?
                @recurring_payment.recurring_payment_data.recurring_charging_data.client_phone = TransactionPhoneData.new
                @recurring_payment.recurring_payment_data.recurring_charging_data.client_phone.ddi = recurring_charging_data.client_phone.ddi
                @recurring_payment.recurring_payment_data.recurring_charging_data.client_phone.ddd = recurring_charging_data.client_phone.ddd
                @recurring_payment.recurring_payment_data.recurring_charging_data.client_phone.phone = recurring_charging_data.client_phone.phone
                @recurring_payment.recurring_payment_data.recurring_charging_data.client_phone.phone_type = recurring_charging_data.client_phone.phone_type
            end

            @recurring_payment
        end

        def self.with_credit_card(credit_card_data)
            @recurring_payment.recurring_payment_data.recurring_card_data = TransactionCardData.new
            @recurring_payment.recurring_payment_data.recurring_card_data.card_holder_name = credit_card_data.card_holder_name
            @recurring_payment.recurring_payment_data.recurring_card_data.card_number = credit_card_data.card_number
            @recurring_payment.recurring_payment_data.recurring_card_data.cvv = credit_card_data.cvv
            @recurring_payment.recurring_payment_data.recurring_card_data.expiration_date = credit_card_data.expiration_date
            @recurring_payment.recurring_payment_data.recurring_card_data.payment_code = credit_card_data.payment_code
            @recurring_payment.recurring_payment_data.recurring_card_data.installments = credit_card_data.installments
            @recurring_payment.recurring_payment_data.recurring_card_data.value = credit_card_data.value
            @recurring_payment

        end

        def self.with_debit_card(debit_card_data)
            @recurring_payment.recurring_payment_data.recurring_debit_data = TransactionDebitData.new
            @recurring_payment.recurring_payment_data.recurring_debit_data.agency = debit_card_data.agency
            @recurring_payment.recurring_payment_data.recurring_debit_data.agency_digit = debit_card_data.agency_digit
            @recurring_payment.recurring_payment_data.recurring_debit_data.account_number = debit_card_data.account_number
            @recurring_payment.recurring_payment_data.recurring_debit_data.account_number_digit = debit_card_data.account_number_digit
            @recurring_payment.recurring_payment_data.recurring_debit_data.account_type = debit_card_data.account_type
            @recurring_payment
        end

        def self.with_delivery(shipping_data)
            @recurring_payment.recurring_payment_data.recurring_shipping_data = RecurringShippingData.new
            @recurring_payment.recurring_payment_data.recurring_shipping_data.shipping_name = shipping_data.shipping_name
            @recurring_payment.recurring_payment_data.recurring_shipping_data.shipping_mail = shipping_data.shipping_mail
            @recurring_payment.recurring_payment_data.recurring_shipping_data.shipping_street = shipping_data.shipping_street
            @recurring_payment.recurring_payment_data.recurring_shipping_data.shipping_number = shipping_data.shipping_number
            @recurring_payment.recurring_payment_data.recurring_shipping_data.shipping_district = shipping_data.shipping_district
            @recurring_payment.recurring_payment_data.recurring_shipping_data.shipping_complement = shipping_data.shipping_complement
            @recurring_payment.recurring_payment_data.recurring_shipping_data.shipping_city = shipping_data.shipping_city
            @recurring_payment.recurring_payment_data.recurring_shipping_data.shipping_state = shipping_data.shipping_state
            @recurring_payment.recurring_payment_data.recurring_shipping_data.shipping_zipcode = shipping_data.shipping_zipcode
            @recurring_payment.recurring_payment_data.recurring_shipping_data.shipping_country = shipping_data.shipping_country
            
            unless shipping_data.shipping_phone.nil?
                @recurring_payment.recurring_payment_data.recurring_shipping_data.shipping_phone = TransactionPhoneData.new
                @recurring_payment.recurring_payment_data.recurring_shipping_data.shipping_phone.ddi = shipping_data.shipping_phone.ddi
                @recurring_payment.recurring_payment_data.recurring_shipping_data.shipping_phone.ddd = shipping_data.shipping_phone.ddd
                @recurring_payment.recurring_payment_data.recurring_shipping_data.shipping_phone.phone = shipping_data.shipping_phone.phone
                @recurring_payment.recurring_payment_data.recurring_shipping_data.shipping_phone.phone_type = shipping_data.shipping_phone.phone_type
            end

            @recurring_payment
        end
    end
end