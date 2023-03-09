package it.beije.neumann.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.neumann.model.Product;
import it.beije.neumann.model.ProductDetails;
import it.beije.neumann.model.ShoppingCart;
import it.beije.neumann.model.ShoppingCartItem;
import it.beije.neumann.repository.ShoppingCartItemRepository;
import it.beije.neumann.repository.ShoppingCartReposistory;
import it.beije.neumann.service.ProductDetailSerivce;
import it.beije.neumann.service.ShoppingCartItemService;
import it.beije.neumann.service.ShoppingCartService;

@Controller
public class CartController {
	
	@Autowired
	ShoppingCartService shoppingCartService;
	
	@Autowired
	ShoppingCartItemService shoppingCartItemService;
	
	@Autowired
	ShoppingCartItemRepository shoppingCartItemRepository;
	
	@RequestMapping(value = "/show_cart", method = RequestMethod.GET)
	public String showCart( Model model ){
	
		ShoppingCart shoppingCart = shoppingCartService.findShoppingCart(1);
		List<ShoppingCartItem> shoppingCartItemsList = shoppingCart.getShoppingCartItem();
		List<ShoppingCartItem> shoppingCartItemsListAvaibe =  new ArrayList<ShoppingCartItem>();
		double totale = 0 ;

		for( int i = 0; i < shoppingCartItemsList.size(); i++ ) {
			if( shoppingCartItemsList.get(i).getDisabledAt() == null ) {
				System.out.println("Disabilitato il " + shoppingCartItemsList.get(i).getDisabledAt());
				shoppingCartItemsListAvaibe.add(shoppingCartItemsList.get(i));
			}
		}
		for( int i = 0; i < shoppingCartItemsListAvaibe.size(); i++ ) {
			totale += shoppingCartItemsListAvaibe.get(i).getProductDetails().getSellingPrice();
		}		
		model.addAttribute("totale",totale);
		model.addAttribute("shoppingCart", shoppingCart);
		model.addAttribute("shoppingCartItemsList", shoppingCartItemsListAvaibe);

		
		return "cart";
	
	}
	
	@RequestMapping(value = "/remove_from_cart", method = RequestMethod.GET)
	public String removeFromCart( Model model, @RequestParam(required=false) String id  ){
		
		System.out.println("ID da rimuovere " +id);
		
		ShoppingCartItem shoppingCartItem = shoppingCartItemService.findById(Integer.valueOf(id));
		shoppingCartItem.setDisabledAt(LocalDateTime.now());
		shoppingCartItemRepository.save(shoppingCartItem);
	
		return "redirect: home";
	}
	
	
}
