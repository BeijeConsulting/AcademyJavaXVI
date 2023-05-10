package esercizioRistorante;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


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

		//Stream1
		  risto.stream().sorted(Comparator.comparing(Ristorante::getCoperti).reversed()).forEach(r->System.out.println(r.getNome()+":"+r.getCoperti()));

		  //Stream2
		  System.out.println(risto.stream().filter(r->r.getCoperti()>=45).collect(Collectors.toList()));
		  
		  //Stream3
		  System.out.println(risto.stream().collect(Collectors.groupingBy(Ristorante::getTipo)));
		  System.out.println("****prova****");
		  System.out.println(risto.stream().collect(Collectors.partitioningBy(null, null) ));
		  
		  //Stream4
		  System.out.println(risto.stream().sorted(Comparator.comparing(Ristorante::getCoperti)).collect(Collectors
		    .groupingBy(Ristorante::getTipo)));
		  
		  //Stream5
		  System.out.println(risto.stream().map(r->r.getNome()).sorted().collect(Collectors.joining(",")));

		  //Stream6
		  System.out.println(risto.stream().map(r->r.getCoperti()).reduce(0, Integer::sum));
		  Integer pt=risto.stream().map(r->r.getCoperti()).reduce(0, Integer::sum);
		  
		  //Stream7
		  IntSummaryStatistics stats = risto.stream().mapToInt(x -> x.getCoperti()).summaryStatistics();
			System.out.println("Min " + stats.getMin());
			System.out.println("Max " +stats.getMax());
			System.out.println("Media " + stats.getAverage());
			
	     //Stream8
			System.out.println(risto.stream().filter(r->r.getNome().startsWith("D")&&r.getNome().length()>=7).collect(Collectors.toList()));
			
		//Stream10

			try{
			   Stream<String> lines = Files.lines(Paths.get("esercizioRistorante/Ristorante.csv"));   
			      List<String> people = lines
			              .skip(1)
			              .map(line -> {
			                  String[] fields = line.split(",");
			                  String name = fields[0];
			                  Integer coperti = Integer.valueOf( fields[1].trim() );
			                  Ristorante r=new Ristorante(name,(int)coperti);
			                  return r.getNome()+":"+r.getCoperti();
			              })
			              .collect(Collectors.toList());
			      people.forEach(System.out::println);
			      
			  } catch (IOException e) {
			      e.printStackTrace();
			  }
			
		}
	}

