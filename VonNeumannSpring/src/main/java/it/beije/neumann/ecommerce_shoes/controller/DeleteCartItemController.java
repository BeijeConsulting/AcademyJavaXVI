package it.beije.neumann.ecommerce_shoes.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.neumann.ecommerce_shoes.model.ShoppingCartItem;
import it.beije.neumann.ecommerce_shoes.repository.ShoppingCartItemRepository;

@Controller
public class DeleteCartItemController {

	@Autowired
	@Qualifier("shoppingCartItemRepository")
	private ShoppingCartItemRepository shoppingCartItemRepository;
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String getLogin(@RequestParam("id") String id, Model model) throws IOException {
		System.out.println("GET /details, id: " + id);
		int intId = 0;
		try{
            intId = Integer.parseInt(id);
        }
        catch (NumberFormatException ex){
            ex.printStackTrace();
        }
		
		Optional<ShoppingCartItem> item = shoppingCartItemRepository.findById(intId);
		ShoppingCartItem i = item.get();
		i.setDisabledAt(LocalDateTime.now());
		return "shopping_cart";
	}
}
