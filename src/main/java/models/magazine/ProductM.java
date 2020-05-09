package main.java.models.magazine;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "product_m")
public class ProductM extends Model {

	private static final long serialVersionUID = 1L;
	
//	@Email
	
//	@Past // The annotated element must be a date in the past.
//	@Future 
	
	@Pattern(regexp = "asdf")
	@NotNull(message = "Product title is null")
	@NotEmpty
	@Size(min = 3, max = 255, message = "must be between 3 and 255")
	private String title;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_category_id", referencedColumnName = "id")
	private ProductCategoryM productCategory;
	
	@NotNull(message = "Product price is null")
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
