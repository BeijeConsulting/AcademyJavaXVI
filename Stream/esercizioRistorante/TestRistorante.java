package esercizioRistorante;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import demo.Person;

public class TestRistorante {

	public static void main(String[] args) {
		List<Ristorante> risto=Arrays.asList(new Ristorante("Zi Pietro",TipoRistorante.RISTO,45),
				new Ristorante("La pergola",TipoRistorante.RISTO,55),
				new Ristorante("Da Ivo",TipoRistorante.PIZZERIA,9),
				new Ristorante("Spazio Pizza",TipoRistorante.PIZZERIA,150),
				new Ristorante("Da Pietro",TipoRistorante.VEGETARIANO,25),
				new Ristorante("Da Francesco",TipoRistorante.BISTRO,80),
				new Ristorante("Giggetto",TipoRistorante.RISTO,40),
				new Ristorante("La terrazza",TipoRistorante.BISTRO,42));
		
		//ESERCIZIO 1
		System.out.println("\nRistoranti in ordini decrescente: ");
		risto.stream().skip(0).sorted(Comparator.comparingInt(Ristorante::getCoperti).reversed()).forEach(r -> System.out.println(r.getNome() + " " + r.getCoperti()));
		
		//ESERCIZIO 2
		System.out.println("\nRistoranti con almeno 45 coperti: ");
		risto.stream().skip(0).filter( r -> r.getCoperti() > 45 ).forEach(r -> System.out.println(r.getNome() + " " + r.getCoperti()));
		
		//ESERCIZIO 3
		System.out.println("\nMappa ristoranti chiave-valore: ");
		System.out.println(risto.stream().collect(Collectors.groupingBy(Ristorante::getTipo)));
		
		//ESERCIZIO 4
		System.out.println("\nMappa ristoranti chiave-valore con coperti: ");
		System.out.println(risto.stream().sorted(Comparator.comparing(Ristorante::getCoperti)).collect(Collectors.groupingBy(Ristorante::getTipo)));
		
		//ESERCIZIO 5
		System.out.println("\nRistoranti in ordini alfabetico: ");
		risto.stream().skip(0).sorted(Comparator.comparing(Ristorante::getNome)).forEach(r -> System.out.println(r.getNome() + " " + r.getCoperti()));
		
		//ESERCIZIO 6
		System.out.println("\nSomma coperti ristoranti: ");
		int somma = risto.stream().mapToInt(Ristorante::getCoperti).sum();
		System.out.println("La somma dei coperti di tutti i ristoranti è: " + somma);
		
		//ESERCIZIO 7
		IntSummaryStatistics stats = risto.stream().mapToInt(r -> r.getCoperti()).summaryStatistics();
		System.out.println("Min " + stats.getMin());
		System.out.println("Max " +stats.getMax());
		System.out.println("Media " + stats.getAverage());
		
		//ESERCIZIO 8
		System.out.println("\nLista ristoranti D");
		System.out.println(risto.stream().filter(r-> r.getNome().startsWith("D") && r.getNome().length()>=7 ).collect(Collectors.toList()) );
		
		//ESERCIZIO 9
		System.out.println("\nSomma doppio del valore");
		System.out.println(risto.stream().map(Ristorante::getCoperti).filter(r->r%2 == 0).map(r -> r*2).reduce(0,Integer::sum)  );

		//ESERCIZIO 10
		
		
		/**
		 * 1)Scrivere un metodo che stampi una riga per ogni ristorante con nome e numero coperti,
		 *   in ordine decrescente di numero di coperti.
		 *   
		 * 2)Data la lista di ristoranti fornita sopra,scrivere un metodo che restituisca l'insieme
		 *   dei ristoranti che hanno almeno 45 coperti.
		 * 
		 * 3)Data la lista dei ristoranti, scrivere un  metodo che restituisca una mappa tipo ristorante (chiave)
		 *   lista dei ristoranti di quel tipo(valore).
		 *   
		 * 4)Come nell'esercizio precedente, ma con ciascuna lista di ristoranti ordinata per nuemro di coperti.
		 *
		 * 5)Data la lista dei ristoranti, scrivere un metodo che stampi i nomi dei ristoranti in ordine 
		 *   alfabetico separati da virgola.
		 *   
		 * 6)Data la lista dei ristoranti,scrivere un metodo che restituisca la somma totale di tutti i coperti
		 *   dei ristorsnti della lista.
		 *   
		 * 7)Data la lista dei ristoranti,scrivere un metodo che restituisca il massimo, il minimo e la media 
		 *   dei coperti.
		 * 
		 * 8)Data la lista dei ristoranti, stampare la lista dei ristoranti con nome che inizia con D e
		 *   lunghi almeno 7 lettere.
		 *   
		 * 9)Calcolare la somma del doppio dei valori pari dei coperti dei ristorsnti della lista.
		 * 
		 * 10)Il file Ristorante.csv indica il nome e il numero di coperti di alcuni ristoranti. Dato questo file
		 *    stampare per ciascuna riga "nome:numero_coperti".
		 *    Ad esempio, per la prima riga -> "Zi Pietro:45".
		 */

	}
}
