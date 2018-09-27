class TransactionAirlineData
    attr_accessor :trip_data
    attr_accessor :passenger_data
    attr_accessor :flight_range_data

    def as_json(options = {})
        json = {:dadosViagem => trip_data, 
                :dadosPassageiros => passenger_data,
                :dadosEscalas => flight_range_data
        }
        json.delete_if { |k, v| v.nil? }
        json
    end
end