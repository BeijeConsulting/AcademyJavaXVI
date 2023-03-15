package it.beije.neumann.db3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.neumann.db3.model.OrderD;
import it.beije.neumann.db3.model.UserD;
import it.beije.neumann.model.Order;

@Repository
public interface OrderRepositoryD extends JpaRepository<OrderD, Integer> {
    //OrderD saveOrder(OrderD order);
	
	public List<OrderD> findByUserId(Integer userId);
}