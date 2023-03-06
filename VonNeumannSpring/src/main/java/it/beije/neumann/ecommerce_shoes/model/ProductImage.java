package it.beije.neumann.ecommerce_shoes.model;



import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_images")
public class ProductImage {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	
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

	public void setDisabledAt(LocalDateTime disabledAt) {
		this.disabledAt = disabledAt;
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

	@Column(name = "created_at")
	private LocalDateTime createdAt;
	
	@Column(name = "disabled_at")
	private LocalDateTime disabledAt;
	
	@Column(name = "image_path")
	private String imagePath;
	
	@Column(name = "product_id")
	private Integer productId;
	

	public String toString() {
		StringBuilder builder = new StringBuilder("{")
				.append(" id: ").append(id)
				.append(", product__id: ").append(productId)
				.append(", image_path: ").append(imagePath)
				.append(", created_at: ").append(createdAt)
				.append(", disabled_at: ").append(disabledAt)
				.append("}");

		return builder.toString();
	}
}
