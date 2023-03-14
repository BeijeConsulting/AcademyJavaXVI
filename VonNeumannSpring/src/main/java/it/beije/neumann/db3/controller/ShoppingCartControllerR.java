package it.beije.neumann.db3.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.beije.neumann.db3.dto.ShoppingCartItemDTO;
import it.beije.neumann.db3.model.Product;
import it.beije.neumann.db3.model.ProductDetails;
import it.beije.neumann.db3.model.ShoppingCart;
import it.beije.neumann.db3.model.ShoppingCartItem;
import it.beije.neumann.db3.model.User;
import it.beije.neumann.db3.service.ProductDetailsService;
import it.beije.neumann.db3.service.ProductService;
import it.beije.neumann.db3.service.ShoppingCartService;
import it.beije.neumann.db3.service.UserService;

@RestController
@RequestMapping("/rest/shopping_cart")
public class ShoppingCartControllerR {

  @Autowired
  private ShoppingCartService shoppingCartService;
  @Autowired
  private UserService userService;
  @Autowired
  private ProductDetailsService productDetailsService;

  @PostMapping("/add")
  public ShoppingCart addItem(@RequestBody ShoppingCartItemDTO itemDTO) {

    ShoppingCart s = userService.getShoppingCart(1);

    if(s != null) { 
      shoppingCartService.addShoppingCartItem(s.getId(), itemDTO.getProductItemId(), itemDTO.getQuantity());
      return s;
    }
    return null;
  }

  @GetMapping
  public ShoppingCart showShoppingCart() {
    ShoppingCart shoppingCart = userService.getShoppingCart(1);
    List<ShoppingCartItem> items = shoppingCart.getShoppingCartItem();
    List<ProductDetails> productsDetails = new ArrayList<>();
    List<Product> products = new ArrayList<>();

    if (shoppingCart != null && items != null) {
      for (ShoppingCartItem item : items) {
        ProductDetails pd = shoppingCartService.getProduct(item.getId());
        Product p = productDetailsService.getProduct(pd.getId());
        productsDetails.add(pd);
        products.add(p);
      }
      return shoppingCart;
    } else {
      return null;
    }
  }

  @DeleteMapping("/remove_item/{cartItemId}")
  public ShoppingCart removeShoppingCartItem(@PathVariable int cartItemId) {

    ShoppingCart s = userService.getShoppingCart(1);

    if (s != null) { 
      shoppingCartService.removeShoppingCartItem(s.getId(), cartItemId);
      return s;
    }
    return null;
  }

}