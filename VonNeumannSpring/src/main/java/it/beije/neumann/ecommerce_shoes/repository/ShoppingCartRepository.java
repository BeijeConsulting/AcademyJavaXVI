package it.beije.neumann.ecommerce_shoes.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.beije.neumann.ecommerce_shoes.model.ShoppingCart;


@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer>{
	
	
	public  ShoppingCart findByUserId(Integer userId);
	

}