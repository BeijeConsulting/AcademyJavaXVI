package it.beije.neumann.mongiello.rubrica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Rubrica {

	public static void main( String[] args ) throws FileNotFoundException, IOException {

		File file = new File("/temp/rubricaCsv.csv");
		if(!file.exists()) System.out.println("Non esiste");
		
		List<Contatto> contatti = RubricaCsv.readRubrica("/temp/rubricaCsv.csv");
			
		System.out.println("Aggiungi contatti");
		Contatto.inputRubrica( contatti );
		
		RubricaCsv.writeRubrica(contatti, file);
		
		
	}
	

}
