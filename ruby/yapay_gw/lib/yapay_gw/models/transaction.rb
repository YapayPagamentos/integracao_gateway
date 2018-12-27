class Transaction
    attr_accessor :store_code
    attr_accessor :payment_code
    attr_accessor :transaction_data
    attr_accessor :transaction_checkout_data
    attr_accessor :transaction_card_data
    attr_accessor :transaction_multiple_card_data
    attr_accessor :transaction_item_data
    attr_accessor :transaction_charging_data
    attr_accessor :transaction_delivery_data
    attr_accessor :transaction_extra_fields

    def as_json(options = {})
        json = {:codigoEstabelecimento => store_code, 
                :codigoFormaPagamento => payment_code, 
                :transacao => transaction_data,
                :checkout => transaction_checkout_data,
                :dadosCartao => transaction_card_data,
                :dadosMultiplosCartoes => transaction_multiple_card_data,
                :itensDoPedido => transaction_item_data,
                :dadosCobranca => transaction_charging_data,
                :dadosEntrega => transaction_delivery_data,
                :camposExtras => transaction_extra_fields
            }
        json.delete_if { |k, v| v.nil? }
        json
    end
end