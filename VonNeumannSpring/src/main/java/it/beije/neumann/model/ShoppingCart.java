package it.beije.neumann.model;

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
import javax.transaction.Transactional;

@Entity
@Table(name = "shopping_cart")
public class ShoppingCart {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "created_at")
	private LocalDateTime createdAt;
	
	@Column(name = "disabled_at")
	private LocalDateTime disabledAt;
	
	@Column(name = "user_id")
	private Integer userId;
	
	@OneToMany(targetEntity = ShoppingCartItem.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "shopping_cart_id")
	List<ShoppingCartItem> shoppingCartItem;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt() {
		this.createdAt = LocalDateTime.now();
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
	
	
	public List<ShoppingCartItem> getShoppingCartItem() {
		return shoppingCartItem;
	}

	public void setShoppingCartItem(List<ShoppingCartItem> shoppingCartItem) {
		this.shoppingCartItem = shoppingCartItem;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		createdAt = LocalDateTime.now();
	}
	
	@Override
	public String toString() {
		return "ShoppingCart [id=" + id + ", createdAt=" + createdAt + ", disabledAt=" + disabledAt + ", userId="
				+ userId + ", shoppingCartItem=" + shoppingCartItem + "]";
	}
	
}