class TransactionCardData
    attr_accessor :card_holder_name
    attr_accessor :card_number
    attr_accessor :cvv
    attr_accessor :expiration_date
    attr_accessor :payment_code
    attr_accessor :installments
    attr_accessor :value

    def as_json(options = {})
        json = {:nomePortador => card_holder_name, 
                :numeroCartao => card_number,
                :codigoSeguranca => cvv,
                :dataValidade => expiration_date,
                :codigoFormaPagamento => payment_code,
                :parcelas => installments,
                :valor => value
            }
        json.delete_if { |k, v| v.nil? }
        json
    end
end