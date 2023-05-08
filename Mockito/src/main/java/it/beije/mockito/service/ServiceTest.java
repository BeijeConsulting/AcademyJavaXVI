package it.beije.mockito.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.beije.mockito.dto.ProvaDTO;
import it.beije.mockito.dto.TodoListDTO;
import it.beije.mockito.model.ToDoList;
import it.beije.mockito.repository.ToDoListRepository;

@Service
public class ServiceTest {
	
	@Autowired
	private ToDoListRepository todoRepo;
	
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
	
	public List<ToDoList> findAll() {
		return todoRepo.findAll();
	}
	
	public TodoListDTO findNotesByUsername(String username){
		TodoListDTO dto = new TodoListDTO();
		List<ToDoList> todo = todoRepo.findByUsername(username);
		List<String> notes = new ArrayList<>();
		
		for(ToDoList td : todo) {
			notes.add(td.getNote());
		}
		
		dto.setUsername(username);
		dto.setNotes(notes);
		
		return dto;
	}
	
	public TodoListDTO addNote(ToDoList todo) {
		TodoListDTO dto = new TodoListDTO();
		todo = saveNew(todo);
		dto.setUsername(todo.getUsername());
		dto.setNotes(new ArrayList<>());
		dto.getNotes().add(todo.getNote());
		return dto;
	}
	
	public ToDoList saveNew(ToDoList todoRow) {
		return todoRepo.save(todoRow);
	}

}
