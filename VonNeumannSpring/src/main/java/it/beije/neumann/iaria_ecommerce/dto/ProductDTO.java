package it.beije.neumann.iaria_ecommerce.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;


public class ProductDTO {

	private Integer id;
	
	@JsonProperty(value = "created_at")
	private LocalDateTime createdAt;
	
	private String name;
	
	private String description;
	
	@JsonProperty(value = "is_listed")
	private Integer isListed;
	
	@JsonProperty(value = "listed_price")
	private Double listedPrice;
	
	private String color;
	
	private String category;
	
	private String type;
	
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
	
	@JsonGetter(value = "created_at")
	public String getCreatedAtAsString() {
		return createdAt.toString();
	}
	
	@JsonSetter(value = "created_at")
	public void setDatetime(String createdAt) {
		//this.createdAt = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).parse(createdAt);
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
