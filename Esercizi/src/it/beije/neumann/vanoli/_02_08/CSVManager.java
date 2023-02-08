package it.beije.neumann.vanoli._02_08;

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

public class CSVManager {
	
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
				fields = r.split(";", -1);
				
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

	public static void writeRubrica(List<Contatto> contatti) {
		try {
			File newFile = new File("/temp/rubricona.csv");
			System.out.println("newFile.exists()? " + newFile.exists());
			
			FileWriter fileWriter = new FileWriter(newFile);
			for (Contatto c : contatti) {
				fileWriter.write(
						c.getSurname() + ";" +
						c.getName() + ";" +
						c.getTelephone() + ";" +
						c.getEmail() + ";" +
						c.getNote());
				fileWriter.write('\n');
			}
			
			fileWriter.flush();
			fileWriter.close();
			
		} catch (FileNotFoundException fnfEx) {
			fnfEx.printStackTrace();
		} catch (IOException ioEx) {
			ioEx.printStackTrace();
		}
	}
	
	public static void appendRubrica(List<Contatto> contatti) {
		try {
			File newFile = new File("/temp/rubricona.csv");
			System.out.println("newFile.exists()? " + newFile.exists());
			
			FileWriter fileWriter = new FileWriter(newFile, true);
			for (Contatto c : contatti) {
				fileWriter.write(
						c.getSurname() + ";" +
						c.getName() + ";" +
						c.getTelephone() + ";" +
						c.getEmail() + ";" +
						c.getNote());
				fileWriter.write('\n');
			}
			
			fileWriter.flush();
			fileWriter.close();
			
		} catch (FileNotFoundException fnfEx) {
			fnfEx.printStackTrace();
		} catch (IOException ioEx) {
			ioEx.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		List<Contatto> contatti = readRubrica("/temp/rubrica.csv");
		System.out.println(contatti);
		writeRubrica(contatti);
		appendRubrica(contatti);
	}

}
