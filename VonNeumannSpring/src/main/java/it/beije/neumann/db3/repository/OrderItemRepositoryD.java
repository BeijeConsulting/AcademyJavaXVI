package it.beije.neumann.db3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.neumann.db3.model.OrderD;
import it.beije.neumann.db3.model.OrderItemD;

@Repository
public interface OrderItemRepositoryD extends JpaRepository<OrderItemD, Integer> {
//    List<OrderItemD> saveOrderItems(List<OrderItemD> orderItems);
	public List<OrderItemD> findByOrderId(Integer orderId);
}