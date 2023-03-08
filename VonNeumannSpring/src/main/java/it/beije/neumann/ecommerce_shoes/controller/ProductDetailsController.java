package it.beije.neumann.ecommerce_shoes.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.neumann.ecommerce_shoes.model.Product;
import it.beije.neumann.ecommerce_shoes.model.ProductDetails;
import it.beije.neumann.ecommerce_shoes.model.ProductImage;
import it.beije.neumann.ecommerce_shoes.repository.ProductDetailsRepository;
import it.beije.neumann.ecommerce_shoes.repository.ProductImageRepository;
import it.beije.neumann.ecommerce_shoes.repository.ProductRepository;


@Controller
public class ProductDetailsController {

	@Autowired
	@Qualifier("productDetailsRepository")
	private ProductDetailsRepository productDetailsRepository;
	@Autowired
	@Qualifier("productRepository")
	private ProductRepository productRepository;
	
	@Autowired
	private ProductImageRepository prodImageRepo;
	
	@RequestMapping(value = "/details", method = RequestMethod.GET)
	public String getLogin(@RequestParam("id") String id, Model model) throws IOException {
		int intId = 0;
		try{
            intId = Integer.parseInt(id);
        }
        catch (NumberFormatException ex){
            ex.printStackTrace();
        }
		
		ProductImage img = prodImageRepo.findByProductId(intId);
		
		List<ProductDetails> productDetails = productDetailsRepository.findByProductId(intId);
		Optional<Product> product = productRepository.findById(intId);
		Product p = product.get();
//		System.out.println(p);
//		System.out.println(productDetails);

		model.addAttribute("product", p);
		model.addAttribute("image", img);
		model.addAttribute("details", productDetails);
		return "productDetails";
	}
}