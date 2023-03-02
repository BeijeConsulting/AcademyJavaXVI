package it.beije.neumann.mongiello.model;

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
	public enum PayStatus {payed,not_payed }
	public enum OrderStatus {pending,confirmed,shipped,completed }

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column
	private String transaction;
	
	@Column(name="payment_status")
	private PayStatus paymentStatus;
	
	@Column
	private OrderStatus status;
	
	@Column(name="user_id")
	private Integer userId;
	
	@Column(name="created_at")
	private Date createdAt;
	
	@Column(name="disabeld_at")
	private Date disabeldAt;

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

	public PayStatus getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(PayStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getDisabeldAt() {
		return disabeldAt;
	}

	public void setDisabeldAt(Date disabeldAt) {
		this.disabeldAt = disabeldAt;
	}
	
	
}
