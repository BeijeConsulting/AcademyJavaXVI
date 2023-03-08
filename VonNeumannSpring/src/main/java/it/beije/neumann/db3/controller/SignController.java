package it.beije.neumann.db3.controller;

import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.neumann.db3.model.User;
import it.beije.neumann.db3.service.UserService;

@Controller
public class SignController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = {"/db3/signin"}, method = RequestMethod.GET)
	public String loginGet(HttpServletRequest request) {
		System.out.println("GET /db3/signin");
		HttpSession session = request.getSession();
		
		String jsp = "db3/";
		
		if ((User)session.getAttribute("logged_user")!=null){
//			jsp+="index";
			jsp+="user/user_page";
		} else {
			jsp+="signin";
		}
		
		return jsp;
	}	
	
	@RequestMapping(value = {"/db3/signin"}, method = RequestMethod.POST)
	public String loginPost(HttpServletRequest request, Model model, @RequestParam(required = false) String email, @RequestParam(required=false) String password) {
		System.out.println("POST /db3/signin");
		
		String jsp = "db3/";
		
		HttpSession session = request.getSession();
		
		User user = userService.findByEmailAndPassword(email, password);
		
		if(user!=null) {
			session.setAttribute("logged_user", user);
			model.addAttribute("logged_user", user);
//			jsp+="index";
			jsp+="user/user_page";
		} else {
			model.addAttribute("signin_error", "Email o password errati :(");
			//TODO Messaggio personalizzato errore login
			jsp+="signin";
		}
		
		model.addAttribute("logged_user", user);
		
		return jsp;
	}

	@RequestMapping(value = "/db3/signup", method = RequestMethod.GET)
	public String signupUtente() {
		return "db3/signup";
	}

	@RequestMapping(value = "/db3/signup", method = RequestMethod.POST)
	public String signupUtente(HttpServletRequest request, Model model, User userData, @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate birthdate) {
		String jsp = "db3/";
		
		HttpSession session = request.getSession();
		
		userData.setBirthDate(birthdate);
		System.out.println(userData);
		
		boolean userPresent = userService.userAlreadyPresent(userData.getEmail());

		if(userPresent) {
			model.addAttribute("signup_error", "Email già esistente!");
			model.addAttribute("signup_user", userData);
			jsp+="signup";
		} else {
			//Va aggiunto il carrello
			model.addAttribute("userSignUp", userData);
			userService.saveUser(userData);
			
			session.setAttribute("logged_user", userData);
			model.addAttribute("logged_user", userData);
			
			jsp="index";	
		}
		return jsp;
	}
	
	@RequestMapping(value = {"/db3/signout"}, method = RequestMethod.GET)
	public String signOut(HttpServletRequest request) {
		System.out.println("GET /db3/signout");
		HttpSession session = request.getSession();
		session.removeAttribute("logged_user");
		
		return "db3/index";
	}	
		
}
