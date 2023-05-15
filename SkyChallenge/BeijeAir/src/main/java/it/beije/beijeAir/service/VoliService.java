package it.beije.beijeAir.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.beijeAir.dto.RottaConIdDto;
import it.beije.beijeAir.dto.RouteDto;
import it.beije.beijeAir.dto.SearchDto;
import it.beije.beijeAir.model.Voli;
import it.beije.beijeAir.repository.CittaRepository;
import it.beije.beijeAir.repository.VoliRepository;

@Service
public class VoliService {

	@Autowired 
	VoliRepository voliRepository;
	
	@Autowired 
	CittaRepository cittaRepository;
	
	
	public List<Voli> findAll() {
		List<Voli> voli = voliRepository.findAll();
		voli.stream().forEach(e -> e.getCittaArrivo().getNome());
		return voli;
	}
	
	public List<RouteDto> find(SearchDto searchDto) {
		
		List<RouteDto> rotte  = new ArrayList<RouteDto>();
				
		for (String s : searchDto.getScali()) {
			if(s.equals("0")) {
				List<Voli> diretti = voliRepository.find(searchDto.getCittaPartenza(), 
														 searchDto.getCittaArrivo(),
														 searchDto.getDataPartenza());
				for (Voli v: diretti) {
					//per ogni volo che abbiamo trovato, costruisco una rotta che contiene solo il volo diretto
					RouteDto r = new RouteDto();
					List<Voli> listVoli = new ArrayList<Voli>();
					listVoli.add(v);
					r.setVoli(listVoli);
					rotte.add(r);
				}
			}
			else {
				List<RottaConIdDto> scaliId = new ArrayList<RottaConIdDto>();
				Integer idPartenza = cittaRepository.findByNome(searchDto.getCittaPartenza()).getId();
				Integer idArrivo = cittaRepository.findByNome(searchDto.getCittaArrivo()).getId();
				if (s.equals("1")) {
					scaliId = voliRepository.findUnoScalo(idPartenza, 
														  idArrivo,
														  searchDto.getDataPartenza());
				}
				else {
					scaliId = voliRepository.findDueScali(idPartenza, 
														  idArrivo,
							  							  searchDto.getDataPartenza());
				}
				
				for (RottaConIdDto rId: scaliId) {
					//per ogni rotta che abbiamo trovato, ci ricaviamo i singoli voli e costruiamo RouteDTO
					RouteDto r = new RouteDto();
					List<Voli> listVoli = new ArrayList<Voli>();
					listVoli.add(voliRepository.findById(rId.getVolo1_id()).get());
					listVoli.add(voliRepository.findById(rId.getVolo2_id()).get());
					if (rId.getVolo3_id() != 0) {
						listVoli.add(voliRepository.findById(rId.getVolo3_id()).get());
					}
					r.setVoli(listVoli);
					rotte.add(r);
				}
			}
		}
		
		if(searchDto.isAndataRitorno()) {
			searchDto.setAndataRitorno(false);
			String appo = searchDto.getCittaArrivo();
			searchDto.setCittaArrivo(searchDto.getCittaPartenza());
			searchDto.setCittaPartenza(appo);
			// TODO: data di arrivo metterla in data di partenza
			rotte.addAll(find(searchDto));
		}		
				
		return rotte;
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
