package it.beije.beijeJet.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.beijeJet.dto.AirportDTO;
import it.beije.beijeJet.model.Airport;
import it.beije.beijeJet.repository.AirportRepository;

@Service
public class AirportService {
	
	@Autowired
	private AirportRepository airportRepository;
	
	public List<AirportDTO> getAllAirports() {
		List<AirportDTO> airportsDTO = new ArrayList<AirportDTO>();
		List<Airport> airports = airportRepository.findAll();
		AirportDTO dto;
		for (Airport a : airports) {
			dto = new AirportDTO();
			BeanUtils.copyProperties(a, dto);
			airportsDTO.add(dto);
		}
		
		return airportsDTO;
	}
	
}
