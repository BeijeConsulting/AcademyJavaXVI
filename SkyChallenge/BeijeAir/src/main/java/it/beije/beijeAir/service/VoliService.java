package it.beije.beijeAir.service;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
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
		
		if(searchDto.getDataRitorno() == null) {
			searchDto.setDataRitorno(searchDto.getDataPartenza().plusMonths(2));
		}

		List<RouteDto> rotte = new ArrayList<RouteDto>();

//		searchDto.setScali(Arrays.asList("0", "1", "2"));
		searchDto.setAndataRitorno(false);
				
		for (String s : searchDto.getScali()) {
			if (s.equals("0")) {
				List<Voli> diretti = voliRepository.find(searchDto.getCittaPartenza(), searchDto.getCittaArrivo(),
						searchDto.getDataPartenza(), searchDto.getDataRitorno());
				for (Voli v : diretti) {
					// per ogni volo che abbiamo trovato, costruisco una rotta che contiene solo il
					// volo diretto
					RouteDto r = new RouteDto();
					List<Voli> listVoli = new ArrayList<Voli>();
					listVoli.add(v);
					r.setVoli(listVoli);
					r.setDurataVoloMinuti(r.calcolaDurata(v.getDataArrivo(), v.getDataPartenza()));
					r.setCostoTotale(costoTotaleRotta(r));
					rotte.add(r);
				}
			} else {
				List<RottaConIdDto> scaliId = new ArrayList<RottaConIdDto>();
				Integer idPartenza = cittaRepository.findByNome(searchDto.getCittaPartenza()).getId();
				Integer idArrivo = cittaRepository.findByNome(searchDto.getCittaArrivo()).getId();
				if (s.equals("1")) {
					scaliId = voliRepository.findUnoScalo(idPartenza, idArrivo, searchDto.getDataPartenza(), searchDto.getDataRitorno());
				} else {
					scaliId = voliRepository.findDueScali(idPartenza, idArrivo, searchDto.getDataPartenza(), searchDto.getDataRitorno());
				}

				for (RottaConIdDto rId : scaliId) {
					// per ogni rotta che abbiamo trovato, ci ricaviamo i singoli voli e costruiamo
					// RouteDTO
					RouteDto r = new RouteDto();
					List<Voli> listVoli = new ArrayList<Voli>();
					listVoli.add(voliRepository.findById(rId.getVolo1_id()).get());
					listVoli.add(voliRepository.findById(rId.getVolo2_id()).get());
					if (rId.getVolo3_id() != 0) {
						listVoli.add(voliRepository.findById(rId.getVolo3_id()).get());
					}
					r.setVoli(listVoli);
					Duration durata = Duration.ofMinutes(0);
					durata = durata.plus(r.calcolaDurata(listVoli.get(listVoli.size() - 1).getDataArrivo(),
							listVoli.get(0).getDataPartenza()));
					r.setDurataVoloMinuti(durata);
					r.setCostoTotale(costoTotaleRotta(r));
					rotte.add(r);
				}
			}
		}

		if (searchDto.isAndataRitorno()) {
			searchDto.setAndataRitorno(false);
			String appo = searchDto.getCittaArrivo();
			searchDto.setCittaArrivo(searchDto.getCittaPartenza());
			searchDto.setCittaPartenza(appo);
			searchDto.setDataPartenza(searchDto.getDataRitorno());
			searchDto.setDataRitorno(null);

			rotte.addAll(find(searchDto));
		}

		return rotte;
	}

	private double costoTotaleRotta(RouteDto rotta) {
		List<Voli> voli = rotta.getVoli();
		double tot = 0;

		for (Voli v : voli) {
			tot += v.getPrezzo();
		}

		return tot;
	}

}
