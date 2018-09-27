class TransactionChargingData
    attr_accessor :client_code
    attr_accessor :client_type
    attr_accessor :client_name
    attr_accessor :client_email
    attr_accessor :client_birthday
    attr_accessor :client_sex
    attr_accessor :client_document
    attr_accessor :client_document_two
    attr_accessor :client_charging_adress_data
    attr_accessor :client_charging_phone_data

    def as_json(options = {})
        json = {:codigoCliente => client_code, 
                :tipoCliente => client_type,
                :nome => client_name,
                :email => client_email,
                :dataNascimento => client_birthday,
                :sexo => client_sex,
                :documento => client_document,
                :documento2 => client_document_two,
                :endereco => client_charging_adress_data,
                :telefone => client_charging_phone_data
        }
        json.delete_if { |k, v| v.nil? }
        json
    end
end