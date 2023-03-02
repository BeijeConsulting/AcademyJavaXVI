package it.beije.neumann.mongiello.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private Integer isListed;
	
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
	private Date createdAt;
	
	@Column(name="disabeld_at")
	private Date disabeldAt;

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

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getDisabeldAt() {
		return disabeldAt;
	}

	public void setDisabeldAt(Date disabeldAt) {
		this.disabeldAt = disabeldAt;
	}
	
	

}
