package it.beije.neumann.nidospring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.neumann.nidospring.model.MyOrder;
import it.beije.neumann.nidospring.repository.MyOrderRepository;


@Controller
public class MyOrderController {
	
	@Autowired
	private MyOrderRepository orderRepository;

	@RequestMapping(value = "/nidospring/order_list", method = RequestMethod.GET)
	public String ordersList(Model model) {
		System.out.println("GET /order_list");
		
		List<MyOrder> orders = orderRepository.findAll();
		System.out.println(orders);
		
		model.addAttribute("orders", orders);
		
		return "nidoviews/ecommerce/order_list";
	}
}
