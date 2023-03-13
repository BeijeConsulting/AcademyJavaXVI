package it.beije.neumann.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.beije.neumann.dto.OrderDTO;
import it.beije.neumann.model.Order;
import it.beije.neumann.repository.OrderRepository;
import it.beije.neumann.service.OrderService;


@RestController
@RequestMapping(value = "api")
public class OrderRestController {
	
	@Autowired
	private OrderService orderService;

	@GetMapping(value = "/orders")
	public List<OrderDTO> orders() {
		System.out.println("GET /orders");
		
		List<Order> orders = orderService.findAll();
//		System.out.println(orders);
		
		List<OrderDTO> orderDTOs = new ArrayList<OrderDTO>(orders.size());
		OrderDTO dto;
		for (Order o : orders) {
			dto = new OrderDTO();
			BeanUtils.copyProperties(o, dto);
			orderDTOs.add(dto);
		}
		
		return orderDTOs;
	}
	
//	@RequestMapping(value = "/ordine", method = RequestMethod.GET)
//	public String dettaglioOrdine(@RequestParam(value = "id") Integer orderId) {
//		System.out.println("GET /ordine?id=" + orderId);
//		
//		Order order = orderService.findById(orderId);
//		System.out.println("order: " + order);
//		
//	
//		return "ordine";
//	}
	
}
