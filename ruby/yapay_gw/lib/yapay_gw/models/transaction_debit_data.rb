class TransactionDebitData
    attr_accessor :agency
    attr_accessor :agency_digit
    attr_accessor :account_number
    attr_accessor :account_number_digit
    attr_accessor :account_type

    def as_json(options = {})
        json = {:agencia => agency, 
                :agenciaDigito => agency_digit,
                :conta => account_number,
                :contaDigito => account_number_digit,
                :tipoConta => account_type
        }
        json.delete_if { |k, v| v.nil? }
        json
    end
end