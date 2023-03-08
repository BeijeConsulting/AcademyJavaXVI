package it.beije.neumann.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import it.beije.neumann.model.ProductDetails;

public interface ProductDetailRepository extends JpaRepository<ProductDetails, Integer>{


	
	

}
