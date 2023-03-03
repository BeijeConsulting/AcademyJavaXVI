package it.beije.neumann.repository.ecommerce;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.neumann.model.ecommerce.ConvertionSize;
import it.beije.neumann.model.ecommerce.Orders;


@Repository
public interface ConvertionSizeRepository extends JpaRepository<ConvertionSize, Integer>{

}
