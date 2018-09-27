class TransactionExtraField
    attr_accessor :key
    attr_accessor :value

    def as_json(options = {})
        json = {:chave => key, 
                :valor => value
            }
        json.delete_if { |k, v| v.nil? }
        json
    end
end