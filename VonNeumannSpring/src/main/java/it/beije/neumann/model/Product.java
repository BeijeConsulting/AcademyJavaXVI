package it.beije.neumann.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column
	private String name;
	
	@Column(columnDefinition = "TEXT")
	private String description;
	
	@Column(name="is_listed")
	private boolean isListed;
	
	@Column(name="listed_price")
	private Double listedPrice;

	@Column
	private String color;
	
	@Column
	private String category;
	
	@Column
	private String type;
	
	@Column
	private String brand;
	
	@Column(name="created_at")
	private LocalDateTime createdAt;
	
	@Column(name="disabled_at")
	private LocalDateTime disabledAt;

	
	@OneToMany(targetEntity = ProductDetails.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "product_id")
	private List<ProductDetails> productDetails;

	public List<ProductDetails> getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(List<ProductDetails> productDetails) {
		this.productDetails = productDetails;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}



	public boolean getIsListed() {
		return isListed;
	}

	public void setIsListed(boolean isListed) {
		this.isListed = isListed;
	}

	public Double getListedPrice() {
		return listedPrice;
	}

	public void setListedPrice(Double listedPrice) {
		this.listedPrice = listedPrice;
	}
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
	public LocalDateTime getDisabledAt() {
		return disabledAt;
	}

	public void setDisabledAt(LocalDateTime disabledAt) {
		this.disabledAt = disabledAt;
	}

	public void setListed(boolean isListed) {
		this.isListed = isListed;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder("{")
				.append(" id: ").append(id)
				.append(", name: ").append(name)
				.append(", description: ").append(description)
				.append(", is listed: ").append(isListed)
				.append(", Listed Price: ").append(listedPrice)
				.append(", color: ").append(color)
				.append(", category: ").append(category)
				.append(", type: ").append(type)
				.append(", brand: ").append(brand)
				.append(", created at: ").append(createdAt)
				.append(", disabled at: ").append(disabledAt)
				.append(", product details: ").append(productDetails)
				.append("}");

		return builder.toString();
	}	

	
}