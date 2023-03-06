package it.beije.neumann.db3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.beije.neumann.db3.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
}