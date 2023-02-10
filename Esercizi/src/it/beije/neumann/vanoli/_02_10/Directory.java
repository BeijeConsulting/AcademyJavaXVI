package it.beije.neumann.vanoli._02_10;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Directory {
	public static void main(String[] args) {	  
		Scanner scanner = new Scanner(System.in);

		String directory = scanner.nextLine();
		File dir = new File(directory);

		if (!dir.exists() || !dir.isDirectory()) {
			System.out.println(directory + " non è una directory");
			System.exit(1);
		}

		String outputFile = dir.getName() + ".txt";
		try {
			FileWriter writer = new FileWriter(outputFile);
			listDirectoryContents(dir, writer, "");
			writer.close();
			System.out.println("file salvato in " + outputFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void listDirectoryContents(File dir, FileWriter writer, String indent) throws IOException {
		File[] files = dir.listFiles();
	    for (File file : files) {
	    	writer.write(indent + file.getName() + "\n");
	    	if (file.isDirectory()) {
	    		listDirectoryContents(file, writer, indent + "  ");
	    	}
	    }
	}
}