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
	
public static List<Contatto> readRubrica(String pathfile) throws FileNotFoundException, IOException {

		
		FileReader fileReader = new FileReader(pathfile);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		List<Contatto> contatti = new ArrayList<Contatto>();
		
		try {
			String r = null;
			String[] fields = null;
			Contatto contatto = null;
			while( bufferedReader.ready() ) {
				r = bufferedReader.readLine();
				fields = r.split(";");
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


	public static void writeRubrica( List<Contatto> contatti, File file ) throws IOException {
		
		FileWriter fileWriter = new FileWriter( file, true );
		
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
		
	}
}