package it.beije.beijeAir.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.beije.beijeAir.dto.SearchDto;
import it.beije.beijeAir.model.Voli;
import it.beije.beijeAir.service.VoliService;



@RestController
public class VoliController {
	
@Autowired VoliService voliService;
	
	@GetMapping(value="/")
	public void hello() {
		System.out.println("Ciao");
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
	 * TODO: PREGA 
	 * */
	@GetMapping(value="/find")
	public List<Voli> findVoli( 
			@RequestBody SearchDto searchDto,
			@RequestParam(required=false) boolean andataRitorno,
			@RequestParam(required = false) @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") LocalDateTime dataPartenza
			){
		
		System.out.println("GET /find");
				
		List<Voli> voli = voliService.find(searchDto, andataRitorno, dataPartenza);
		
		return voli;
	}

}
