package it.beije.neumann.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.neumann.model.Product;
import it.beije.neumann.repository.ProductRepository;
import it.beije.neumann.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	
	
	
//	@RequestMapping(value = "/", method = RequestMethod.GET)
//	public String home() {
//		System.out.println("GET /");
//		return "index";
//	}
	
//	@RequestMapping(value = "/list_products", method = RequestMethod.GET)
//	public String listaProdotti(Model model) {
//		System.out.println("GET /lista_prodotti");
//		
//		try {
//			List<Product> products = productService.findAll();
//			List<String> categories = productService.getCategories();
//			List<String> types = productService.getTypes();
//			
//			model.addAttribute("types", types);
//			model.addAttribute("categories", categories);
//			model.addAttribute("products", products);
//
//		}catch( IndexOutOfBoundsException iobEx ) {
//			String message = "Non ci sono prodotti da visualizzare ";
//			System.out.println(message + iobEx);
//			model.addAttribute("message", message);
//		}
//		
//		
//		return "index";
//	}
	
	@RequestMapping(value = "/products_filtred", method = RequestMethod.GET)
	public String filtred( Model model, 
			@RequestParam(required = false) String name,
			@RequestParam(required = false) String category, 
			@RequestParam(required = false) String color,
			@RequestParam(required = false) String type,
			@RequestParam(required = false) String brand,
			@RequestParam(required = false) String minSellingPrice,
			@RequestParam(required = false) String maxSellingPrice
			 ) {
		
		List<Product> products = null;
		Double minPricel = null;
		Double maxPricel = null;
		try {
			
			name = name.length() > 0 ? name : "%";
			category = category.equals("") ? "%" : category;
			color = color.length() > 0 ? color : "%";
			category = category.equals("") ? "%" : category;
			type = type.equals("") ? "%" : type;
			brand = brand.equals("") ? "%" : brand;
			minPricel = minSellingPrice.length() > 0 ? Double.valueOf(minSellingPrice) :  productService.findMinSellingPrice();
			maxPricel= maxSellingPrice.length() > 0 ? Double.valueOf(maxSellingPrice) :  productService.findMaxSellingPrice();

			
			 products = productService.find( name,category, color, type, brand,minPricel, maxPricel );
			 
			System.out.println(products);
				
		
	
		}catch( IndexOutOfBoundsException iobEx ) {
			String message = "Non ci sono prodotti da visualizzare ";
			System.out.println(message + iobEx);
			model.addAttribute("message", message);
		}

		
		return "home";
	}

	
}
