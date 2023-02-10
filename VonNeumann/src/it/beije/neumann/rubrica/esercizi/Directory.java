package it.beije.neumann.rubrica.esercizi;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Directory {

	public static void main(String[] args) {
//		File f = new File("./src/it/beije/neumann/rubrica/esercizi");
		File f = new File("./src");
		printName(f);
		
	}
	
	
	public static void printName(File f) {
		if(f.exists() && f.isDirectory()) {
			System.out.println(f.getName());
			File[] arr = f.listFiles();
			for(int i = 0; i < arr.length; i++) {
				if(arr[i].isDirectory()) {
					printName(arr[i]);
				} else {
					System.out.println(arr[i].getName());
					writeFile(" " + arr[i].getName());
				}
			}
		}
	}
	public static void writeFile(String line) {
		try {
		      FileWriter myWriter = new FileWriter("./src/it/beije/neumann/rubrica/esercizi/test.txt", true);
		      myWriter.write(line + "\n");
		      myWriter.close();
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
}
