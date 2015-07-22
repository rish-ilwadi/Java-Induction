package hibernate;

import java.util.Set;

public class ProductCategories {

	private int categoryId;
	private String categoryName;
	private Set <ProductDetails>category;
	
	public Set <ProductDetails> getCategory() {
		return category;
	}
	public void setCategory(Set <ProductDetails>category) {
		this.category = category;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
}
