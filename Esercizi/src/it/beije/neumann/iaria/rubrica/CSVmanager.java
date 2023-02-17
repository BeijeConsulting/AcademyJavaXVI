package it.beije.neumann.iaria.rubrica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CSVmanager {
	
	//Contatti ivo
	public static List<Contatto> readRubrica(String pathfile) throws FileNotFoundException, IOException {
		FileReader fileReader = new FileReader(pathfile);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		List<Contatto> contatti = new ArrayList<Contatto>();
		
		try {
			String r = null;
			String[] fields = null;
			Contatto contatto = null;
			while (bufferedReader.ready()) {
				r = bufferedReader.readLine();
				fields = r.split(";");
				
				contatto = new Contatto();
				contatto.setSurname(fields[0]);
				contatto.setName(fields[1]);
				contatto.setTelephone(fields[2]);
				contatto.setEmail(fields[3]);
				contatto.setNote(fields[4]);
				
				contatti.add(contatto);
				
			}
		} catch (IOException ioEx) {
			ioEx.printStackTrace();
			throw ioEx;
		} finally {
			bufferedReader.close();
		}
		
		return contatti;
	}

	//Metodo che chiede all'utente di inserire 3 contatti e li inserisce nella List<Contatto>
	public static List<Contatto> userContacts() {
		System.out.println("Inserisci 3 contatti:");
		Scanner s = new Scanner(System.in);		
		List<Contatto> contattiDaScanner = new ArrayList<Contatto>();
		
		for(int i=1; i<=3; i++) {
			Contatto contattoInput = new Contatto();
			System.out.print("Nome: ");
			contattoInput.setName(s.nextLine());
		
			System.out.print("Cognome: ");
			contattoInput.setSurname(s.nextLine());
		
			System.out.print("Numero di telefono: ");
			contattoInput.setTelephone(s.nextLine());
				
			System.out.print("Email: ");
			contattoInput.setEmail(s.nextLine());
		
			System.out.print("Note: ");
			contattoInput.setNote(s.nextLine());

			int mancanti = 3-i;
			
			if(mancanti==0) {
				System.out.println("Contatti salvati con successo!");
				contattiDaScanner.add(contattoInput); //Inserisco valori nella lista contatti
				break;
			}
			System.out.println("Salvato il "+i+"° contatto, ne mancano ancora "+mancanti);
			
			contattiDaScanner.add(contattoInput); //Inserisco valori nella lista contatti

		}
		
		return contattiDaScanner;		
	}
	
	//Metodo per creare un nuovo csv con dati inseriti dall'utente (userContacts())
	public static void writeNewRubrica(String pathfile, List<Contatto> contacts) throws FileNotFoundException, IOException{
		File newRubrica = new File("/Users/gianf/Desktop/newrubrica.csv");
		FileWriter fileWriter = new FileWriter(newRubrica);
		
		try {
			File oldRubrica = new File("/Users/gianf/Desktop/rubrica.csv");
			FileReader fileReaderOldRubrica = new FileReader(oldRubrica);
			BufferedReader bufferedreader = new BufferedReader(fileReaderOldRubrica); //Per leggere file
			
			String firstLine = bufferedreader.readLine(); //Considero la prima riga
			firstLine = firstLine.replace(';', '/');  //Cambio split come richiesto
			fileWriter.write(firstLine); //Inserisco la prima riga con split diversi
			fileWriter.write("\n"); //A capo
			
			for (Contatto persona : contacts) {
				fileWriter.write(persona.getName() + "/");
				fileWriter.write(persona.getSurname() + "/");
				fileWriter.write(persona.getTelephone() + "/");
				fileWriter.write(persona.getEmail() + "/");
				fileWriter.write(persona.getNote() + "\n");
			}

		}catch(FileNotFoundException fnfEx) {
			fnfEx.printStackTrace();
		}catch (IOException ioEx) {
			ioEx.printStackTrace();
			throw ioEx;
		} finally {
			fileWriter.close(); //Chiudo il file per salvare modifiche
		}
	}
	
	//Metodo per sovrascrivere il csv esistente "newrubrica" con dati inseriti dall'utente (userContacts())
	public static void overloadNewRubrica(String pathfile, List<Contatto> contacts) throws FileNotFoundException, IOException{
		File newRubrica = new File("/Users/gianf/Desktop/newrubrica.csv");
		FileWriter fileOverload = new FileWriter("/Users/gianf/Desktop/newrubrica.csv", true);
		
		try {
			
			for (Contatto persona : contacts) {  //Per ogni contatto inserisci...
				fileOverload.write(persona.getName() + "/");
				fileOverload.write(persona.getSurname() + "/");
				fileOverload.write(persona.getTelephone() + "/");
				fileOverload.write(persona.getEmail() + "/");
				fileOverload.write(persona.getNote() + "\n");
			}

		}catch(FileNotFoundException fnfEx) {
			fnfEx.printStackTrace();
		}catch (IOException ioEx) {
			ioEx.printStackTrace();
			throw ioEx;
		} finally {
			fileOverload.close(); //Chiudo il file per salvare modifiche
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		//List<Contatto> contattiIvo = readRubrica("/Users/gianf/Desktop/rubrica.csv");
		//System.out.println(contattiIvo);
		
		List<Contatto> newContattiGian = userContacts(); //Prima lista
		writeNewRubrica("/Users/gianf/Desktop/newrubrica.csv", newContattiGian); //Creazione newRubrica
		List<Contatto> overloadContattiGian = userContacts(); //Nuova lista
		overloadNewRubrica("/Users/gianf/Desktop/newrubrica.csv", overloadContattiGian); //Overload newRubrica
		//System.out.println(contattiGian);
	}
	
}