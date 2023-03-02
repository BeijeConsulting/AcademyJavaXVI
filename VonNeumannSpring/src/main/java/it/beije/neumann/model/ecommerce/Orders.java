package it.beije.neumann.model.ecommerce;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private  PayStatus paymentStatus;
	

	@Column(name = "status")
	private Status status;
	

	@Column(name = "created_at")
	private LocalDateTime createdAt;
	

	@Column(name = "total_price")
	private double totalPrice;
	

	@Column(name = "disabled_at")
	private LocalDateTime disabledAt;
	

	@Column(name = "user_id")
	private int userId;
	
	
	 
	
	
	
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

	public PayStatus getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(PayStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
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

	public void setTotalPrice(double totalPrice) {
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

	public void setUserId(int userId) {
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

	enum PayStatus{
		PAYED,
		NOTPAYED;
	}

	enum Status{
		PENDING,
		CONFIRMED,
		SHIPPED,
		COMPLETED;
	}
}
