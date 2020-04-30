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
	@JoinColumn(name = "product_category_id", referencedColumnName = "id")
	private ProductCategoryM productCategory;
	
	private BigDecimal price;

	public ProductM() {
		
	}

	public ProductM(Long id) {
		super(id);
	}

	public ProductM(String title, ProductCategoryM productCategory, BigDecimal price) {
		this.title = title;
		this.productCategory = productCategory;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public ProductCategoryM getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategoryM productCategory) {
		this.productCategory = productCategory;
	}

	@Override
	public String toString() {
		return "ProductM [title=" + title + ", productCategory=" + productCategory + ", price=" + price + ", ID="
				+ getId() + "]";
	}



	

}
