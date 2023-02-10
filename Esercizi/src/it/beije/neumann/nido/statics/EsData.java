/*
 * Realizzare un programma che, ricevuta in input una data
 * in formato 13/09/2021 stampi le seguenti informazioni:
 * 	Lunedì 13 Settembre, giorno 256 dell'anno 2021, settimana numero 37
 * (in italiano od inglese, va bene comunque)
 */
package it.beije.neumann.nido.statics;

import java.time.LocalDate;
//import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
//import java.util.Locale;

public class EsData {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Inserire la data -> ");
		String inputDate = in.nextLine().trim();
		System.out.println();
		
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date = LocalDate.parse(inputDate, df);
		//LocalDate end = LocalDate.parse("31/12/2021",df);
		
		StringBuilder output = new StringBuilder();
		
		output.append(date.getDayOfWeek().toString().toLowerCase()+" ");
		output.append(date.getDayOfMonth()+" ");
		output.append(date.getMonth().toString().toLowerCase()+", day ");
		output.append(date.getDayOfYear()+" ");
		output.append("of year "+date.getYear()+", ");
		output.append("week number "+ Math.round((float)date.getDayOfYear()/7));

		System.out.println(output.toString());
		
		in.close();

	}

}
