class RecurringPaymentData
    attr_accessor :payment_code
    attr_accessor :recurring_payment_number
    attr_accessor :value
    attr_accessor :modality
    attr_accessor :frequency
    attr_accessor :notification_url
    attr_accessor :process_immediately
    attr_accessor :billing_amount
    attr_accessor :billing_first_date
    attr_accessor :bill_due_date
    attr_accessor :free_field_one
    attr_accessor :free_field_two
    attr_accessor :free_field_three
    attr_accessor :free_field_four
    attr_accessor :free_field_five
    attr_accessor :recurring_charging_data
    attr_accessor :recurring_card_data
    attr_accessor :recurring_shipping_data

    def as_json(options = {})
        json = {:formaPagamento => payment_code, 
                :numeroRecorrencia => recurring_payment_number,
                :valor => value,
                :modalidade => modality,
                :periodicidade => frequency,
                :urlNotificacao => notification_url,
                :processarImediatamente => process_immediately,
                :quantidadeCobrancas => billing_amount,
                :dataPrimeiraCobranca => billing_first_date,
                :vencimentoBoleto => bill_due_date,
                :campoLivre1 => free_field_one,
                :campoLivre2 => free_field_two,
                :campoLivre3 => free_field_three, 
                :campoLivre4 => free_field_four,
                :campoLivre5 => free_field_five,
                :dadosCobranca => recurring_charging_data,
                :dadosCartao => recurring_card_data,
                :dadosEntrega => recurring_shipping_data
        }
        json.delete_if { |k, v| v.nil? }
        json
    end
end