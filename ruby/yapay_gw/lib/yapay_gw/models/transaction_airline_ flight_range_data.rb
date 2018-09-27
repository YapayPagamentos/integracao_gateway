class TransactionAirlineFlightRangeData
    attr_accessor :service_class
    attr_accessor :trip_date
    attr_accessor :company_code
    attr_accessor :permit_flight
    attr_accessor :departure_airport
    attr_accessor :departure_date
    attr_accessor :arrival_airport
    attr_accessor :arrival_date
    attr_accessor :fly_number
    attr_accessor :rate_class

    def as_json(options = {})
        json = {:classeDoServico => service_class, 
                :dataDaViagem => trip_date,
                :codigoCompanhiaAerea => company_code,
                :escalaPermitida => permit_flight,
                :aeroportoPartida => departure_airport,
                :dataHoraPartida => departure_date,
                :aeroportoChegada => arrival_airport,
                :dataHoraChegada => arrival_date,
                :numeroVoo => fly_number,
                :classeTarifaria => rate_class
            }
        json.delete_if { |k, v| v.nil? }
        json
    end
end