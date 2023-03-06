package it.beije.neumann.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class CreateAccountController {

	@RequestMapping(value = {"/create_account"}, method = RequestMethod.GET)
	public String createAccount(HttpServletRequest request) {
		System.out.println("GET " + request.getRequestURL());
		return "create_account";
	}	
}