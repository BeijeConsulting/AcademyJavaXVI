package it.beije.neumann.nidospring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.neumann.nidospring.model.MyUser;
import it.beije.neumann.nidospring.repository.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository userRepo;
	
	@RequestMapping(value = {"/nidospring/login"}, method = RequestMethod.GET)
	public String login() {
		System.out.println("GET /nidospring/login");
		return "nidoviews/ecommerce/login";
	}	
	
	@RequestMapping(value = "/nidospring/user_details", method = RequestMethod.GET)
	public String userDetails(Model model, @RequestParam(required = false) String email, @RequestParam(required=false) String password) {
		System.out.println("GET /user_details");
		
		MyUser user = userRepo.findByEmailAndPassword(email, password);
		
		model.addAttribute("logged_user", user);
		
		return "nidoviews/ecommerce/user_details";
	}

}
