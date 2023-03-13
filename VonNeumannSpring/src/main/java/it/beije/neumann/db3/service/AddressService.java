package it.beije.neumann.db3.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.neumann.db3.model.Address;
import it.beije.neumann.db3.repository.AddressRepository;

@Service
public class AddressService {
	
	@Autowired
	private AddressRepository addressRepo;
	
	public Address saveAddress(Address address) {
		return addressRepo.save(address);
	}
	
	public Address findById(Integer id) {
		Optional<Address> a = addressRepo.findById(id);
		System.out.println("AddressServ findById:"+id+a.isPresent());
		return a.get(); // Essendo una modifica ad un address esistente, no torna null [eventualmente provare]
	}

}
