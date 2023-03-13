package it.beije.neumann.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.neumann.model.Product;
import it.beije.neumann.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

	
	@RequestMapping(value = "/products_filtred", method = RequestMethod.GET)
	public String filtred( Model model, 
			@RequestParam(required = false) String name,
			@RequestParam(required = false) String category, 
			@RequestParam(required = false) String color,
			@RequestParam(required = false) String type,
			@RequestParam(required = false) String brand,
			@RequestParam(required = false) String minSellingPrice,
			@RequestParam(required = false) String maxSellingPrice
			) {
		
		
		List<Product> products = null;
		Double minPricel = null;
		Double maxPricel = null;
		try {
			name = name.length() > 0 ? name : "%";
			category = category.equals("") ? "%" : category;
			color = color.length() > 0 ? color : "%";
			category = category.equals("") ? "%" : category;
			type = type.equals("") ? "%" : type;
			brand = brand.equals("") ? "%" : brand;
			minPricel = minSellingPrice.length() > 0 ? Double.valueOf(minSellingPrice) :  productService.findMinSellingPrice();
			maxPricel= maxSellingPrice.length() > 0 ? Double.valueOf(maxSellingPrice) :  productService.findMaxSellingPrice();
			
			List<String> categories = productService.getCategories();
			List<String> types = productService.getTypes();
			List<String> brands = productService.getBrands();
			products = productService.find( name,category, color, type, brand,minPricel, maxPricel );
			 
			model.addAttribute("brands", brands);
			model.addAttribute("types", types);
			model.addAttribute("categories", categories);
			model.addAttribute("products", products);
			//System.out.println(products);

		}catch( IndexOutOfBoundsException iobEx ) {
			String message = "Non ci sono prodotti da visualizzare ";
			System.out.println(message + iobEx);
			model.addAttribute("message", message);
		}
	
		return "/home";
	}
	
	
	@RequestMapping(value = "/show_detail", method = RequestMethod.GET)
	public String showDetails( Model model, @RequestParam String id){
		System.out.println("id " + id);

		Product product = productService.findById(Integer.valueOf(id));
		List<String> sizes = new ArrayList<>();
		for( int i = 0; i < product.getProductDetails().size(); i++  ) {
			sizes.add( product.getProductDetails().get(i).getSize() );
		}
		System.out.println(sizes );
		
		model.addAttribute("product", product);
		model.addAttribute("sizes", sizes);
	
		return "dettagli_prodotto";
	}

	
}
>>>>>>> refs/remotes/origin/team-2-ecommerceshoes
