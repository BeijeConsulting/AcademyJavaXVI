package it.beije.beijeJet.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.beije.beijeJet.dto.FlightDTO;
import it.beije.beijeJet.dto.TotalFlightDTO;
import it.beije.beijeJet.exception.BeijeJetException;
import it.beije.beijeJet.model.Flight;
import it.beije.beijeJet.repository.FlightRepository;

@Service
public class SearchService {
//metodo per ottenere da stringa ad aereoporto
	
	@Autowired
	private FlightRepository flightRepo;
	
	public TotalFlightDTO getByDateAndTime(FlightDTO dto) {
		
		TotalFlightDTO flightDto=new TotalFlightDTO();
//		System.out.println(dto.getTimeDeparture());
		String time=dto.getTimeDeparture();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	    LocalDateTime dob = LocalDateTime.parse(time, formatter);
	    
		LocalDateTime timeDeparture=dob;
		System.out.println(timeDeparture);
		
		
		Integer idAirportDeparture= dto.getIdAirportDeparture();
		Integer idAirportArrival= dto.getIdAirportArrival();
		System.out.println(idAirportDeparture);
		System.out.println(idAirportArrival);
			
		Flight f=flightRepo.getFlight(timeDeparture,idAirportDeparture,idAirportArrival);
		
		System.out.println(f);
		
		
		if(Objects.isNull(f)) throw new BeijeJetException("Volo non disponibile.");
		else {
			
	    	 flightDto.setAirportArrival(f.getAirportArrival());
	    	 flightDto.setIdFlight(f.getIdFlight());
	    	 flightDto.setAirportDeparture(f.getAirportDeparture());
	    	 flightDto.setTimeDeparture(f.getTimeDeparture());
	    	 flightDto.setTimeArrival(f.getTimeArrival());
	    	 flightDto.setCost(f.getCost());
	    	 flightDto.setMax_capacity(f.getMaxCapacity());
	    	 flightDto.setCompany(f.getCompany());
	    	 
	    	 return flightDto;
		}
		
	}
	
	public Map<String,List<TotalFlightDTO>> getByDate(FlightDTO dto) {
		
		String date=dto.getTimeDeparture();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	    LocalDate dob = LocalDate.parse(date, formatter);
	    
//	    LocalTime time = LocalTime.of(00,00,00);
//		LocalDateTime timeDeparture = LocalDateTime.of(dob, time);
		
//		System.out.println(timeDeparture);
//		
		Integer idAirportDeparture= dto.getIdAirportDeparture();
		Integer idAirportArrival= dto.getIdAirportArrival();
		System.out.println(idAirportDeparture);
		System.out.println(idAirportArrival);
			
		List<Flight> fl=flightRepo.getFlightDate(dob,idAirportDeparture,idAirportArrival);
		
		System.out.println(fl);
		
		Map<String,List<TotalFlightDTO>> mappa=new LinkedHashMap<>();
		List<TotalFlightDTO>lista=new ArrayList<>();
		
			for(Flight f: fl) {
			TotalFlightDTO flightDto=new TotalFlightDTO();
	    	 flightDto.setAirportArrival(f.getAirportArrival());
	    	 flightDto.setIdFlight(f.getIdFlight());
	    	 flightDto.setAirportDeparture(f.getAirportDeparture());
	    	 flightDto.setTimeDeparture(f.getTimeDeparture());
	    	 flightDto.setTimeArrival(f.getTimeArrival());
	    	 flightDto.setCost(f.getCost());
	    	 flightDto.setMax_capacity(f.getMaxCapacity());
	    	 flightDto.setCompany(f.getCompany());
	    	lista.add(flightDto);
			}
			 mappa.put("flight", lista);
	    	 
	    	 return mappa;
		}
	}
	

