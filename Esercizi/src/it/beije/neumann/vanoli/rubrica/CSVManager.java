package it.beije.neumann.vanoli.rubrica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVManager {
	
	public static int[] getOrderOfProperties(String[] fields) {
		int[] order = {-1, -1, -1, -1, -1, -1};
		/*significato di ogni posizione dell'array:
		 * 0 - dove si trova nome all'interno di fields
		 * 1 - dove si trova cognome all'interno di fields
		 * 2 - dove si trova telefono all'interno di fields
		 * 3 - dove si trova email all'interno di fields
		 * 4 - dove si trova note all'interno di fields
		 * 5 - dove si trova id all'interno di fields
		 * 
		 * per ogni posizione, se il valore è -1 vuol dire che nella riga non è stato trovato il rispettivo campo
		 */
		
		for (int i = 0; i < fields.length; i++) {
			switch(fields[i].trim().toLowerCase()) {
			case "nome":
				order[0] = i;
				break;
			case "cognome":
				order[1] = i;
				break;
			case "telefono":
				order[2] = i;
				break;
			case "email":
				order[3] = i;
				break;
			case "note":
				order[4] = i;
				break;
			case "id":
				order[5] = i;
				break;
			}
		}
		return order;		
	}
	
	public static List<Contatto> loadRubricaFromCSV(String pathFile, String separator) throws FileNotFoundException, IOException {
		FileReader fileReader = new FileReader(pathFile);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		List<Contatto> contatti = new ArrayList<Contatto>();
		
		try {
			String r = null;
			String[] fields = null;
			Contatto contatto = null;
			boolean firstRow = true;			
			int[] orderFields = null;
			
			while (bufferedReader.ready()) {
				r = bufferedReader.readLine();
				fields = r.split(separator, -1);
				
				if (firstRow) {
					firstRow = false;
					orderFields = getOrderOfProperties(fields);
					continue;
				}
				
				contatto = new Contatto();
				
				if (orderFields[0] != -1)
					contatto.setNome(fields[orderFields[0]]);
				if (orderFields[1] != -1)
					contatto.setCognome(fields[orderFields[1]]);
				if (orderFields[2] != -1)
					contatto.setTelefono(fields[orderFields[2]]);
				if (orderFields[3] != -1)
					contatto.setEmail(fields[orderFields[3]]);
				if (orderFields[4] != -1)
					contatto.setNote(fields[orderFields[4]]);
				if (orderFields[5] != -1)
					contatto.setId(Integer.parseInt(fields[orderFields[5]]));
				
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

	public static void writeRubricaCSV(List<Contatto> contatti, String pathFile, String separator) {
		try {
			File newFile = new File(pathFile);
			
			FileWriter fileWriter = new FileWriter(newFile, true);
			fileWriter.write("ID;COGNOME;NOME;TELEFONO;EMAIL;NOTE\n");
			for (Contatto c : contatti) {
				fileWriter.write(
						c.getId() + separator +
						c.getCognome() + separator +
						c.getNome() + separator +
						c.getTelefono() + separator +
						c.getEmail() + separator +
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
		
}
