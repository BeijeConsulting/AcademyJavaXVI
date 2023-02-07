package it.beije.neumann.mercuri.esercizi0302;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EspandiData {

	public static void main(String[] args) {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter month = DateTimeFormatter.ofPattern("MMMM");
	
		LocalDate date = LocalDate.parse(args[0], formatter);
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(date.getDayOfWeek()).append(" ").append(date.getDayOfMonth()).append(" ").append(date.format(month)).append(", giorno ");
		sb.append(date.getDayOfYear()).append(" dell'anno ").append(date.getYear()).append(", settimana numero ").append(date.getDayOfYear()/7 + 1);
		
		//System.out.println(date.getDayOfWeek()); // MONDAY

		System.out.println(sb.toString());
		//Lunedì 13 Settembre, giorno 256 dell'anno 2021, settimana numero 37
	}

}
