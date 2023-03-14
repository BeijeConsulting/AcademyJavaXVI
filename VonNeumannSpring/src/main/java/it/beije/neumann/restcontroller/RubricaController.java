package it.beije.neumann.restcontroller;


import java.util.List;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

import it.beije.neumann.model.Contatto;
import it.beije.neumann.repository.ContattoRepository;


//@Controller
@RestController
@RequestMapping(value = "api")
public class RubricaController {

	@Autowired
	private ContattoRepository contattoRepository;

//	@RequestMapping(value = "/contatti", method = RequestMethod.GET)
//	public @ResponseBody List<Contatto> prova(@RequestParam(required = false) String surname) {
	@GetMapping(value = "/lista_contatti")
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

	@GetMapping(value = "/contatto/{id}")
	public Contatto dettaglioContatto(@PathVariable(name = "id") Integer id) {
		System.out.println("GET /contatto/"+id);
		
		Optional<Contatto> contatto = contattoRepository.findById(id);
		
		return contatto.isPresent() ? contatto.get() : null;

//		return contatto.isPresent() ? contatto.get() : "contatto non trovato";
		
//		if (!contatto.isPresent()) {
//			Map<String, String> message = new HashMap<String, String>();
//			
//			message.put("message", "contatto non trovato");
//			
//			return message;
//		}
//		
//		return contatto.get();
	}
	
	
	@PostMapping(value = "/contatto")
	public Contatto insertContatto(@RequestBody Contatto contatto) {
		System.out.println("POST /contatto : " + contatto);
		
		contattoRepository.save(contatto);
		
		return contatto;
	}


	@PutMapping(value = "/contatto/{id}")
	public Contatto dettaglioContatto(@PathVariable(name = "id") Integer id, @RequestBody Contatto newValues) {
		System.out.println("PUT /contatto/"+id);
		
		if (id.compareTo(newValues.getId()) != 0) throw new IllegalArgumentException("id non corrispondenti");
		
		//TODO dovrebbe stare in un ContattoService...
		Optional<Contatto> c = contattoRepository.findById(id);
		if (!c.isPresent()) throw new IllegalArgumentException("id errato");
		
		Contatto contatto = c.get();		
		if (newValues.getName() != null) contatto.setName(newValues.getName());
		//...
		
		BeanUtils.copyProperties(newValues, contatto, "id");		
		
		contattoRepository.save(contatto);
		
		return contatto;
	}

	@DeleteMapping(value = "/contatto/{id}")
	public Boolean deleteContatto(@PathVariable(name = "id") Integer id) {
		System.out.println("DELETE /contatto/"+id);

//		Optional<Contatto> c = contattoRepository.findById(id);
//		if (!c.isPresent()) throw new IllegalArgumentException("id errato");

		contattoRepository.deleteById(id);
		
		return true;
	}
}
