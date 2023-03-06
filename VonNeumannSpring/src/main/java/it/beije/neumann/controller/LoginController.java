package it.beije.neumann.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class LoginController {

	@RequestMapping(value = {"/login"}, method = RequestMethod.GET)
	public String login(HttpServletRequest request) {
		System.out.println("GET " + request.getRequestURL());
		return "login";
	}	
}