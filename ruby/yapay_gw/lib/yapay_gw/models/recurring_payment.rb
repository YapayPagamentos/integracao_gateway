class RecurringPayment
    attr_accessor :recurring_payment_data
    attr_accessor :store_code

    def as_json(options = {})
        json = {:recorrencia => recurring_payment_data, 
                :estabelecimento => store_code
            }
        json.delete_if { |k, v| v.nil? }
        json
    end
end