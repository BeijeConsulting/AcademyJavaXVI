package it.beije.neumann.db3.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.neumann.db3.model.Address;
import it.beije.neumann.db3.model.Product;
import it.beije.neumann.db3.model.ProductDetails;
import it.beije.neumann.db3.model.ShoppingCart;
import it.beije.neumann.db3.model.ShoppingCartItem;
import it.beije.neumann.db3.model.TryOrder;
import it.beije.neumann.db3.model.TryOrderItem;
import it.beije.neumann.db3.model.User;
import it.beije.neumann.db3.service.OrderServiceD;
import it.beije.neumann.db3.service.ProductDetailsService;
import it.beije.neumann.db3.service.ProductService;
import it.beije.neumann.db3.service.ShoppingCartService;
import it.beije.neumann.db3.service.UserService;

@Controller
public class TryOrderController {

	@Autowired
	private ShoppingCartService shoppingCartService;
	@Autowired
	private UserService userService;
	@Autowired
	private ProductService productService;
	@Autowired
	private ProductDetailsService productDetailsService;
	@Autowired
	private OrderServiceD orderService;
	
	@GetMapping("/db3/try_order")
    public String getProduct(Model model, HttpServletRequest request) {
		System.out.println("GET /db3/try_order");
        HttpSession session = request.getSession();
        
        if(!userService.isUserLogged(session)) return "db3/signin";

        //else
        User loggedUser = userService.getLoggedUser(session);
//      model.addAttribute("logged_user", loggedUser);
        
        //Prendo il carrello e il suo contenuto
        ShoppingCart shoppingCart = userService.getShoppingCart(loggedUser.getId());
        
        shoppingCart.setShoppingCartItem(shoppingCartService.getShoppingCartItems(shoppingCart.getId()));
        
        System.out.println("\nIn get:\n" + shoppingCart);
        
        //Setting order
	    TryOrder order = new TryOrder();
	    
    	order.setStatus("Pending");
    	order.setUserId(loggedUser.getId());
    	
    	Double tot = 0.0;
	    
    	//Creating orderItems
	    List<TryOrderItem> orderItems = new ArrayList<>();
	    
	    if (shoppingCart.getShoppingCartItem().isEmpty()) return "db3/index";
	    
	    for (ShoppingCartItem item : shoppingCart.getShoppingCartItem()) {
	    	TryOrderItem orItem = new TryOrderItem();
	    	
	    	ProductDetails details = shoppingCartService.getProduct(item.getId());
	    	Product product = productDetailsService.getProduct(details.getId());
	    	
	    	double price = details.getSellingPrice()*item.getQuantity();
	    	tot+=price;
	    	
	    	orItem.setColor(product.getColor());
	    	orItem.setName(product.getName());
	    	orItem.setProductDetails(details); //metti hiddenform con solo id di product details
	    	orItem.setPrice(price);
	    	orItem.setSize(details.getSize().getEu());
	    	orItem.setQuantity(item.getQuantity());
	    	
	    	orderItems.add(orItem);
	    }
	    
	    order.setTotalPrice(tot);
	    order.setOrderItems(orderItems);

	    session.setAttribute("loading_order", order);
	    model.addAttribute("order", order);
	    
	    return "db3/user/order2";
	}

//	@RequestMapping(value = "/db3/add_order", method = RequestMethod.POST)
//	public String addOrder(HttpServletRequest request, Model model, @ModelAttribute("order") OrderD order, @ModelAttribute("orderItems") List<OrderItemD> orderItems) {
//		HttpSession session = request.getSession();
//		User user = (User) session.getAttribute("logged_user");
//	    model.addAttribute("logged_user", user);
//	    if (user != null) {
//		    ShoppingCart shoppingCart = userService.getShoppingCart(user.getId());
//		    orderService.saveOrder(order, orderItems); //da passare anche l'user e i dati eventualmente mancanti dal form perchÃ¨ impossibili da incapsulare su una post
//		    shoppingCartService.emptyShoppingCart(shoppingCart.getId());
//		}
//		else {
//			return "db3/signin";
//		}
//	    return "db3/index";
//	}
	
//	@PostMapping("/db3/add_order")
//	public String addOrder(List<OrderItemD> orderItems) {
//		System.out.println("POST add_order");
////		System.out.println(order);
//		for(OrderItemD od : orderItems) {
//			System.out.println(od);
//		}
//		
//	    return "db3";
//	}
	
	//Commentalo per non usarlo, ma non eliminarlo
	@PostMapping("/db3/try_add_order")
	public String addOrderMary(@RequestParam(required=false)TryOrderItem item) {
		System.out.println("POST add_order");
		
		System.out.println("OrderItems: " + item);
		
	    return "db3";
	}
}