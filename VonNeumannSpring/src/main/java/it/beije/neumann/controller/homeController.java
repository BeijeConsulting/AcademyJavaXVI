package it.beije.neumann.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.neumann.model.Product;
import it.beije.neumann.service.ProductService;

@Controller
public class homeController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
	public String home(Model model) {
		try {
			
			List<Product> products = productService.findAvailble();
			List<String> categories = productService.getCategories();
			List<String> types = productService.getTypes();
			List<String> brands = productService.getBrands();
			
			model.addAttribute("brands", brands);
			model.addAttribute("types", types);
			model.addAttribute("categories", categories);
			model.addAttribute("products", products);

		}catch( IndexOutOfBoundsException iobEx ) {
			String message = "Non ci sono prodotti da visualizzare ";
			System.out.println(message + iobEx);
			model.addAttribute("message", message);
		}
		return "home";
	}
}
