package it.beije.neumann.controller;

import javax.servlet.http.HttpServletRequest;

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
    public String loginGet(Model model,HttpSession session) {
    	
    	System.out.println("login");

    	
    	System.out.println("pre Auth " + (Boolean) model.getAttribute("isFailed"));
    	return "login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public String logout(Model model,HttpSession session, @RequestParam(value = "logOut", required=false) String logOut) {
    	
    	System.out.println("logout");

    	if(logOut != null) {
    		session.removeAttribute("user");
    		System.out.println("entrato nell if");
    	}
    	

    	return "login";
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String formUser (@RequestParam(value = "email", required=false) String email,@RequestParam(value = "password", required=false) String password,
    Model model, HttpSession session, HttpServletRequest request) {
    	
    	

    	
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
    		
    		return "redirect: home";
    	}
    	
    	
    	
    	isFailed = true;
    	System.out.println(isFailed);
    	model.addAttribute("isFailed", isFailed);
    	
    	return "login";
    //	return "/login";
    }


}
