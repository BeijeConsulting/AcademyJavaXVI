package it.beije.mockito.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.beije.mockito.service.ServiceTest;

@RestController
public class Test {

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public @ResponseBody String hello(HttpServletRequest request) {
		System.out.println("GET " + request.getRequestURL());
		return "Mockito hello";
	}

	@RequestMapping(value = "/ciao", method = RequestMethod.GET)
	public @ResponseBody String ciao() {
		System.out.println("GET /ciao");
		return "Mockito ciao";
	}

}
