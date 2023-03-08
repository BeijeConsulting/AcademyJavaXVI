package it.beije.neumann.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.neumann.NotEnoughQuantityException;
import it.beije.neumann.NotEnoughQuantityException;
import it.beije.neumann.model.Product;
import it.beije.neumann.model.ProductDetails;
import it.beije.neumann.repository.ProductDetailRepository;


@Service
public class ProductDetailSerivce {

	@Autowired
	ProductDetailRepository productDetailRepository;
	
	public ProductDetails findByProductIdAndSize(Integer id, String size) {
		Optional<ProductDetails> pd = productDetailRepository.findByProductIdAndSize(id, size);
		if (pd.isPresent()) {
			ProductDetails productDetail = pd.get();
			return productDetail;
		} else return null;
	}
	
	
	public boolean checkQuantity( ProductDetails productDetail, Integer quantity ) throws NotEnoughQuantityException {
		if(  productDetail.getQuantity() < quantity) {
			throw new NotEnoughQuantityException();
		}else if ( quantity <= 0  ) {
			throw new IllegalArgumentException();
			
		}
		return true;
	}

}	
