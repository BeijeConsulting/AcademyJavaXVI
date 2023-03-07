package it.beije.neumann.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.neumann.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	
//	public List<Product> findByName(String name);
//	
//	public List<Product> findByCategory(String category);
//	
//	public List<Product> findByColor(String color);
//	
//	public List<Product> findByNameAndCategory(String name, String category);
//	
//	public List<Product> findByNameAndColor(String name, String color);
//	
//	public List<Product> findByCategoryAndColor(String category,String color);
//	
//	public List<Product> findByNameAndCategoryAndColor(String name, String category, String color);
	
	
	//@Query(value = "select p.* from product p inner join product_details pd on p.id = pd. product_id where p.name like :name and p.category like :category, p.color like :color AND p.type like :type AND p.brand like :brand  ", nativeQuery = true)
	@Query(value = "select p from Product p INNER JOIN ProductDetails pd on p.id = pd. productId where p.name like :name AND p.category like :category AND p.color like :color AND p.type like :type AND p.brand like :brand AND pd.sellingPrice  BETWEEN :minPricel AND :maxPricel   ")
	public List<Product> find(@Param("name") String name, @Param("category") String category, @Param("color") String color,  @Param("type") String type, @Param("brand") String brand, @Param("minPricel") Double minPricel,@Param("maxPricel") Double maxPricel );
	
	@Query(value = "select min(sellingPrice) from ProductDetails")
	public Double findMinSellingPrice();
	
	@Query(value = "select max(sellingPrice) from ProductDetails")
	public Double findMaxSellingPrice();
	
	
	
}




