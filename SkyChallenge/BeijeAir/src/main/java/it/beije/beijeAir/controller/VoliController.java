package it.beije.beijeAir.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import it.beije.beijeAir.model.Voli;
import it.beije.beijeAir.service.VoliService;



@RestController
public class VoliController {
	
	@Autowired 
	private VoliService voliService;
	
	@GetMapping(value="/")
	public List<Voli> getAllVoli(){
		System.out.println("GET /voli");
		List<Voli> voli = voliService.findAll();
		return voli;
	}

}
