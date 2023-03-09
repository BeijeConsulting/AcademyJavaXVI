package it.beije.neumann.db3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.neumann.db3.model.OrderD;

@Repository
public interface OrderRepositoryD extends JpaRepository<OrderD, Integer> {
    //OrderD saveOrder(OrderD order);
}