package it.beije.neumann.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.neumann.NotEnoughQuantityException;
import it.beije.neumann.model.Product;
import it.beije.neumann.model.ProductDetails;
import it.beije.neumann.model.ShoppingCart;
import it.beije.neumann.model.ShoppingCartItem;
import it.beije.neumann.repository.CartItemRepository;
import it.beije.neumann.repository.ShoppingCartReposistory;
import it.beije.neumann.service.ProductDetailSerivce;
import it.beije.neumann.service.ProductService;
import it.beije.neumann.service.ShoppingCartService;

@Controller
public class ProductdDetailController {
	@Autowired
	private ProductDetailSerivce  productDetailService;
	
	@Autowired
	private ProductService  productService;

	@Autowired
	ShoppingCartReposistory shoppingCartRepository;
	
	@Autowired
	CartItemRepository cartItemRepository;



	@RequestMapping(value = "/add_to_cart", method = RequestMethod.GET)
	public String addToCart( Model model, @RequestParam(name="id") String idProduct, @RequestParam String size, @RequestParam String quantity){
		

		try {
			Product product = productService.findById(Integer.valueOf(idProduct));
			ProductDetails productDetail = productService.getProductDetail( product, size );
			productDetailService.checkQuantity(productDetail, Integer.valueOf(quantity));

			System.out.println( "product Detail Id " + productDetail.getId()  );
			System.out.println( "product  " + productDetail.getProduct().getName()  );
	
			Optional<ShoppingCart> sc = shoppingCartRepository.findById(1);
			ShoppingCart cart = sc.get();
			

			ShoppingCartItem cartItem = new ShoppingCartItem();
		
			cartItem.setCreatedAt();
			cartItem.setQuantity(Integer.valueOf(quantity));

//			cartItem.setQuantity(Integer.valueOf(quantity));
//			cartItem.setProductDetailsId(productDetail.getId());
			cartItem.setShoppingCartId(cart.getId());
			
			cartItem.setProductDetails(productDetail);
			
			List<ShoppingCartItem> cartItems = new ArrayList<>();
			cartItems.add(cartItem);
			cart.setShoppingCartItem(cartItems);
			
			cartItemRepository.save(cartItem);
			
			model.addAttribute("productDetail", productDetail);
			model.addAttribute("cart", cart);
		}catch( NotEnoughQuantityException neqEX ) {
			String message = "Non ci sono abbastanza prodotti";
			System.out.println(message + neqEX);
			model.addAttribute("message", message);
		
		}catch( IllegalArgumentException iaEX ) {
			String message = "Inserisci correttamente la quantità";
			System.out.println(message + iaEX);
			model.addAttribute("message", message);
		}
	
		
		
		return "redirect: home";
	
	
	}
}
