package it.beije.neumann.mongiello.controller;

import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.neumann.mongiello.model.Product;
import it.beije.neumann.mongiello.repository.ProductRepository;

@Controller
public class ProductController {

//	@Autowired
//	private ProductRepository productRepository;
	
	@RequestMapping(value = "/mongiello/insertProduct", method = RequestMethod.GET)
	public String index() {
		System.out.println("/mongiello/insertProduct  GET");
		return "mongiello/insert_product";
	}	
	
	@RequestMapping(value="/mongiello/insertProduct", method = RequestMethod.POST)
	public String insertProduct(  Product product ) {
		System.out.println("insertProduct POST");
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"); 
		
		LocalDateTime now = LocalDateTime.now();  
	//	product.setCreatedAt(now);
		
//		productRepository.save(product);

		return "redirect: index";
	}
	
	@RequestMapping(value = "/mongiello/searchProductByName", method = RequestMethod.GET )
		public String searchByName( Model model,@RequestParam String name ) {
		
		//List<Product> products = productRepository.findAll();
//		List<Product> products = productRepository.findByName(name);
		
//		model.addAttribute("products" ,products);
		
//		System.out.println(products);
		return "mongiello/insert_product_detail";
		
	}
	
}
