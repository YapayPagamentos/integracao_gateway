class TransactionAdressData
    attr_accessor :street
    attr_accessor :number
    attr_accessor :complement
    attr_accessor :zip_code
    attr_accessor :district
    attr_accessor :city
    attr_accessor :state
    attr_accessor :country

    def as_json(options = {})
        json = {:logradouro => street, 
                :numero => number,
                :complemento => complement,
                :cep => zip_code,
                :bairro => district,
                :cidade => city,
                :estado => state,
                :pais => country
        }
        json.delete_if { |k, v| v.nil? }
        json
    end
end