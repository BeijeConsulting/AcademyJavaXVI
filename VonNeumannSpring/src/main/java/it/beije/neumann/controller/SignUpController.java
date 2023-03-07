package it.beije.neumann.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.neumann.model.User;
import it.beije.neumann.service.LoginService;

@Controller
public class SignUpController {

	
    @Autowired
    private LoginService loginService;
	@RequestMapping(value = "/create_account", method = RequestMethod.GET)
	public String accountget(Model model) {
	
		model.addAttribute("user", new User());

	    System.out.println("get");
	
	    return "create_account";
	}
 
	@RequestMapping(value = "/create_account", method = RequestMethod.POST)
	public String accountpost(User user, Model model) {
		
	    System.out.println("pre-save");
	    
//	    System.out.println(date);
//	    System.out.println(user);
	    loginService.addAccount(user);
	
	    return "redirect:/login";
	}
	
//	@RequestMapping(value = "/create_account", method = RequestMethod.POST)
//	public String accountpost(@ModelAttribute("user") User user, Model model) {
//		
//	    System.out.println("pre-save");
//	    
//	    loginService.addAccount(user);
//	      
//	    System.out.println(user);
//	      
//	
//	    return "redirect:/create_account";
//	}
    
//  @RequestMapping(value = "/lista_ordini", method = RequestMethod.GET)
//  public String listaOrdini(Model model) {
//      System.out.println("GET /lista_ordini");
//
//      List<Order> orders = orderService.findAll();
//      System.out.println(orders);
//
//      model.addAttribute("orders", orders);
//
//      return "lista_ordini";
//  }
//
//  @RequestMapping(value = "/ordine", method = RequestMethod.GET)
//  public String dettaglioOrdine(@RequestParam(value = "id") Integer orderId, Model model) {
//      System.out.println("GET /ordine?id=" + orderId);
//
//      Order order = orderService.findById(orderId);
//      System.out.println("order: " + order);
//
//      model.addAttribute("order", order);
//
//      return "ordine";
//  }
}
