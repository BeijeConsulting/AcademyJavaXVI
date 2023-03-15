package it.beije.neumann.db3.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import it.beije.neumann.db3.model.Product;
import it.beije.neumann.db3.model.ProductDetails;
import it.beije.neumann.db3.model.UserD;
import it.beije.neumann.db3.service.ProductService;

@Controller
public class ProductController {
    
    @Autowired
    private ProductService productService;
    
    @GetMapping("/db3")
    public String getAllProducts(Model model, HttpServletRequest request) {
        model.addAttribute("products", productService.getAllProducts());
        HttpSession session = request.getSession();
        model.addAttribute("logged_user", (UserD) session.getAttribute("logged_user"));
        return "db3/index";
    }
    @GetMapping("/db3/product/{id}")
    public String getProduct(Model model, @PathVariable int id, HttpServletRequest request) {
    	List<ProductDetails> pd = productService.getProductDetails(id);
        model.addAttribute("productDetails", pd);
        HttpSession session = request.getSession();
        model.addAttribute("logged_user", (UserD) session.getAttribute("logged_user"));
        return "db3/product";
    }
}
