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
	
	//Per il momento tanto per non far aprire 404
	@RequestMapping(value = {"/db3/"}, method = RequestMethod.GET)
	public String index() {
		System.out.println("GET /db3/");
		return "db3/index";
	}
	
	@RequestMapping(value = {"/db3/signin"}, method = RequestMethod.GET)
	public String loginGet() {
		System.out.println("GET /db3/signin");
		return "db3/signin";
	}	
	
	@RequestMapping(value = {"/db3/signin"}, method = RequestMethod.POST)
	public String loginPost(HttpServletRequest request, Model model, @RequestParam(required = false) String email, @RequestParam(required=false) String password) {
		System.out.println("POST /db3/signin");
		
		String jsp = "db3/";
		
		HttpSession session = request.getSession();
		
		User user = userService.findByEmailAndPassword(email, password);
		
		if(user!=null) {
			session.setAttribute("logged_user", user);
			model.addAttribute("user", user);
//			jsp+="index";
			jsp+="user/user_page";
		} else {
			model.addAttribute("signin_error", "Email o password errati :(");
			jsp+="signin";
		}
		
		model.addAttribute("user", user);
		
		return jsp;
	}
	
	@RequestMapping(value = {"/db3/user_page"}, method = RequestMethod.GET)
	public String userPage(HttpServletRequest request, Model model) {
		System.out.println("GET /db3/user_page");
		
		HttpSession session = request.getSession();
		model.addAttribute("user", (User) session.getAttribute("logged_user"));
		
		return "db3/user/user_page";
	}	
	
	@RequestMapping(value = {"/db3/edit_user"}, method = RequestMethod.GET)
	public String editUserGet(HttpServletRequest request, Model model) {
		System.out.println("GET /db3/edit_user");
		HttpSession session = request.getSession();
		model.addAttribute("user", (User) session.getAttribute("logged_user"));
		return "db3/user/edit_user";
	}	
	
	@RequestMapping(value = {"/db3/edit_user"}, method = RequestMethod.POST)
	public String editUserPost(Model model) {
		System.out.println("POST /db3/edit_user");
//		User editedUser = new User();
		//Apportare le modifiche
		
		return "db3/index";
	}	

}
