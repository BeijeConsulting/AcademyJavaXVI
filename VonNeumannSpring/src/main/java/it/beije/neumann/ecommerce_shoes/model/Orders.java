package it.beije.neumann.ecommerce_shoes.model;



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
import javax.persistence.Table;


@Entity
@Table(name = "orders")
public class Orders {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	

	@Column(name = "transaction")
	private String  transaction;
	

	@Column(name = "transaction_date")
	private LocalDateTime transactionDate;
	

	@Column(name = "payment_status")
	private String paymentStatus;
	

	@Column(name = "status")
	private String status;
	

	@Column(name = "created_at")
	private LocalDateTime createdAt;
	

	@Column(name = "total_price")
	private Double totalPrice;
	

	@Column(name = "disabled_at")
	private LocalDateTime disabledAt;
	

	@Column(name = "user_id")
	private Integer userId;
	

	
	@ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private List<User> users;
	
	 
	
	public List<User> getUsers() {
		return users;
	}

	public void setItems(List<User> users) {
		this.users = users;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTransaction() {
		return transaction;
	}

	public void setTransaction(String transaction) {
		this.transaction = transaction;
	}

	public LocalDateTime getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDateTime transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public LocalDateTime getDisabledAt() {
		return disabledAt;
	}

	public void setDisabledAt(LocalDateTime disabledAt) {
		this.disabledAt = disabledAt;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	
	public String toString() {
		StringBuilder builder = new StringBuilder("{")
				.append(" id: ").append(id)
				.append(", user_id: ").append(userId)
				.append(", total_price ").append(totalPrice)
				.append(", status: ").append(status)
				.append(", payment_status: ").append(paymentStatus)
				.append(", created_at: ").append(createdAt)
				.append(", disabled_at: ").append(disabledAt)
				.append("}");

		return builder.toString();
	}

	
}