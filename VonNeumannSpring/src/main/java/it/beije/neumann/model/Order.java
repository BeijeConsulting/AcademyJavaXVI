//package it.beije.neumann.model;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//
//
//@Entity
//@Table(name = "orders")
//public class Order {
//
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@Column(name = "id")
//	private Integer id;
//	
//	@Column(name = "users_id")
//	private Integer userId;
//	
//	@Column(name = "datetime")
//	private LocalDateTime datetime;
//	
//	@Column(name = "amount")
//	private Double amount;
//	
//	@Column(name = "discount")
//	private Double discount;
//
////	@OneToMany(targetEntity = OrderItem.class, fetch = FetchType.LAZY)
//	@OneToMany(targetEntity = OrderItem.class, fetch = FetchType.EAGER)
//	@JoinColumn(name = "orders_id")
//	private List<OrderItem> items;
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
//	public Integer getUserId() {
//		return userId;
//	}
//
//	public void setUserId(Integer userId) {
//		this.userId = userId;
//	}
//
//	
//	public LocalDateTime getDatetime() {
//		return datetime;
//	}
//
//	public void setDatetime(LocalDateTime datetime) {
//		this.datetime = datetime;
//	}
//
//	
//	public Double getAmount() {
//		return amount;
//	}
//
//	public void setAmount(Double amount) {
//		this.amount = amount;
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
//	public List<OrderItem> getItems() {
//		return items;
//	}
//
//	public void setItems(List<OrderItem> items) {
//		this.items = items;
//	}
//
//
//	public String toString() {
//		StringBuilder builder = new StringBuilder("{")
//				.append(" id: ").append(id)
//				.append(", userId: ").append(userId)
//				.append(", datetime: ").append(datetime)
//				.append(", amount: ").append(amount)
//				.append(", discount: ").append(discount)
//				.append(", items: ").append(items)
//				.append("}");
//
//		return builder.toString();
//	}
//
//}
