package it.beije.neumann.rubrica.esercizi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import it.beije.neumann.rubrica.Contatto;

public class CSVmanager {

	public static void main(String[] args) throws IOException {
	    List<Contatto> contatti = readRubrica("./src/it/beije/neumann/rubrica/esercizi/rubrica.csv");
	    System.out.println(contatti);
	  }
	
	public static List<Contatto> readRubrica(String filePath) throws IOException {
		FileReader fileReader = new FileReader(filePath);
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
	
	public static List<String[]> readLines(String filePath) throws IOException {
		FileReader fileReader = new FileReader(filePath);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		List<String[]> rows = new ArrayList<String[]>();
		
		try {
			String r = null;
			String[] fields = null;
			while (bufferedReader.ready()) {
				r = bufferedReader.readLine();
				fields = r.split(";");
				rows.add(fields);
				
			}
		} catch (IOException ioEx) {
			ioEx.printStackTrace();
			throw ioEx;
		} finally {
			bufferedReader.close();
		}
		
		return rows;
	}
	
	public static void createFile(String name) {
		try {
		      File myObj = new File("../mille.txt");
		      if (myObj.createNewFile()) {
		        System.out.println("File created: " + myObj.getName());
		      } else {
		        //	
		      }
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	
	public static void writeCsv(List<String> rows, String filePath) {
		File file = new File(filePath);
		  
	    try {
	        // create FileWriter object with file as parameter
	        FileWriter fileWriter = new FileWriter(file);
	  
	  
	        for (String s : rows) {
				fileWriter.write(s);
				fileWriter.write('\n');
			}
			
			fileWriter.flush();
			fileWriter.close();
	    }
	    catch (IOException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	}
}
