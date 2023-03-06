package it.beije.neumann.ecommerce_shoes.model;

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

	@Column(name = "created_at")
	private LocalDateTime createdAt;
	
	
	@Column(name = "disabled_at")
	private LocalDateTime disabledAt;
	
	@Column(name = "is_listed")
	private Boolean isListed;
	
	@Column(name = "selling_price")
	private Double sellingPrice;
	
	
	@Column(name = "quantity")
	private Double quantity;
	
	
	@OneToOne(targetEntity = ConvertionSize.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "size")
	private ConvertionSize size;
	
	@OneToOne(targetEntity = Product.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "product_id")
	private Product product;
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product=product;
	}

	public ConvertionSize getSizeS() {
		return size;
	}

	public void setSizeS(ConvertionSize sizeS) {
		this.size=sizeS;
				
	}
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

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	
	public String toString() {
		StringBuilder builder = new StringBuilder("{")
				.append(" id: ").append(id)
				.append(", size_id: ").append(size)
				.append(", quantity: ").append(quantity)
				.append(", product_id: ").append(product.getId())
				.append(", selling_price: ").append(sellingPrice)
				.append(", created_at: ").append(createdAt)
				.append(", disabled_at: ").append(disabledAt)
				.append("}");

		return builder.toString();
	}
	

}