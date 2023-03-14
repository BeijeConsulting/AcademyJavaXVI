package it.beije.neumann.restcontroller.nicole;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.beije.neumann.exception.IdNotFoundException;
import it.beije.neumann.exception.InvalidJSONException;
import it.beije.neumann.model.Contatto;
import it.beije.neumann.repository.ContattoRepository;

@RestController
public class RubricaRestController {

	@Autowired
	private ContattoRepository contattoRepository;
	
	@GetMapping(value = "/contattiBySurname")
	public List<Contatto> listaContatti(@RequestParam(required = false) String surname) {
		System.out.println("GET /contatti");
		
		List<Contatto> contatti;
		Integer totale = null;
		if (surname != null) {
			contatti = contattoRepository.findBySurname(surname);
			totale = contattoRepository.countBySurname(surname);
			System.out.println("totale : " + totale);
		} else {
			contatti = contattoRepository.findAll();
		}
		 
		return contatti;
	}
	
	
	
	@PutMapping(value = "/modifica_contatto")
	public Contatto dettaglioContatto(@RequestParam(required = false) String surname,@RequestParam(required = false) String name, @RequestBody Contatto newValues) {
		System.out.println("PUT /modifica_contatto");
		
//		if (id.compareTo(newValues.getId()) != 0) throw new InvalidJSONException("id non corrispondenti");
		
		//TODO dovrebbe stare in un ContattoService...
//		Optional<Contatto> c = contattoRepository.findById(id);
//		if (!c.isPresent()) throw new IdNotFoundException("id errato");

		Contatto newC=new Contatto();
		List<Contatto> c=contattoRepository.findBySurnameAndName(surname, name);
		for(Contatto contatto: c) {		
			newC=contatto;
		if (newValues.getName() != null) newC.setName(newValues.getName());
		if (newValues.getSurname() != null) newC.setSurname(newValues.getSurname());
		if (newValues.getTelephone() != null) newC.setTelephone(newValues.getTelephone());
		if (newValues.getEmail() != null) newC.setEmail(newValues.getEmail());
		if (newValues.getNote() != null) newC.setNote(newValues.getNote());
		
		BeanUtils.copyProperties(newValues, newC, "id");		
		
		contattoRepository.save(newC);
		}
		
		return newC;
	}

}
