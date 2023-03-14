package it.beije.neumann.nidospring.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ContactDTO {

	@JsonProperty(value = "user_id")
	private Integer id;

	private String surname;

	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("{")
				.append(" id: ").append(id)
				.append(", name: ").append(name)
				.append(", surname: ").append(surname)
				.append("}");

		return builder.toString();
	}

}
