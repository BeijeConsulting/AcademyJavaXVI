package it.beije.neumann.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import it.beije.neumann.model.Order;
import it.beije.neumann.repository.OrderRepository;


@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;
	
	public List<Order> findAll() {		
		return orderRepository.findAll();
	}
	
	public List<Order> findByUserId(Integer userId) {
		return orderRepository.findByUserId(userId);
	}
	
	@Transactional
	public Order findById(Integer id) {
		Optional<Order> o = orderRepository.findById(id);
//		return o.isPresent() ? o.get() : null;

		if (o.isPresent()) {
			Order order = o.get();
			System.out.println(order);
			return order;
		} else return null;
	}
	
}
