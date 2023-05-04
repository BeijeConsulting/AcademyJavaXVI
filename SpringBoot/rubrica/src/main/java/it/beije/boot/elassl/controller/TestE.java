package it.beije.boot.elassl.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class TestE {


	@RequestMapping(value = "/elciao", method = RequestMethod.GET)
	public @ResponseBody String ciao() {
		System.out.println("GET /ciao" );
		return "ELCIAO";
	}	

}
