package it.beije.neumann.ecommerce_shoes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import it.beije.neumann.ecommerce_shoes.model.Addresses;


@Repository
public interface AddressesRepository extends JpaRepository<Addresses, Integer>{
	@Query(value = "SELECT * FROM addresses as address WHERE address.user_id = :userId", nativeQuery = true)
	public List<Addresses> findByUserId(@Param(value = "userId") Integer userId);
}
