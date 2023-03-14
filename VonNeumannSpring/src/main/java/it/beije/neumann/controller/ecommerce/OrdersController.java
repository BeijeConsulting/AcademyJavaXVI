package it.beije.neumann.controller.ecommerce;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.neumann.model.ecommerce.Orders;
import it.beije.neumann.repository.ecommerce.OrdersRepository;

@Controller
public class OrdersController {
	@Autowired
	private OrdersRepository ordersRepository;

	@RequestMapping(value = "/lista", method = RequestMethod.GET)
	public String listaOrdini(Model model) {
		System.out.println("GET /lista_ordini");
		
		List<Orders> orders = ordersRepository.findAll();
		System.out.println(orders);
		
		model.addAttribute("orders", orders);
		
		return "lista_ordini";
	}

}
