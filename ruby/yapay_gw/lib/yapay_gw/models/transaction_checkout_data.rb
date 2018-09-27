class TransactionCheckoutData
    attr_accessor :process
    attr_accessor :payment_type
    attr_accessor :multiple_card
    attr_accessor :multiple_bill
    attr_accessor :multiple_bill_data

    def as_json(options = {})
    json = {:processar => process, 
            :tipoPagamento => payment_type,
            :multiploCartao => multiple_card,
            :multiploBoleto => multiple_bill,
            :boletos => multiple_bill_data
        }
    json.delete_if { |k, v| v.nil? }
    json
end
end