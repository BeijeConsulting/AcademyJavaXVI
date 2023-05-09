package demo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class Demo1 {
	public static void main(String args[]) throws IOException {
		
		Stream<Integer> streamInt = Stream.of(1,2,3,6,4,5);
		Stream<String> streamBuilder = Stream.<String>builder().add("Lunedi").build();
		
		Integer[] array = new Integer[]{5,6,9,7,2};
		Stream<Integer> toStreamFromArray = Arrays.stream(array);
		
		List<Integer> listaNumerica = Arrays.asList(5,6,87,45,12,36,98,120,120);
		List<String> listaString = Arrays.asList("ciao", "benvenuto", "casa");
		
		//max di una lista
		System.out.println("Massimo " + listaNumerica.stream().max(Integer::compare).get());
	
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
		
		//Lista ordinata
		System.out.println("\nLista ordinata");
		listaString.stream().sorted().forEach( e -> System.out.print(e + " " ));
		
		//No ripetizioni
		System.out.println("\n\nSenza ripetizioni");
		List<Integer> listaNumerica2 = listaNumerica.stream().distinct().collect(Collectors.toCollection(ArrayList::new));
		System.out.println(listaNumerica2);
				
		Person p1 = new Person("Marco", 23);
		Person p2 = new Person("Sebastiano", 41);
		Person p3 = new Person("Roberto", 15);
		
		
		List<Person> persons = new ArrayList<>();
		persons.add(p1);
		persons.add(p2);
		persons.add(p3);
	
		//Da lista a mappa
		System.out.println("\n\nDa lista a mappa");
		Map<String, Integer> map = persons.stream().collect(Collectors.toMap(Person::getName, Person::getAge));
		System.out.println(map);
		Map<String, List<Person>> map2 = persons.stream().collect(Collectors.groupingBy(Person::getName));
		System.out.println(map2);
		
		
		//Somma di tutti gli elementi
		System.out.println("\nSomma di tutta la lista");
		System.out.println(listaNumerica.stream().reduce(0, (x,y)->x+y));
//FINO QUA		

		//Summary static
		System.out.println("\nSummary static");
		IntSummaryStatistics stats = listaNumerica.stream().mapToInt(x -> x).summaryStatistics();
		System.out.println("Min " + stats.getMin());
		System.out.println("Max " +stats.getMax());
		System.out.println("Media " + stats.getAverage());
		System.out.println("Count "+stats.getCount());
		
		//Iterate
		System.out.println("\nPrimi 10 numeri");
		Stream<Integer> numbers = Stream.iterate(0, n -> n+10);
		numbers.limit(6).skip(1).forEach(System.out::println);;
		
		//boolenai
		System.out.println("\nBoolean");
		boolean anyStartsWithA = listaString.stream().anyMatch(s -> s.startsWith("c"));
		System.out.println("Qualcosa inizia con 'c' ? " + anyStartsWithA); // true
		boolean allStartsWithA = listaString.stream().allMatch(s -> s.startsWith("c"));
		System.out.println("Tutti iniziano con 'c' ? " + allStartsWithA); // false
		boolean noneStartsWithZ = listaString.stream().noneMatch(s -> s.startsWith("f"));
		System.out.println("Nessunp inizia con 'f' ? " + noneStartsWithZ); // true
		
		//Filesdemo
//		File file = new File("demo/CiaoVonNeumann!.txt");
//		FileReader fileReader = new FileReader(file);
//		BufferedReader bufferedReader = new BufferedReader(fileReader);
//		String r = null;
//		while( bufferedReader.ready() ) {
//			r = bufferedReader.readLine();
//			System.out.println(r);
//		}	

		System.out.println("\nFILE");
		try{
			Stream<String> strList = Files.lines(Paths.get("demo/CiaoVonNeumann!.csv"));
			strList.skip(1).forEach(System.out::println);
		} catch (IOException e) {
		    e.printStackTrace();
		}    
		
//		System.out.println("\nDa File a lista");
//		try{
//			Stream<String> lines = Files.lines(Paths.get("demo/CiaoVonNeumann!.csv"));			
//		    List<Person> people = lines
//		            .skip(1)
//		            .map(line -> {
//		                String[] fields = line.split(",");
//		                String name = fields[0];
//		                Integer age = Integer.valueOf( fields[1].trim() );   
//		                return new Person(name, age);
//		            })
//		            .collect(Collectors.toList());
//		    people.forEach(System.out::println);
//		} catch (IOException e) {
//		    e.printStackTrace();
//		}    
		
		//FlatMap
		System.out.println("\nFlat map");
		Stream<String> lines = Files.lines(Paths.get("demo/CiaoVonNeumann!.csv"));
		lines
		.skip(1)
		.map(line -> line.split(",")) // Stream<String[]>
		    .flatMap(Arrays::stream) // Stream<String>
		    .forEach(System.out::println);
		

		
	}	
}