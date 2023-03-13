package it.beije.neumann.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

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
import it.beije.neumann.model.User;
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
	public String showCart( HttpSession session, Model model ){
	
		try {
			ShoppingCart shoppingCart = null;
			User user =(User)session.getAttribute("user");
		
			if( user == null) {
				shoppingCart = (ShoppingCart) session.getAttribute("cart");
			}else {
				shoppingCart = shoppingCartService.findShoppingCart(user.getId());
			}
			

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
			totale += shoppingCartItemsListAvaibe.get(i).getProductDetails().getSellingPrice() * shoppingCartItemsListAvaibe.get(i).getQuantity();
		
		}		
		
	
		if( user == null ) {
			session.setAttribute("totale",totale);
			session.setAttribute("shoppingCart", shoppingCart);
			session.setAttribute("shoppingCartItemsList", shoppingCartItemsListAvaibe);
			
		}else {
			model.addAttribute("totale",totale);
			model.addAttribute("shoppingCart", shoppingCart);
			model.addAttribute("shoppingCartItemsList", shoppingCartItemsListAvaibe);
		}
			
		}catch( IndexOutOfBoundsException iofEX ) {
			String message = "Carrello vuoto";
			System.out.println(message + iofEX);
			model.addAttribute("message", message);
		}catch( NullPointerException npEX ) {
			String message = "Nulla";
			System.out.println(message + npEX);
			model.addAttribute("message", message);
		}
		
		return "cart";
	
	}
	
	@RequestMapping(value = "/remove_from_cart", method = RequestMethod.GET)
	public String removeFromCart( HttpSession session, Model model, @RequestParam(required=false) String id  ){
		try {
			System.out.println("ID da rimuovere " +id);
			User user =(User)session.getAttribute("user");
			
			if( user == null ) {
				ShoppingCartItem shoppingCartItem = shoppingCartItemService.findById(1);
				shoppingCartItem.setDisabledAt(LocalDateTime.now());

			}else {
				ShoppingCartItem shoppingCartItem = shoppingCartItemService.findById(Integer.valueOf(id));
				shoppingCartItem.setDisabledAt(LocalDateTime.now());
				shoppingCartItemRepository.save(shoppingCartItem);
			}
				
		}catch( IndexOutOfBoundsException iofEX ) {
			String message = "Carrello vuoto";
			System.out.println(message + iofEX);
			model.addAttribute("message", message);
		}catch( NullPointerException npEX ) {
			String message = "Nulla";
			System.out.println(message + npEX);
			model.addAttribute("message", message);
		}
			return "redirect: home";
	}
	
	
}
