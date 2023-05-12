package it.beije.beijeJet.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.beije.beijeJet.dto.ReqFlightsDTO;


@RestController
public class SearchController {
	
	
	//@ApiOperation(value = "Get a specific address by ID", response = AddressDTO.class)
	@GetMapping("/flights")
	public String getFlights(@RequestBody ReqFlightsDTO req) {
		//servizio search flights
		
		return null;
	
	}
}
