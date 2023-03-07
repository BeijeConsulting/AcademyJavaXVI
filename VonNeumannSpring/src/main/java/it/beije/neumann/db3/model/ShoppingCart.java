package it.beije.neumann.db3.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import it.beije.neumann.model.OrderItem;

@Entity
@Table(name = "shopping_cart")
public class ShoppingCart {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "created_at", nullable = false)
	@Generated(value=GenerationTime.INSERT)
	private LocalDateTime createdAt;
	
	@Column(name = "disabled_at")
	private LocalDateTime disabledAt;
	
	@Column(name = "user_id", unique = true, nullable = false)
	private Integer userId;
	

	@OneToOne(mappedBy = "shoppingCart", cascade = CascadeType.ALL)
	private User user;
	
	//@OneToMany(targetEntity = ShoppingCartItem.class, fetch = FetchType.EAGER)
	//@JoinColumn(name = "shopping_cart_id")
	//private List<ShoppingCartItem> shoppingCartItem;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
	public void setDisableAt(LocalDateTime disabledAt) {
		this.disabledAt = disabledAt;
	}
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	@OneToMany(targetEntity = ShoppingCartItem.class,fetch = FetchType.LAZY)
	@JoinColumn(name = "shopping_cart_id")
	private List<ShoppingCartItem> shoppingCartItem;

	public List<ShoppingCartItem> getShoppingCartItem() {
		return shoppingCartItem;
	}

	public void setShoppingCartItem(List<ShoppingCartItem> shoppingCartItem) {
		this.shoppingCartItem = shoppingCartItem;
	}
	public void addShoppingCartItem(ShoppingCartItem shoppingCartItem) {
		this.shoppingCartItem.add(shoppingCartItem);
	}

	public void setDisabledAt(LocalDateTime disabledAt) {
		this.disabledAt = disabledAt;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder("{")
				.append(" ID: ").append(id)
				.append(", Created: ").append(createdAt)
				.append(", Disabled: ").append(disabledAt)
				.append(", User id: ").append(userId)
				.append("}");

		return builder.toString();
	}

}
