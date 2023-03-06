package it.beije.neumann.db3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import it.beije.neumann.db3.model.Product;
import it.beije.neumann.db3.model.ProductDetails;
import it.beije.neumann.db3.service.ProductService;

@Controller
public class ProductController {
    
    @Autowired
    private ProductService productService;
    
    @GetMapping("/db3")
    public String getAllProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "db3/index";
    }
    @GetMapping("/db3/product")
    public String getProduct(Model model) {
    	
    	Product p = productService.findProduct((Integer)model.getAttribute("id"));
    	List<ProductDetails> pd = p.getProductDetails();
        model.addAttribute("productDetails", pd);
        return "db3/product";
    }
}
