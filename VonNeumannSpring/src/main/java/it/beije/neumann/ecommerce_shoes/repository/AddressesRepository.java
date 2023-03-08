package it.beije.neumann.ecommerce_shoes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import it.beije.neumann.ecommerce_shoes.model.Addresses;
import it.beije.neumann.ecommerce_shoes.model.User;


@Repository
public interface AddressesRepository extends JpaRepository<Addresses, Integer>{
	@Query(value = "SELECT address.id FROM addresses as address WHERE address.user_id = :userId", nativeQuery = true)
	public List<Integer> findByUserId(@Param(value = "userId") Integer userId);
}
