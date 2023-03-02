package it.beije.neumann.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.neumann.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}