package it.beije.mockito.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.beije.mockito.dto.ProvaDTO;
import it.beije.mockito.service.ServiceTest;

import static org.springframework.http.ResponseEntity.*;

@RestController
public class ControllerTest {

	@Autowired
	ServiceTest service;

//	@GetMapping(value = "/{num}")
//	public @ResponseBody String dummy(@PathVariable int num) {
//		return service.dummyService(num);
//	}
	
	@GetMapping(value="/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ProvaDTO prova(@PathVariable int id) {
		return service.findUser(id);
//		return ResponseEntity.ok(service.findUser(id));
//		return status(HttpStatus.OK).body(service.findUser(id));
	}
}
