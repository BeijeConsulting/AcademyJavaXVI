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
	
	public static void main(String[] args) throws IOException {
		
		Scanner s = new Scanner(System.in);
		try{
			File file = new File("C:\\Users\\pietr\\git\\AcademyJavaXVI\\Esercizi\\src\\it\\beije\\neumann\\mongiello\\rubrica .csv");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			FileWriter fileWriter = new FileWriter( file, true );

			//Lettura da file e memorizzazione oggetto
			List<Contatto> contatti = new ArrayList<>();
			Contatto contatto = null;
			
				String r = null;
				String[] fields = null;
				
				while( bufferedReader.ready() ) {
					r = bufferedReader.readLine();
					fields = r.split(";");
					contatto = new Contatto( fields[0], fields[1], fields[2], fields[3], fields[4] );
					contatti.add(contatto);
				}		

				System.out.println("Aggiungi contatti");
				
				System.out.print("Nome: ");
				String name = s.nextLine();
			
				System.out.print("Cognome: ");
				String surname = s.nextLine();
				
				System.out.print("Telefono: ");
				String telephone = s.nextLine();
				
				System.out.println("Email: ");
				String email = s.nextLine();
				
				System.out.println("Note: ");
				String note = s.nextLine();
				
				contatti.add(new Contatto( name, surname, telephone, email, note ));
				
				fileWriter.write( contatti.get( contatti.size() -1 ).getName() );
				fileWriter.write(";");
				
				fileWriter.write( contatti.get( contatti.size() -1 ).getSurname() );
				fileWriter.write(";");
				
				fileWriter.write( contatti.get( contatti.size() -1 ).getTelephone() );
				fileWriter.write(";");
				
				fileWriter.write( contatti.get( contatti.size() -1 ).getEmail() );
				fileWriter.write(";");
				
				fileWriter.write( contatti.get( contatti.size() -1 ).getNote() );
				fileWriter.write(";");
								
				fileWriter.flush();
			
		}catch( IOException ioEx ) {
			ioEx.printStackTrace();
			throw ioEx;
		}
	}
}
