package it.beije.neumann.mongiello.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="shopping_cart_item")
public class ShoppingCartItem {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column
	private Integer quantity;
	
	@Column(name="shopping_cart_id")
	private Integer shoppingCartId;
	
	@Column(name="product_details_id")
	private Integer productDeteilsId;

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

	public Integer getProductDeteilsId() {
		return productDeteilsId;
	}

	public void setProductDeteilsId(Integer productDeteilsId) {
		this.productDeteilsId = productDeteilsId;
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

