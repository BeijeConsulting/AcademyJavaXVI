package it.beije.beijeAir.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
	
	@GetMapping(value="/")
	public String getIndex(Model model) {
		model.addAttribute("SearchDTO", new SearchDTO());
	    return "index";
	}
	
	@PostMapping("/ricercaVoli")
	public String searchFlights(@ModelAttribute("SearchDTO") SearchDTO searchDTO, Model model) {

		//TODO ricerca utilizzando i dati del DTO
		
		//aggiunge i risultati alla model per passarli alla pagina dei risultati
		model.addAttribute("flightResults", flightResults);
		
	    return "ricercaVoli";
	}

}
