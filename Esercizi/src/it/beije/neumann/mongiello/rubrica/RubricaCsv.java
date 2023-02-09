package it.beije.neumann.mongiello.rubrica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class RubricaCsv {
	
public static List<Contatto> loadRubricaFromCSV(String pathfile, String separator) throws FileNotFoundException, IOException {

		FileReader fileReader = new FileReader(pathfile);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		List<Contatto> contatti = new ArrayList<Contatto>();
		
		try {
			String r = null;
			String[] fields = null;
			Contatto contatto = null;
			while( bufferedReader.ready() ) {
				r = bufferedReader.readLine();
				fields = r.split(separator, -1);
				contatto = new Contatto( fields[0], fields[1], fields[2], fields[3], fields[4] );
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


	public static void writeRubricaCSV( List<Contatto> contatti, String pathFile, String separator ) throws IOException {
		
		FileWriter fileWriter = new FileWriter( pathFile, true );
		
		fileWriter.write( contatti.get( contatti.size() -1 ).getName() );
		fileWriter.write(separator);
		
		fileWriter.write( contatti.get( contatti.size() -1 ).getSurname() );
		fileWriter.write(separator);
		
		fileWriter.write( contatti.get( contatti.size() -1 ).getTelephone() );
		fileWriter.write(separator);
		
		fileWriter.write( contatti.get( contatti.size() -1 ).getEmail() );
		fileWriter.write(separator);
		
		fileWriter.write( contatti.get( contatti.size() -1 ).getNote() );
		fileWriter.write("\n");
		
		fileWriter.flush();
		
	}
}