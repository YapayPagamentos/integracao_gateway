class TransactionAirlineTripData
    attr_accessor :pnr
    attr_accessor :cardholder_is_passenger
    attr_accessor :ticket_issue_date
    attr_accessor :company_code
    attr_accessor :departure_airport
    attr_accessor :departure_date
    attr_accessor :arrival_airport
    attr_accessor :arrival_date

    def as_json(options = {})
        json = {:pnr => pnr, 
                :titularCartaoEPassageiro => cardholder_is_passenger,
                :dataEmissaoPassagem => ticket_issue_date,
                :codigoCompanhiaAerea => company_code,
                :aeroportoPartida => departure_airport,
                :dataHoraPartida => departure_date,
                :aeroportoChegada => arrival_airport,
                :dataHoraChegada => arrival_date
            }
        json.delete_if { |k, v| v.nil? }
        json
    end
end