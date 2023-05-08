package esercizioPizzeria;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import demo.Person;

public class TestRistorante {

	public static void main(String[] args) {
		List<Ristorante> risto=Arrays.asList(new Ristorante("La pergola",TipoRistorante.RISTO,55),
				new Ristorante("La pergola",TipoRistorante.RISTO,55),
				new Ristorante("Da Ivo",TipoRistorante.PIZZERIA,9),
				new Ristorante("Spazio Pizza",TipoRistorante.PIZZERIA,150),
				new Ristorante("Da Pietro",TipoRistorante.VEGETARIANO,25),
				new Ristorante("Da Francesco",TipoRistorante.BISTRO,80),
				new Ristorante("Giggetto",TipoRistorante.RISTO,40),
				new Ristorante("La terrazza",TipoRistorante.BISTRO,42));


//		1)Scrivere un metodo che stampi una riga per ogni ristorante con nome e numero coperti,
//		  in ordine decrescente di numero di coperti.
		System.out.println("1)------------");
		risto.stream().sorted(Comparator.comparing(Ristorante::getCoperti).reversed()).forEach(r -> System.out.println(r.getNome() + ": " + r.getCoperti()));
		
		
//		 2)Data la lista di ristoranti fornita sopra,scrivere un metodo che restituisca l'insieme
//		   dei ristoranti che hanno almeno 45 coperti.
		System.out.println("\n2)------------");
		List ristorantiFIltrati = risto.stream().filter(x -> x.getCoperti() > 45 ).collect(Collectors.toList());
		System.out.println(ristorantiFIltrati);
		
		//Map<String, Integer> map2 = persons.stream().collect(Collectors.toMap(Person::getName, Person::getAge));
//		  3)Data la lista dei ristoranti, scrivere un  metodo che restituisca una mappa tipo ristorante (chiave)
//		    lista dei ristoranti di quel tipo(valore).
		System.out.println("\n3)------------");
		Map<TipoRistorante, List<Ristorante>> mapRistoranti = risto.stream().collect(Collectors.groupingBy(Ristorante::getTipo));
		System.out.println(mapRistoranti);
		
		
//		 4)Come nell'esercizio precedente, ma con ciascuna lista di ristoranti ordinata per nuemro di coperti.
		System.out.println("\n4)------------");
		System.out.println(risto.stream()
        .sorted(Comparator.comparing(Ristorante::getCoperti))
        .collect(Collectors.groupingBy(Ristorante::getTipo)));
		
		
		
//		  5)Data la lista dei ristoranti, scrivere un metodo che stampi i nomi dei ristoranti in ordine 
//		    alfabetico separati da virgola.
		System.out.println("\n5)------------");
		System.out.println( risto.stream().map(Ristorante::getNome).sorted().collect(Collectors.joining(", ")) );
		
//		 6)Data la lista dei ristoranti,scrivere un metodo che restituisca la somma totale di tutti i coperti
//		  dei ristorsnti della lista.
		System.out.println("\n6)------------");
		System.out.println( risto.stream().map(Ristorante::getCoperti).reduce(0, (a,b) -> a+b) );
		
		
//		7)Data la lista dei ristoranti,scrivere un metodo che restituisca il massimo, il minimo e la media dei coperti
//		  dei ristorsnti della lista.
		System.out.println("\n7)------------");
		IntSummaryStatistics stats = risto.stream().mapToInt(x -> x.getCoperti()).summaryStatistics();
		System.out.println("Min " + stats.getMin());
		System.out.println("Max " +stats.getMax());
		System.out.println("Media " + stats.getAverage());
		
//    8)Calcolare la somma del doppio dei valori pari dei coperti
//		dei ristorsnti della lista.
		System.out.println("\n8)------------");
		System.out.println( risto.stream().map(Ristorante::getCoperti).filter(e->e%2 == 0).map(e -> e*2).reduce(0,Integer::sum)  );

//	 9)Data la lista dei ristoranti, stampare la lista dei ristoranti con nome che inizia con D e lunghi almeno 7 lettere
		System.out.println("\n9)------------");
		System.out.println( risto.stream().filter(s-> s.getNome().startsWith("D") && s.getNome().length()>=7 ).collect(Collectors.toList()) );
		


		
	}

}
