package it.beije.neumann.mongiello.rubrica;

import java.io.IOException;

import java.util.List;
import java.util.Scanner;

public class Contatto {
	
	private int id;
	
	private String name;
	private String surname;
	private String telephone;
	private String email;
	private String note;

	
	public Contatto( int id, String name, String surname, String telephone, String email, String note ) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.telephone = telephone;
		this.email = email;
		this.note = note;
	
	}
	
	public Contatto(  String name, String surname, String telephone, String email, String note ) {
		this.name = name;
		this.surname = surname;
		this.telephone = telephone;
		this.email = email;
		this.note = note;
	
	}
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}

	public static  void stampaRubrica(List<Contatto> rubrica) {
		StringBuilder sb = new StringBuilder("");
		
		for( Contatto c: rubrica ) {

				sb.append(" name: ").append( c.getName() ).append("\n")
				.append(" surname: ").append(c.getSurname() ).append("\n")
				.append(" telephone: ").append( c.getTelephone() ).append("\n")
				.append(" email: ").append( c.getEmail() ).append("\n")
				.append(" note: ").append( c.getNote() ).append("\n\n");
		}
		
		System.out.println(sb);
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder("{")
				.append(" name: ").append(name)
				.append(", surname: ").append(surname)
				.append(", telephone: ").append(telephone)
				.append(", email: ").append(email)
				.append(", note: ").append(note)
				.append("}");
	
		
		return builder.toString();
	}
	
	public static List<Contatto> inputRubrica( List<Contatto> contatti ){	
		Scanner s = new Scanner(System.in);
		boolean isAlpha = true;
		String name = null;
		
		do {
			try {
				System.out.print("Nome: ");
				name = s.nextLine();
				isAlpha = Check.isAlpha( name );
		} catch (IOException e) {
			e.printStackTrace();
			isAlpha = false;
		}
			
		}while( !isAlpha );
		
		System.out.print("Cognome: ");
		String surname = s.nextLine();
		
		System.out.print("Telefono: ");
		String telephone = s.nextLine();
		
		System.out.println("Email: ");
		String email = s.nextLine();
		
		System.out.println("Note: ");
		String note = s.nextLine();
		
		contatti.add(new Contatto( name, surname, telephone, email, note ));
		return contatti;	
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
	
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
}
	
	
	
	

