package it.beije.neumann.db3.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.neumann.db3.model.Address;
import it.beije.neumann.db3.model.User;
import it.beije.neumann.db3.service.UserService;

@Controller
public class AddressController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = { "/db3/addresses" }, method = RequestMethod.GET)
	public String addressesListGet(HttpServletRequest request, Model model) {
		System.out.println("GET /db3/addresses");
		
		HttpSession session = request.getSession();
		model.addAttribute("logged_user", (User) session.getAttribute("logged_user"));
		
		return "db3/user/addresses";
	}
	
	@RequestMapping(value = { "/db3/add_address" }, method = RequestMethod.GET)
	public String addAddressGet() {
		System.out.println("GET /db3/add_address");
		
		return "db3/user/add_address";
	}
	
	@RequestMapping(value = { "/db3/add_address" }, method = RequestMethod.POST)
	public String addAddressPost(HttpServletRequest request, Model model, Address addressData) {
		System.out.println("POST /db3/add_address");
		
		HttpSession session = request.getSession();
//		model.addAttribute("logged_user", (User) session.getAttribute("logged_user"));
		addressData.setUserId(((User) session.getAttribute("logged_user")).getId());
		System.out.println(addressData);
		
		userService.saveAddress(addressData); //TODO Fix
		
		return "db3/user/addresses";
	}

}
