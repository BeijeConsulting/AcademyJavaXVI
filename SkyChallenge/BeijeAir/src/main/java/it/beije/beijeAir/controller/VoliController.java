package it.beije.beijeAir.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import it.beije.beijeAir.model.Voli;
import it.beije.beijeAir.service.VoliService;



@Controller
public class VoliController {
	
	@Autowired 
	private VoliService voliService;
	
	@GetMapping(value="/voli")
	public String getAllVoli(Model model) {
		System.out.println("GET/  voli");
	    List<Voli> voli = voliService.findAll();
	    model.addAttribute("voli", voli);
	    return "voli";
	}

}
