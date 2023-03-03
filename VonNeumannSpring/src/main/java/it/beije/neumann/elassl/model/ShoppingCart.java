package it.beije.neumann.elassl.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "shopping_cart")
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "created_at", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(name = "disabled_at")
    private LocalDateTime disabledAt;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    public ShoppingCart() {}

    // Constructor without ID
    public ShoppingCart(LocalDateTime createdAt, LocalDateTime disabledAt, Integer userId) {
        this.createdAt = createdAt;
        this.disabledAt = disabledAt;
        this.userId = userId;
    }

    // Getters and Setters
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

	@Override
	public String toString() {
		return "ShoppingCart [id=" + id + ", createdAt=" + createdAt + ", disabledAt=" + disabledAt + ", userId="
				+ userId + "]";
	}
    

}