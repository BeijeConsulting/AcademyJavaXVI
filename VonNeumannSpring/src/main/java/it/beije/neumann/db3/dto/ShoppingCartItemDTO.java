package it.beije.neumann.db3.dto;

public class ShoppingCartItemDTO {
	  private int quantity;
	  private int productItemId;

	  public int getQuantity() {
	    return quantity;
	  }

	  public void setQuantity(int quantity) {
	    this.quantity = quantity;
	  }

	  public int getProductItemId() {
	    return productItemId;
	  }

	  public void setProductItemId(int productItemId) {
	    this.productItemId = productItemId;
	  }

	}