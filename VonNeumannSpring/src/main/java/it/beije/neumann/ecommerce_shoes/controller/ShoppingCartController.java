package it.beije.neumann.ecommerce_shoes.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import it.beije.neumann.ecommerce_shoes.model.OrdersItems;
import it.beije.neumann.ecommerce_shoes.model.Product;
import it.beije.neumann.ecommerce_shoes.model.ProductDetails;
import it.beije.neumann.ecommerce_shoes.model.ShoppingCartItem;
import it.beije.neumann.ecommerce_shoes.repository.OrdersItemsRepository;
import it.beije.neumann.ecommerce_shoes.repository.ShoppingCartItemRepository;

@Controller
public class ShoppingCartController {
	
	
	@Autowired
	private ShoppingCartItemRepository cartItemRepo;
	
	
	
	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public String getCart(Model model) {
		
		int totale=0;
		List<ProductDetails> det=new ArrayList<>();
		List<Product> products=new ArrayList<>();
		System.out.println("GET /shopping_cart");
		List<ShoppingCartItem> items=cartItemRepo.findAll();
		
		
		for(ShoppingCartItem item: items) {
			totale+=item.getProductDetails().getSellingPrice();
			det.add(item.getProductDetails());
		}
		for(ProductDetails p: det) {
			
			products.add(p.getProduct());
			
		}
		
		
		System.out.println(totale);

		System.out.println(det);
		model.addAttribute("totale",totale);
		model.addAttribute("products",products);
		return "shopping_cart";
	}

}
