package it.beije.neumann.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.neumann.NotEnoughQuantityException;
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

	@RequestMapping(value = "/add_to_cart", method = RequestMethod.GET)
	public String addToCart( Model model, @RequestParam(name="id") String id, @RequestParam String size, @RequestParam String quantity){
		
		System.out.println("Id prodotto " + id);
		System.out.println("Taglia scelta " + size);
		System.out.println("Quantita scelta " + quantity);
		
		try {
			ProductDetails productDetail = productDetailService.findByProductIdAndSize(Integer.valueOf(id), size);
			productDetailService.checkQuantity(productDetail, Integer.valueOf(quantity));
			System.out.println("Dettagli prodotto " + productDetail);
		
		}catch( NotEnoughQuantityException neqEX ) {
			String message = "Non ci sono abbastanza prodotti";
			System.out.println(message + neqEX);
			model.addAttribute("message", message);
		
		}catch( IllegalArgumentException iaEX ) {
			String message = "Inserisci correttamente la quantità";
			System.out.println(message + iaEX);
			model.addAttribute("message", message);
		}

		return "cart";
	
	
	}
}
