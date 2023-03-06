package it.beije.neumann.ecommerce_shoes.model;



import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "shopping_cart_item")
public class ShoppingCartItem {
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@Column(name = "disabled_at")
	private LocalDateTime disabledAt;
	
	@Column(name = "quantity")
	private Integer quantity;

	@Column(name = "shopping_cart_id")
	private Integer shoppingCartId;
	
	@Column(name = "product_details_id")
	private Integer productDetailsId;
	
	@ManyToOne(targetEntity = ShoppingCart.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "shopping_cart_id")
	private ShoppingCart shoppingCart;
	

	@OneToOne(targetEntity = ProductDetails.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "product_details_id")
	private ProductDetails productDetails;
	
	public ProductDetails getProductDetails() {
		return productDetails;
	}
	
	public void getProductDetails(ProductDetails productDetails) {
		this.productDetails = productDetails;
	}
	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}


	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}


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

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
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

	public String toString() {
		StringBuilder builder = new StringBuilder("{")
				.append(" id: ").append(id)
				.append(", quantity: ").append(quantity)
				.append(", shopping_cart_item: ").append(shoppingCartId)
				.append(", products_details_id: ").append(productDetailsId)
				
				.append(", created_at: ").append(createdAt)
				.append(", disabled_at: ").append(disabledAt)
				.append("}");

		return builder.toString();
	}

}
