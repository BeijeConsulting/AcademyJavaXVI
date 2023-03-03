package it.beije.neumann.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.neumann.model.Address;
import it.beije.neumann.repository.AddressRepository;

@Controller
public class AddressController {

	@Autowired
	private AddressRepository addressRepository;
	
	@RequestMapping(value = "/lista_address", method = RequestMethod.GET)
	public String listaAddress(Model model) {
		System.out.println("GET /lista_address");
		
		List<Address> addresses = addressRepository.findAll();
		System.out.println(addresses);
		
		model.addAttribute("addresses", addresses);
		
		return "lista_address";
	}
}