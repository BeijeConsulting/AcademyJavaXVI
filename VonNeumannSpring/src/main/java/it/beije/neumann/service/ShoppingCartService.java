package it.beije.neumann.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.neumann.model.Product;
import it.beije.neumann.model.ProductDetails;
import it.beije.neumann.model.ShoppingCart;
import it.beije.neumann.repository.ShoppingCartReposistory;

@Service
public class ShoppingCartService {
	@Autowired
	ShoppingCartReposistory shoppingCartRepository;
	
//	@Transactional
//	public ShoppingCart findById(Integer id) {
//		Optional<ShoppingCart> sc = shoppingCartRepository.findById(id);
//		if (sc.isPresent()) {
//			ShoppingCart shoppingCart = sc.get();
//			System.out.println("Transactionale "+shoppingCart.getShoppingCartItem());
//			return shoppingCart;
//		} else return null;
//
//	}	
	
	@Transactional
	public ShoppingCart findShoppingCart(Integer id) {
		Optional<ShoppingCart> p = shoppingCartRepository.findById(id);
		if (p.isPresent()) {
			ShoppingCart shoppingCart = p.get();
			System.out.println("Transactionale "+shoppingCart.getShoppingCartItem().get(0).getProductDetails().getProduct().getName());
			return shoppingCart;
		}
		return null;
	}

	@Transactional
	public ShoppingCart findUserId(Integer id) {
		Optional<ShoppingCart> sc = shoppingCartRepository.findUserId(id);
		if (sc.isPresent()) {
			ShoppingCart shoppingCart = sc.get();
			System.out.println("Transactionale "+shoppingCart.getShoppingCartItem());
			return shoppingCart;
		} else return null;

	}	

}	