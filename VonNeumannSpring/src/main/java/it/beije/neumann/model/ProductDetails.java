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
    private Integer quantity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "size_id")
    private ConversionSizes size;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
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

	public ConversionSizes getSize() {
		return size;
	}

	public void setSize(ConversionSizes size) {
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
		return "ProductDetails [id=" + id + ", createdAt=" + createdAt + ", disabledAt=" + disabledAt + ", isListed="
				+ isListed + ", sellingPrice=" + sellingPrice + ", quantity=" + quantity + ", size=" + size
				+ ", product=" + product + "]";
	}

}




