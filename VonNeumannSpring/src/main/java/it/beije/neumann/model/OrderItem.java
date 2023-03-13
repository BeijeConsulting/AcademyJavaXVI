//package it.beije.neumann.model;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//
//@Entity
//@Table(name = "order_items")
//public class OrderItem {
//
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@Column(name = "id")
//	private Integer id;
//	
//	@Column(name = "orders_id")
//	private Integer orderId;
//	
//	@Column(name = "product_id")
//	private Integer productId;
//	
//	@Column(name = "quantity")
//	private Integer quantity;
//	
//	@Column(name = "price")
//	private Double price;
//	
//	@Column(name = "discount")
//	private Double discount;
//
//	
//	public Integer getId() {
//		return id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}
//
//	
//	public Integer getOrderId() {
//		return orderId;
//	}
//
//	public void setOrderId(Integer orderId) {
//		this.orderId = orderId;
//	}
//
//	
//	public Integer getProductId() {
//		return productId;
//	}
//
//	public void setProductId(Integer productId) {
//		this.productId = productId;
//	}
//
//	
//	public Integer getQuantity() {
//		return quantity;
//	}
//
//	public void setQuantity(Integer quantity) {
//		this.quantity = quantity;
//	}
//
//	
//	public Double getPrice() {
//		return price;
//	}
//
//	public void setPrice(Double price) {
//		this.price = price;
//	}
//
//	
//	public Double getDiscount() {
//		return discount;
//	}
//
//	public void setDiscount(Double discount) {
//		this.discount = discount;
//	}
//
//	
//	public String toString() {
//		StringBuilder builder = new StringBuilder("{")
//				.append(" id: ").append(id)
//				.append(", orderId: ").append(orderId)
//				.append(", productId: ").append(productId)
//				.append(", quantity: ").append(quantity)
//				.append(", price: ").append(price)
//				.append(", discount: ").append(discount)
//				.append("}");
//
//		return builder.toString();
//	}
//}