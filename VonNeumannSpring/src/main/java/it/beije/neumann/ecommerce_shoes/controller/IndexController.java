package it.beije.neumann.ecommerce_shoes.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.neumann.ecommerce_shoes.model.Product;
import it.beije.neumann.ecommerce_shoes.repository.ProductRepository;


@Controller
public class IndexController {

	@Autowired
	@Qualifier("productRepository")
	private ProductRepository productRepository;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getLogin(Model model) throws IOException {
		System.out.println("GET /");
		List<Product> products = productRepository.findAll();
		System.out.println(products);
		model.addAttribute("products", products);
		return "index";
	}
}
