package it.beije.neumann.ecommerce_shoes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import it.beije.neumann.ecommerce_shoes.model.ShoppingCart;
import it.beije.neumann.ecommerce_shoes.model.ShoppingCartItem;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer>{
	
	@Query(value = "SELECT c.id FROM shopping_cart as c WHERE item.user_id = :userId", nativeQuery = true)
	public ShoppingCart findByUserId(Integer userId);
	

}
