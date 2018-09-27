require_relative '../models/oneclick_register_data'

module Builder
    class OneclickBuilder
        def self.register_new_oneclick(store_code, payment_code)
            @oneclick_registration = OneClickRegisterData.new
            @oneclick_registration.store_code = store_code
            @oneclick_registration.payment_code = payment_code
            @oneclick_registration
        end

        def self.with_credit_card(card_holder_name, card_number, expiration_date)
            @oneclick_registration.card_holder_name = card_holder_name
            @oneclick_registration.card_number = card_number
            @oneclick_registration.expiration_date = expiration_date
            @oneclick_registration
        end

        def self.for_email(buyer_email)
            @oneclick_registration.buyer_email = buyer_email
            @oneclick_registration
        end
    end

end