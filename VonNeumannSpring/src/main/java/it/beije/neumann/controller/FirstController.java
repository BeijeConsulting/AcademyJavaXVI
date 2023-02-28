package main.java.it.beije.neumann.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import main.java.it.beije.neumann.model.Contatto;


@Controller
public class FirstController {

	@RequestMapping(value = "/lista_contatti", method = RequestMethod.GET)
	public String prova(Model model) {
		System.out.println("GET /lista_contatti");
		
		Contatto contatto = new Contatto();
		contatto.setName("Paolino");
		contatto.setSurname("Paperino");
		contatto.setTelephone("3334445556");
		List<Contatto> contatti = new ArrayList<Contatto>();
		contatti.add(contatto);
						
		model.addAttribute("lista", contatti);
		
		return "lista_contatti";
	}	

}
