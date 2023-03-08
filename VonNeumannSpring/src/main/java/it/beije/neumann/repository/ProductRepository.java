package it.beije.neumann.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.neumann.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	
	@Query(value = "select  p from Product p INNER JOIN ProductDetails pd on p.id = pd. productId where p.name like :name AND p.category like :category AND p.color like :color AND p.type like :type AND p.brand like :brand AND pd.sellingPrice  BETWEEN :minPricel AND :maxPricel  group by p.id ")
	public List<Product> find(@Param("name") String name, @Param("category") String category, @Param("color") String color,  @Param("type") String type, @Param("brand") String brand, @Param("minPricel") Double minPricel,@Param("maxPricel") Double maxPricel );
	
	@Query(value = "select p from Product p where p.isListed = 1")
	public List<Product> findAvailble();
	
	@Query(value = "select min(sellingPrice) from ProductDetails")
	public Double findMinSellingPrice();
	
	@Query(value = "select max(sellingPrice) from ProductDetails")
	public Double findMaxSellingPrice();
	
	@Query(value = "select category from Product group by category")
	public List<String> getCategories();
	
	@Query(value = "select type from Product group by type")
	public List<String> getTypes();
	
	@Query(value = "select brand from Product group by brand")
	public List<String> getBrands();
	
	@Query(value = "select pd.size from Product p INNER JOIN  ProductDetails pd  ON p.id = pd.productId group by pd.size")
	public List<String> getSizes();
	
	
	
}




