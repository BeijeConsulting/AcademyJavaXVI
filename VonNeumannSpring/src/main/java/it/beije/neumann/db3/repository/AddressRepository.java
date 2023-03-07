package it.beije.neumann.db3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.neumann.db3.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer>{
}
