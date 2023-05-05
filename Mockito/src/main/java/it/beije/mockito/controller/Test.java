package it.beije.mockito.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Test {

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public @ResponseBody String hello(HttpServletRequest request) {
		System.out.println("GET " + request.getRequestURL());
		return "Mockito hello";
	}	

	@RequestMapping(value = "/ciao", method = RequestMethod.GET)
	public @ResponseBody String ciao() {
		System.out.println("GET /ciao" );
		return "Mockito ciao";
	}	

}
