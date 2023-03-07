package it.beije.neumann.db3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.beije.neumann.db3.model.Product;
import it.beije.neumann.db3.model.ProductDetails;
import it.beije.neumann.db3.model.ShoppingCart;
import it.beije.neumann.db3.model.ShoppingCartItem;
import it.beije.neumann.db3.repository.ProductDetailsRepository;
import it.beije.neumann.db3.repository.ProductRepository;
import it.beije.neumann.db3.repository.ShoppingCartRepository;
import it.beije.neumann.db3.repository.ShoppingCartItemRepository;

@Service
public class ShoppingCartService {
	@Autowired
	private ShoppingCartRepository shoppingCartRepository;
	@Autowired
	private ShoppingCartItemRepository shoppingCartItemRepository;
	@Autowired
	private ProductDetailsRepository productDetailsRepository;

	@Transactional
	public ShoppingCart findShoppingCart(Integer id) {
		Optional<ShoppingCart> p = shoppingCartRepository.findById(id);
		return p.isPresent() ? p.get() : null;
	}

	@Transactional
	public void addShoppingCartItem(Integer shoppingCartId, Integer productDetailsId, Integer quantity) {

		ShoppingCart s = findShoppingCart(shoppingCartId);
		ShoppingCartItem item = new ShoppingCartItem();
		Optional<ProductDetails> pd = productDetailsRepository.findById(productDetailsId);

		if (pd.isPresent() && s != null) {
			item.setProductDetailsId(pd.get().getId());
			item.setShoppingCartId(s.getId());
			item.setQuantity(quantity.intValue());
			shoppingCartItemRepository.save(item);
		}
	}
}
