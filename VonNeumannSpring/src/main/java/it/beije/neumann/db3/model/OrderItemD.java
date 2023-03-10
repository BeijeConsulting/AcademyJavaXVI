package it.beije.neumann.db3.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

@Entity
@Table(name = "order_items")
public class OrderItemD {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "quantity")
    private int quantity;
    
    @Column(name = "price")
    private double price;
    
    @Column(name = "size")
    private String size;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "color")
    private String color;
    
    @Column(name = "created_at", nullable = false)
	@Generated(value=GenerationTime.INSERT)
    private LocalDate createdAt;
    
    @Column(name = "disabled_at")
    private LocalDate disabledAt;
    
//    @ManyToOne(targetEntity = OrderD.class,fetch = FetchType.LAZY)
//    @JoinColumn(name = "order_id")
//    private OrderD order;
    
    @Column(name = "order_id", nullable = false)
    private Integer orderId;
    
    @Column(name = "product_details_id", nullable = false)
    private Integer productDetailsId;
    
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "product_details_id")
    @Transient
    private ProductDetails productDetails;
    
    public OrderItemD() {
    }

	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", quantity=" + quantity + ", price=" + price + ", size=" + size + ", name="
				+ name + ", color=" + color + ", createdAt=" + createdAt + ", disabledAt=" + disabledAt + ", order="
				+ orderId + ", productDetailsId=" + productDetailsId + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDate getDisabledAt() {
		return disabledAt;
	}

	public void setDisabledAt(LocalDate disabledAt) {
		this.disabledAt = disabledAt;
	}

	public Integer getOrder() {
		return orderId;
	}

	public void setOrder(Integer order) {
		this.orderId = order;
	}

	public ProductDetails getProductDetails() {
		return productDetails;
	}
	
	public Integer getProductDetailsId() {
		return productDetailsId;
	}

	public void setProductDetailsId(Integer productDetails) {
		this.productDetailsId = productDetails;
	}

	public void setProductDetails(ProductDetails productDetails) {
		this.productDetails = productDetails;
	}
    
}