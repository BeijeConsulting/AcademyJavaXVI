package it.beije.neumann.nidospring.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order_items")
public class MyOrderItem {

	// Properties mapping
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "quantity")
	private Integer quantity;

	@Column(name = "price")
	private Double price;

	@Column(name = "order_id")
	private Integer orderId;

	@Column(name = "product_details_id")
	private Integer productDetailsId;

	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@Column(name = "disabled_at")
	private LocalDateTime disabledAt;

	// Getters-Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getProductDetailsId() {
		return productDetailsId;
	}

	public void setProductDetailsId(Integer productDetailsId) {
		this.productDetailsId = productDetailsId;
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
	
	//Other methods
	@Override
	public String toString() { //Completo di tutto, alcuni attributi si possono togliere
		StringBuilder builder = new StringBuilder()
				.append(" Order Item Id: ").append(id).append(",<br>")
				.append(" Quantity: ").append(quantity).append(",<br>")
				.append(" Price: ").append(price).append(",<br>")
				.append(" Order Id: ").append(orderId).append(",<br>")
				.append(" Product Details Id: ").append(productDetailsId).append(",<br>")
				.append(" Created At: ").append(createdAt).append(",<br>")
				.append(" Disabled At: ").append(disabledAt).append("<br>");
		
		return builder.toString();
	}
	
	/*
	 * @Override
	public String toString() { //Completo di tutto, alcuni attributi si possono togliere
		StringBuilder builder = new StringBuilder("{")
				.append(" Id: ").append(id)
				.append(", Quantity: ").append(quantity)
				.append(", Price: ").append(price)
				.append(", Order Id: ").append(orderId)
				.append(", Product Details Id: ").append(productDetailsId)
				.append(", Created At: ").append(createdAt)
				.append(", Disabled At: ").append(disabledAt)
				.append("}");
		
		return builder.toString();
	}
	 */

}
