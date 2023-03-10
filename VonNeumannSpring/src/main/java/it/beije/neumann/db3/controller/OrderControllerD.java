package it.beije.neumann.db3.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
import it.beije.neumann.db3.model.OrderD;
import it.beije.neumann.db3.model.OrderItemD;
import it.beije.neumann.db3.model.Product;
import it.beije.neumann.db3.model.ProductDetails;
import it.beije.neumann.db3.model.ShoppingCart;
import it.beije.neumann.db3.model.ShoppingCartItem;
import it.beije.neumann.db3.model.User;
import it.beije.neumann.db3.service.AddressService;
import it.beije.neumann.db3.service.OrderServiceD;
import it.beije.neumann.db3.service.ProductDetailsService;
import it.beije.neumann.db3.service.ProductService;
import it.beije.neumann.db3.service.ShoppingCartService;
import it.beije.neumann.db3.service.UserService;

@Controller
public class OrderControllerD {

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
	@Autowired
	private AddressService addressService;
	
	@GetMapping("/db3/order")
    public String getProduct(Model model, HttpServletRequest request) {
    	//prende carrello da utente in sessione 
		
		//List<ProductDetails> pd = productService.getProductDetails(id);
        //model.addAttribute("productDetails", pd);
        HttpSession session = request.getSession();
		User user = (User) session.getAttribute("logged_user");
		
		if (user == null) return "db3/signin";
		
	    model.addAttribute("logged_user", user);
	    List<OrderItemD> orderItems = new ArrayList<>();
	    OrderD order = new OrderD();
	    ShoppingCart shoppingCart = userService.getShoppingCart(user.getId());
	    List<ShoppingCartItem> shoppingCartItems = shoppingCartService.getShoppingCartItems(shoppingCart.getId());
	    
	    if (shoppingCartItems.size() < 1) return "db3";
	    double totalPrice=0.0;
	    order.setStatus("Pending");
	    order.setUser(user);
	    
	    for(ShoppingCartItem shoppingCartItem: shoppingCartItems) {
	    	ProductDetails productDetails = shoppingCartService.getProduct(shoppingCartItem.getId()); 
	    	Product product = productDetailsService.getProduct(productDetails.getId());
	    	Double price = productDetails.getSellingPrice();
	    	price*=shoppingCartItem.getQuantity();
	    	OrderItemD orderItem = new OrderItemD();
	    	orderItem.setColor(product.getColor());
	    	orderItem.setName(product.getName());
	    	orderItem.setPrice(price);
	    	orderItem.setProductDetails(productDetails); //metti hiddenform con solo id di product details
	    	orderItem.setQuantity(shoppingCartItem.getQuantity());
	    	orderItem.setSize(productDetails.getSize().getEu());
	    	totalPrice+=price;
	    	orderItems.add(orderItem);
	    }
	    List<Address> addresses = user.getAddresses();
	    order.setTotalPrice(totalPrice);
//	    model.addAttribute("orderItems", orderItems); //Prova Mary
	    order.setOrderItems(orderItems); //Prova Mary
	    session.setAttribute("loading_order", order);
	    model.addAttribute("order", order);
	    model.addAttribute("addresses", addresses);
        
        return "db3/user/order";
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
	
	//Youness
//	@PostMapping("/db3/add_order")
//	public String addOrder(@ModelAttribute("orderItems") ArrayList<OrderItemD> orderItems, String transaction, Integer address) {
//		System.out.println("POST add_order");
//		System.out.println(transaction+address);
//		
//		
//	    return "/db3";
//	}
	
	//Marianna
	@PostMapping("/db3/add_order")
	public String addOrder(HttpServletRequest request, @RequestParam String transaction, @RequestParam Integer address) {
		System.out.println("POST add_order");
		System.out.println(transaction+address);
		
		HttpSession session = request.getSession();
		
		User loggedUser = userService.getLoggedUser(session);
		
		OrderD loadingOrder = (OrderD) session.getAttribute("loading_order");
		loadingOrder.setId(0);
		loadingOrder.setTransaction(transaction);
		loadingOrder.setPaymentStatus("Completed");
		loadingOrder.setStatus("Shipped");
		loadingOrder.setAddress(addressService.findById(address));
		loadingOrder.setUser(loggedUser);
		
		orderService.saveOrder(loadingOrder, loadingOrder.getOrderItems());
		
		loggedUser = userService.findById(loggedUser.getId());
		session.setAttribute("logged_user", loggedUser);
		
		System.out.println("Shopping cart id: "+loggedUser.getShoppingCart().getId());
//		shoppingCartService.findShoppingCart(loggedUser.getShoppingCart().getId());
		shoppingCartService.emptyShoppingCart(loggedUser.getShoppingCart().getId());
		
		
	    return "db3/user/user_page";
	}
}