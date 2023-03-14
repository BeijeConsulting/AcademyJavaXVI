package it.beije.neumann.repository.ecommerce;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.neumann.model.ecommerce.OrdersItems;
import it.beije.neumann.model.ecommerce.Users;

@Repository
public interface UsersRepository  extends JpaRepository<Users, Integer>{

}
