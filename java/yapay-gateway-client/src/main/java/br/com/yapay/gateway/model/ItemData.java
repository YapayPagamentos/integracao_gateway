package br.com.yapay.gateway.model;

import com.google.gson.annotations.SerializedName;

/**
 * Class describing cart items
 * 
 * @author Adriano Santos
 *
 */
public class ItemData {

	@SerializedName("codigoProduto")
	private String productCode;

	@SerializedName("codigoCategoria")
	private String productCategory;

	@SerializedName("nomeProduto")
	private String productName;

	@SerializedName("quantidadeProduto")
	private Integer productAmount;

	@SerializedName("valorUnitarioProduto")
	private Long productUnitaryValue;

	@SerializedName("nomeCategoria")
	private String categoryName;

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getProductAmount() {
		return productAmount;
	}

	public void setProductAmount(Integer productAmount) {
		this.productAmount = productAmount;
	}

	public Long getProductUnitaryValue() {
		return productUnitaryValue;
	}

	public void setProductUnitaryValue(Long productUnitaryValue) {
		this.productUnitaryValue = productUnitaryValue;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}
