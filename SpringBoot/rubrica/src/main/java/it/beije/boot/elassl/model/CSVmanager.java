package it.beije.boot.elassl.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class CSVmanager {
	/*
	public List<Contatto> loadRubricaFromCSV(String pathFile, String separator) {...}
	public void writeRubricaCSV(List<Contatto> contatti, String pathFile, String separator) {...}
	*/
	/*
	public static void appendRubricaCSV(List<Contatto> contatti, String pathfile, String separator) throws FileNotFoundException, IOException {
		for(Contatto contatto: contatti)
			writeRubrica( pathfile, contatto, separator, true);
	}*/
	public static void writeRubricaCSV(List<Contatto> contatti, String pathfile, String separator) throws FileNotFoundException, IOException {
		for(Contatto contatto: contatti)
			writeRubrica( pathfile, contatto, separator, true);
	}
	
	public static void writeRubrica(String pathfile, Contatto contatto, String separator, boolean append) throws FileNotFoundException, IOException {
		try (FileWriter fileWriter = new FileWriter(pathfile, append);){
			String s = String.format("\n%s%s%s%s%s%s%s%s%s", contatto.getSurname(), separator, contatto.getName(), separator, contatto.getTelephone(), separator, contatto.getEmail(), separator, contatto.getNote());
			fileWriter.write(s);
		}
		catch (FileNotFoundException fnfEx) {
			System.out.println(new File(".").getCanonicalPath());
			fnfEx.printStackTrace();
		} 
		catch (IOException ioEx) {
			ioEx.printStackTrace();
		}
	}
	
	
	public static List<Contatto> loadRubricaFromCSV(String pathFile, String separator) throws FileNotFoundException, IOException{
		
		FileReader fileReader = new FileReader(pathFile);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		List<Contatto> contatti = new ArrayList<Contatto>();
		
		try {
			String r = null;
			String[] fields = null;
			Contatto contatto = null;
			while (bufferedReader.ready()) {
				r = bufferedReader.readLine();
				if(r==null || r.length()==0) continue;
				fields = r.split(separator);
				
				contatto = new Contatto();
				contatto.setSurname(fields[0]);
				contatto.setName(fields[1]);
				contatto.setTelephone(fields[2]);
				contatto.setEmail(fields[3]);
				contatto.setNote(fields.length>4 ? fields[4]:null);
				
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

}
