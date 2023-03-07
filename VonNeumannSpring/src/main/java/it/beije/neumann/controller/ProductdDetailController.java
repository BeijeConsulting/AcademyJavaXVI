package it.beije.neumann.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.neumann.model.ProductDetails;
import it.beije.neumann.service.ProductDetailSerivce;

@Controller
public class ProductdDetailController {
	@Autowired
	private ProductDetailSerivce  productDetailService;
	
	@RequestMapping(value = "/show_detail", method = RequestMethod.GET)
	public String showDetails( Model model, @RequestParam String id){
		System.out.println("id " + id);

		List<ProductDetails> productDetails = productDetailService.findByProductId(Integer.valueOf(id));
		model.addAttribute("productDetails", productDetails);
		
		
		return "redirect: ./home";
		//return "dettagli_prodotti";
	}
}
