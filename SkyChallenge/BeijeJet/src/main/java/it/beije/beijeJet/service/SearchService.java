package it.beije.beijeJet.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.beijeJet.dto.FlightDTO;
import it.beije.beijeJet.dto.TotalFlightDTO;
import it.beije.beijeJet.model.Flight;
import it.beije.beijeJet.repository.FlightRepository;

@Service
public class SearchService {
//metodo per ottenere da stringa ad aereoporto
	
	@Autowired
	private FlightRepository flightRepo;
	
	public TotalFlightDTO getByDate(FlightDTO dto) {
		
		TotalFlightDTO flightDto=new TotalFlightDTO();
		System.out.println(dto.getTimeDeparture());
		String time=dto.getTimeDeparture();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	    LocalDateTime dob = LocalDateTime.parse(time, formatter);
	    
		LocalDateTime timeDeparture=dob;
		System.out.println(timeDeparture);
		
		Integer idAirportDeparture= dto.getIdAirportDeparture();
		Integer idAirportArrival= dto.getIdAirportArrival();
		
//		
		Flight f=flightRepo.getFlight(timeDeparture,idAirportDeparture,idAirportArrival);
		
		System.out.println(f);
		
		 
		 
//    	 flightDto.setAirportArrival(f.getAirportArrival());
		 
		 
		 return flightDto;
		
	}
	
}
