package it.beije.neumann.nidospring.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "shopping_cart_item")
public class ShoppingCartItem {

	// Properties mapping
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "quantity")
	private Integer quantity;

	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@Column(name = "disabled_at")
	private LocalDateTime disabledAt;

	@Column(name = "shopping_cart_id")
	private Integer shoppingCartId;

	@Column(name = "product_details_id")
	private Integer productDetailsId;

	// Getters-Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
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

	public Integer getShoppingCartId() {
		return shoppingCartId;
	}

	public void setShoppingCartId(Integer shoppingCartId) {
		this.shoppingCartId = shoppingCartId;
	}

	public Integer getProductDetailsId() {
		return productDetailsId;
	}

	public void setProductDetailsId(Integer productDetailsId) {
		this.productDetailsId = productDetailsId;
	}
	
	//Other methods
	@Override
	public String toString() { //Completo di tutto, alcuni attributi si possono togliere
		StringBuilder builder = new StringBuilder()
				.append(" Cart Item Id: ").append(id).append(",<br>")
				.append(" Quantity: ").append(quantity).append(",<br>")
				.append(" Created At: ").append(createdAt).append(",<br>")
				.append(" Disabled At: ").append(disabledAt).append(",<br>")
				.append(" Shopping Cart Id: ").append(productDetailsId).append(",<br>")
				.append(" Product Details Id: ").append(productDetailsId).append("<br>");
		
		return builder.toString();
	}
	
	/*
	 * @Override
	public String toString() { //Completo di tutto, alcuni attributi si possono togliere
		StringBuilder builder = new StringBuilder("{")
				.append(" Id: ").append(id)
				.append(", Quantity: ").append(quantity)
				.append(", Created At: ").append(createdAt)
				.append(", Disabled At: ").append(disabledAt)
				.append(", Shopping Cart Id: ").append(productDetailsId)
				.append(", Product Details Id: ").append(productDetailsId)
				.append("}");
		
		return builder.toString();
	}
	 */

}
