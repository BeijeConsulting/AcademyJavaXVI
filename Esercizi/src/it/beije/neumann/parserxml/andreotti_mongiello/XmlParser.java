package it.beije.neumann.parserxml.andreotti_mongiello;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class XmlParser {
	//metodo che legge da un file tutti i caratteri e ritorna una stringBuilder
	public static StringBuilder fromFileToString(String path) throws IOException {

		StringBuilder contenuto = new StringBuilder();
		FileReader fileReader = new FileReader(path);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		while( bufferedReader.ready() ) {
			contenuto.append(bufferedReader.readLine());
			contenuto.append("\n");
		}
		
		return contenuto;
	}
}
