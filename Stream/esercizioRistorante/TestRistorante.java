package esercizioRistorante;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import demo.Person;

public class TestRistorante {

	public static void main(String[] args) throws IOException{
		List<Ristorante> risto=Arrays.asList(new Ristorante("Zi Pietro",TipoRistorante.RISTO,45),
				new Ristorante("La pergola",TipoRistorante.RISTO,55),
				new Ristorante("Da Ivo",TipoRistorante.PIZZERIA,9),
				new Ristorante("Spazio Pizza",TipoRistorante.PIZZERIA,150),
				new Ristorante("Da Pietro",TipoRistorante.VEGETARIANO,25),
				new Ristorante("Da Francesco",TipoRistorante.BISTRO,80),
				new Ristorante("Giggetto",TipoRistorante.RISTO,40),
				new Ristorante("La terrazza",TipoRistorante.BISTRO,42));
		
		/**
		 * 1)Scrivere un metodo che stampi una riga per ogni ristorante con nome e numero coperti,
		 *   in ordine decrescente di numero di coperti.
		 **/
		
		System.out.println("**Esercizio 1**");
		risto.stream().sorted(Comparator.comparing(Ristorante::getCoperti).reversed()).forEach((rist) -> System.out.println("- " + rist.getNome() + " -> " + rist.getCoperti()));
		System.out.println("------------------------------------");
		
		/*
		 * 2)Data la lista di ristoranti fornita sopra,scrivere un metodo che restituisca l'insieme
		 *   dei ristoranti che hanno almeno 45 coperti.
		 **/
		
		System.out.println("**Esercizio 2**");
		System.out.println(risto.stream().filter((r) -> r.getCoperti()>45).collect(Collectors.toSet()));
		System.out.println("------------------------------------");
		
		/*
		 * 3)Data la lista dei ristoranti, scrivere un  metodo che restituisca una mappa tipo ristorante (chiave)
		 *   lista dei ristoranti di quel tipo(valore).
		 **/
		
		System.out.println("**Esercizio 3**");
		Map<TipoRistorante, List<Ristorante>> ristoMap = risto.stream().collect(Collectors.groupingBy(Ristorante::getTipo));
		System.out.println(ristoMap);
		System.out.println("------------------------------------");
		
		/*
		 * 4)Come nell'esercizio precedente, ma con ciascuna lista di ristoranti ordinata per nuemro di coperti.
		 **/
		
		System.out.println("**Esercizio 4**");
		Map<TipoRistorante, List<Ristorante>> sortedRistoMap = risto.stream().sorted(Comparator.comparing(Ristorante::getCoperti)).collect(Collectors.groupingBy(Ristorante::getTipo));
		System.out.println(sortedRistoMap);
		System.out.println("------------------------------------");
		
		/*
		 * 5)Data la lista dei ristoranti, scrivere un metodo che stampi i nomi dei ristoranti in ordine 
		 *   alfabetico separati da virgola.
		 **/
		
		System.out.println("**Esercizio 5**");
		System.out.println(risto.stream().map(Ristorante::getNome).sorted().collect(Collectors.joining(", ")));;
		System.out.println("------------------------------------");
		
		/*
		 * 6)Data la lista dei ristoranti,scrivere un metodo che restituisca la somma totale di tutti i coperti
		 *   dei ristorsnti della lista.
		 **/
		
		System.out.println("**Esercizio 6**");
		System.out.println("Totale coperti: "+ risto.stream().map(Ristorante::getCoperti).reduce(0, Integer::sum));
		System.out.println("------------------------------------");
		
		/*
		 * 7)Data la lista dei ristoranti,scrivere un metodo che restituisca il massimo, il minimo e la media 
		 *   dei coperti.
		 **/
		
		System.out.println("**Esercizio 7**");
		IntSummaryStatistics copertiStats = risto.stream().mapToInt(Ristorante::getCoperti).summaryStatistics();
		System.out.println("Max coperti: "+copertiStats.getMax());
		System.out.println("Min coperti: "+copertiStats.getMin());
		System.out.println("Avg coperti: "+copertiStats.getAverage());
		System.out.println("------------------------------------");
		
		/*
		 * 8)Data la lista dei ristoranti, stampare la lista dei ristoranti con nome che inizia con D e
		 *   lunghi almeno 7 lettere.
		 **/
		
		System.out.println("**Esercizio 8**");
		System.out.println(risto.stream().filter(r -> r.getNome().startsWith("D") && r.getNome().length()>6).collect(Collectors.toList()));
		System.out.println("------------------------------------");
		
		/*
		 * 9)Calcolare la somma del doppio dei valori pari dei coperti dei ristoranti della lista.
		 **/
		
		System.out.println("**Esercizio 9**");
		System.out.println(risto.stream().map(Ristorante::getCoperti).filter(c -> c%2==0).map(c -> c*2).reduce(0, Integer::sum));
		System.out.println("------------------------------------");
		
		/*
		 * 10)Il file Ristorante.csv indica il nome e il numero di coperti di alcuni ristoranti. Dato questo file
		 *    stampare per ciascuna riga "nome:numero_coperti".
		 *    Ad esempio, per la prima riga -> "Zi Pietro:45".
		 */
		
		System.out.println("**Esercizio 10**");
		Files.lines(Paths.get("esercizioRistorante/Ristorante.csv")).skip(1).forEach(line -> System.out.println(line.replace(",", ":")));
		System.out.println("------------------------------------");

	}
}
