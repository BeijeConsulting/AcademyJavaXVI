
package it.beije.neumann.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.neumann.model.Order;


@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{

	public List<Order> findByUserId(Integer userId);
	
}

