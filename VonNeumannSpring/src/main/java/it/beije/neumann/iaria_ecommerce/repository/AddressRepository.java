package it.beije.neumann.iaria_ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.neumann.iaria_ecommerce.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
	//Metodi
}
