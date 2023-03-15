package it.beije.neumann.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HelloController {

	@RequestMapping(value = {"/hello", "/ciao"}, method = RequestMethod.GET)
	public String hello(HttpServletRequest request) {
		System.out.println("GET " + request.getRequestURL());
		return "hello"; // /WEB-INF/views/hello.jsp
	}

}
