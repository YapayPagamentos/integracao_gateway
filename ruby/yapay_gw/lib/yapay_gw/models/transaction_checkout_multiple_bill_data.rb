class TransactionCheckoutMultipleBillData
    attr_accessor :value
    attr_accessor :due_data
    
    def as_json(options = {})
        json = {:valor => value, 
                :vencimento => due_data
        }
        json.delete_if { |k, v| v.nil? }
        json
    end
end