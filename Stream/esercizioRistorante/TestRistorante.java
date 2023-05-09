package esercizioRistorante;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
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
		List<Ristorante> risto = Arrays.asList(new Ristorante("Zi Pietro", TipoRistorante.RISTO, 45),
				new Ristorante("La pergola", TipoRistorante.RISTO, 55),
				new Ristorante("Da Ivo", TipoRistorante.PIZZERIA, 9),
				new Ristorante("Spazio Pizza", TipoRistorante.PIZZERIA, 150),
				new Ristorante("Da Pietro", TipoRistorante.VEGETARIANO, 25),
				new Ristorante("Da Francesco", TipoRistorante.BISTRO, 80),
				new Ristorante("Giggetto", TipoRistorante.RISTO, 40),
				new Ristorante("La terrazza", TipoRistorante.BISTRO, 42));
		// 1
		risto.stream().forEach(x -> System.out.println(x.getNome() + " " + x.getCoperti()));
		// 2
		List<Ristorante> risto45 = risto.stream().filter(x -> x.getCoperti() >= 45)
				.collect(Collectors.toCollection(ArrayList::new));
		// 3
		Map<TipoRistorante, List<Ristorante>> ristorantiPerTipo = risto.stream()
				.collect(Collectors.groupingBy(Ristorante::getTipo));
		// 4
		risto.stream().sorted(Comparator.comparing(Ristorante::getCoperti))
				.collect(Collectors.groupingBy(Ristorante::getTipo));
		// 5
		risto.stream().map(Ristorante::getNome).sorted().collect(Collectors.joining(", "));
		// 6
		int totaleCoperti = risto.stream().mapToInt(Ristorante::getCoperti).sum();
		// 7
		IntSummaryStatistics copertiStats = risto.stream().mapToInt(Ristorante::getCoperti).summaryStatistics();
		int minCoperti = copertiStats.getMin();
		int maxCoperti = copertiStats.getMax();
		double mediaCoperti = copertiStats.getAverage();
		// 8
		risto.stream().filter(r -> r.getNome().startsWith("D") && r.getNome().length() >= 7)
				.forEach(r -> System.out.println(r.getNome()));

		// 9
		int sommaDoppiCopertiPari = risto.stream().mapToInt(Ristorante::getCoperti).filter(c -> c % 2 == 0)
				.map(c -> c * 2).sum();
		// 10
		try {
			Files.lines(Paths.get("Ristorante.csv")).map(line -> {
				String[] parts = line.split(",");
				return parts[0] + ":" + parts[1];
			}).forEach(System.out::println);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/**
		 * 1)Scrivere un metodo che stampi una riga per ogni ristorante con nome e
		 * numero coperti, in ordine decrescente di numero di coperti.
		 * 
		 * 2)Data la lista di ristoranti fornita sopra,scrivere un metodo che
		 * restituisca l'insieme dei ristoranti che hanno almeno 45 coperti.
		 * 
		 * 3)Data la lista dei ristoranti, scrivere un metodo che restituisca una mappa
		 * tipo ristorante (chiave) lista dei ristoranti di quel tipo(valore).
		 * 
		 * 4)Come nell'esercizio precedente, ma con ciascuna lista di ristoranti
		 * ordinata per nuemro di coperti.
		 *
		 * 5)Data la lista dei ristoranti, scrivere un metodo che stampi i nomi dei
		 * ristoranti in ordine alfabetico separati da virgola.
		 * 
		 * 6)Data la lista dei ristoranti,scrivere un metodo che restituisca la somma
		 * totale di tutti i coperti dei ristorsnti della lista.
		 * 
		 * 7)Data la lista dei ristoranti,scrivere un metodo che restituisca il massimo,
		 * il minimo e la media dei coperti.
		 * 
		 * 8)Data la lista dei ristoranti, stampare la lista dei ristoranti con nome che
		 * inizia con D e lunghi almeno 7 lettere.
		 * 
		 * 9)Calcolare la somma del doppio dei valori pari dei coperti dei ristorsnti
		 * della lista.
		 * 
		 * 10)Il file Ristorante.csv indica il nome e il numero di coperti di alcuni
		 * ristoranti. Dato questo file stampare per ciascuna riga
		 * "nome:numero_coperti". Ad esempio, per la prima riga -> "Zi Pietro:45".
		 */

	}
}
