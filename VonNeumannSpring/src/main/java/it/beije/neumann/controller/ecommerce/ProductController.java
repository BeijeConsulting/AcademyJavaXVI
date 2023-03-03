package it.beije.neumann.controller.ecommerce;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.neumann.model.ecommerce.Product;
import it.beije.neumann.repository.ecommerce.ProductRepository;



@Controller
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;

	@RequestMapping(value = "/lista_ordini", method = RequestMethod.GET)
	public String listaOrdini(Model model) {
		System.out.println("GET /lista_prodotti");
		
		List<Product> prodotti = productRepository.findAll();
		System.out.println(prodotti);
		
		model.addAttribute("prodotti", prodotti);
		
		return "lista_prodotti";
	}


}
