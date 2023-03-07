package it.beije.neumann.service;

import java.util.List;

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
	
	public Double findMinSellingPrice() {
		Double minPrice = productRepository.findMinSellingPrice();
		return minPrice;
	}
	
	public Double findMaxSellingPrice() {
		Double maxPrice = productRepository.findMaxSellingPrice();
		return maxPrice;
	}
	
//	
//	@Transactional
//	public List<Product> findByName(String name) {
//		List<Product> products = productRepository.findByName(name);
//		System.out.println(products.get(0).getProductDetails().get(0).getSellingPrice());
//		return products;
//	}
//	
//	@Transactional
//	public List<Product> findByCategory(String category) {
//		List<Product> products = productRepository.findByCategory(category);
//		System.out.println(products.get(0).getProductDetails().get(0).getSellingPrice());
//		return products;
//	}
//
//	@Transactional
//	public List<Product> findByColor(String color) {
//		List<Product> products = productRepository.findByColor(color);
//		System.out.println(products.get(0).getProductDetails().get(0).getSellingPrice());
//		return products;
//	}
//	
//	@Transactional
//	public List<Product> findByNameAndCategoryAndColor(String name, String category, String color) {
//		List<Product> products = productRepository.findByNameAndCategoryAndColor(name, category ,color);
//		System.out.println(products.get(0).getProductDetails().get(0).getSellingPrice());
//		return products;
//	}
//	
//	@Transactional
//	public List<Product> findByNameAndColor(String name, String color) {
//		List<Product> products = productRepository.findByNameAndColor(name,color);
//		System.out.println(products.get(0).getProductDetails().get(0).getSellingPrice());
//		return products;
//	}
//
//	@Transactional
//	public List<Product> findByCategoryAndColor( String category, String color) {
//		List<Product> products = productRepository.findByCategoryAndColor( category ,color);
//		System.out.println(products.get(0).getProductDetails().get(0).getSellingPrice());
//		return products;
//	}
//
//	
//	@Transactional
//	public List<Product> findByNameAndCategory(String name,String category) {
//		List<Product> products = productRepository.findByNameAndCategory(name, category);
//		System.out.println(products.get(0).getProductDetails().get(0).getSellingPrice());
//		return products;	
//	}
//	
	//@Transactional
	public List<Product> find(String name,String category, String color, String type,  String brand, Double minPricel, Double maxPricel) {
		List<Product> products = productRepository.find(name, category, color, type, brand, minPricel, maxPricel);
	//	System.out.println(products.get(0).getProductDetails().get(0).getSellingPrice());
		
		
		return products;	
	}

//	
//	@Transactional
//	public List<Product> find(String name,String category) {
//		List<Product> products = productRepository.findByNameAndCategory(name, category);
//		System.out.println(products.get(0).getProductDetails().get(0).getSellingPrice());
//		return products;
	
	




}