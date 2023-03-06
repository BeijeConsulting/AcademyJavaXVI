package it.beije.neumann.db3.model;

import java.time.LocalDateTime;

import javax.persistence.*;

@Entity
@Table(name = "product_details")
public class ProductDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "created_at", nullable = false)
	private LocalDateTime createdAt;

	@Column(name = "disabled_at")
	private LocalDateTime disabledAt;

	@Column(name = "is_listed", nullable = false)
	private Boolean isListed;

	@Column(name = "selling_price")
	private Double sellingPrice;

	@Column(name = "quantity", nullable = false)
	private Integer quantity;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "size_id", nullable = false)
	private ConversionSize size;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id", nullable = false)
	private Product product;

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

	public Boolean getIsListed() {
		return isListed;
	}

	public void setIsListed(Boolean isListed) {
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

	public ConversionSize getSize() {
		return size;
	}

	public void setSize(ConversionSize size) {
		this.size = size;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "ProductDetail [id=" + id + ", createdAt=" + createdAt + ", disabledAt=" + disabledAt + ", isListed="
				+ isListed + ", sellingPrice=" + sellingPrice + ", quantity=" + quantity + ", product=" + product + "]";
	}

}
