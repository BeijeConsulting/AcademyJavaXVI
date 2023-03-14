package it.beije.neumann.iaria_ecommerce.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.beije.neumann.iaria_ecommerce.dto.ProductDTO;
import it.beije.neumann.iaria_ecommerce.model.Products;
import it.beije.neumann.iaria_ecommerce.service.ProductService;



@RestController
@RequestMapping(value = "api")
public class ProductRestController {
	
	@Autowired
	private ProductService productService;

	@GetMapping(value = "/products")
	public List<ProductDTO> products() {
		System.out.println("GET /products");
		
		List<Products> products = productService.findAll();
		
		List<ProductDTO> ProductDTOs = new ArrayList<ProductDTO>(products.size());
		ProductDTO dto;
		for (Products p : products) {
			dto = new ProductDTO();
			BeanUtils.copyProperties(p, dto);
			ProductDTOs.add(dto);
		}
		
		return ProductDTOs;
	}
	
}
