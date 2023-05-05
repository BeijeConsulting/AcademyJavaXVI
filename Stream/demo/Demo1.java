package demo;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo1 {
	public static void main(String args[]) throws IOException {
		
		List<Integer> listaNumerica = Arrays.asList(5,6,87,45,12,36,98,120,120);
		List<String> listaString = Arrays.asList("ciao", "benvenuto", "casa");
		
		//max di una lista
		System.out.println("Massimo " + listaNumerica.stream().max(Integer::compare));
	
		//minimo
		Optional<Integer> min = listaNumerica.stream().min(Integer::compare);
		System.out.println("Minimo " + min.get());
		
		//Dispari
		System.out.println("\nDispari");
		listaNumerica.stream().filter( f -> f % 2 == 1 ).forEach( e -> System.out.print(e + " " ));
		
		//Incremento la lista di uno
		System.out.println("\n\n Lista + 1");
		listaNumerica.stream().map(p -> p+1).forEach(e -> System.out.print(e + " " ));
		
		//Maiuscolo
		System.out.println("\n\nMaiuscolo");
		//listaString.stream().map(String::toUpperCase).forEach(System.out::println);
		List<String> lista2 = listaString.stream().map(String::toUpperCase).collect(Collectors.toList());
		System.out.println(lista2);
		
		System.out.println("\nLista con virgola");
		System.out.println(listaString.stream().map(e -> e.toUpperCase()).collect(Collectors.joining(", ")));
		
		Person p1 = new Person("Marco", 23);
		Person p2 = new Person("Sebastiano", 41);
		Person p3 = new Person("Roberto", 15);
		
		List<Person> persons = new ArrayList<>();
		persons.add(p1);
		persons.add(p2);
		persons.add(p3);
		
		//Da lista a mappa
		System.out.println("\nDa lista a mappa");
		//Map<Integer, String> map = persons.stream().collect(Collectors.toMap(Person::getAge, Person::getName,(name1, name2) -> name1 + ";" + name2));
		Map<String, Integer> map2 = persons.stream().collect(Collectors.toMap(Person::getName, Person::getAge));
		//System.out.println(map);
		System.out.println(map2);
		
		//No ripetizioni
		System.out.println("\nSenza ripetizioni");
		List<Integer> listaNumerica2 = listaNumerica.stream().collect(Collectors.toCollection(ArrayList::new));
		System.out.println(listaNumerica2);
		
		//Somma di tutti gli elementi
		System.out.println("\nSomma di tutta la lista");
		System.out.println(listaNumerica.stream().reduce(0, (x,y)->x+y));
		
		//Stampa gli elementi di una lista toUpperCase e li ordina
		
		List<String> l=Arrays.asList("da","ab","ac","bb");
		l.stream().map(String::toUpperCase).sorted(Comparator.<String>naturalOrder().reversed()).forEach(System.out::println);
		
		//Files
//		long numberOfLines=Files.lines(Paths.get("CiaoVonNeumann!.txt")).count();
//		System.out.println(numberOfLines);
	}
}
