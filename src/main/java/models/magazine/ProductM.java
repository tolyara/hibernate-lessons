package main.java.models.magazine;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product_m")
public class ProductM extends Model {

	private static final long serialVersionUID = 1L;
	
	private String title;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_product_category", referencedColumnName = "id")
	private ProductCategoryM productCategory;
	
	private BigDecimal price;

	public ProductM() {
		
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public ProductCategoryM getModelProductCategory() {
		return productCategory;
	}

	public void setModelProductCategory(ProductCategoryM modelProductCategory) {
		this.productCategory = modelProductCategory;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}	

}
