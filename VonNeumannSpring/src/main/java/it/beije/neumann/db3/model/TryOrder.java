package it.beije.neumann.db3.model;

import java.time.LocalDate;
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
public class TryOrder {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "transaction")
    private String transaction;
    
    @Column(name = "transaction_date")
    private LocalDate transactionDate;
    
    @Column(name = "payment_status", nullable = false)
    private String paymentStatus;
    
    @Column(name = "status", nullable = false)
    private String status;
    
    @Column(name = "total_price", nullable = false)
    private Double totalPrice;
    
    @Column(name = "created_at", nullable = false)
    private LocalDate createdAt;
    
    @Column(name = "disabled_at")
    private LocalDate disabledAt;
    
    @Column(name = "user_id", nullable = false)
    private Integer userId;
    
    @Column(name = "address_id", nullable = false)
    private Integer addressId;
    
	@OneToMany(targetEntity = TryOrderItem.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "order_id")
    private List<TryOrderItem> orderItems;

	@Override
	public String toString() {
		return "TryOrder [id=" + id + ", transaction=" + transaction + ", transactionDate=" + transactionDate
				+ ", paymentStatus=" + paymentStatus + ", status=" + status + ", totalPrice=" + totalPrice
				+ ", createdAt=" + createdAt + ", disabledAt=" + disabledAt + ", userId=" + userId + ", addressId="
				+ addressId + ", orderItems=" + orderItems + "]";
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

	public LocalDate getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(LocalDate transactionDate) {
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

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
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

	public List<TryOrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<TryOrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}
 
}