package it.beije.neumann.iaria_ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.neumann.iaria_ecommerce.model.Address;
import it.beije.neumann.iaria_ecommerce.repository.AddressRepository;

@Controller
public class EcommerceController {
	
	@Autowired
	private AddressRepository addressRepository;
	
}
