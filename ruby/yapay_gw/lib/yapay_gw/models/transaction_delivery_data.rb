class TransactionDeliveryData
    attr_accessor :name
    attr_accessor :mail
    attr_accessor :birthday
    attr_accessor :sex
    attr_accessor :document
    attr_accessor :document_two
    attr_accessor :delivery_address_data
    attr_accessor :delivery_phone_data


    def as_json(options = {})
        json = {:nome => name, 
                :email => mail,
                :dataNascimento => birthday,
                :sexo => sex,
                :documento => document,
                :documento2 => document_two,
                :endereco => delivery_address_data,
                :telefone => delivery_phone_data
        }
        json.delete_if { |k, v| v.nil? }
        json
    end
end