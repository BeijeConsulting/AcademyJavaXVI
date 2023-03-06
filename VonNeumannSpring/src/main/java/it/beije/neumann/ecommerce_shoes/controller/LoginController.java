package it.beije.neumann.ecommerce_shoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.neumann.model.Order;
import it.beije.neumann.repository.OrderRepository;


@Controller
public class LoginController {
	
	@Autowired
	private OrderRepository orderRepository;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLogin() {
		System.out.println("GET /login");		
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String postLogin(Model model) {
		System.out.println("GET /login");
		
		List<Order> orders = orderRepository.findAll();
		System.out.println(orders);
		
		model.addAttribute("orders", orders);
		
		return "login";
	}
}
