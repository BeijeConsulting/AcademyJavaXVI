package it.beije.neumann.ecommerce_shoes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.beije.neumann.ecommerce_shoes.model.ShoppingCartItem;
import it.beije.neumann.ecommerce_shoes.model.User;

@Repository
public interface ShoppingCartItemRepository extends JpaRepository<ShoppingCartItem, Integer>{
	
	@Query(value = "SELECT item.id,item.quantuty,item.created_at,item.disabled_at,item.shopping_cart_id,item.product_details_id FROM shopping_cart_item as item WHERE item.shopping_cart_id = :cartId", nativeQuery = true)
	public List<ShoppingCartItem> findByCartId(Integer cartId);

}
