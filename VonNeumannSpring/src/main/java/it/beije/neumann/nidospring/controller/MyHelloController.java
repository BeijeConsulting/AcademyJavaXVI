package it.beije.neumann.nidospring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class MyHelloController {

	@RequestMapping(value = {"/nidospring/hello", "/nidospring/ciao"}, method = RequestMethod.GET)
	public String hello(HttpServletRequest request) {
		System.out.println("GET " + request.getRequestURL());
		return "nidoviews/hello"; // /WEB-INF/views/hello.jsp
	}	

	@RequestMapping(value = "/nidospring/", method = RequestMethod.GET)
	public String index() {
		System.out.println("GET /nidospring/ ");
		return "nidoviews/index";
	}	
	
}
