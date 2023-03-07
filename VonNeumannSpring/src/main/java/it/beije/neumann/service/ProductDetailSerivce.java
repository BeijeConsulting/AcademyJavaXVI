package it.beije.neumann.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.neumann.model.ProductDetails;
import it.beije.neumann.repository.ProductDetailRepository;


@Service
public class ProductDetailSerivce {

	@Autowired
	ProductDetailRepository productDetailRepository;
	
	public List<ProductDetails> findByProductId( Integer id ) {	
		return productDetailRepository.findByProductId(id);
	}
	
//	public ProductDetails findByProductId( Integer id ) {		
//		Optional<ProductDetails> pd = productDetailRepository.findByProductId(id);
//		
//		if (pd.isPresent()) {
//			ProductDetails productDetail = pd.get();
//			return productDetail;
//		}else return null;
//	}

}	
