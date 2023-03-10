package it.beije.neumann.db3.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.beije.neumann.db3.model.ProductDetails;
import it.beije.neumann.db3.model.ShoppingCart;
import it.beije.neumann.db3.model.ShoppingCartItem;
import it.beije.neumann.db3.repository.ProductDetailsRepository;
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
	public ProductDetails getProduct(Integer cartItemId) {
		Optional<ShoppingCartItem> shoppingCartItem = shoppingCartItemRepository.findById(cartItemId);
		if(shoppingCartItem.isPresent()) {
			Optional<ProductDetails> p = productDetailsRepository.findById(shoppingCartItem.get().getProductDetailsId());
			if(p.isPresent()) return p.get();
			
		}
		return null;
	}
	
	@Transactional
	public List<ShoppingCartItem> getShoppingCartItems(Integer shoppingCartId) {
		ShoppingCart s = findShoppingCart(shoppingCartId);
		System.out.println("service getShoppingCartItems ShoppingCart: "+s);
		List<ShoppingCartItem> items = s.getShoppingCartItem();
		System.out.println("unlazy "+s);
		if(items == null)
			items = new ArrayList<ShoppingCartItem>();
		
		List<ShoppingCartItem> items2 = new ArrayList<>();
		
		for(ShoppingCartItem item : items) {
			if(item.getDisabledAt()==null) {
				items2.add(item);
			}
		}
		
		return items2;
	}
	
	@Transactional
	public ShoppingCart emptyShoppingCart(Integer shoppingCartId) {
		ShoppingCart s = findShoppingCart(shoppingCartId);
		System.out.println("emptyShoppingCart/ s -> "+s);
		List<ShoppingCartItem> items = getShoppingCartItems(shoppingCartId);
		System.out.println("emptyShoppingCart/ items -> "+items);
		for(ShoppingCartItem item: items) {
			item.setDisableAt(LocalDateTime.now());
//			item.setShoppingCartId(null); //todo in realtà non bisogna farlo e nel getShoppingCart items e service controller di shopping cart va controllata la deletedat
		}
//		s.setShoppingCartItem(null);
		return s;
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
	@Transactional
	public void removeShoppingCartItem(Integer shoppingCartId, Integer shoppingCartItemId) {

		List<ShoppingCartItem> items = getShoppingCartItems(shoppingCartId);
		for(ShoppingCartItem i: items) {
			if(i.getId().intValue()==shoppingCartItemId.intValue()) {
				i.setDisableAt(LocalDateTime.now());
			}
		}
	}

	@Transactional
	public void editShoppingCartQuantity(Integer shoppingCartId, Integer shoppingCartItemId, Integer quantity) {

		List<ShoppingCartItem> items = getShoppingCartItems(shoppingCartId);
		for(ShoppingCartItem i: items) {
			if(i.getId().intValue()==shoppingCartItemId.intValue()) {
				i.setQuantity(quantity);
			}
		}
	}
}