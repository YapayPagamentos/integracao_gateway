class RecurringChargingData
    attr_accessor :buyer_name
    attr_accessor :buyer_mail
    attr_accessor :client_type
    attr_accessor :document
    attr_accessor :birthday
    attr_accessor :client_code
    attr_accessor :client_sex
    attr_accessor :document_two
    attr_accessor :client_address_street
    attr_accessor :client_address_number
    attr_accessor :client_address_district
    attr_accessor :client_address_complement
    attr_accessor :client_address_city
    attr_accessor :client_address_state
    attr_accessor :client_address_zipcode
    attr_accessor :client_address_country
    attr_accessor :client_phone

    def as_json(options = {})
        json = {:nomeComprador => buyer_name, 
                :emailComprador => buyer_mail,
                :tipoCliente => client_type,
                :documento => document,
                :dataNascimento => birthday,
                :codigoCliente => client_code,
                :sexo => client_sex,
                :documento2 => document_two,
                :enderecoComprador => client_address_street,
                :numeroEnderecoComprador => client_address_number,
                :bairroComprador => client_address_district,
                :complementoComprador => client_address_complement,
                :cidadeComprador => client_address_city,
                :estadoComprador => client_address_state,
                :cepComprador => client_address_zipcode,
                :paisComprador => client_address_country,
                :telefone => client_phone
            }
        json.delete_if { |k, v| v.nil? }
        json
    end

end