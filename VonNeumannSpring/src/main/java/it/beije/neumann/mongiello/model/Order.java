package it.beije.neumann.mongiello.model;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
//	public enum PayStatus {payed,not_payed }
//	public enum OrderStatus {pending,confirmed,shipped,completed }

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column
	private String transaction;
	
	@Column(name="transaction_date")
	private LocalDateTime transactionDate;
	
	@Column(name="total_price")
	Double totalPrice;
	
	@Column(name="payment_status")
	private String paymentStatus;
	
	@Column
	private String status;
	
	@Column(name="user_id")
	private Integer userId;
	
	@Column(name="created_at")
	private LocalDateTime createdAt;
	
	@Column(name="disabeld_at")
	private LocalDateTime disabeldAt;

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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getDisabeldAt() {
		return disabeldAt;
	}

	public void setDisabeldAt(LocalDateTime disabeldAt) {
		this.disabeldAt = disabeldAt;
	}

	public LocalDateTime getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDateTime transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	
}
