package it.beije.mockito.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.beije.mockito.dto.ProvaDTO;
import it.beije.mockito.dto.TodoListDTO;
import it.beije.mockito.model.ToDoList;
import it.beije.mockito.service.ServiceTest;

@RestController
public class ControllerTest {

	@Autowired
	ServiceTest service;

	@GetMapping(value = "/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ProvaDTO prova(@PathVariable int id) {
		return service.findUser(id);
	}
	
	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ToDoList> getAllNotes() {
		return service.findAll();
	}
	
	@GetMapping(value = "/notes", produces = MediaType.APPLICATION_JSON_VALUE)
	public TodoListDTO getNotes(@RequestParam String username) {
		return service.findNotesByUsername(username);
	}
	
	@PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
	public TodoListDTO addNote(@RequestBody ToDoList todo) {
		return service.addNote(todo);
	}
}
