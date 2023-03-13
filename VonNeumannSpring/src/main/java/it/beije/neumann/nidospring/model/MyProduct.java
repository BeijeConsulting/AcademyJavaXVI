package it.beije.neumann.nidospring.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class MyProduct {

	// Properties mapping
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "description", columnDefinition = "text")
	private String description;

	@Column(name = "is_listed")
	private boolean isListed;

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

	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@Column(name = "disabled_at")
	private LocalDateTime disabledAt;

	// Getters-Setters
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

	public boolean isListed() {
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
	
	//Other methods
	@Override
	public String toString() { //Completo di tutto, alcuni attributi si possono togliere
		StringBuilder builder = new StringBuilder()
				.append(" Product Id: ").append(id).append(",<br>")
				.append(" Name: ").append(name).append(",<br>")
				.append(" Description: ").append(description).append(",<br>")
				.append(" Is Listed: ").append(isListed).append(",<br>")
				.append(" Listed Price: ").append(listedPrice).append(",<br>")
				.append(" Category: ").append(category).append(",<br>")
				.append(" Type: ").append(type).append(",<br>")
				.append(" Brand: ").append(brand).append(",<br>")
				.append(" Created At: ").append(createdAt).append(",<br>")
				.append(" Disabled At: ").append(disabledAt).append("<br>");
		
		return builder.toString();
	}
	
	/*
	 * @Override
	public String toString() { //Completo di tutto, alcuni attributi si possono togliere
		StringBuilder builder = new StringBuilder("{")
				.append(" Id: ").append(id)
				.append(", Name: ").append(name)
				.append(", Description: ").append(description)
				.append(", Is Listed: ").append(isListed)
				.append(", Listed Price: ").append(listedPrice)
				.append(", Category: ").append(category)
				.append(", Type: ").append(type)
				.append(", Brand: ").append(brand)
				.append(", Created At: ").append(createdAt)
				.append(", Disabled At: ").append(disabledAt)
				.append("}");
		
		return builder.toString();
	}
	 */

}
