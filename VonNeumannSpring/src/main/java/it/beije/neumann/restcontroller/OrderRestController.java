package it.beije.neumann.restcontroller;

//import java.util.ArrayList;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//
//@RestController
//@RequestMapping(value = "api")
//public class OrderRestController {
//	
//	@Autowired
//	private OrderService orderService;
//
//	@GetMapping(value = "/orders")
//	public List<OrderDTO> orders() {
//		System.out.println("GET /orders");
//		
//		List<Order> orders = orderService.findAll();
////		System.out.println(orders);
//		
//		List<OrderDTO> orderDTOs = new ArrayList<OrderDTO>(orders.size());
//		OrderDTO dto;
//		for (Order o : orders) {
//			dto = new OrderDTO();
//			BeanUtils.copyProperties(o, dto);
//			orderDTOs.add(dto);
//		}
//		
//		return orderDTOs;
//	}
//	
////	@RequestMapping(value = "/ordine", method = RequestMethod.GET)
////	public String dettaglioOrdine(@RequestParam(value = "id") Integer orderId) {
////		System.out.println("GET /ordine?id=" + orderId);
////		
////		Order order = orderService.findById(orderId);
////		System.out.println("order: " + order);
////		
////	
////		return "ordine";
////	}
//	
//}
