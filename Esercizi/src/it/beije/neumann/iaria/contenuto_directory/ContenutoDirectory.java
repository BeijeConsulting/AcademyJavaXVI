package it.beije.neumann.iaria.contenuto_directory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ContenutoDirectory {
	
	static void directorySuFile(String path) throws IOException {
		int count = 0; //Mi servirà per creare meglio l'elenco
		String pathFile = "/Users/gianf/Desktop/Programmazione2.txt"; //Directory dove creare il file con le informazioni
		File fileDirectory = new File(path);
		
		File elencoDirectory = new File(pathFile);
		FileWriter fileWriter = new FileWriter(elencoDirectory);
		
		try {
			File[] folderAndFiles = fileDirectory.listFiles();
			for(File element : folderAndFiles) {
				System.out.println(element.getName());
				if(element.isDirectory()) {
					count++;
					fileWriter.write(element.getName()+" (dir)");
					fileWriter.write("\n");
					directorySuFile(path+"/"+element.getName());
				}if(element.isFile()) {
					fileWriter.write(element.getName());
					fileWriter.write("\n");
				}
			}
		} catch (IOException ioEx) {
			ioEx.printStackTrace();
			throw ioEx;
		} finally {
			fileWriter.close(); //Chiudo il file per salvare modifiche
		}
		
	}

	public static void main(String[] args) throws IOException {
		String pathDirectory = "/Users/gianf/Documents/Università/Programmazione2"; //Directory dove leggere i file
		directorySuFile(pathDirectory);
	}

}
