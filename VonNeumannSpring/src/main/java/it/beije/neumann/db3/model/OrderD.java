package it.beije.neumann.db3.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
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

import it.beije.neumann.model.OrderItem;

@Entity
@Table(name = "orders")
public class OrderD {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "transaction")
    private String transaction;
    
    @Column(name = "transaction_date")
    private Date transactionDate;
    
    @Column(name = "payment_status")
    private String paymentStatus;
    
    @Column(name = "status")
    private String status;
    
    @Column(name = "total_price")
    private double totalPrice;
    
    @Column(name = "created_at")
    private Date createdAt;
    
    @Column(name = "disabled_at")
    private Date disabledAt;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id")
    private Address address;
    
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItemD> orderItems = new ArrayList<>();
    
    public OrderD() {
    }

	@Override
	public String toString() {
		return "Order [id=" + id + ", transaction=" + transaction + ", paymentStatus=" + paymentStatus + ", status="
				+ status + ", totalPrice=" + totalPrice + ", user=" + user + ", orderItems=" + orderItems + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTransaction() {
		return transaction;
	}

	public void setTransaction(String transaction) {
		this.transaction = transaction;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
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

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getDisabledAt() {
		return disabledAt;
	}

	public void setDisabledAt(Date disabledAt) {
		this.disabledAt = disabledAt;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<OrderItemD> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItemD> orderItems) {
		this.orderItems = orderItems;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

    
    
}