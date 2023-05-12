package it.beije.beijeAir.service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.beije.beijeAir.dto.SearchDto;
import it.beije.beijeAir.model.Voli;
import it.beije.beijeAir.repository.VoliRepository;

@Service
public class VoliService {

	@Autowired 
	VoliRepository voliRepository;
	
	
	public List<Voli> findAll() {
		List<Voli> voli = voliRepository.findAll();
		voli.stream().forEach(e -> e.getCittaArrivo().getCitta());
		return voli;
	}
	
	public List<Voli> find(SearchDto searchDto, boolean andataRitorno, LocalDateTime dataPartenza) {
		
		List<Voli> voli  = voliRepository.find( searchDto.getCittaPartenza(), searchDto.getCittaArrivo(), dataPartenza );
	
		if( andataRitorno ) {
			voli.addAll(voliRepository.find( searchDto.getCittaArrivo(), searchDto.getCittaPartenza(), dataPartenza));
		}
		 

		
		return voli;
	}
	
	
	
	
	
}
