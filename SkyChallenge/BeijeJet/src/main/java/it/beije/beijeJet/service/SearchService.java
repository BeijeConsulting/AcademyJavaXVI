package it.beije.beijeJet.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.BeanUtils;
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
	
	public Map<String,Object> getByDate(FlightDTO dto) {
		
		String date=dto.getTimeDeparture();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    LocalDate dob = LocalDate.parse(date, formatter);
	    	
		Integer idAirportDeparture= dto.getIdAirportDeparture();
		Integer idAirportArrival= dto.getIdAirportArrival();
		System.out.println(idAirportDeparture);
		System.out.println(idAirportArrival);
			
		List<Flight> fl=flightRepo.getFlightDate(dob,idAirportDeparture,idAirportArrival);
		
		System.out.println(fl);
		
		Map<String,Object> voli=new LinkedHashMap<>();
		List<TotalFlightDTO>listaAndata=new ArrayList<>();
		List<TotalFlightDTO>listaRitorno=new ArrayList<>();
		
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
	    	 flightDto.setAirportArrival(airportRepo.findNameByIdAirport(f.getAirportArrival()));
	    	 listaAndata.add(flightDto);
	    	 
			}
			voli.put("outward_flights", listaAndata);
			
	    	if(!Objects.isNull(dto.getReturnDate())) {
	    		
	    		String dateReturn=dto.getReturnDate();
	    		Integer idAirportDeparture2= dto.getIdAirportArrival();
	    		Integer idAirportArrival2= dto.getIdAirportDeparture();
	    		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    	    LocalDate returnDate = LocalDate.parse(dateReturn, formatter2);
	    	    List<Flight> returnFlights=flightRepo.getFlightDate(returnDate,idAirportDeparture2,idAirportArrival2);
	    	    
	    		
				for(Flight f: returnFlights) {
					
				TotalFlightDTO flightDto=new TotalFlightDTO();
		    	 flightDto.setAirportArrival(airportRepo.findNameByIdAirport(f.getAirportArrival()));
		    	 flightDto.setIdFlight(f.getIdFlight());
		    	 flightDto.setAirportDeparture(airportRepo.findNameByIdAirport(f.getAirportDeparture()));
		    	 flightDto.setTimeDeparture(f.getTimeDeparture());
		    	 flightDto.setTimeArrival(f.getTimeArrival());
		    	 flightDto.setCost(f.getCost());
		    	 flightDto.setMax_capacity(f.getMaxCapacity());
		    	 flightDto.setCompany(f.getCompany());
		    	 listaRitorno.add(flightDto);
		    	 
				}
				
	    	}
		
	    	voli.put("return_flights", listaRitorno);
			
			return voli;
		}
	

	
	
	}
	

