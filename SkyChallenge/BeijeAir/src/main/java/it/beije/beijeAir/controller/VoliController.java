package it.beije.beijeAir.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.beije.beijeAir.dto.RouteDto;
import it.beije.beijeAir.dto.SearchDto;
import it.beije.beijeAir.model.Voli;
import it.beije.beijeAir.service.VoliService;

@Controller
public class VoliController {
	
	@Autowired 
	private VoliService voliService;
	
	@GetMapping(value="/voli")
	public String getAllVoli(Model model) {
		System.out.println("GET/ voli");
	    List<Voli> voli = voliService.findAll();
	    model.addAttribute("voli", voli);
	    return "voli";
	}
	
	@GetMapping(value="/")
	public String getIndex(Model model) {
		model.addAttribute("SearchDto", new SearchDto());
	    return "index";
	}

	@PostMapping(value="/ricercaVoli")
	public String findRotte(SearchDto searchDto, Model model, @RequestParam("dataPartenza") @DateTimeFormat(pattern="yyyy-MM-dd HH:mm") String dataPartenzaString) {		
		LocalDateTime dataPartenza = LocalDateTime.parse(dataPartenzaString);
	    searchDto.setDataPartenza(dataPartenza);
		
		System.out.println("POST /ricercaVoli");
		
		searchDto.setDataPartenza(dataPartenza);
		List<RouteDto> rotte = voliService.find(searchDto);
		
		model.addAttribute("flightResults", rotte);
	    return "ricercaVoli";
	}

}
