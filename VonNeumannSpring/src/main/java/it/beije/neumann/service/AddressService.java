package it.beije.neumann.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import it.beije.neumann.model.Address;
import it.beije.neumann.model.User;
import it.beije.neumann.repository.AddressRepository;

@Service
public class AddressService {
	

	@Autowired
	private AddressRepository addressRepository;
	
	public void getAddresses (Model model) {
		
		User user = (User) model.getAttribute("user");
		
		model.addAttribute("addresses",user.getAddresses());
	}
	
	public void addAddress(Address address) {
		
		addressRepository.save(address);
		
	}
}
