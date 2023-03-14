package it.beije.neumann.iaria_ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.neumann.iaria_ecommerce.model.Products;

@Repository
public interface ProductsRepository extends JpaRepository<Products, Integer> {
	public List<Products> findAll();
}