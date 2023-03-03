package it.beije.neumann.elassl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.neumann.elassl.model.Product;
import it.beije.neumann.elassl.model.ProductImage;

@Repository
public interface ProductImageRepository extends JpaRepository<ProductImage, Integer> {
    List<ProductImage> findByProduct(Product product);
    List<ProductImage> findByImagePath(String imagePath);
}