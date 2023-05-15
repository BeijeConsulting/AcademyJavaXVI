package it.beije.beijeJet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import it.beije.beijeJet.dto.AirportDTO;
import it.beije.beijeJet.service.AirportService;


@RestController
public class AirportController {
	
	@Autowired
	private AirportService airportService;
	
	
	//@ApiOperation(value = "Get a lists of airport) swagger
	@GetMapping("/airports")
	public List<AirportDTO> getFlights() {
		System.out.println("GET /api/airports");
		
		return airportService.getAllAirports();
	
	}
}
