class TransactionData
    attr_accessor :transaction_number
    attr_accessor :value
    attr_accessor :discount_value
    attr_accessor :boarding_fee
    attr_accessor :installments
    attr_accessor :installment_type
    attr_accessor :hint_url
    attr_accessor :result_url
    attr_accessor :unpaid_redirect_url
    attr_accessor :idiom
    attr_accessor :ip
    attr_accessor :browser
    attr_accessor :transaction_origin
    attr_accessor :free_field_one
    attr_accessor :free_field_two
    attr_accessor :free_field_three
    attr_accessor :free_field_four
    attr_accessor :free_field_five
    attr_accessor :bill_due_date
    attr_accessor :country
    attr_accessor :currency
    attr_accessor :recurrent_payment


    def as_json(options = {})
        json = {:numeroTransacao => transaction_number, 
                :valor => value,
                :valorDesconto => discount_value,
                :taxaEmbarque => boarding_fee,
                :parcelas => installments,
                :tipoParcelamento => installment_type,
                :urlCampainha => hint_url,
                :urlResultado => result_url,
                :urlRedirecionamentoNaoPago => unpaid_redirect_url,
                :idioma => idiom,
                :ip => ip,
                :browser => browser,
                :origemTransacao => transaction_origin,
                :campoLivre1 => free_field_one,
                :campoLivre2 => free_field_two,
                :campoLivre3 => free_field_three,
                :campoLivre4 => free_field_four,
                :campoLivre5 => free_field_five,
                :dataVencimentoBoleto => bill_due_date,
                :pais => country,
                :moeda => currency,
                :pagamentoRecorrente => recurrent_payment
            }
        json.delete_if { |k, v| v.nil? }
        json
    end
end