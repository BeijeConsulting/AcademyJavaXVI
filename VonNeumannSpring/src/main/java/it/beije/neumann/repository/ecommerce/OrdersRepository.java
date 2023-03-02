package it.beije.neumann.repository.ecommerce;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.neumann.model.Order;
import it.beije.neumann.model.ecommerce.Orders;

@Repository
public interface OrdersRepository  extends JpaRepository<Orders, Integer>{

}
