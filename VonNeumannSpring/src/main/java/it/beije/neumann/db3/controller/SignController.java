package it.beije.neumann.db3.controller;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.neumann.db3.model.User;
import it.beije.neumann.db3.repository.UserRepository;
import it.beije.neumann.db3.service.UserService;

@Controller
public class SignController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/db3/signup", method = RequestMethod.GET)
	public String signupUtente() {
		return "db3/user/signup";
	}

	@RequestMapping(value = "/db3/signup", method = RequestMethod.POST)
	public String signupUtente(HttpServletRequest request, Model model, @RequestParam String name, @RequestParam String surname, 
			@RequestParam String email, @RequestParam String password, @RequestParam LocalDate birthdate, @RequestParam String telephone ) {
		
		String jsp = "db3/";
		
		HttpSession session = request.getSession();
		
		User user = userService.findByEmail(email);
		User userSignUp = new User();
		
		if(user != null) {
			//Email esistente
			model.addAttribute("signup_error", "Email già esistente!");
			jsp+="user/signup";
		} else {
			//Email inesistente
			userSignUp.setName(name);
			userSignUp.setSurname(surname);
			userSignUp.setEmail(email);
			userSignUp.setPassword(password);
			userSignUp.setBirthDate(birthdate);
			userSignUp.setTelephone(telephone);
			model.addAttribute("userSignUp", userSignUp);
			userService.saveUser(userSignUp);
			jsp="index";	
		}
		System.out.println(userSignUp);
		return jsp;
	}
}
