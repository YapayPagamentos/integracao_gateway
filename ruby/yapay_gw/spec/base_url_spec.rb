require 'spec_helper'

RSpec.describe BaseURL do

    it "With no argument, get_url should return sandbox url" do
        expect(BaseURL.get_url).to eq "https://sandbox.gateway.yapay.com.br/checkout"
    end

    it "With 'production' argument, get_url should return production url" do
        expect(BaseURL.get_url("production")).to eq "https://gateway.yapay.com.br/checkout"
    end

    it "Except for 'production', it always return sandbox url" do
        expect(BaseURL.get_url('donaflorinda')).to eq "https://sandbox.gateway.yapay.com.br/checkout"
    end

end