package it.beije.neumann.nido.rubricaex;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVManager {

	public static final String PATH_READ = "./src/it/beije/neumann/nido/rubricaex/rubrica.csv";
	public static final String PATH_WRITE = "./src/it/beije/neumann/nido/rubricaex/rubricaRewrited.csv";

	public static List<Contatto> readRubrica(String pathfile, String splitter, boolean newRub) throws FileNotFoundException, IOException {
		FileReader fileReader = new FileReader(pathfile);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		List<Contatto> contatti = new ArrayList<Contatto>();

		try {
			String r = null;
			String[] fields = null;
			Contatto contatto = null;
			while (bufferedReader.ready()) {
				r = bufferedReader.readLine();
				fields = r.split(splitter);

				contatto = new Contatto();
				if(newRub) {
					contatto.setName(fields[0]);
					contatto.setSurname(fields[1]);
				}else {
					contatto.setSurname(fields[0]);
					contatto.setName(fields[1]);
				}
				
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

	// Caso in cui il file viene sovrascritto ogni volta
	public static boolean writeRubrica(String pathfile, List<Contatto> contacts) throws FileNotFoundException, IOException {
		boolean status = true;
		
		FileWriter fW = new FileWriter(pathfile);

		try {
			for (Contatto contact : contacts) {
				fW.write(contact.getName() + "#");
				fW.write(contact.getSurname() + "#");
				fW.write(contact.getTelephone() + "#");
				fW.write(contact.getEmail() + "#");
				fW.write(contact.getNote() + "\n");
			}
		} catch (IOException ioEx) {
			status = false;
			ioEx.printStackTrace();
			throw ioEx;
		} finally {
			fW.flush();
			fW.close();
		}

		return status;

	}

	// Caso in cui i contatti vengono messi in coda al file
	public static boolean writeRubricaAppend(String pathfile, Contatto contact) throws FileNotFoundException, IOException {
		boolean status = true;

		FileWriter fW = new FileWriter(pathfile, true);

		try {

			fW.write(contact.getName() + "#");
			fW.write(contact.getSurname() + "#");
			fW.write(contact.getTelephone() + "#");
			fW.write(contact.getEmail() + "#");
			fW.write(contact.getNote() + "\n");

		} catch (IOException ioEx) {
			status = false;
			ioEx.printStackTrace();
			throw ioEx;
		} finally {
			fW.flush();
			fW.close();
		}

		return status;
	}
	
	public static Contatto addContact() {
		Scanner in = new Scanner(System.in);
		Contatto contact = new Contatto();
		
		System.out.print("Inserisci un nuovo contatto:\n"+
							"\t-Nome: ");
		contact.setName(in.nextLine());
		System.out.print("\t-Cognome: ");
		contact.setSurname(in.nextLine());
		System.out.print("\t-Telefono: ");
		contact.setTelephone(in.nextLine());
		System.out.print("\t-E-Mail: ");
		contact.setEmail(in.nextLine());
		System.out.print("\t-Note sul contatto: ");
		contact.setNote(in.nextLine());
		System.out.println();
		
		in.close();
		
		return contact;
		
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		List<Contatto> contatti = readRubrica(PATH_READ, ";",false);
		
		//Copia contatti rubrica da file
		System.out.println("Copia contatti da rubrica in input -> "+writeRubrica(PATH_WRITE, contatti)+"\n");
		
		//Aggiunta contatto
		Contatto add1 = addContact();
		System.out.println("Contatto aggiunto alla nuova rubrica -> "+writeRubricaAppend(PATH_WRITE,add1)+"\n");
		
		//Lettura rubrica
		contatti = readRubrica(PATH_WRITE,"#",true);
		System.out.print("La tua nuova rubrica -> \n");
		for(Contatto contatto:contatti) {
			System.out.println(contatto);
		}


	}

}
