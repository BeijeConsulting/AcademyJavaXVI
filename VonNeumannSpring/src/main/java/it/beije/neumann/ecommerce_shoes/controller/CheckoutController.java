package it.beije.neumann.ecommerce_shoes.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.neumann.ecommerce_shoes.model.Addresses;
import it.beije.neumann.ecommerce_shoes.model.Orders;
import it.beije.neumann.ecommerce_shoes.model.OrdersItems;
import it.beije.neumann.ecommerce_shoes.model.ShoppingCart;
import it.beije.neumann.ecommerce_shoes.model.ShoppingCartItem;
import it.beije.neumann.ecommerce_shoes.model.User;
import it.beije.neumann.ecommerce_shoes.repository.AddressesRepository;
import it.beije.neumann.ecommerce_shoes.repository.OrdersItemsRepository;
import it.beije.neumann.ecommerce_shoes.repository.OrdersRepository;
import it.beije.neumann.ecommerce_shoes.repository.ShoppingCartItemRepository;
import it.beije.neumann.ecommerce_shoes.repository.ShoppingCartRepository;
import it.beije.neumann.ecommerce_shoes.repository.UserRepository;


@Controller
public class CheckoutController {
	
	@Autowired
    private ShoppingCartRepository shoppingCartRepo;
	@Autowired
	private ShoppingCartItemRepository cartItemRepo;
	@Autowired
	private AddressesRepository addressesRepo;
	@Autowired
	private OrdersRepository ordersRepo;
	@Autowired
	private OrdersItemsRepository ordersItemsRepo;

	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public String getCheckout(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("GET /checkout");
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if (user == null) {
			response.sendRedirect("./login");
			return "index";
		}
		
		ShoppingCart userCart = shoppingCartRepo.findByUserId(user.getId());
		model.addAttribute("totale", calcoloTotale(userCart.getId()));
		List<Addresses> addresses = addressesRepo.findByUserId(user.getId());
		System.out.println(addresses);
		model.addAttribute("addresses", addresses);
		return "checkout";
	}
	
	@RequestMapping(value = "/checkout", method = RequestMethod.POST)
	public String postCheckout(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if (user == null) {
			response.sendRedirect("./login");
			return "index";
		}
		
		ShoppingCart userCart = shoppingCartRepo.findByUserId(user.getId());
		//Creazione ordine
		Orders order = new Orders();
		order.setCreatedAt(LocalDateTime.now());
		order.setPaymentStatus("Complete");
		order.setStatus("Complete");
		order.setTotalPrice(calcoloTotale(userCart.getId()));
		order.setUser(user);
		order = ordersRepo.save(order); //la save dovrebbe ritornare l'order che ha creato con il suo id?
		//Creazione orderItems
		List<Integer> itemsId = cartItemRepo.findByCartId(userCart.getId());
		List<ShoppingCartItem> cartItems = cartItemRepo.findAllById(itemsId);
		for (ShoppingCartItem i : cartItems) {
			OrdersItems ordItem = new OrdersItems();
			ordItem.setCreatedAt(LocalDateTime.now());
			ordItem.setOrder(order);
			ordItem.setColor(i.getProductDetails().getProduct().getColor());
			ordItem.setName(i.getProductDetails().getProduct().getName());
			ordItem.setPrice(i.getProductDetails().getProduct().getListedPrice());
			ordItem.setProductDetails(i.getProductDetails());
			ordItem.setQuantity(i.getQuantity());
			ordItem.setSize(i.getProductDetails().getSize());
			ordersItemsRepo.save(ordItem);
			i.setDisabledAt(LocalDateTime.now());
			cartItemRepo.save(i);
		}
		response.sendRedirect("./");
		return "index";
	}
	
	private double calcoloTotale(int cartId) {
		double totale = 0;
		List<Integer> itemsId = cartItemRepo.findByCartId(cartId);
		List<ShoppingCartItem> cartItems = cartItemRepo.findAllById(itemsId);
		for(ShoppingCartItem item : cartItems) {
			totale += item.getProductDetails().getProduct().getListedPrice() * item.getQuantity();
		}
		return totale;
	}

}
