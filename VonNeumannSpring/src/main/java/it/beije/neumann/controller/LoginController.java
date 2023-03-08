package it.beije.neumann.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.neumann.model.User;
import it.beije.neumann.service.LoginService;

@Controller
public class LoginController {



    @Autowired
    private LoginService loginService;
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginGet(Model model,HttpSession session, HttpServletRequest request,  HttpServletResponse response) {
    	
    	System.out.println("login");
    	if(((String) model.getAttribute("logOut")).equals("on")) {
    		session.removeAttribute("user");
    	}
    	
    	System.out.println("pre Auth " + (Boolean) model.getAttribute("isFailed"));
    	return "login";
    }
    
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String formUser (@RequestParam(value = "email") String email,@RequestParam(value = "password") String password, Model model,
    		HttpSession session, HttpServletRequest request,  HttpServletResponse response) {
    	
    	
    	Boolean isFailed = false;
    	System.out.println("pre Auth " +isFailed);
    	if(loginService.isAuthenticated(email, password)) {
    		
    		User user = loginService.findByEmailAndPassword(email, password);
    		
    		session = request.getSession();
    		session.setAttribute("user", user);

    		System.out.println("user: " + user);
    		System.out.println("user: " + (User) session.getAttribute("user"));
    		
    		model.addAttribute("user", user);
    		model.addAttribute("isFailed", isFailed);
    		
    		return "home";
    	}
    	
    	
    	
    	isFailed = true;
    	System.out.println(isFailed);
    	model.addAttribute("isFailed", isFailed);
    	
    	return "/login";
    }


}
