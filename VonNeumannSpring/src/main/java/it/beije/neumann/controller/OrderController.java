package it.beije.neumann.controller;

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
public class OrderController {
	
	@Autowired
	private OrderRepository orderRepository;

	@RequestMapping(value = "/lista_ordini", method = RequestMethod.GET)
	public String listaOrdini(Model model) {
		System.out.println("GET /lista_ordini");
		
		List<Order> orders = orderRepository.findAll();
		System.out.println(orders);
		
		model.addAttribute("orders", orders);
		
		return "lista_ordini";
	}
}
