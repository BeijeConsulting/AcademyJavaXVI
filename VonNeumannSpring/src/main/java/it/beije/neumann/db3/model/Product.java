package it.beije.neumann.db3.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "created_at", nullable = false)
	private LocalDateTime createdAt;

	@Column(name = "disabled_at")
	private LocalDateTime disabledAt;

	@Column(name = "name", nullable = false, length = 100)
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "is_listed", nullable = false)
	private boolean isListed;

	@Column(name = "listed_price", nullable = false)
	private double listedPrice;

	@Column(name = "color", nullable = false, length = 100)
	private String color;

	@Column(name = "category", nullable = false, length = 100)
	private String category;

	@Column(name = "type", nullable = false, length = 100)
	private String type;

	@Column(name = "brand", nullable = false, length = 100)
	private String brand;

	// constructors
	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
	private List<ProductDetails> productDetails;

	public List<ProductDetails> getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(List<ProductDetails> productDetails) {
		this.productDetails = productDetails;
	}

	public Product() {
	}

	public Product(String name, String description, double listedPrice, String color, String category, String type,
			String brand) {
		this.name = name;
		this.description = description;
		this.isListed = false;
		this.listedPrice = listedPrice;
		this.color = color;
		this.category = category;
		this.type = type;
		this.brand = brand;
		this.createdAt = LocalDateTime.now();
	}

	public int getId() {
		return id;
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

	public boolean isListed() {
		return isListed;
	}

	public void setListed(boolean isListed) {
		this.isListed = isListed;
	}

	public double getListedPrice() {
		return listedPrice;
	}

	public void setListedPrice(double listedPrice) {
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

	@Override
	public String toString() {
		return "Product [id=" + id + ", createdAt=" + createdAt + ", disabledAt=" + disabledAt + ", name=" + name
				+ ", description=" + description + ", isListed=" + isListed + ", listedPrice=" + listedPrice
				+ ", color=" + color + ", category=" + category + ", type=" + type + ", brand=" + brand + "]";
	}

}