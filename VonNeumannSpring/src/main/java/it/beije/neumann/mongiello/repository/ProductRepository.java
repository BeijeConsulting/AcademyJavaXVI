package it.beije.neumann.mongiello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.neumann.mongiello.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
