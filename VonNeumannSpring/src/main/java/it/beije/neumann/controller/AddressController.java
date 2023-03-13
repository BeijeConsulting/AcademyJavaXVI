package it.beije.neumann.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.neumann.model.Address;
import it.beije.neumann.model.User;
import it.beije.neumann.service.AddressService;


@Controller
public class AddressController {
	
	@Autowired
	private AddressService addressService;

	
	@RequestMapping(value = {"/address"}, method = RequestMethod.GET)
	public String address(Model model,HttpSession session) {
		
		
		addressService.getAddresses(model, session);
		return "address";

	}
	
	@RequestMapping(value = {"/address"}, method = RequestMethod.POST)
	public String addressPost(Address address, Model model, HttpSession session) {
		
		address.setCreatedAt(null);
		address.setUser(((User)session.getAttribute("user")).getId());
		addressService.addAddress(address);
		return "address";

	}

}