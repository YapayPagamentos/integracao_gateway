require 'spec_helper'

RSpec.describe Builder::RecurringPaymentBuilder do


    before do
        @recurring_payment = Builder::RecurringPaymentBuilder.register_new_recurring_payment 1564560546, 145, 2000, 100
    end

    it "The Builder need to initialize a non-null RecurringPayment type object" do
        expect(@recurring_payment).not_to be nil
        expect(@recurring_payment).to be_an(RecurringPayment)
    end

    it "A new recurring payment need to start with modality eq one" do
        expect(@recurring_payment.recurring_payment_data.modality).to eq 1
    end

    it "You need to be able to set a frequency" do
        @recurring_payment = Builder::RecurringPaymentBuilder.with_frequency_of 6
        expect(@recurring_payment.recurring_payment_data.frequency).to eq 6
    end

    it "You can set the notification url" do
        @recurring_payment = Builder::RecurringPaymentBuilder.set_notification_url "https://google.com.br"
        expect(@recurring_payment.recurring_payment_data.notification_url).to eq "https://google.com.br"
    end

    it "Choose if you want process it immediately" do
        @recurring_payment = Builder::RecurringPaymentBuilder.process_immediately? true
        expect(@recurring_payment.recurring_payment_data.process_immediately).to eq true
        @recurring_payment = Builder::RecurringPaymentBuilder.process_immediately? false
        expect(@recurring_payment.recurring_payment_data.process_immediately).to eq false
    end

    it "Set your billing options" do
        @recurring_payment = Builder::RecurringPaymentBuilder.billing_options 6, 1, 20
        expect(@recurring_payment.recurring_payment_data.billing_first_date).to eq 1
        expect(@recurring_payment.recurring_payment_data.billing_amount).to eq 6
        expect(@recurring_payment.recurring_payment_data.bill_due_date).to eq 20
    end

    it "You need to be able to set free fields if you want" do
        @recurring_payment = Builder::RecurringPaymentBuilder.with_free_fields nil, "It's free field 2", nil, "It's free field 4", nil
        expect(@recurring_payment.recurring_payment_data.free_field_one).to eq nil
        expect(@recurring_payment.recurring_payment_data.free_field_two).to eq "It's free field 2"
        expect(@recurring_payment.recurring_payment_data.free_field_three).to eq nil
        expect(@recurring_payment.recurring_payment_data.free_field_four).to eq "It's free field 4"
        expect(@recurring_payment.recurring_payment_data.free_field_five).to eq nil
    end

    it "Set charging infos" do
        charging_info = RecurringChargingData.new
        charging_info.buyer_name = "IVAN SIMIONATO"
        charging_info.buyer_mail = "ivan.simionato@yapay.com.br"
        charging_info.document_two = "JH423J4111"
        charging_info.client_address_zipcode = "123123123"
        charging_info.client_address_district = "Capão"
        charging_info.client_code = "321321321"
        charging_info.client_sex = "M"

        @recurring_payment = Builder::RecurringPaymentBuilder.with_charging charging_info

        expect(@recurring_payment.recurring_payment_data.recurring_charging_data.client_sex).to eq "M"
        expect(@recurring_payment.recurring_payment_data.recurring_charging_data.buyer_mail).to eq "ivan.simionato@yapay.com.br"
        expect(@recurring_payment.recurring_payment_data.recurring_charging_data.client_phone).to eq nil
    end

    it "Insert the credit card" do
        credit_card = TransactionCardData.new
        credit_card.card_holder_name = "IVAN SIMIONATO"
        credit_card.card_number = 123123123123
        credit_card.cvv = 1234
        credit_card.expiration_date = "12/2020"
        credit_card.payment_code = 140
        credit_card.installments = 2
        credit_card.value = 123

        @recurring_payment = Builder::RecurringPaymentBuilder.with_credit_card credit_card

        expect(@recurring_payment.recurring_payment_data.recurring_card_data.expiration_date).to eq "12/2020"
        expect(@recurring_payment.recurring_payment_data.recurring_card_data.cvv).to eq 1234
        expect(@recurring_payment.recurring_payment_data.recurring_card_data.value).to eq 123
    end

    it "Or insert the debit card informations" do
        debit_card = TransactionDebitData.new
        debit_card.agency = "SP"
        debit_card.agency_digit = "123"
        debit_card.account_number = "45678"
        debit_card.account_number_digit = "7"
        debit_card.account_type = "PF"

        @recurring_payment = Builder::RecurringPaymentBuilder.with_debit_card debit_card

        expect(@recurring_payment.recurring_payment_data.recurring_debit_data.agency).to eq "SP"
        expect(@recurring_payment.recurring_payment_data.recurring_debit_data.account_type).to eq "PF"
        expect(@recurring_payment.recurring_payment_data.recurring_debit_data.account_number_digit).to eq "7"

    end

    it "Insert shipping informations" do
        shipping_info = RecurringShippingData.new
        shipping_info.shipping_name = "IVAN"
        shipping_info.shipping_mail = "ivan.simionato@yapay.com.br"
        shipping_info.shipping_street = "teste"
        shipping_info.shipping_number = "123"
        shipping_info.shipping_district = "SP"
        shipping_info.shipping_phone = TransactionPhoneData.new
        shipping_info.shipping_phone.ddd = "11"

        @recurring_payment = Builder::RecurringPaymentBuilder.with_delivery shipping_info
    end

end