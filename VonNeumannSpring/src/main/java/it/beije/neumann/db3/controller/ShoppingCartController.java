package it.beije.neumann.db3.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.neumann.db3.model.ShoppingCart;
import it.beije.neumann.db3.model.User;
import it.beije.neumann.db3.service.ShoppingCartService;
import it.beije.neumann.db3.service.UserService;

@Controller
public class ShoppingCartController {
	@Autowired
	private ShoppingCartService shoppingCartService;
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/db3/add_shopping_cart/{productItemId}")
	public String addCartItem(HttpServletRequest request, Model model, @PathVariable int productItemId) {
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("logged_user");
		String referrer = request.getHeader("referer");
        model.addAttribute("logged_user", user);
		if (user != null) {
			ShoppingCart s = userService.getShoppingCart(user.getId());
			if(s != null) { //check
				shoppingCartService.addShoppingCartItem(s.getId(), productItemId, 1);
				System.out.println(s);
			    return "redirect:" + referrer;
			}
		}
	    return "redirect:" + referrer;
	}
	
	  @RequestMapping(value = "/db3/shopping_cart", method = RequestMethod.GET)
	  public String showShoppingCart(HttpServletRequest request, Model model) {
		System.out.println("GET: /db3/shopping_cart");
	    HttpSession session = request.getSession();
		User user = (User) session.getAttribute("logged_user");
		
		if (user != null) {

		    ShoppingCart shoppingCart = userService.getShoppingCart(user.getId());
		    
		    model.addAttribute("shoppingCart", shoppingCart);
		    return "db3/user/shopping_cart";
		}
		else {
			return "db3/signin";
		}
	  }
	  
		@GetMapping("/db3/remove_cart_item/{cartItemId}")
		public String removeShoppingCart(HttpServletRequest request, Model model, @PathVariable int cartItemId) {
			
			HttpSession session = request.getSession();
			User user = (User) session.getAttribute("logged_user");
			String referrer = request.getHeader("referer");
	        model.addAttribute("logged_user", user);
			if (user != null) {
				ShoppingCart s = userService.getShoppingCart(user.getId());
				if(s != null) { 
					shoppingCartService.removeShoppingCartItem(s.getId(), cartItemId);
				    return "redirect:" + referrer;
				}
			}
		    return "redirect:" + "/db3/shopping_cart";
		}
	
}
