package it.beije.neumann.ecommerce_shoes.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
public class LoginController {
	
	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("GET /login");
		
		HttpSession session = request.getSession();
		if (session.getAttribute("user") != null) {
			response.sendRedirect("./");
		}
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String postLogin(HttpServletRequest request, HttpServletResponse response,
							Model model,
							@RequestParam(required = true) String email,
							@RequestParam(required = true) String password) throws IOException {
		System.out.println("POST /login");
		List<User> risultati = userRepository.findByEmailAndPassword(email, password);
		if (risultati.isEmpty()) {
			model.addAttribute("error", "Invalid Credentials!");
			return "login";
		}
		else {
			HttpSession session = request.getSession();
			session.setAttribute("user", risultati.get(0));
			response.sendRedirect("./");
			return "index";
		}
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		return "login";
	}
}
