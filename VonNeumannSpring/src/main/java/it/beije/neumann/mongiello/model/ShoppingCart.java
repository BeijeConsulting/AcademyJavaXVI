package it.beije.neumann.mongiello.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="shopping_cart")
public class ShoppingCart {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name="user_id")
	private Integer userId;
	
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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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
