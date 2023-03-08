package it.beije.neumann.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "product_details")
public class ProductDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name="is_listed")
	private boolean isListed;
	
	@Column(name="selling_price")
	private Double sellingPrice;
	
	@Column
	private Integer quantity;
	
//	@ManyToOne(targetEntity = Product.class, fetch = FetchType.LAZY)
//	@JoinColumn(name = "id")
//	private Product product;
//	
//	public Product getProduct() {
//		return product;
//	}
//
//	public void setProduct(Product product) {
//		this.product = product;
//	}

	private String size;
	
	@Column(name="product_id")
	private Integer productId;
	
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

	public boolean isListed() {
		return isListed;
	}

	public void setListed(boolean isListed) {
		this.isListed = isListed;
	}

	public Double getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(Double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getDisabled_at() {
		return disabledAt;
	}

	public void setDisabled_at(LocalDateTime disabledAt) {
		this.disabledAt = disabledAt;
	}

	
	public String toString() {
		StringBuilder builder = new StringBuilder("{")
				.append(" id: ").append(id)
				.append(", isListed: ").append(isListed)
				.append(", selling Price: ").append(sellingPrice)
				.append(", quantity: ").append(quantity)
				.append(", size: ").append(size)
				.append(", product id: ").append(productId)
				.append(", created at: ").append(createdAt)
				.append(", disabled at: ").append(disabledAt)
				.append("}");

		return builder.toString();
	}
}




