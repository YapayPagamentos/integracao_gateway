require 'http'
require_relative 'base_url'
require 'active_support'

class RestV3
    def transaction_authorize(credentials, transaction)
        HTTP.basic_auth(:user => credentials.user, 
                        :pass => credentials.password)
            .headers(:user_agent => "Gateway Ruby Client", :content_type => "application/json")
            .post("#{BaseURL.get_url}/api/v3/transacao", :body => ActiveSupport::JSON.encode(transaction)) 
    end

    def transaction_query(credentials, transaction_number)
        transaction_query(credentials, credentials.store_code, transaction_number)
    end

    def transaction_query(credentials, store_code, transaction_number)
        HTTP.basic_auth(:user => credentials.user, 
                        :pass => credentials.password)
            .headers(:user_agent => "Gateway Ruby Client", :content_type => "application/json")
            .get("#{BaseURL.get_url}/api/v3/transacao/#{store_code}/#{transaction_number}")
    end

    def transaction_capture(credentials, transaction_number, value)
        transaction_capture(credentials, credentials.store_code, transaction_number, value)
    end

    def transaction_capture(credentials, store_code, transaction_number, value)
        HTTP.basic_auth(:user => credentials.user, 
                        :pass => credentials.password)
            .headers(:user_agent => "Gateway Ruby Client", :content_type => "application/json")
            .put("#{BaseURL.get_url}/api/v3/transacao/#{store_code}/#{transaction_number}/capturar")
    end

    def transaction_cancel(credentials, transaction_number, value)
        transaction_cancel(credentials, credentials.store_code, transaction_number, value)
    end

    def transaction_cancel(credentials, store_code, transaction_number, value)
        HTTP.basic_auth(:user => credentials.user, 
                        :pass => credentials.password)
            .headers(:user_agent => "Gateway Ruby Client", :content_type => "application/json")
            .put("#{BaseURL.get_url}/api/v3/transacao/#{store_code}/#{transaction_number}/cancelar")
    end

    def oneclick_register(credentials, oneclick_register_data)
        HTTP.basic_auth(:user => credentials.user, 
                        :pass => credentials.password)
            .headers(:user_agent => "Gateway Ruby Client", :content_type => "application/json")
            .post("#{BaseURL.get_url}/api/v3/oneclick", :body => ActiveSupport::JSON.encode(oneclick_register_data))
    end

    def oneclick_query(credentials, token)
        HTTP.basic_auth(:user => credentials.user, 
                        :pass => credentials.password)
            .headers(:user_agent => "Gateway Ruby Client", :content_type => "application/json")
            .get("#{BaseURL.get_url}/api/v3/oneclick/#{token}")
    end

    def oneclick_register_update(credentials, token, oneclick_register_data)
        HTTP.basic_auth(:user => credentials.user, 
                        :pass => credentials.password)
            .headers(:user_agent => "Gateway Ruby Client", :content_type => "application/json")
            .put("#{BaseURL.get_url}/api/v3/oneclick/#{token}/alterar", :body => ActiveSupport::JSON.encode(oneclick_register_data))
    end

    def oneclick_authorize(credentials, token, transaction)
        HTTP.basic_auth(:user => credentials.user, 
                        :pass => credentials.password)
            .headers(:user_agent => "Gateway Ruby Client", :content_type => "application/json")
            .post("#{BaseURL.get_url}/api/v3/oneclick/#{token}/autorizar", :body => ActiveSupport::JSON.encode(oneclick_payment_data))
    end

    def recurring_payment_register(credentials, recurring_payment_data)
        HTTP.basic_auth(:user => credentials.user, 
                        :pass => credentials.password)
            .headers(:user_agent => "Gateway Ruby Client", :content_type => "application/json")
            .post("#{BaseURL.get_url}/api/v3/recorrencia", :body => ActiveSupport::JSON.encode(recurring_payment_data))
    end

    def recurring_payment_query(credentials, recurring_payment_number)
        recurring_payment_query(credentials, credentials.store_code, recurring_payment_number);
    end

    def recurring_payment_query(credentials, store_code, recurring_payment_number)
        HTTP.basic_auth(:user => credentials.user, 
                        :pass => credentials.password)
            .headers(:user_agent => "Gateway Ruby Client", :content_type => "application/json")
            .get("#{BaseURL.get_url}/api/v3/recorrencia/#{store_code}/#{recurring_payment_number}")
    end

    def recurring_payment_cancel(credentials, recurring_payment_number)
         recurring_payment_cancel(credentials, credentials.store_code, recurring_payment_number)
     end 

    def recurring_payment_cancel(credentials, store_code, recurring_payment_number)
        HTTP.basic_auth(:user => credentials.user, 
                        :pass => credentials.password)
            .headers(:user_agent => "Gateway Ruby Client", :content_type => "application/json")
            .put("#{BaseURL.get_url}/api/v3/recorrencia/#{store_code}/#{recurring_payment_number}/cancelar")
    end
end