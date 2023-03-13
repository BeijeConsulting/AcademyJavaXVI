package it.beije.neumann.db3.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.neumann.db3.model.ShoppingCart;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer>{
	//ShoppingCart findByUserIdAndDisabledAtIsNull(Integer userId);
	Optional<ShoppingCart> findByUserId(Integer userId);
}
