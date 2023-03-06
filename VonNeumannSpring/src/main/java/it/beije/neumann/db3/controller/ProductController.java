package it.beije.neumann.db3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import it.beije.neumann.db3.service.ProductService;

@Controller
public class ProductController {
    
    @Autowired
    private ProductService productService;
    
    @GetMapping("/db3")
    public String getAllProducts(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "db3/product";
    }
}