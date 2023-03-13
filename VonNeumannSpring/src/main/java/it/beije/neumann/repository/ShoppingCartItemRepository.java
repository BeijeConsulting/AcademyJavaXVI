package it.beije.neumann.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import it.beije.neumann.model.ShoppingCartItem;

public interface ShoppingCartItemRepository extends JpaRepository<ShoppingCartItem, Integer> {

	Optional<ShoppingCartItem> findById(Integer id);

}
