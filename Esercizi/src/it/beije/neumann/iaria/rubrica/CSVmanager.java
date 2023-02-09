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
import java.util.StringTokenizer;

public class CSVmanager {
	
	//Metodo per leggere dati da csv
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
		
		//Crea file, controlla che esiste ecc.
		File fileNuovo = new File(""); 
		System.out.println("file.exists()?  "+fileNuovo.exists());
		//
		
		return contatti;
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		List<Contatto> contatti = readRubrica("");
		System.out.println(contatti);
	}
	
}