package it.beije.beijeAir.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	
	@GetMapping(value="/find")
	public List<Voli> findVoli( @RequestBody SearchDto searchDto  ){
		System.out.println("GET /find");
		
		List<Voli> voli = voliService.find(searchDto);
		
		return voli;
	}

}
