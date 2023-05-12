package it.beije.beijeAir.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.beije.beijeAir.model.Voli;
import it.beije.beijeAir.repository.VoliRepository;

@Service
public class VoliService {

	@Autowired 
	VoliRepository voliRepository;
	
	@Transactional
	public List<Voli> findAll() {
		System.out.println(voliRepository.findAll());
		return voliRepository.findAll();
	}
}
