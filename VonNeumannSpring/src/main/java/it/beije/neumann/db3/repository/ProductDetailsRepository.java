package it.beije.neumann.db3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.beije.neumann.db3.model.ProductDetails;

public interface ProductDetailsRepository extends JpaRepository<ProductDetails, Integer>{
	
};
