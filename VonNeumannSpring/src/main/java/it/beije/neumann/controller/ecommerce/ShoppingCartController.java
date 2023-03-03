package it.beije.neumann.controller.ecommerce;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.neumann.model.ecommerce.Orders;
import it.beije.neumann.model.ecommerce.ShoppingCart;
import it.beije.neumann.repository.ecommerce.ShoppingCartRepository;

@Controller
public class ShoppingCartController {
	@Autowired
	private ShoppingCartRepository shoppingCartRepository;

	@RequestMapping(value = "/lista_ordini", method = RequestMethod.GET)
	public String listaOrdini(Model model) {
		System.out.println("GET /lista_carts");
		
		List<ShoppingCart> cart = shoppingCartRepository.findAll();
		System.out.println(cart);
		
		model.addAttribute("carts", cart);
		
		return "lista_carts";
	}


}
