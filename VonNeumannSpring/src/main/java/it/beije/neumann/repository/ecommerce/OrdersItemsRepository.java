package it.beije.neumann.repository.ecommerce;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.neumann.model.ecommerce.Orders;
import it.beije.neumann.model.ecommerce.OrdersItems;

@Repository
public interface OrdersItemsRepository extends JpaRepository<OrdersItems, Integer>{
	
	

}
