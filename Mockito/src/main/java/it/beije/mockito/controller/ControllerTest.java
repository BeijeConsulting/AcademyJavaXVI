package it.beije.mockito.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.beije.mockito.dto.ProvaDTO;
import it.beije.mockito.service.ServiceTest;

@RestController
public class ControllerTest {

	@Autowired
	ServiceTest service;

//	@GetMapping(value = "/{num}")
//	public @ResponseBody String dummy(@PathVariable int num) {
//		return service.dummyService(num);
//	}
	
	@GetMapping(value="/{id}")
	public ProvaDTO prova(@PathVariable int id) {
		return service.findUser(id);
	}
}
