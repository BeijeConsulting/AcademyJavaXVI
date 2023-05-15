package it.beije.beijeAir.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
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
		
		if(voli.size()==0) {
			voli = checkScali(voli,  searchDto);
		}
		 

		
		return voli;
	}

	private List<Voli> checkScali(List<Voli> voli, SearchDto searchDto ) {
	
		System.out.println("Nessun volo diretto");
		List<Voli> scali = new ArrayList<>();
		List<Voli> voliTo = voliRepository.find( null, searchDto.getCittaArrivo(), null );
		List<Voli> voliFrom = voliRepository.find( searchDto.getCittaPartenza(), null, null );		
		 
		scali = confrontaListeVoli(voliTo,voliFrom);
		
		return scali;
			
	}
	
	
	
	private List<Voli> confrontaListeVoli(List<Voli> voliTo, List<Voli> voliFrom) {
		List<Voli> voli = new ArrayList<>();
        for (Voli voTo : voliTo) {
            for (Voli voFrom : voliFrom) {
                if (voTo.getCittaPartenza().equals(voFrom.getCittaArrivo())) {
                    voli.add(voFrom);
                    voli.add(voTo);
                }
            }
        }
        
        //se voli è vuoto richiama ricerca e passa parametri di liste 
        return voli;
    }
	
}
