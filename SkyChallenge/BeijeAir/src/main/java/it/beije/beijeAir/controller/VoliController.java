package it.beije.beijeAir.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
		System.out.println("GET/  voli");
	    List<Voli> voli = voliService.findAll();
	    model.addAttribute("voli", voli);
	    return "voli";
	}
	
	@GetMapping(value="/")
	public String getIndex(Model model) {
		model.addAttribute("SearchDTO", new SearchDto());
	    return "index";
	}
	
	@GetMapping(value="/all_voli")
	public List<Voli> getAllVoli(){
		System.out.println("GET /AllVoli");
		List<Voli> voli = voliService.findAll();
		
		return voli;
	}
	
	/*
	 * TODO: dataRitorno
	 * TODO: Scali
	 * TODO: Durata( voli + scali)
	 * TODO: sistema pom e configurazione import e metodo, togli restController
	 * */
	@PostMapping(value="/ricercaVoli")
	public @ResponseBody List<RouteDto> findRotte(@RequestBody SearchDto searchDto) {		
		System.out.println("POST /ricercaVoli");
				
		List<RouteDto> rotte = voliService.find(searchDto);
		
		System.out.println(rotte);
		return rotte;
		/*
		model.addAttribute("flightResults", flightResults);
	    return "ricercaVoli";*/
	}
	
	@PostMapping(value="/ricercaVoliProva")
	public String findRotte(SearchDto searchDto, Model model, @DateTimeFormat(pattern="yyyy-MM-dd'T'hh:mm:ss") LocalDateTime dataPartenza2) {		
		System.out.println("POST /ricercaVoli");
		
		System.out.println(dataPartenza2);
		List<RouteDto> rotte = voliService.find(searchDto);
		
		model.addAttribute("flightResults", rotte);
	    return "ricercaVoli";
	}

}
