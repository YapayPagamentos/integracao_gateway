require 'spec_helper'

RSpec.describe Builder::TransactionBuilder do

    before do
        @transaction = Builder::TransactionBuilder.new_transaction 15000010, 150, 100001, 100
    end

    it "The Builder need to initialize a non-null Transaction type object" do
        expect(@transaction).not_to be nil
        expect(@transaction).to be_an(Transaction)
    end

    it "Must be initialized too the transaction data informations" do
        expect(@transaction.transaction_data).not_to be nil
    end

    it "That should be an object of TransactonData type object" do
        expect(@transaction.transaction_data).to be_an(TransactionData)
    end

    it "A new transaction always start with 1 installments" do
        expect(@transaction.transaction_data.installments).to eq 1
    end

    it "You should be able to set the installments with the builder" do
        @transaction = Builder::TransactionBuilder.with_installments(2)
        expect(@transaction.transaction_data.installments).to eq 2
    end

    it "You should be able to set the single payment card information with the builder" do
        @transaction = Builder::TransactionBuilder.with_single_card("IVAN SIMIONATO", 1234567890, 1234, "10/2020")
        expect(@transaction.transaction_card_data).not_to be nil
        expect(@transaction.transaction_card_data).to be_an(TransactionCardData)
        expect(@transaction.transaction_card_data.card_holder_name).to eq "IVAN SIMIONATO"
    end

    it "You should include a array of extra fields to transaction through the builder" do
        extra_field_1 = TransactionExtraField.new
        extra_field_1.key = 1001
        extra_field_1.value = "This is extra field one!"
        extra_field_2 = TransactionExtraField.new
        extra_field_2.key = 1002
        extra_field_2.value = "This is extra field two!"
        extra_fields = Array.new
        extra_fields.push extra_field_1, extra_field_2

        @transaction = Builder::TransactionBuilder.include_extra_fields(extra_fields)
        expect(@transaction.transaction_extra_fields.size).to eq 2
    end
    
    it "Builder should prevent null pointer when pass a nil array to include extra fields" do
        @transaction = Builder::TransactionBuilder.include_extra_fields(nil)
        expect(@transaction.transaction_extra_fields.size).to eq 0
    end

    it "You should be able to include charging data through the builder" do

        charging_data = TransactionChargingData.new
        charging_data.client_code = "423421"
        charging_data.client_type = 1
        charging_data.client_name = "IVAN"
        charging_data.client_email = "ivan@teste.com.br"
        charging_data.client_birthday = "26/07/1994"
        charging_data.client_sex = "M"
        charging_data.client_document = "1234"
        charging_data.client_document_two = "5678"
        
        @transaction = Builder::TransactionBuilder.with_charging_data(charging_data)
        expect(@transaction.transaction_charging_data).not_to be nil
        expect(@transaction.transaction_charging_data).to be_an(TransactionChargingData)
    end

    

  end
  