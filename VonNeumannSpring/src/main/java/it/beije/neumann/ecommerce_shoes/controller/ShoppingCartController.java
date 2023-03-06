package it.beije.neumann.ecommerce_shoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import it.beije.neumann.ecommerce_shoes.model.OrdersItems;
import it.beije.neumann.ecommerce_shoes.repository.OrdersItemsRepository;

@Controller
public class ShoppingCartController {
	
	
	@Autowired
	private OrdersItemsRepository orderItemRepo;
	
	
	
	@RequestMapping(value = "/shopping_cart", method = RequestMethod.GET)
	public String getCart(Model model) {
		System.out.println("GET /shopping_cart");
		List<OrdersItems> items=orderItemRepo.findAll();
		model.addAttribute("items",items);
		return "shopping_cart";
	}

}
