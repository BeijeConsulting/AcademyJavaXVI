package it.beije.neumann.mercuri.rubrica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import it.beije.neumann.rubrica.Contatto;

public class CSVmanager {
	
	public static List<Contatto> loadRubricaDinamicaFromCSV(String pathfile,String separator) throws FileNotFoundException, IOException {
		FileReader fileReader = new FileReader(pathfile);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		List<Contatto> contatti = new ArrayList<Contatto>();
		
		try {
			String r = null;
			String[] fields = null;
			String[] dynamicFields = null;
			Contatto contatto = null;
			r = bufferedReader.readLine();
			
			dynamicFields = r.split(separator , -1);

			while (bufferedReader.ready()) {
				
				r = bufferedReader.readLine();
				fields = r.split(separator , -1);
				
				contatto = new Contatto();
				int i = 0;
				
				for (String field: dynamicFields) {

					switch (field) {
					case "COGNOME" : contatto.setSurname(fields[i]);
					break;
					case "NOME" : contatto.setName(fields[i]);
					break;
					case "TELEFONO" : contatto.setTelephone(fields[i]);
					break;
					case "EMAIL" : contatto.setEmail(fields[i]); 
					break;
					case "NOTE" : contatto.setNote(fields[i]);
					break;
					case "" : //il carattere per andare a capo?
					break;
					default: 
						throw new IllegalArgumentException("campo nuovo non gestito");
					}
					
					i++;
				}
			
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
	
	public static List<Contatto> loadRubricaFromCSV(String pathfile,String separator) throws FileNotFoundException, IOException {
		FileReader fileReader = new FileReader(pathfile);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		List<Contatto> contatti = new ArrayList<Contatto>();
		
		try {
			String r = null;
			String[] fields = null;
			Contatto contatto = null;
			while (bufferedReader.ready()) {
				r = bufferedReader.readLine();
				fields = r.split(separator , -1);
				
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
	
	public static void writeRubricaCSV (String pathFile, List<Contatto> list,String separator)  {
					
		File newFile = new File(pathFile);
						
		FileWriter fileWriter = null;
		StringBuilder sb = new StringBuilder();
		
		if (!newFile.exists()) {
			System.out.println("file not found, creating a new file");
		
			try {
				
				fileWriter = new FileWriter(newFile);
				for (Contatto s : list) {
					
					sb.setLength(0);
					sb.append(s.getSurname()).append(separator)
						.append(s.getName()).append(separator)
						.append(s.getTelephone()).append(separator)
						.append(s.getEmail()).append(separator)
						.append(s.getNote()).append(separator);
					
					fileWriter.write(sb.toString());
					fileWriter.write('\n');
				}
				
			} 
			catch (IOException ioEx) {
				ioEx.printStackTrace();
			
			} 
			finally {
				
				try {
					fileWriter.flush();
					fileWriter.close();
				} 
				catch (IOException ioEx) {
					ioEx.printStackTrace();
				}
		
			}
		}
		else {
			try {
				
				System.out.println("file found, adding new lines");
				
				Writer writeFile = new BufferedWriter(new FileWriter(pathFile, true));
				
				for (Contatto s : list) {
					
					sb.setLength(0);
					sb.append(s.getSurname()).append(separator)
						.append(s.getName()).append(separator)
						.append(s.getTelephone()).append(separator)
						.append(s.getEmail()).append(separator)
						.append(s.getNote()).append(separator);
					
					writeFile.append(sb.toString() + "\n");
				}
				
				writeFile.flush();
				writeFile.close();
				
			} catch (IOException ioEx) {
				ioEx.printStackTrace();
			}
			
		}
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
	List<Contatto> contatti = loadRubricaDinamicaFromCSV("/temp/rubricaDinamica.csv", ";");
	System.out.println(contatti);
//
//		CSVmanager.writeRubrica("/temp/rubricaCopiata.csv", contatti);
//		
//		contatti = readRubrica("/temp/rubricaCopiata.csv");
//		System.out.println(contatti);
	}
	
}
