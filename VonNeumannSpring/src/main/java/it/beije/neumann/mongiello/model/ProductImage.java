package it.beije.neumann.mongiello.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product_images")
public class ProductImage {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name="image_path")
	private String imagePath;
	
	@Column(name="product_id")
	private Integer productId;
	
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

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
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

