package it.beije.neumann.db3.controller;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class SignController {

	@RequestMapping(value = "/db3/signup", method = RequestMethod.GET)
	public String signupUtente() {
		return "db3/user/signup";
	}

	@RequestMapping(value = "/db3/signup", method = RequestMethod.POST)
	public String signupUtente(Model model, @RequestParam String name, @RequestParam String surname, 
			@RequestParam String email, @RequestParam LocalDate birthdate, @RequestParam String telephone ) {
		
		System.out.println("name : " + name);
		System.out.println("surname : " + surname);
		System.out.println("email : " + email);
		System.out.println("birthdate : " + birthdate);
		System.out.println("telephone : " + telephone);
		
		return "db3/user/signup";
	}

}
