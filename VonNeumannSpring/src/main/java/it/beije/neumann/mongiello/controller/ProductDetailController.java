package it.beije.neumann.mongiello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.neumann.mongiello.repository.ProductDetailRepository;

@Controller
public class ProductDetailController {
	
	@Autowired
	private ProductDetailRepository productDetailRepository;
	
	@RequestMapping(value = "/mongiello/insertProductDetail", method = RequestMethod.GET)
	public String insertProductDetail() {
	//	List<Product> prodotto = product
		
		return "mongiello/insert_product_detail";
	}	
	
}
