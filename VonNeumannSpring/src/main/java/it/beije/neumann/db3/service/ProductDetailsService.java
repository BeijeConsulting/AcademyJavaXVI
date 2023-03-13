package it.beije.neumann.db3.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.beije.neumann.db3.model.Product;
import it.beije.neumann.db3.model.ProductDetails;
import it.beije.neumann.db3.repository.ProductDetailsRepository;
import it.beije.neumann.db3.repository.ProductRepository;

@Service
public class ProductDetailsService {
	@Autowired
    private ProductRepository productRepository;
	@Autowired
    private ProductDetailsRepository productDetailsRepository;
	@Transactional
	public Product getProduct(Integer productDetailsid) {
		Optional<ProductDetails> pd = productDetailsRepository.findById(productDetailsid);
		if(pd.isPresent()) {
			System.out.println(pd);
			return pd.get().getProduct();
		}
		return null;
	}
}