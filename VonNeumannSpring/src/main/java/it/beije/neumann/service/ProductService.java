package it.beije.neumann.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.neumann.model.Product;
import it.beije.neumann.model.ProductDetails;
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
	
//	public List<String> getSizes() {
//		List<String> sizes = productRepository.getSizes();
//		return sizes;
//	}

	
	public List<Product> find(String name,String category, String color, String type,  String brand, Double minPricel, Double maxPricel) {
		List<Product> products = productRepository.find(name, category, color, type, brand, minPricel, maxPricel);	
		if( products.size() == 0 ) throw new IndexOutOfBoundsException();
		
		return products;	
	}
	
	@Transactional
	public Product findById(Integer id) {
		Optional<Product> p = productRepository.findById(id);
		if (p.isPresent()) {
			Product productDetail = p.get();
			return productDetail;
		} else return null;
	}
	
	
	public ProductDetails getProductDetail( Product product, String size ) {
		ProductDetails pd;
		for( int i = 0; i < product.getProductDetails().size();i++ ) {
			if( product.getProductDetails().get(i).getSize().equals(size) ) {
				pd = product.getProductDetails().get(i);
				return pd;
			}
		}
		return null;
	}
	
	}


	