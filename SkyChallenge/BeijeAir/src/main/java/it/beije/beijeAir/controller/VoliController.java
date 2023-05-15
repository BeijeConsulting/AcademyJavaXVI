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
		System.out.println("GET/  voli");
	    List<Voli> voli = voliService.findAll();
	    model.addAttribute("voli", voli);
	    return "voli";
	}
	
	@GetMapping(value="/")
	public String getIndex(Model model) {
		model.addAttribute("SearchDto", new SearchDto());
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
	public String findRotte(SearchDto searchDto, Model model, @RequestParam("dataPartenza") @DateTimeFormat(pattern="yyyy-MM-dd HH:mm") String dataPartenzaString) {		
		LocalDateTime dataPartenza = LocalDateTime.parse(dataPartenzaString);
	    searchDto.setDataPartenza(dataPartenza);
		
		System.out.println("GET /find");
		
		System.out.println(dataPartenza);
		searchDto.setDataPartenza(dataPartenza);
		List<RouteDto> rotte = voliService.find(searchDto);
		
		
		System.out.println(rotte);
		
		model.addAttribute("flightResults", rotte);
	    return "ricercaVoli";
	}

	/*
	@PostMapping("/ricercaVoli")
	public String searchFlights(@ModelAttribute("SearchDTO") SearchDto searchDTO, Model model) {

		//TODO ricerca utilizzando i dati del DTO
		String flightResults = null; //TODO: Da cambiare
		
		//aggiunge i risultati alla model per passarli alla pagina dei risultati
		model.addAttribute("flightResults", flightResults);
		
	    return "ricercaVoli";
	}
*/
}
