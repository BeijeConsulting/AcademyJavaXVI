package it.beije.neumann.ecommerce_shoes.controller;

import java.util.ArrayList;

import java.util.List;
import java.util.ListIterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import it.beije.neumann.ecommerce_shoes.model.ShoppingCart;
import it.beije.neumann.ecommerce_shoes.model.ShoppingCartItem;
import it.beije.neumann.ecommerce_shoes.model.User;
import it.beije.neumann.ecommerce_shoes.repository.ProductImageRepository;
import it.beije.neumann.ecommerce_shoes.repository.ShoppingCartItemRepository;
import it.beije.neumann.ecommerce_shoes.repository.ShoppingCartRepository;


@Controller
public class ShoppingCartController {
	
	
	@Autowired
	private ShoppingCartItemRepository cartItemRepo;
	
	@Autowired
    private ShoppingCartRepository shoppingCartRepo;
	
	
	
	/**
	 * Visualizzazione shopping_cart
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public String getCart(Model model,HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("GET /shopping_cart");
		
		HttpSession session = request.getSession();
		User user=(User) session.getAttribute("user");
		if(user.equals(null)) {
		ShoppingCart userCart=shoppingCartRepo.findByUserId(user.getId());
//		System.out.println(userCart);
		List<ShoppingCartItem> items2=new ArrayList<>();
		List<Integer> itemsId= cartItemRepo.findByCartId(userCart.getId());
		List<ShoppingCartItem> items=cartItemRepo.findAllById(itemsId);

		

//		System.out.println(items);
		
		int totale=0;

		for(int i=0;i<items.size();i++)
		{			if((items.get(i).getDisabledAt().equals(null))) {
			 totale+=items.get(i).getProductDetails().getProduct().getListedPrice()*items.get(i).getQuantity();
			 items2.add(items.get(i));
		}
		}
//		System.out.println("ITEMS FINALI: "+items2);

		model.addAttribute("totale",totale);
		model.addAttribute("items",items2);
		return "shopping_cart";
			
		}
		else {
			return "login";
		}
	}

}
