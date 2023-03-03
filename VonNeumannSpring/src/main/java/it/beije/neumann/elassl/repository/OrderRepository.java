package it.beije.neumann.elassl.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.beije.neumann.elassl.model.Order;
import it.beije.neumann.elassl.model.User;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    List<Order> findByUser(User user);

    List<Order> findByCreatedAtBetween(LocalDateTime startDate, LocalDateTime endDate);

    List<Order> findByPaymentStatus(String paymentStatus);

    List<Order> findByStatus(String status);

    List<Order> findByTotalPriceGreaterThanEqual(Double price);

    List<Order> findByTotalPriceLessThanEqual(Double price);
    
    List<Order> findByCreatedAtGreaterThanEqual(LocalDateTime dateTime);

    List<Order> findByCreatedAtLessThanEqual(LocalDateTime dateTime);

    List<Order> findByUserAndStatus(User user, String status);

    List<Order> findByUserAndPaymentStatus(User user, String paymentStatus);

    List<Order> findByUserAndCreatedAtBetween(User user, LocalDateTime startDate, LocalDateTime endDate);

    List<Order> findByUserAndTotalPriceGreaterThanEqual(User user, Double price);

    List<Order> findByUserAndTotalPriceLessThanEqual(User user, Double price);
}

