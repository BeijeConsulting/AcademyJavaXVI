package it.beije.neumann.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.neumann.model.Product;
import it.beije.neumann.repository.ProductRepository;

@Controller
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
	
	@RequestMapping(value = "/lista_prodotti", method = RequestMethod.GET)
	public String listaProdotti(Model model) {
		System.out.println("GET /lista_prodotti");
		
		List<Product> products = productRepository.findAll();
		System.out.println(products);
		
		model.addAttribute("products", products);
		
		return "lista_prodotti";
	}
}