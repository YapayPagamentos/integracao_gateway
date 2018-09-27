class RecurringShippingData
    attr_accessor :shipping_name
    attr_accessor :shipping_mail
    attr_accessor :shipping_street
    attr_accessor :shipping_number
    attr_accessor :shipping_district
    attr_accessor :shipping_complement
    attr_accessor :shipping_city
    attr_accessor :shipping_state
    attr_accessor :shipping_zipcode
    attr_accessor :shipping_country
    attr_accessor :shipping_phone

    def as_json(options = {})
        json = {:nomeEntrega => shipping_name, 
                :emailEntrega => shipping_mail,
                :enderecoEntrega => shipping_street,
                :numeroEnderecoEntrega => shipping_number,
                :bairroEntrega => shipping_district,
                :complementoEntrega => shipping_complement,
                :cidadeEntrega => shipping_city,
                :estadoEntrega => shipping_state,
                :cepEntrega => shipping_zipcode,
                :paisEntrega => shipping_country,
                :telefone => shipping_phone
        }
        json.delete_if { |k, v| v.nil? }
        json
    end

end