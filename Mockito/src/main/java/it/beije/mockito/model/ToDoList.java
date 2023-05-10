package it.beije.mockito.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "todo")
public class ToDoList {
	
	@Id
	@Column(name = "id", nullable = false)
	private Integer id;
	
	@Column(name = "username", nullable = false)
	private String username;
	
	@Column(name = "note")
	private String note;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "ToDoList [id=" + id + ", username=" + username + ", note=" + note + "]";
	}

}
