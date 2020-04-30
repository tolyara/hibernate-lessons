package main.java.models.magazine;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "product_category_m")
public class ProductCategoryM extends Model {

	private static final long serialVersionUID = 1L;
	
	private String title;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "parent_product_category", referencedColumnName = "id")
	private ProductCategoryM parentProductCategory;
	
	@OneToMany(mappedBy = "productCategory")
	private Set<ProductM> products = new HashSet<ProductM>();
	
	public ProductCategoryM() {
		
	}

	public ProductCategoryM(Long id) {
		super(id);
	}

	public ProductCategoryM(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public ProductCategoryM getParentProductCategory() {
		return parentProductCategory;
	}

	public void setParentProductCategory(ProductCategoryM parentProductCategory) {
		this.parentProductCategory = parentProductCategory;
	}

	public Set<ProductM> getProducts() {
		return products;
	}

	public void setProducts(Set<ProductM> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "ProductCategoryM [title=" + title + "]";
	}

}
