package it.beije.neumann.model;

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
import javax.transaction.Transactional;

@Entity
@Table(name = "shopping_cart_item")
public class ShoppingCartItem {

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

    @OneToOne(fetch= FetchType.EAGER)
    @JoinColumn(name = "product_details_id")
    private ProductDetails productDetails;

    @Transactional
    public ProductDetails getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(ProductDetails productDetails) {
		this.productDetails = productDetails;
	}

//	@Column(name="product_details_id")
//    private Integer productDetailsId;
    
    @Column(name="shopping_cart_id")
    private Integer shoppingCartId;
    
    public Integer getShoppingCartId() {
		return shoppingCartId;
	}

	public void setShoppingCartId(Integer shoppingCartId) {
		this.shoppingCartId = shoppingCartId;
	}

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

    public void setCreatedAt() {
    	createdAt = LocalDateTime.now();
    }

    public LocalDateTime getDisabledAt() {
        return disabledAt;
    }

    public void setDisabledAt(LocalDateTime disabledAt) {
        this.disabledAt = disabledAt;
    }

//    public ShoppingCart getShoppingCart() {
//        return shoppingCart;
//    }
//
//    public void setShoppingCart(ShoppingCart shoppingCart) {
//        this.shoppingCart = shoppingCart;
//    }

//    public ProductDetails getProductDetails() {
//        return productDetails;
//    }
//
//    public void setProductDetails(ProductDetails productDetails) {
//        this.productDetails = productDetails;
//    }

//	@Override
//	public String toString() {
//		return "ShoppingCartItem [id=" + id + ", quantity=" + quantity + ", createdAt=" + createdAt + ", disabledAt="
//				+ disabledAt + ", shoppingCart=" + shoppingCart + ", productDetails=" + productDetails + "]";
//	}
    
//	public Integer getProductDetailsId() {
//		return productDetailsId;
//	}
//
//	public void setProductDetailsId( Integer productDetailsId) {
//		this.productDetailsId = productDetailsId;
//	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "ShoppingCartItem [id=" + id + ", quantity=" + quantity + ", createdAt=" + createdAt + ", disabledAt="
				+ disabledAt + ", productDetailsID=" + productDetails + "]";
	}
}