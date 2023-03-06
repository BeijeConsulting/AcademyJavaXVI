package it.beije.neumann.ecommerce_shoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.neumann.ecommerce_shoes.model.OrdersItems;

@Repository
public interface OrdersItemsRepository extends JpaRepository<OrdersItems, Integer>{

}
