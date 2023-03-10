package it.beije.neumann.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.neumann.model.Address;
@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>{

}
