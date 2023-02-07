package it.beije.neumann.elassl.feb3;

import java.time.*;
/*
Realizzare un programma che, ricevuta in input una data in formato 13/09/2021 stampi le seguenti informazioni:
Lunedì 13 Settembre, giorno 256 dell'anno 2021, settimana numero 37
in italiano od inglese, va bene comunque
*/
public class Data {
	public void stampa(String data) {
		String day = data.substring(0,2);
		String month = data.substring(3,5);
		String year = data.substring(6,10);
		System.out.println(day+month+year);
		LocalDate giorno = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		StringBuilder s= new StringBuilder("");
		s.append(giorno.getDayOfWeek());
		s.append(" "+day);
		s.append(" "+giorno.getMonth());
		s.append(", day "+giorno.getDayOfYear()+" of the year "+year+" week number "+Math.ceil(giorno.getDayOfYear()/7));
		System.out.println(s);
		
	}
	public static void main(String[] args) {
		Data d = new Data();
		d.stampa("13/09/2021");
		//LocalDate.of(2015, Month.JANUARY, 20);
	}
	
}

