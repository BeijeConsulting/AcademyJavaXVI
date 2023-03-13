package it.beije.neumann.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.neumann.service.LoginService;

@Controller
public class profileController {

    @Autowired
    private LoginService loginService;
    
    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String loginGet(Model model,HttpSession session) {
    	

    	return "profile";
    }
}
