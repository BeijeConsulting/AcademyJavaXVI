package it.beije.beijeJet.controller;


import java.util.List;
import java.util.Map;

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
	
	
		/**
		 * API per ottenere un volo da :
		 *  -id aereoporto partenza
		 *  -id aereoporto ritorno
		 *  -data partenza
		 * @param dto
		 * @return
		 */
			@GetMapping("/flightsByDate")
			public List<TotalFlightDTO> getFlightByDate(@RequestBody FlightDTO dto) {
				
				return searchService.getByDate(dto);
			
			}
			
			@GetMapping("/flightsDepartureArrival")
			public Map<String,List<TotalFlightDTO>> getFlightDepartureArrival(@RequestBody FlightDTO dto) {
				
				return searchService.getFlightDepartureArrival(dto);
			
			}
}
