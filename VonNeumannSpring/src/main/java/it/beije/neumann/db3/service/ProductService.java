package it.beije.neumann.db3.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.beije.neumann.db3.model.Product;
import it.beije.neumann.db3.model.ProductDetails;
import it.beije.neumann.db3.repository.ProductRepository;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;
    
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

	public Product findProduct(Integer id) {
		Optional<Product> p = productRepository.findById(id);
		return p.isPresent() ? p.get() : null;
	}
	@Transactional
	public List<ProductDetails> getProductDetails(Integer id){
		Product p = findProduct(id);
		List<ProductDetails> pd = new ArrayList<>();
		if(p!=null) {
			pd = p.getProductDetails();
		}
		return pd;
	}
}
