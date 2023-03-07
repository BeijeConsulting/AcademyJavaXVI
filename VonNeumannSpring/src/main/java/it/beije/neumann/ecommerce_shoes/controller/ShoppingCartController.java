package it.beije.neumann.ecommerce_shoes.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import it.beije.neumann.ecommerce_shoes.model.OrdersItems;
import it.beije.neumann.ecommerce_shoes.model.Product;
import it.beije.neumann.ecommerce_shoes.model.ProductDetails;
import it.beije.neumann.ecommerce_shoes.model.ShoppingCart;
import it.beije.neumann.ecommerce_shoes.model.ShoppingCartItem;
import it.beije.neumann.ecommerce_shoes.model.User;
import it.beije.neumann.ecommerce_shoes.repository.OrdersItemsRepository;
import it.beije.neumann.ecommerce_shoes.repository.ShoppingCartItemRepository;
import it.beije.neumann.ecommerce_shoes.repository.ShoppingCartRepository;

@Controller
public class ShoppingCartController {
	
	
	@Autowired
	private ShoppingCartItemRepository cartItemRepo;
	
	@Autowired
	private ShoppingCartRepository shoppingCartRepo;
	
	/**
	 * Visualizzazione shopping_cart
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public String getCart(Model model,HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("GET /shopping_cart");
		
		
		int totale=0;
		List<ProductDetails> prodDetails=new ArrayList<>();
		List<Product> products=new ArrayList<>();
		
		
		HttpSession session = request.getSession();
		User user=(User) session.getAttribute("user");
		
		ShoppingCart userCart=shoppingCartRepo.findByUserId(user.getId());
		List<ShoppingCartItem> items= cartItemRepo.findByCartId(userCart.getId());
		
		for(ShoppingCartItem item : items) {
			prodDetails.add(item.getProductDetails());
		}
		
		for(ProductDetails det : prodDetails) {
			products.add(det.getProduct());
			totale+=det.getSellingPrice();
		}
		
		
		System.out.println(totale);

		System.out.println(prodDetails);
		model.addAttribute("totale",totale);
		model.addAttribute("pdetails",prodDetails);
		return "shopping_cart";
	}

}
