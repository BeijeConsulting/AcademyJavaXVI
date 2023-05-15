package it.beije.beijeJet.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.beijeJet.dto.FlightDTO;
import it.beije.beijeJet.dto.TotalFlightDTO;
import it.beije.beijeJet.model.Flight;
import it.beije.beijeJet.repository.AirportRepository;
import it.beije.beijeJet.repository.FlightRepository;

@Service
public class SearchService {

	@Autowired
	private FlightRepository flightRepo;
	
	@Autowired
	private AirportRepository airportRepo;
	
	public List<TotalFlightDTO> getByDate(FlightDTO dto) {
		
		String date=dto.getTimeDeparture();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    LocalDate dob = LocalDate.parse(date, formatter);
	    	
		Integer idAirportDeparture= dto.getIdAirportDeparture();
		Integer idAirportArrival= dto.getIdAirportArrival();
		System.out.println(idAirportDeparture);
		System.out.println(idAirportArrival);
			
		List<Flight> fl=flightRepo.getFlightDate(dob,idAirportDeparture,idAirportArrival);
		
		System.out.println(fl);
		
		List<TotalFlightDTO>lista=new ArrayList<>();
		
			for(Flight f: fl) {
			TotalFlightDTO flightDto=new TotalFlightDTO();
	    	 flightDto.setAirportArrival(airportRepo.findNameByIdAirport(f.getAirportArrival()));
	    	 flightDto.setIdFlight(f.getIdFlight());
	    	 flightDto.setAirportDeparture(airportRepo.findNameByIdAirport(f.getAirportDeparture()));
	    	 flightDto.setTimeDeparture(f.getTimeDeparture());
	    	 flightDto.setTimeArrival(f.getTimeArrival());
	    	 flightDto.setCost(f.getCost());
	    	 flightDto.setMax_capacity(f.getMaxCapacity());
	    	 flightDto.setCompany(f.getCompany());
	    	 lista.add(flightDto);
			}
			
	    	 
	    	 return lista;
		}
	}
	

