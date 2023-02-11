package it.beije.neumann.mongiello.rubrica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;



public class RubricaCsv {
	
	public static void editRubrica(  String pathFile, String separator, String fieldToEdit ,String oldParametro, String newParametro ) throws IOException  {
		
		try {
			String pathTempFile = "/temp/temp.csv";
			
			File oldFile = new File(pathFile);
			File newFile = new File(pathTempFile);
			//File newFile  = File.createTempFile("tmp", ".csv", new File(tempFile));
			
			FileReader fileReader = new FileReader(oldFile);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			FileWriter fileWriter = new FileWriter( pathTempFile,true );
			BufferedWriter bw = new BufferedWriter(fileWriter); 

			String r = null;
			String[] fields = null;

			while( bufferedReader.ready() ) {
				r = bufferedReader.readLine();
				fields = r.split(separator,-1);
				for(String f: fields) {
					if ( f.equals(oldParametro) ) {
						fileWriter.write(newParametro + separator);
					}else {
						fileWriter.write(f+separator);
					}
				}
				fileWriter.write("\n");
			}
			
			fileWriter.flush();
			fileWriter.close();
			
			fileReader.close();
			bufferedReader.close();
			
			oldFile.delete();
			
			File dump = new File(pathFile);
			newFile.renameTo(dump);
			
		}catch( Exception ioEx ) {
			ioEx.printStackTrace();
			throw ioEx;
		}
	}
	
	public static void searchRubrica( String pathfile, String separator, String parametro ) throws IOException {
		FileReader fileReader = new FileReader(pathfile);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		String r = null;
		String[] fields = null;
		
		while( bufferedReader.ready() ) {
			r = bufferedReader.readLine();
			fields = r.split(separator, -1);
			for(String f: fields) {
				if ( f.equals(parametro) ) {
					System.out.println(r);
				}
			}
			
		}
		
		
	}

public static List<Contatto> loadRubricaFromCSV(String pathfile, String separator) throws FileNotFoundException, IOException {


		FileReader fileReader = new FileReader(pathfile);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		List<Contatto> contatti = new ArrayList<Contatto>();
		
		try {
			String r = null;
			String rigaIntestazione = null;
			String[] fields = null;
			
			String[] dynamicFields = null;
			String surname = null;
			String name = null;
			String telephone = null;
			String email = null;
			String note = null;

			rigaIntestazione = bufferedReader.readLine();
			dynamicFields = rigaIntestazione.split(separator, -1);

			
			Contatto contatto = null;
			int i = 0;
			while( bufferedReader.ready() ) {
				 i = 0;
				r = bufferedReader.readLine();	
				fields = r.split(separator, -1);
				 for( String f : dynamicFields ) {
				//	 System.out.println(f);
					switch(f) {	
					case "COGNOME":
						surname = fields[i];
						break;
					case "NOME":
						name = fields[i];
						break;
					case "TELEFONO":
						telephone = fields[i];
						break;
					case "EMAIL":
						email = fields[i];
						break;
					case "NOTE":
						note = fields[i];
						break;
				}
					i++;	
			}
					
				if(r.equalsIgnoreCase("NOME"+separator +"COGNOME"+separator +"TELEFONO"+separator+"EMAIL"+separator +"NOTE")) continue;
				//contatto = new Contatto( fields[0], fields[1], fields[2], fields[3], fields[4] );
				contatto = new Contatto( name,surname,telephone,email,note );
				contatti.add(contatto);
			}		
		} catch (IOException ioEx) {
			ioEx.printStackTrace();
			throw ioEx;
		}finally {
			bufferedReader.close();
		}
		return contatti;
	}



	public static void writeRubricaCSV( List<Contatto> contatti, String pathFile, String separator ) throws IOException {
		
		FileWriter fileWriter = new FileWriter( pathFile,true );
		fileWriter.write("\n");
		fileWriter.write( contatti.get( contatti.size() -1 ).getName() );
		fileWriter.write(separator);
		
		fileWriter.write( contatti.get( contatti.size() -1 ).getSurname() );
		fileWriter.write(separator);
		
		fileWriter.write( contatti.get( contatti.size() -1 ).getTelephone() );
		fileWriter.write(separator);
		
		fileWriter.write( contatti.get( contatti.size() -1 ).getEmail() );
		fileWriter.write(separator);
		
		fileWriter.write( contatti.get( contatti.size() -1 ).getNote() );
		
		
		fileWriter.flush();
		fileWriter.close();
	}



	public static void creaFile( File csv ) throws IOException {
		FileWriter fw = new FileWriter(csv);
		fw.write("NOME;COGNOME;TELEFONO;EMAIL;NOTE");
		fw.close();
		fw.flush();
		
	}
	

}