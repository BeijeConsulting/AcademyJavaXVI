package it.beije.neumann.mongiello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.neumann.model.Contatto;
import it.beije.neumann.mongiello.model.Product;
import it.beije.neumann.mongiello.repository.ProductRepository;

@Controller
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
	
	@RequestMapping(value = "/mongiello", method = RequestMethod.GET)
	public String index() {
		return "mongiello/insertProduct";
	}	
	
	@RequestMapping(value="/mongiello/insertProduct", method = RequestMethod.POST)
	public String insertProduct( Model model, Product product ) {
		System.out.println("insertProduct POST");
		
		System.out.println(product.getName());
		
		return "mongiello/index";
	}
}
