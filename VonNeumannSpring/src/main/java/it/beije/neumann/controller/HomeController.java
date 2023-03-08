package it.beije.neumann.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeController {
    
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(Model model) {
    	return "home";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
    	return "login";
    }

    @RequestMapping(value = "/create_account", method = RequestMethod.GET)
    public String createAccount(Model model) {
    	return "create_account";
    }
    
    @RequestMapping(value = "/dettagli_prodotto", method = RequestMethod.GET)
    public String dettagliProdotto(Model model) {
    	return "dettagli_prodotto";
    }
    
    @RequestMapping(value = "/cart", method = RequestMethod.GET)
    public String cart(Model model) {
    	return "cart";
    }



}