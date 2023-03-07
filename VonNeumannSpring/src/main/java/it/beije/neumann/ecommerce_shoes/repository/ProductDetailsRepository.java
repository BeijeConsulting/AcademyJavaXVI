package it.beije.neumann.ecommerce_shoes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.neumann.ecommerce_shoes.model.ConvertionSize;
import it.beije.neumann.ecommerce_shoes.model.Product;
import it.beije.neumann.ecommerce_shoes.model.ProductDetails;

@Repository
public interface ProductDetailsRepository extends JpaRepository<ProductDetails, Integer>{
	public List<ProductDetails> findByProductIdAndSize(Product product, ConvertionSize size);
	public List<ProductDetails> findByProductId(Product product);
}
