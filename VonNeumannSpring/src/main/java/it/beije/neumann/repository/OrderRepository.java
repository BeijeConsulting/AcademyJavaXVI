package it.beije.neumann.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.neumann.elassl.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByPaymentStatus(String paymentStatus);
    List<Order> findByStatus(String status);
    List<Order> findByUserId(Long userId);
}