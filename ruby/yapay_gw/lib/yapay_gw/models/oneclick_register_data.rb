class OneClickRegisterData
    attr_accessor :store_code
    attr_accessor :card_holder_name
    attr_accessor :card_number
    attr_accessor :expiration_date
    attr_accessor :buyer_email
    attr_accessor :payment_code

    def as_json(options = {})
        json = {:codigoEstabelecimento => store_code, 
                :nomeTitularCartaoCredito => card_holder_name,
                :numeroCartaoCredito => card_number,
                :dataValidadeCartao => expiration_date,
                :emailComprador => buyer_email,
                :formaPagamento => payment_code
        }
        json.delete_if { |k, v| v.nil? }
        json
    end
end