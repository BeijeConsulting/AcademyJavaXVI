package it.beije.neumann.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
//	@OneToOne(targetEntity = ConversionSizes.class, fetch = FetchType.EAGER)
//	@JoinColumn(name = "size_id")
	private Integer size;
	
	@Column(name="product_id")
	private Integer productId;
	
	@Column(name="created_at")
	private LocalDateTime createdAt;
	
	@Column(name="disabled_at")
	private LocalDateTime disabled_at;

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

	

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
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
		return disabled_at;
	}

	public void setDisabled_at(LocalDateTime disabled_at) {
		this.disabled_at = disabled_at;
	}

	
}




