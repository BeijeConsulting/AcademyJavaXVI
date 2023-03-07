package it.beije.neumann.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.neumann.service.LoginService;

@Controller
public class LoginController {



    @Autowired
    private LoginService loginService;
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginGet(Model model) {
    	
    	
    	
    	return "login";
    }
    
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String formUser (@RequestParam(value = "email") String email,@RequestParam(value = "password") String password, Model model) {
    	
    	if(loginService.isAuthenticated(email, password))
    		return "/home";
    	
    	
    	return "login";
    }


}
