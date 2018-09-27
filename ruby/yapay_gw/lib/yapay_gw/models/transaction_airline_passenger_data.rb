class TransactionAirlinePassengerData
    attr_accessor :first_name
    attr_accessor :middle_name
    attr_accessor :last_name
    
    
    def as_json(options = {})
        json = {:primeiroNome => first_name, 
                :segundoNome => middle_name,
                :sobrenome => last_name
            }
        json.delete_if { |k, v| v.nil? }
        json
    end
end