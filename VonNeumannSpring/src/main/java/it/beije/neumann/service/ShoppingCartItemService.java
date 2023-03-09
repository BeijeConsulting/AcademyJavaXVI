package it.beije.neumann.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.neumann.model.Product;
import it.beije.neumann.model.ShoppingCartItem;
import it.beije.neumann.repository.ShoppingCartItemRepository;

@Service
public class ShoppingCartItemService {

	@Autowired
	ShoppingCartItemRepository shoppingCartItemRepository;
	

	public ShoppingCartItem findById(Integer id) {
		Optional<ShoppingCartItem> si = shoppingCartItemRepository.findById(id);
		if (si.isPresent()) {
			ShoppingCartItem shoppingCartItem = si.get();
			return shoppingCartItem;
		} else return null;
	}
}
