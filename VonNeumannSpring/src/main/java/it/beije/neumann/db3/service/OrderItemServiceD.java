package it.beije.neumann.db3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.beije.neumann.db3.model.OrderItemD;
import it.beije.neumann.db3.repository.OrderItemRepositoryD;

@Service
public class OrderItemServiceD {
	
    @Autowired
    private OrderItemRepositoryD orderItemRepository;

    @Transactional
	public List<OrderItemD> findByOrderId(Integer orderId) {
		return orderItemRepository.findByOrderId(orderId);
    }
}
