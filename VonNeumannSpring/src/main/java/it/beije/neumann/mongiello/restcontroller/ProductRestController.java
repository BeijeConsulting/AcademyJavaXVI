package it.beije.neumann.mongiello.restcontroller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.beije.neumann.model.Contatto;
import it.beije.neumann.mongiello.model.Product;
import it.beije.neumann.mongiello.repository.ProductRepository;

@RestController
public class ProductRestController {

	@Autowired
	ProductRepository productRepository;
	
	@GetMapping(value="/mongiello/products")
	public List<Product> getProducts(){
		List<Product> products =  productRepository.findAll();	
		
		
		return products;
		
	}
	
	
	@PostMapping(value = "/mongiello/product")
	public Product insertContatto(@RequestBody Product product) {
		System.out.println("POST /contatto : " + product);
		
		product.setCreatedAt();
		System.out.println("Creato il " +product.getCreatedAtString());
		productRepository.save(product);
		
		return product;
	}
	
	@PutMapping(value = "/mongiello/product/{id}")
	public Product editProduct(@PathVariable(name = "id") Integer id, @RequestBody Product newValues) {
		System.out.println("PUT /product/"+id);

		if (id.compareTo(newValues.getId()) != 0) throw new IllegalArgumentException("id non corrispondenti");
		
//		//TODO dovrebbe stare in Service...
		Optional<Product> p = productRepository.findById(id);
		if (!p.isPresent()) throw new IllegalArgumentException("id errato");
		
		Product product = p.get();		
		
		BeanUtils.copyProperties(newValues, product, "id");		
		
		System.out.println(product.getBrand());
		productRepository.save(product);
		
		return product;
	}
	
	
	@PutMapping(value = "/mongiello/disable/product/{id}")
	public Product disableProduct(@PathVariable(name = "id") Integer id) {
		System.out.println("PUT /product/"+id);

//		if (id.compareTo(newValues.getId()) != 0) throw new IllegalArgumentException("id non corrispondenti");
		
//		//TODO dovrebbe stare in Service...
		Optional<Product> p = productRepository.findById(id);
		if (!p.isPresent()) throw new IllegalArgumentException("id errato");
		
		Product product = p.get();		


//		BeanUtils.copyProperties(newValues, product, "id");	
		LocalDateTime now = LocalDateTime.now(); 
		DateTimeFormatter FOMATTER = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
		String date = FOMATTER.format(now);

		product.setDisable(date);
		productRepository.save(product);
		
		return product;
	}

	
}
