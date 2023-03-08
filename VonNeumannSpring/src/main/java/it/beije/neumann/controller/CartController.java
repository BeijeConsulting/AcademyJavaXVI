package it.beije.neumann.controller;

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
import it.beije.neumann.repository.ShoppingCartReposistory;
import it.beije.neumann.service.ProductDetailSerivce;
import it.beije.neumann.service.ShoppingCartService;

@Controller
public class CartController {
	
	@Autowired
	ShoppingCartService shoppingCartService;
	
	@RequestMapping(value = "/show_cart", method = RequestMethod.GET)
	public String showCart( Model model ){
		
		
		ShoppingCart shoppingCart = shoppingCartService.findShoppingCart(1);
		List<ShoppingCartItem> shoppingCartItemsList = shoppingCart.getShoppingCartItem();
		double totale = 0 ;

		model.addAttribute("totale",totale);
		model.addAttribute("shoppingCart", shoppingCart);
		model.addAttribute("shoppingCartItemsList", shoppingCartItemsList);
		return "cart";
	
	}
	

}
