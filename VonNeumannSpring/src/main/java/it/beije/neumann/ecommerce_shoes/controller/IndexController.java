package it.beije.neumann.ecommerce_shoes.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.neumann.ecommerce_shoes.model.User;
import it.beije.neumann.ecommerce_shoes.repository.UserRepository;


@Controller
public class IndexController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getLogin() {
		System.out.println("GET /");		
		return "index";
	}
}
