package it.beije.neumann.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.beije.neumann.model.ShoppingCart;


public interface ShoppingCartRepository  extends JpaRepository<ShoppingCart, Integer> {

}
