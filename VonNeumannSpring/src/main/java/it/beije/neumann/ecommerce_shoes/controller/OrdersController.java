package it.beije.neumann.ecommerce_shoes.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.neumann.ecommerce_shoes.model.Orders;
import it.beije.neumann.ecommerce_shoes.model.OrdersItems;
import it.beije.neumann.ecommerce_shoes.model.User;
import it.beije.neumann.ecommerce_shoes.repository.OrdersItemsRepository;
import it.beije.neumann.ecommerce_shoes.repository.OrdersRepository;


@Controller
public class OrdersController {
	
	/**
	 * TODO:
	 * #prendo user dalla sessione,cerco gli order items associati a quell'id
	 * #raggruppo in base all'id dell'ordine e visualizzo solo l'ordine su orders.jsp
	 * 
	 */
	@Autowired
	private OrdersRepository ordersRepo;
	
	@RequestMapping(value = "/orders", method = RequestMethod.GET)
	public String getOrders(Model model,HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		User user=(User) session.getAttribute("user");
		
		List<Orders> orders=ordersRepo.findByUserId(user.getId());
		
		//Raggruppo gli items in base
		
		
		
		System.out.println("GET / orders");
		
//		System.out.println(ordersItems.size());
		
		model.addAttribute("orders",orders);
		return"/orders";
	}
		
	

}
