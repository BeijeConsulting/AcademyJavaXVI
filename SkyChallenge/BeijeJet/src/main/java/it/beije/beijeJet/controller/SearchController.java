package it.beije.beijeJet.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import it.beije.beijeJet.dto.FlightDTO;
import it.beije.beijeJet.dto.ReqFlightsDTO;
import it.beije.beijeJet.dto.TotalFlightDTO;
import it.beije.beijeJet.service.SearchService;


@RestController
public class SearchController {
	
	@Autowired

	private SearchService searchService;
	
	
	//@ApiOperation(value = "Get a specific address by ID", response = AddressDTO.class) swagger
	@GetMapping("/flights")
	public String getFlights(@RequestBody ReqFlightsDTO req) {
		//servizio search flights
		
		return null;
	
	}
	//api get per ottenere aereoporti
	//
	//@ApiOperation(value = "Get a specific address by ID", response = AddressDTO.class) swagger
		@GetMapping("/flightsByDate")
		public TotalFlightDTO getFlightByDate(@RequestBody FlightDTO dto) {
			
			return searchService.getByDate(dto);
		
		}
}
