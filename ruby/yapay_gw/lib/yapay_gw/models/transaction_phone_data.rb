class TransactionPhoneData
    attr_accessor :ddi
    attr_accessor :ddd
    attr_accessor :phone
    attr_accessor :phone_type
    
    def as_json(options = {})
        json = {:ddi => ddi, 
                :ddd => ddd,
                :telefone => phone,
                :tipoTelefone => phone_type
            }
        json.delete_if { |k, v| v.nil? }
        json
    end
end