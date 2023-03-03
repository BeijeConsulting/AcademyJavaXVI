package it.beije.neumann.iaria_ecommerce.model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Products {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "created_at")
	private LocalDateTime createdAt;
	
	@Column(name = "disabled_at")
	private LocalDateTime disabledAt;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description", columnDefinition="text")
	private String description;
	
	@Column(name = "is_listed")
	private Integer isListed;
	
	@Column(name = "listed_price")
	private Double listedPrice;
	
	@Column(name = "color")
	private String color;
	
	@Column(name = "category")
	private String category;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "brand")
	private String brand;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public void setDisableAt(LocalDateTime disabledAt) {
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
	
	public Integer getIsListed() {
		return isListed;
	}
	public void setIsListed(Integer isListed) {
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

	public String toString() {
		StringBuilder builder = new StringBuilder("{")
				.append(" ID: ").append(id)
				.append(", Created: ").append(createdAt)
				.append(", Disabled: ").append(disabledAt)
				.append(", Name: ").append(name)
				.append(", Description: ").append(description)
				.append(", Listed: ").append(isListed)
				.append(", Listed Price: ").append(listedPrice)
				.append(", Color: ").append(color)
				.append(", Category: ").append(category)
				.append(", Type: ").append(type)
				.append(", Brand: ").append(brand)
				.append("}");

		return builder.toString();
	}
}
