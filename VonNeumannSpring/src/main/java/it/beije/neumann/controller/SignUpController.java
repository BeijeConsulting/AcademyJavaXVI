package it.beije.neumann.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.neumann.model.User;
import it.beije.neumann.service.LoginService;

@Controller
public class SignUpController {

	
    @Autowired
    private LoginService loginService;
    
    
  @RequestMapping(value = "/jsp_newAccount", method = RequestMethod.POST)
  public String listaOrdini(Model model) {

      loginService.addAccount(model);
      
      

      return "/jsp_newAccount";
  }
    
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
