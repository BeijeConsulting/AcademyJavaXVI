package it.beije.neumann.elassl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.beije.neumann.elassl.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByIsListedTrueOrderByCreatedAtDesc();
    List<Product> findByName(String name);
    List<Product> findByCategory(String category);
    List<Product> findByBrand(String brand);
    List<Product> findByType(String type);
    List<Product> findByColor(String color);
    List<Product> findByIsListedTrueAndCategoryOrderByCreatedAtDesc(String category);
}
