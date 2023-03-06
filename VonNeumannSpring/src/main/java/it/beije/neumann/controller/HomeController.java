package it.beije.neumann.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomeController {

	@RequestMapping(value = {"/home"}, method = RequestMethod.GET)
	public String home(HttpServletRequest request) {
		System.out.println("GET " + request.getRequestURL());
		return "home";
	}
	
	@RequestMapping(value = {"/filtro"}, method = RequestMethod.GET)
	public String filtro(HttpServletRequest request, @RequestParam(required = false) String productName,
			@RequestParam(required = false) String category) {
		
		System.out.println(productName);
		System.out.println(category);
		System.out.println("GET " + request.getRequestURL());
		return "home";
	}
}