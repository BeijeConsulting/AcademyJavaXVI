package it.beije.neumann.iaria.esercizi_misti_8febbraio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Imbottigliamento {
	
	public static void CalcolaSgasata(int content, int evapPerDay, int threshold, LocalDate data) {
		int risultato = 0;
		LocalDate scadenza;
		
		//Finchè risultato (che sarebbe evapPerDay+evapPerDay+evapPerDay..) < limite massimo gas evaporato
		while(risultato < threshold) {
			data = data.plusDays(1);
			risultato+=evapPerDay;
		} //Aumenta di un giorno, altrimenti si ferma e ci da il giorno di scadenza
		
		scadenza = data;
		System.out.println(scadenza);
	}

	public static void main(String[] args) {
		int content = 1000; //Contenitore
		int evapPerDay = 8; //Percentuale di gas che evapora giornalmente in percentuale
		int threshold = 50; //Limite massimo gas evaporato in percentuale
		
		//Passo il giorno in cui è stata prodotta
		DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate DataProduzione = LocalDate.parse("12/02/2023",f);
		
		CalcolaSgasata(content,evapPerDay,threshold,DataProduzione);
	}

}
