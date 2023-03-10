package it.beije.neumann.db3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.beije.neumann.db3.model.OrderD;
import it.beije.neumann.db3.model.OrderItemD;
import it.beije.neumann.db3.repository.OrderItemRepositoryD;
import it.beije.neumann.db3.repository.OrderRepositoryD;
import it.beije.neumann.model.Order;

@Service
public class OrderServiceD {
    
    @Autowired
    private OrderRepositoryD orderRepository;
    
    @Autowired
    private OrderItemRepositoryD orderItemRepository;
    
	public List<OrderD> findByUserId(Integer userId) {
		if(userId!=null) {
			return orderRepository.findByUserId(userId);
		} else {
			return null;
		}
	}
    
    @Transactional
    public void saveOrder(OrderD order, List<OrderItemD> orderItems) {
        orderRepository.save(order);
        for (OrderItemD orderItem : orderItems) { //decrease quantità altrimenti torna -1 
            orderItem.setOrder(order);
            orderItemRepository.save(orderItem);
        }
    }
}