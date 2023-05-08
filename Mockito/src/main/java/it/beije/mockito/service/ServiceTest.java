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
	    ProvaDTO u = null;
	    switch (id) {
	        case 1:
	            u = new ProvaDTO(id, "Pinco", "Pallino");
	            break;
	        case 2:
	            u = new ProvaDTO(id, "Mario", "Rossi");
	            break;
	        case 3:
	            u = new ProvaDTO(id, "Giovanni", "Verdi");
	            break;
	        case 4:
	            u = new ProvaDTO(id, "Luigi", "Bianchi");
	            break;
	        case 5:
	            u = new ProvaDTO(id, "Franco", "Neri");
	            break;
	        case 6:
	            u = new ProvaDTO(id, "Antonio", "Gialli");
	            break;
	        case 7:
	            u = new ProvaDTO(id, "Carlo", "Marrone");
	            break;
	        case 8:
	            u = new ProvaDTO(id, "Giuseppe", "Celeste");
	            break;
	        case 9:
	            u = new ProvaDTO(id, "Roberto", "Blu");
	            break;
	        case 10:
	            u = new ProvaDTO(id, "Stefano", "Viola");
	            break;
	    }
	    return u;
	}

}
