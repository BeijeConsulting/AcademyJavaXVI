package it.beije.neumann.ecommerce_shoes.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.neumann.ecommerce_shoes.model.Product;
import it.beije.neumann.ecommerce_shoes.model.ProductDetails;
import it.beije.neumann.ecommerce_shoes.repository.ProductDetailsRepository;

@Controller
public class ProductDetailsController {

	@Autowired
	@Qualifier("productDetailsRepository")
	private ProductDetailsRepository ProductDetailsRepository;
	
	@RequestMapping(value = "/details", method = RequestMethod.GET)
	public String getLogin(@RequestParam("id") String id, Model model) throws IOException {
		System.out.println("GET /details");
		List<ProductDetails> products = ProductDetailsRepository.findByProductId(null);
		System.out.println(products);
		model.addAttribute("products", products);
		return "productDetails";
	}
}