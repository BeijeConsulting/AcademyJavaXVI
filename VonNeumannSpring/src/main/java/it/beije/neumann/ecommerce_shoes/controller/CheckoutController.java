package it.beije.neumann.ecommerce_shoes.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
import it.beije.neumann.ecommerce_shoes.repository.ProductDetailsRepository;
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
	@Autowired
	private ProductDetailsRepository productDetailsRepo;


	@RequestMapping(value = "/checkout", method = RequestMethod.GET)
	public String getCheckout(Model model, HttpServletRequest request, HttpServletResponse response, @RequestParam(name = "new",  required = false) String newAddress) throws IOException {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if (user == null) {
			response.sendRedirect("./login");
			return "index";
		}		
		ShoppingCart userCart = shoppingCartRepo.findByUserId(user.getId());
		double totale = calcoloTotale(userCart.getId());
		if (totale == 0) {
			model.addAttribute("error", "Il carrello è vuoto. Non e' possibile effettuare il checkout");
			return "error";
		}
		model.addAttribute("totale", calcoloTotale(userCart.getId()));
		List<Addresses> addresses = addressesRepo.findByUserId(user.getId());
		System.out.println(addresses);
		if(newAddress != null && newAddress.equals("true")) {
			model.addAttribute("new", "true");
		} else {
			model.addAttribute("new");
		}
		model.addAttribute("addresses", addresses);
		return "checkout";
	}
	
	@RequestMapping(value = "/checkout", method = RequestMethod.POST)
	public String postCheckout(Model model, HttpServletRequest request, HttpServletResponse response,
			 @RequestParam(name = "label", required = false) String label,
			 @RequestParam(name = "name", required = false) String name,
			 @RequestParam(name = "country", required = false) String country,
			 @RequestParam(name = "street", required = false) String street,
			 @RequestParam(name = "zipcode", required = false) String zipcode,
			 @RequestParam(name = "telephone", required = false) String telephone,
			 @RequestParam(name = "instructions", required = false) String instructions
			) throws IOException {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if (user == null) {
			response.sendRedirect("./login");
			return "index";
		}
		
		if(label != null) {
			Addresses address = new Addresses();
			address.setLabel(label);
			address.setUser(user);
			address.setNameSurname(name);
			address.setCountry(country);
			address.setStreetAddress(street);
			address.setZipcode(zipcode);
			address.setTelephone(telephone);
			address.setInstructions(instructions);
			address.setCreatedAt(LocalDateTime.now());
			addressesRepo.save(address);
		}
		
		ShoppingCart userCart = shoppingCartRepo.findByUserId(user.getId());
		//Creazione ordine
		Orders order = new Orders();
		order.setCreatedAt(LocalDateTime.now());
		order.setPaymentStatus("Pending");
		order.setStatus("Pending");
		order.setTotalPrice(calcoloTotale(userCart.getId()));
		order.setUser(user);
		order = ordersRepo.save(order); //la save dovrebbe ritornare l'order che ha creato con il suo id?
		//Creazione orderItems
		List<Integer> itemsId = cartItemRepo.findByCartId(userCart.getId());
		List<ShoppingCartItem> cartItems = cartItemRepo.findAllById(itemsId);
		boolean error = false;
		List<OrdersItems> listOrdItems = new ArrayList<OrdersItems>();
		for (ShoppingCartItem i : cartItems) {
			if (i.getDisabledAt() == null) {
				//Creo l'Order Item
				OrdersItems ordItem = new OrdersItems();
				ordItem.setCreatedAt(LocalDateTime.now());
				ordItem.setOrder(order);
				ordItem.setColor(i.getProductDetails().getProduct().getColor());
				ordItem.setName(i.getProductDetails().getProduct().getName());
				ordItem.setPrice(i.getProductDetails().getProduct().getListedPrice());
				ordItem.setProductDetails(i.getProductDetails());
				ordItem.setQuantity(i.getQuantity());
				if (i.getQuantity() > i.getProductDetails().getQuantity()) {
					error = true;
				}
				ordItem.setSize(i.getProductDetails().getSize());
				listOrdItems.add(ordItem);
				//disabilito il shopping cart item (IN OGNI CASO, ANCHE SE CANCELLO L'ORDINE)
				i.setDisabledAt(LocalDateTime.now());
				cartItemRepo.save(i);
			}
		}
		//dopo aver creato gli order items in locale, li carico sui database solo se non ci sono errori
		if (error) {
			order.setPaymentStatus("Cancelled");
			order.setStatus("Cancelled");
			ordersRepo.save(order);
			model.addAttribute("error", "Errore durante la processazione dell'ordine. Il carrello è stato svuotato.");
			return "error";
		}
		else {
			for (OrdersItems o : listOrdItems) {
				ordersItemsRepo.save(o);
				o.getProductDetails().setQuantity(o.getProductDetails().getQuantity() - o.getQuantity());
				productDetailsRepo.save(o.getProductDetails());
			}
			order.setPaymentStatus("Complete");
			order.setStatus("Complete");
			ordersRepo.save(order);
			response.sendRedirect("./");
			return "index";
		}
	}
	
	private double calcoloTotale(int cartId) {
		double totale = 0;
		List<Integer> itemsId = cartItemRepo.findByCartId(cartId);
		List<ShoppingCartItem> cartItems = cartItemRepo.findAllById(itemsId);
		for(ShoppingCartItem item : cartItems) {
			if (item.getDisabledAt() == null)
				totale += item.getProductDetails().getProduct().getListedPrice() * item.getQuantity();
		}
		return totale;
	}

}
