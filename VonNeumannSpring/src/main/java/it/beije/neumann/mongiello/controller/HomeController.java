package it.beije.neumann.mongiello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.beije.neumann.mongiello.model.Product;

@Controller
public class HomeController {

	@RequestMapping(value={"/mongiello", "/mongiello/index"}, method = RequestMethod.GET)
	public String home() {
		return "mongiello/index";
	}
}
