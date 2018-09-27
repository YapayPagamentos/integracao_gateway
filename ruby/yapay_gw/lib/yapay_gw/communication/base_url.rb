class BaseURL
    
    def self.sandbox
        "https://sandbox.gateway.yapay.com.br/checkout"
    end
    
    def self.production
        "https://gateway.yapay.com.br/checkout"
    end

    def self.get
        sandbox
    end

end