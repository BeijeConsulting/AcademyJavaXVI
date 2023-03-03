package it.beije.neumann.elassl.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "shopping_cart_item")
public class ShoppingCartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "created_at", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(name = "disabled_at")
    private LocalDateTime disabledAt;

    @Column(name = "shopping_cart_id", nullable = false)
    private Integer shoppingCartId;

    @Column(name = "product_details_id", nullable = false)
    private Integer productDetailsId;

    public ShoppingCartItem() {}

    /* Constructor without id
    public ShoppingCartItem(Integer quantity, LocalDateTime createdAt, LocalDateTime disabledAt, Integer shoppingCartId, Integer productDetailsId) {
        this.quantity = quantity;
        this.createdAt = createdAt;
        this.disabledAt = disabledAt;
        this.shoppingCartId = shoppingCartId;
        this.productDetailsId = productDetailsId;
    }*/

    // Getters and Setters
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

	@Override
	public String toString() {
		return "ShoppingCartItem [id=" + id + ", quantity=" + quantity + ", createdAt=" + createdAt + ", disabledAt="
				+ disabledAt + ", shoppingCartId=" + shoppingCartId + ", productDetailsId=" + productDetailsId + "]";
	}
    
}
