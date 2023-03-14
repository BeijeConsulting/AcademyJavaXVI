package it.beije.neumann.service;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import it.beije.neumann.model.Address;
import it.beije.neumann.model.User;
import it.beije.neumann.repository.AddressRepository;

@Service
public class AddressService {
	

	@Autowired
	private AddressRepository addressRepository;
	
//	@Transactional
	public void getAddresses (Model model, HttpSession session) {
		
		User user = (User) session.getAttribute("user");
		
//		System.out.println(user);
//		model.addAttribute("addresses",user.getAddresses());
		
		System.out.println((List<Address>)model.getAttribute("addresses"));
	}
	
	public void addAddress(Address address) {
		
		addressRepository.save(address);
		
	}
}
