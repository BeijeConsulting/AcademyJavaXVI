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
	public static void newFile( String path ) {
		
		File file = new File("rubrica.csv");
		if( file.exists()) {
			System.out.println("File esistente");
		}else{
			System.out.println("File creato con successo");
		}
	}
	

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		try{
			File file = new File("rubicaA.csv");
			FileWriter fileWriter = new FileWriter(file, true);
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			if( file.createNewFile() ) {
				System.out.println("File creato");
			}else {
				 System.out.println("Il file esiste gia");
			}
			
			//Contatto contatto = null;
			
			System.out.print("Nome: ");
			String nome = s.nextLine();
		//	contatto.setNome(nome);
			fileWriter.write(nome);
			fileWriter.write(";");
			System.out.println();
			
			
			System.out.print("Cognome: ");
			String cognome = s.nextLine();
		//	contatto.setCognome(cognome);
			fileWriter.write(cognome);
			fileWriter.write(";");
			System.out.println();
			
			System.out.print("Numero: ");
			String numero = s.nextLine();
		//	contatto.setCognome(cognome);
			fileWriter.write(numero);
			fileWriter.write(";");
			System.out.println();
			
			

			
			fileWriter.flush();

			String r = null;
			
			while (bufferedReader.ready()) {
				r = bufferedReader.readLine();
				System.out.println("### " + r);
			}
		
			
			
			
			
		} catch (IOException ioEx) {		
			ioEx.printStackTrace();	
		}
		
		


	}
}
