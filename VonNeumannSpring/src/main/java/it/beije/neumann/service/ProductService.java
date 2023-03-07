package it.beije.neumann.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.neumann.model.Product;
import it.beije.neumann.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	//@Transactional
	public List<Product> findAll() {
		List<Product> products = productRepository.findAll();
		//System.out.println(products.get(0).getProductDetails().get(0).getSellingPrice());
		return products;
	}
	
	public List<Product> findAvailble() {		
		return productRepository.findAvailble();
	}
	
	public Double findMinSellingPrice() {
		Double minPrice = productRepository.findMinSellingPrice();
		return minPrice;
	}
	
	public Double findMaxSellingPrice() {
		Double maxPrice = productRepository.findMaxSellingPrice();
		return maxPrice;
	}
	
	public List<String> getCategories() {
		List<String> categories = productRepository.getCategories();
		return categories;
	}
	
	public List<String> getTypes() {
		List<String> types = productRepository.getTypes();
		return types;
	}
	
	public List<String> getBrands() {
		List<String> brands = productRepository.getBrands();
		return brands;
	}

	public List<Product> find(String name,String category, String color, String type,  String brand, Double minPricel, Double maxPricel) {
		List<Product> products = productRepository.find(name, category, color, type, brand, minPricel, maxPricel);	
		return products;	
	}
	
	public Product findById(Integer id) {
		Optional<Product> p = productRepository.findById(id);
		if (p.isPresent()) {
			Product product = p.get();
			return product;
		} else return null;
	}

	




}