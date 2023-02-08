package it.beije.neumann.vellani.feb8;

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
				
				//System.out.println(contatto);
			}
		} catch (IOException ioEx) {
			ioEx.printStackTrace();
			throw ioEx;
		} finally {
			bufferedReader.close();
		}
		
		return contatti;
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		List<Contatto> contatti = readRubrica("/temp/rubrica.csv");
		System.out.println(contatti);
	}
	
	public static void oldMain(String[] args) {
		
		try {
			File file = new File("/temp/rubrica.csv");
			
			System.out.println("file.exists()? " + file.exists());
			System.out.println("file.isDirectory()? " + file.isDirectory());
			
			FileReader fileReader = new FileReader(file);
			
//			//char c = 0;
//			StringBuilder builder = new StringBuilder();
//			while (fileReader.ready()) {
//				//c = (char) fileReader.read();
//				//System.out.print(c);
//				builder.append((char) fileReader.read());
//			}
//			
//			System.out.println(builder.toString());
			
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			//BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
			List<String> rows = new ArrayList<String>();
			String r = null;
			while (bufferedReader.ready()) {
				r = bufferedReader.readLine();
				rows.add(r);
				System.out.println("### " + r);
			}
			
			System.out.println(rows.size());
			
			List<Contatto> contatti = new ArrayList<Contatto>();
			String[] fields = null;
			Contatto contatto = null;
			for (String s : rows) {
				fields = s.split(";");
				//System.out.println(Arrays.toString(fields));
				//for (String f : fields) System.out.println(f);
				contatto = new Contatto();
				contatto.setSurname(fields[0]);
				contatto.setName(fields[1]);
				contatto.setTelephone(fields[2]);
				contatto.setEmail(fields[3]);
				contatto.setNote(fields[4]);
				
				contatti.add(contatto);
				
				System.out.println(contatto);
				System.out.println("--------------");
			}
			
//			StringTokenizer tokenizer = null;
//			for (String s : rows) {
//				tokenizer = new StringTokenizer(s, ";");
//				while (tokenizer.hasMoreElements()) {
//					System.out.println(tokenizer.nextElement());
//				}
//				System.out.println("--------------");
//			}
			
			
//			File newFile = new File("/temp/neumann.csv");
//			System.out.println("newFile.exists()? " + newFile.exists());
//			
////			if (!newFile.exists()) {
////				//....
////			}
//			
//			FileWriter fileWriter = new FileWriter(newFile);
//			for (String s : rows) {
//				fileWriter.write(s);
//				fileWriter.write('\n');
//			}
//			
//			fileWriter.flush();
//			fileWriter.close();
			
		} catch (FileNotFoundException fnfEx) {
			fnfEx.printStackTrace();
		} catch (IOException ioEx) {
			ioEx.printStackTrace();
		}

	}

}
