package it.beije.neumann.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.beije.neumann.model.ShoppingCartItem;

public interface CartItemRepository extends JpaRepository<ShoppingCartItem, Integer> {

}
