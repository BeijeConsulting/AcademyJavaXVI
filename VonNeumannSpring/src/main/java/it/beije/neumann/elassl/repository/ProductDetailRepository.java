package it.beije.neumann.elassl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.neumann.elassl.model.ConversionSize;
import it.beije.neumann.elassl.model.Product;
import it.beije.neumann.elassl.model.ProductDetail;

@Repository
public interface ProductDetailRepository extends JpaRepository<ProductDetail, Integer> {
    List<ProductDetail> findByProduct(Product product);
    List<ProductDetail> findByProductAndIsListedTrue(Product product);
    List<ProductDetail> findByProductAndSize(Product product, ConversionSize size);
}
