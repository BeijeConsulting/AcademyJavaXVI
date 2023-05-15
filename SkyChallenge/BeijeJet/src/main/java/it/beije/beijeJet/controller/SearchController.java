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
	
	
	//@ApiOperation(value = "Get a specific address by ID", response = AddressDTO.class) swagger
	@GetMapping("/flights")
	public String getFlights(@RequestBody ReqFlightsDTO req) {
		//servizio search flights
		
		return null;
	
	}
	/**
	 * API per ottenere un volo da :
	 *  -id aereoporto partenza
	 *  -id aereoporto ritorno
	 *  -data e orario partenza
	 * @param dto
	 * @return
	 */
	//@ApiOperation(value = "Get a specific address by ID", response = AddressDTO.class) swagger
		@GetMapping("/flightsByDateAndTime")
		public TotalFlightDTO getFlightByDateAndTime(@RequestBody FlightDTO dto) {
			
			return searchService.getByDateAndTime(dto);
		
		}
		/**
		 * API per ottenere un volo da :
		 *  -id aereoporto partenza
		 *  -id aereoporto ritorno
		 *  -data e orario partenza
		 * @param dto
		 * @return
		 */
		//@ApiOperation(value = "Get a specific address by ID", response = AddressDTO.class) swagger
			@GetMapping("/flightsByDate")
			public Map<String,List<TotalFlightDTO>> getFlightByDate(@RequestBody FlightDTO dto) {
				
				return searchService.getByDate(dto);
			
			}
}
