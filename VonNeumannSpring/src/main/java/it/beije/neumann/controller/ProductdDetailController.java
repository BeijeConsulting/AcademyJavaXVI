package it.beije.neumann.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.neumann.model.Product;
import it.beije.neumann.model.ProductDetails;
import it.beije.neumann.service.ProductDetailSerivce;
import it.beije.neumann.service.ProductService;

@Controller
public class ProductdDetailController {
	@Autowired
	private ProductDetailSerivce  productDetailService;
	
	@Autowired
	private ProductService  productService;
	
	@RequestMapping(value = "/show_detail", method = RequestMethod.GET)
	public String showDetails( Model model, @RequestParam String id){
		System.out.println("id " + id);

		Product product = productService.findById(Integer.valueOf(id));
		model.addAttribute("product", product);
		
		System.out.println(product);
		
		return "redirect: ./home";
		//return "dettagli_prodotti";
	}
	
	
}
