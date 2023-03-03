package it.beije.neumann.elassl.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.beije.neumann.elassl.model.ShoppingCart;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer> {

    List<ShoppingCart> findByUserId(Integer userId);

    List<ShoppingCart> findByDisabledAtIsNull();

    List<ShoppingCart> findByCreatedAtBetween(LocalDateTime start, LocalDateTime end);

}