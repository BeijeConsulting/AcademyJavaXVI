package it.beije.neumann.iaria_ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import it.beije.neumann.iaria_ecommerce.dto.ProductDTO;
import it.beije.neumann.iaria_ecommerce.model.Products;
import it.beije.neumann.iaria_ecommerce.repository.ProductsRepository;

@Service
public class ProductService{

	@Autowired
	private ProductsRepository productRepository;
	
	public List<Products> findAll() {		
		return productRepository.findAll();
	}
	
}
