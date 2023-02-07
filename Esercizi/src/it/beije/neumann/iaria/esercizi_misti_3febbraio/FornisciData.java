package it.beije.neumann.iaria.esercizi_misti_3febbraio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FornisciData {
	
	public static void FormattaData(DateTimeFormatter f, String data)
	{
		LocalDate t = LocalDate.parse(data,f);
		System.out.println(t.getDayOfWeek() + " " + t.getDayOfMonth() + " " + t.getMonth() + ", DAY " + t.getDayOfYear() + " OF YEAR " + t.getYear());
	}

	public static void main(String[] args) {
		FornisciData forDate = new FornisciData();
		DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		forDate.FormattaData(f, "13/09/2021");
	}

}