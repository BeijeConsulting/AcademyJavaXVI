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
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = { "/db3/" }, method = RequestMethod.GET)
	public String index() {
		System.out.println("GET /db3/");
		return "db3/index";
	}

	@RequestMapping(value = { "/db3/user_page" }, method = RequestMethod.GET)
	public String userPage(HttpServletRequest request, Model model) {
		System.out.println("GET /db3/user_page");

		HttpSession session = request.getSession();
		model.addAttribute("logged_user", (User) session.getAttribute("logged_user"));

		return "db3/user/user_page";
	}

	@RequestMapping(value = { "/db3/edit_user" }, method = RequestMethod.GET)
	public String editUserGet(HttpServletRequest request, Model model) {
		System.out.println("GET /db3/edit_user");
		HttpSession session = request.getSession();
		model.addAttribute("logged_user", (User) session.getAttribute("logged_user"));
		return "db3/user/edit_user";
	}

	@RequestMapping(value = { "/db3/edit_user" }, method = RequestMethod.POST)
	public String editUserPost(HttpServletRequest request, Model model, User userData, @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate birthdate) {
		System.out.println("POST /db3/edit_user");
		
		HttpSession session = request.getSession();
		
		User toEdit = userService.findById(((User) session.getAttribute("logged_user")).getId());
		
		toEdit.setName(userData.getName());
		toEdit.setSurname(userData.getSurname());
		toEdit.setEmail(userData.getEmail());
		toEdit.setPassword(userData.getPassword());
		toEdit.setTelephone(userData.getTelephone());
		toEdit.setBirthDate(birthdate);
		
		userService.saveUser(toEdit);
		
		session.setAttribute("logged_user", toEdit);
		model.addAttribute("logged_user", toEdit);

		return "db3/user/user_page";
	}

}