package it.beije.neumann.nicole;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Realizzare un programma che, ricevuta in input una data in formato 13/09/2021 stampi le seguenti informazioni:

Lunedì 13 Settembre, giorno 256 dell'anno 2021, settimana numero 37
in italiano od inglese, va bene comunque
 * @author nverz
 *
 */
public class Date 
{
	public static void getData(DateTimeFormatter f, String stringa)
	{
		LocalDate t= LocalDate.parse(stringa,f);
		int numeroSettimana= (t.getDayOfYear()/7)+1;
		
		System.out.print(t.getDayOfWeek()+" "+t.getDayOfMonth()+" "+t.getMonth()+ ", giorno "+t.getDayOfYear()+" dell'anno "+t.getYear()+", settimana numero "+numeroSettimana);
		
		
	}
	
	
	public static void main(String [] args)
	{
		DateTimeFormatter f= DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String stringa="13/09/2021";
		getData(f,stringa);
	}

}
