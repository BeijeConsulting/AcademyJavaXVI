package it.beije.neumann.iaria_ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.neumann.iaria_ecommerce.model.Products;
import it.beije.neumann.iaria_ecommerce.repository.ProductsRepository;

@Controller
public class EcommerceController {
	
	@Autowired
	private ProductsRepository productsRepository;

	@RequestMapping(value = "/iaria/ecommerce/lista_prodotti", method = RequestMethod.GET)
	public String Lettura(Model model) {
		System.out.println("In");

		//Lettura dati
		List<Products> products = productsRepository.findAll();
						
		model.addAttribute("products", products);
		
		return "iaria/ecommerce/lista_prodotti";
	}
	
}
