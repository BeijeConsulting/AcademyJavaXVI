package it.beije.neumann.web.vanoli;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PathFinder {
	public static void main(String[] args) {	  
		Scanner scanner = new Scanner(System.in);

		String directory = scanner.nextLine();
		File dir = new File(directory);
		StringBuilder result = new StringBuilder();

		if (!dir.exists() || !dir.isDirectory()) {
			System.out.println(directory + " non è una directory");
			System.exit(1);
		}

		String outputFile = dir.getName() + ".txt";
		try {
			FileWriter writer = new FileWriter(outputFile);
			listDirectoryContents(dir, result, "");
			writer.write(result.toString());
			writer.close();
			System.out.println("file salvato in " + outputFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static void listDirectoryContents(File dir, StringBuilder writer, String indent) throws IOException {
		File[] files = dir.listFiles();
	    for (File file : files) {
	    	writer.append(indent + file.getName() + "<br/>");
	    	if (file.isDirectory()) {
	    		listDirectoryContents(file, writer, indent + "&emsp;");
	    	}
	    }
	}
}