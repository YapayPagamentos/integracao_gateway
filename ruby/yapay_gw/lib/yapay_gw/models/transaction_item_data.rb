class TransactionItemData
    attr_accessor :product_code
    attr_accessor :product_category
    attr_accessor :product_name
    attr_accessor :product_amount
    attr_accessor :product_unitary_value
    attr_accessor :category_name

    def as_json(options = {})
        json = {:codigoProduto => product_code, 
                :codigoCategoria => product_category,
                :nomeProduto => product_name,
                :quantidadeProduto => product_amount,
                :valorUnitarioProduto => product_unitary_value,
                :nomeCategoria => category_name
        }
        json.delete_if { |k, v| v.nil? }
        json
    end
end