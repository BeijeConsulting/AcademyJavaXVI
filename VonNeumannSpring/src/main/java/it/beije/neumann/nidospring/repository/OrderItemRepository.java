package it.beije.neumann.nidospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.neumann.nidospring.model.MyOrderItem;

@Repository
public interface OrderItemRepository extends JpaRepository<MyOrderItem, Integer> {

}
