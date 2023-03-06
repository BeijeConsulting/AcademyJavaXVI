package it.beije.neumann.db3.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.neumann.db3.model.User;
import it.beije.neumann.db3.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = {"/db3/login"}, method = RequestMethod.GET)
	public String loginGet() {
		System.out.println("GET /db3/login");
		return "db3/user/login";
	}	
	
	@RequestMapping(value = {"/db3/login"}, method = RequestMethod.POST)
	public String loginPost(HttpServletRequest request, Model model, @RequestParam(required = false) String email, @RequestParam(required=false) String password) {
		System.out.println("POST /db3/login");
		
		String jsp = "db3/user/";
		
		HttpSession session = request.getSession();
		
		User user = userService.findByEmailAndPassword(email, password);
		
		if(user!=null) {
			session.setAttribute("logged_user", user);
			model.addAttribute("user", user);
//			jsp+="index";
			jsp+="user_page";
		} else {
			model.addAttribute("login_error", "Email o password errati :(");
			jsp+="login";
		}
		
		model.addAttribute("user", user);
		
		return jsp;
	}
	
	@RequestMapping(value = {"/db3/"}, method = RequestMethod.GET)
	public String m() {
		System.out.println("GET /db3/login");
		return "db3/user/login";
	}	

}
