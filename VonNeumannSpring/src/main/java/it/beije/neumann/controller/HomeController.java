package it.beije.neumann.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.neumann.model.Product;
import it.beije.neumann.model.ProductDetails;
import it.beije.neumann.service.ProductDetailSerivce;
import it.beije.neumann.service.ProductService;


@Controller
public class HomeController {
	@Autowired
	private ProductService productService;

	@Autowired
	private ProductDetailSerivce productDetailsService;
	
	@RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
	public String home(Model model, HttpSession session) {
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
 
    
    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public String cart(Model model) {
    	return "cart";
    }
    
    @RequestMapping(value = "/address", method = RequestMethod.GET)
    public String address(Model model) {
    	return "address";
    }

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public String order(Model model) {
    	return "order";
    }
    
    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String profile(Model model) {
    	return "profile";
    }
    
    @RequestMapping(value = "/order_history", method = RequestMethod.GET)
    public String order_history(Model model) {
    	return "order_history";
    }


}