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
import it.beije.neumann.ecommerce_shoes.model.ShoppingCartItem;
import it.beije.neumann.ecommerce_shoes.repository.ProductDetailsRepository;


@Controller
public class AddItemController {

	@Autowired
	@Qualifier("productDetailsRepository")
	private ProductDetailsRepository productDetailsRepository;
	
	@RequestMapping(value = "/addItem", method = RequestMethod.POST)
	public String addItem(Model model, HttpServletRequest request,
						  @RequestParam(required = true) String size,
						  @RequestParam(required = true) String quantity) throws IOException {
		System.out.println("POST /addItem");
		HttpSession session = request.getSession();
		Product product = (Product)session.getAttribute("product");
		
		ShoppingCartItem cartItem = new ShoppingCartItem();
		
		//productDetailsRepository.find
		return "index";
	}
}
