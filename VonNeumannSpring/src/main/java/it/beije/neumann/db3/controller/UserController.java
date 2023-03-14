package it.beije.neumann.db3.controller;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.neumann.db3.model.Address;
import it.beije.neumann.db3.model.OrderD;
import it.beije.neumann.db3.model.UserD;
import it.beije.neumann.db3.service.AddressService;
import it.beije.neumann.db3.service.OrderServiceD;
import it.beije.neumann.db3.service.UserServiceD;

@Controller
public class UserController {

	@Autowired
	private UserServiceD userService;
	
	@Autowired
	private OrderServiceD orderService;
	
	@Autowired
	private AddressService addressService;

	@RequestMapping(value = { "/db3/user_page" }, method = RequestMethod.GET)
	public String userPage(HttpServletRequest request, Model model) {
		System.out.println("GET /db3/user_page");

		String jsp = "db3/";
		HttpSession session = request.getSession();

		if (userService.isUserLogged(session)) {
			model.addAttribute("logged_user", userService.getLoggedUser(session));
			jsp += "user/user_page";
		} else {
			jsp += "signin";
		}

		return jsp;
	}

	@RequestMapping(value = { "/db3/edit_user" }, method = RequestMethod.GET)
	public String editUserGet(HttpServletRequest request, Model model) {
		System.out.println("GET /db3/edit_user");

		String jsp = "db3/";

		HttpSession session = request.getSession();

		if (userService.isUserLogged(session)) {
			model.addAttribute("logged_user", userService.getLoggedUser(session));
			jsp += "user/edit_user";
		} else {
			jsp += "signin";
		}

		return jsp;
	}

	@RequestMapping(value = { "/db3/edit_user" }, method = RequestMethod.POST)
	public String editUserPost(HttpServletRequest request, Model model, UserD userData,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate birthdate) {
		System.out.println("POST /db3/edit_user");

		HttpSession session = request.getSession();

		UserD toEdit = userService.findById((userService.getLoggedUser(session)).getId());

		userData.setBirthDate(birthdate);

		toEdit.copyValuesOf(userData);

		userService.saveUser(toEdit);

		session.setAttribute("logged_user", toEdit);
		model.addAttribute("logged_user", toEdit);

		return "db3/user/user_page";
	}
	
	@RequestMapping(value = { "/db3/my_order" }, method = RequestMethod.GET)
	public String myOrder(HttpServletRequest request, Model model) {
		System.out.println("GET /db3/my_order");
		
		String jsp = "db3/";
		HttpSession session = request.getSession();
		
		UserD loggedUser = (UserD) session.getAttribute("logged_user");
		
		if (loggedUser!=null) {
			model.addAttribute("logged_user", loggedUser);
			List<OrderD> order = orderService.findByUserId(loggedUser.getId());
			model.addAttribute("order", order);
			jsp+="user/my_order";
		} else {
			jsp+="signin";
		}
		
		return jsp;
	}

}
