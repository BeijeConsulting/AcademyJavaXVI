package it.beije.neumann.mongiello.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

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
	
	@JsonGetter(value = "createdAt")
	public String getCreatedAtString() {
		return createdAt.toString();
	}

	public void setCreatedAt() {
		LocalDateTime now = LocalDateTime.now();
		this.createdAt = now;
	}

//	@JsonSetter(value = "createdAt")
//	public void setCreated() {
//		LocalDateTime now = LocalDateTime.now();
//		//this.createdAt = now;
//		this.createdAt = (LocalDateTime) DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).parse(now.toString());
//	}
													
	@JsonGetter(value = "disabledAt")
	public String getDisabledAtString() {
		if(disabledAt == null  ) return null;
		return disabledAt.toString();
	}
	
	public LocalDateTime getDisabledAt() {
		
		return disabledAt;
	}

	@JsonSetter(value = "disabledAt")
	public void setDisable(String date) {

		this.disabledAt =(LocalDateTime) DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).parse(date);
	}
	
	public void setDisabledAt(LocalDateTime disabledAt) {
		System.out.println("ENtrato");
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
//				.append(", created at: ").append(createdAt)
				.append(", disabled at: ").append(disabledAt)
				.append("}");

		return builder.toString();
	}	

}
