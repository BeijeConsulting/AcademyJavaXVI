package it.beije.neumann.ecommerce_shoes.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.neumann.ecommerce_shoes.model.Product;
import it.beije.neumann.ecommerce_shoes.model.ProductDetails;
import it.beije.neumann.ecommerce_shoes.model.ShoppingCart;
import it.beije.neumann.ecommerce_shoes.model.ShoppingCartItem;
import it.beije.neumann.ecommerce_shoes.model.User;
import it.beije.neumann.ecommerce_shoes.repository.ProductDetailsRepository;
import it.beije.neumann.ecommerce_shoes.repository.ShoppingCartRepository;


@Controller
public class AddItemController {
	@RequestMapping(value = "/addItem", method = RequestMethod.GET)
	public String test() {
		return "index";
	}
/*
	@Autowired
	@Qualifier("productDetailsRepository")
	private ProductDetailsRepository productDetailsRepository;
	
	@Autowired
	@Qualifier("shoppingCartRepository")
	private ShoppingCartRepository shoppingCartRepository;
	
	@RequestMapping(value = "/addItem", method = RequestMethod.POST)
	public String addItem(Model model, HttpServletRequest request,
						  @RequestParam(required = true) String productDetailsId,
						  @RequestParam(required = true) String quantity) throws IOException {
		System.out.println("POST /addItem");
		HttpSession session = request.getSession();		
		User user = (User)session.getAttribute("user");
		
		ShoppingCart cart = shoppingCartRepository.findByUserId(user.getId());
		ShoppingCartItem cartItem = new ShoppingCartItem();
		
		ProductDetails prodDetails = productDetailsRepository.findById(Integer.parseInt(productDetailsId)).get();
		
		return "index";
	}
	*/
}
