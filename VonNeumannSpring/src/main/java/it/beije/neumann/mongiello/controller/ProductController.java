package it.beije.neumann.mongiello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {

	@RequestMapping(value = "/mongiello", method = RequestMethod.GET)
	public String index() {
		
		return "mongiello/index";
	}	
}
