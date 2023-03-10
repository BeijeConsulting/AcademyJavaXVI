package it.beije.neumann.ecommerce_shoes.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
public class IndexController {

	@Autowired
	@Qualifier("productRepository")
	private ProductRepository productRepository;
	
	@Autowired
	private ProductImageRepository prodImageRepo;
	

	@Autowired
	private ProductDetailsRepository prodDetailsRepo;
	
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)

	public String getIndex(Model model, @RequestParam(required = false) String type) throws IOException {

		System.out.println("GET /");

		//Lista d'appoggio
		List<ProductImage> imagesAppoggio=new ArrayList<>();
		
		List<ProductDetails> details2=new ArrayList<>();
		
		List<ProductImage> allProd = prodImageRepo.findAll();
		
		boolean controllo=false;
		
		
		for(ProductImage p : allProd) {
			
			details2=prodDetailsRepo.findByProductId(p.getProduct().getId());
			for(ProductDetails d : details2) {
				if(d.getQuantity()==0)controllo=true;
				else controllo=false;
			}
			if(!controllo) imagesAppoggio.add(p);
			
		}
		
		List<ProductImage> prodImg;
		if (type == null) {
			prodImg = imagesAppoggio;
		}
		else {
			prodImg = new ArrayList<ProductImage>();
			for(ProductImage p : imagesAppoggio) {
				if (p.getProduct().getType().equals(type)) {
					prodImg.add(p);
				}
			}
			if (type.equals("M"))
				model.addAttribute("filter", "maschi");
			else if (type.equals("W"))
				model.addAttribute("filter", "femmine");
		}
		
		model.addAttribute("images", prodImg);
		
		return "index";
	}
}
