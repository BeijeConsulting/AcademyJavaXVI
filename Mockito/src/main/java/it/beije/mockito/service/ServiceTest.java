package it.beije.mockito.service;

import org.springframework.stereotype.Service;

import it.beije.mockito.dto.ProvaDTO;

@Service
public class ServiceTest {
	
	public String dummyService(int num) {
		if (num == 1) return "One";
		else return "No one";
	}
	
	public ProvaDTO findUser(Integer id) {
		ProvaDTO u;
		if(id==1) {
			u = new ProvaDTO(id, "Pinco", "Pallino");
		} else {
			u = null;
		}
		return u;
	}

}
