package it.beije.neumann.nidospring.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class MyOrder {

	// Properties mapping
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "transaction")
	private String transaction;

	@Column(name = "transaction_date")
	private LocalDateTime transactionDate;

	@Column(name = "payment_status")
	private String paymentStatus;

	@Column(name = "status")
	private String status;

	@Column(name = "total_price")
	private Double totalPrice;

	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@Column(name = "disabled_at")
	private LocalDateTime disabledAt;

	@Column(name = "user_id")
	private Integer userId;
	
	@OneToMany(targetEntity = MyOrderItem.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "order_id")
	private List<MyOrderItem> items;

	// Getters-Setters
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

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public List<MyOrderItem> getItems() {
		return items;
	}

	public void setItems(List<MyOrderItem> items) {
		this.items = items;
	}

	//Other methods
	@Override
	public String toString() { //Completo di tutto, alcuni attributi si possono togliere
		StringBuilder builder = new StringBuilder()
				.append(" Order Id: ").append(id).append(",<br>")
				.append(" Transaction: ").append(transaction).append(",<br>")
				.append(" Transaction Date: ").append(transactionDate).append(",<br>")
				.append(" Payment Status: ").append(paymentStatus).append(",<br>")
				.append(" Status: ").append(status).append(",<br>")
				.append(" Total Price: ").append(totalPrice).append(",<br>")
				.append(" Created At: ").append(createdAt).append(",<br>")
				.append(" Disabled At: ").append(disabledAt).append(",<br>")
				.append(" User Id: ").append(userId).append(",<br>")
				.append(" Items: ").append(items).append("<br>");
		
		return builder.toString();
	}
	
	/*
	 * @Override
	public String toString() { //Completo di tutto, alcuni attributi si possono togliere
		StringBuilder builder = new StringBuilder("{")
				.append(" Id: ").append(id)
				.append(", \nTransaction: ").append(transaction)
				.append(", \nTransaction Date: ").append(transactionDate)
				.append(", \nPayment Status: ").append(paymentStatus)
				.append(", \nStatus: ").append(status)
				.append(", \nTotal Price: ").append(totalPrice)
				.append(", \nCreated At: ").append(createdAt)
				.append(", \nDisabled At: ").append(disabledAt)
				.append(", \nUser Id: ").append(userId)
				.append("}");
		
		return builder.toString();
	}
	 */

}
