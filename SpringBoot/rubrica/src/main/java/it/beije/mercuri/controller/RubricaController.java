package it.beije.mercuri.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import it.beije.mercuri.model.Contatto;
import it.beije.mercuri.service.RubricaService;

import static org.springframework.http.ResponseEntity.ok;
@RestController
public class RubricaController {

	
	@Autowired
	private RubricaService rubricaService;
	
	@GetMapping(value="/contatti_list")
	public ResponseEntity<Map<String, List<Contatto>>> contattiList() {

		return ok(rubricaService.viewContatti());		

	}
}
