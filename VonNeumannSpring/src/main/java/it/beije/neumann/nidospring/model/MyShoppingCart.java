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
@Table(name = "shopping_cart")
public class MyShoppingCart {

	// Properties mapping
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@Column(name = "disabled_at")
	private LocalDateTime disabledAt;

	@Column(name = "user_id")
	private Integer userId;
	
	@OneToMany(targetEntity = MyShoppingCartItem.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "shopping_cart_id")
	private List<MyShoppingCartItem> cartItems;

	// Getters-Setters
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

	public void setDisabledAt(LocalDateTime disabledAt) {
		this.disabledAt = disabledAt;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public List<MyShoppingCartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<MyShoppingCartItem> cartItems) {
		this.cartItems = cartItems;
	}

	//Other methods
	@Override
	public String toString() { //Completo di tutto, alcuni attributi si possono togliere
		StringBuilder builder = new StringBuilder()
				.append(" Shopping Cart Id: ").append(id).append(",<br>")
				.append(" Created At: ").append(createdAt).append(",<br>")
				.append(" Disabled At: ").append(disabledAt).append(",<br>")
				.append(" User Id: ").append(userId).append("<br>");
		
		return builder.toString();
	}
	
	/*
	 * @Override
	public String toString() { //Completo di tutto, alcuni attributi si possono togliere
		StringBuilder builder = new StringBuilder("{")
				.append(" Id: ").append(id)
				.append(", Created At: ").append(createdAt)
				.append(", Disabled At: ").append(disabledAt)
				.append(", User Id: ").append(userId)
				.append("}");
		
		return builder.toString();
	}
	 */

}
