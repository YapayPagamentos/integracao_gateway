require 'spec_helper'

RSpec.describe Builder::OneclickBuilder do

    before do
        @oneclick_register_data = Builder::OneclickBuilder.register_new_oneclick 155002311, 165
    end

    it "The Builder need to initialize a non-null OneClickRegister type object" do
        expect(@oneclick_register_data).not_to be nil
        expect(@oneclick_register_data).to be_an(OneClickRegisterData)
    end

    it "You need to be able to set the card information to OneClick through the Builder" do
        @oneclick_register_data = Builder::OneclickBuilder.with_credit_card "IVAN SIMIONATO", 123123123, "10/2020"
        expect(@oneclick_register_data.card_holder_name).not_to be nil
        expect(@oneclick_register_data.card_number).not_to be nil
        expect(@oneclick_register_data.expiration_date).not_to be nil
    end

    it "You need to be able to set the customer mail to OneClick through the Builder" do
        @oneclick_register_data = Builder::OneclickBuilder.for_email "ivan.simionato@yapay.com.br"
        expect(@oneclick_register_data.buyer_email).not_to be nil
    end

end