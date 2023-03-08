package it.beije.neumann.ecommerce_shoes.model;


	import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
	import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

	@Entity
	@Table(name = "order_items")
	public class OrdersItems {
		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name = "id")
		private Integer id;
		
		
		@Column(name = "quantity")
		private Integer quantity;
		
		@Column(name = "price")
		private Double price;
		
		
		@Column(name = "created_at")
		private LocalDateTime createdAt;
		
		@Column(name = "disabled_at")
		private LocalDateTime disabledAt;
		
		@Column(name = "name")
		private String name;
		
		@Column(name = "color")
		private String color;

		
		@ManyToOne(targetEntity = Orders.class, fetch = FetchType.EAGER)
		@JoinColumn(name = "order_id")
		private Orders order;
		
		@OneToOne(targetEntity = ProductDetails.class, fetch = FetchType.EAGER)
		@JoinColumn(name = "product_details_id")
		private ProductDetails productDetails;
		
		@OneToOne(targetEntity = ConvertionSize.class, fetch = FetchType.EAGER)
		@JoinColumn(name = "size")
		private ConvertionSize size;
		
		
		public ProductDetails getProductDetails() {
			return productDetails;
		}

		public void setProductDetails(ProductDetails productDetails) {
			this.productDetails=productDetails;
					
		}
		
		
		public ConvertionSize getSize() {
			return size;
		}

		public void setSize(ConvertionSize size) {
			this.size=size;
					
		}
		
		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(Integer quantity) {
			this.quantity = quantity;
		}

		public Double getPrice() {
			return price;
		}

		public void setPrice(Double price) {
			this.price = price;
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
		
		
		
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name=name;
		}
		
		public String getColor() {
			return color;
		}
		
		public void setColor(String color) {
			this.color=color;
		}

		public String toString() {
			StringBuilder builder = new StringBuilder("{")
					.append(" id: ").append(id)
					.append(", order_id: ").append(order.getId())
					.append(", quantity: ").append(quantity)
					.append(", product_details_id: ").append(productDetails.getId())
					.append(", price: ").append(price)
					.append(", name: ").append(name)
					.append(", size: ").append(size)
					.append(", color: ").append(color)
					.append(", created_at: ").append(createdAt)
					.append(", disabled_at: ").append(disabledAt)
					.append("}");

			return builder.toString();
		}
	}

