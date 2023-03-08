package it.beije.neumann.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.beije.neumann.model.ShoppingCart;
import it.beije.neumann.model.ShoppingCartItem;

public interface ShoppingCartReposistory extends JpaRepository<ShoppingCart, Integer> {

	//Optional<ShoppingCart> findById(Integer id);

	@Query(value = "select c from ShoppingCart c where c.userId = 1")
	Optional<ShoppingCart> findUserId(Integer id);
	
}
