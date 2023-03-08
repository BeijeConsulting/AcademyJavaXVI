package it.beije.neumann.ecommerce_shoes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.beije.neumann.ecommerce_shoes.model.ShoppingCartItem;
import it.beije.neumann.ecommerce_shoes.model.User;

@Repository
public interface ShoppingCartItemRepository extends JpaRepository<ShoppingCartItem, Integer>{
	
	@Query(value = "SELECT item.id  FROM shopping_cart_item as item WHERE item.shopping_cart_id = :cartId", nativeQuery = true)
	public List<Integer> findByCartId(@Param(value = "cartId") Integer cartId);

	@Query(value = "SELECT * FROM shopping_cart_item as item WHERE item.shopping_cart_id = :cartId AND item.product_details_id = :detailsId AND disabled_at IS NULL", nativeQuery = true)
	public ShoppingCartItem findExistingItem(@Param(value = "cartId") Integer cartId, @Param(value = "detailsId") Integer detailsId);
}
