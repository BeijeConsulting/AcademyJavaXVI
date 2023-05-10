package it.beije.mockito.dto;

import java.util.ArrayList;
import java.util.List;

public class TodoListDTO {
	
	private String username;

	private List<String> notes;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public TodoListDTO() {
		this(new ArrayList<>());
	}
	
	public TodoListDTO(List<String> notes) {
		this.notes = notes;
	}

	public List<String> getNotes() {
		return notes;
	}

	public void setNotes(List<String> notes) {
		this.notes = notes;
	}

	@Override
	public String toString() {
		return "TodoListDTO [username=" + username + ", notes=" + notes + "]";
	}
	
}
