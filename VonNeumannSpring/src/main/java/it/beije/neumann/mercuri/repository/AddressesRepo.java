package it.beije.neumann.mercuri.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.neumann.mercuri.model.Address;

@Repository
public interface AddressesRepo extends JpaRepository<Address, Integer> {

	public List<Address> findByUserId(String userId);

	
	//@Query(value = "SELECT COUNT(c) FROM Contatto as c WHERE c.surname = :surname")
//	@Query(value = "SELECT * from addresses where ", nativeQuery = true)
//	public int countBySurname(@Param("surname") String surname);
}
