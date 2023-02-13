package it.beije.neumann.parserxml.iaria_mercuri_vanoli;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Documento {
	
	private Documento() {
		
	}
	
	private Elemento rootElement;

	public static Documento parse(String file) throws IOException {
		Documento document = new Documento();
		FileReader reader = new FileReader(file);
		StringBuilder tag = null;
		List<Elemento> elementi = new ArrayList<>();
		Elemento currentElement = null;
		
        int content;
        while ((content = reader.read()) != -1) {
        	if(content == '<' && (content = reader.read()) != '?' && content != '/') {
        		tag = new StringBuilder();
        		tag.append((char)content);
        		while((content = reader.read()) != '>') {
        			tag.append((char)content);
        		}
        		currentElement = new Elemento(tag.toString(), null, null, currentElement);
        		if(tag.charAt(0) == '/') {
        			currentElement = currentElement.getParent();
        			//Elemento e = new Elemento(tag.toString(), null, null, );
        			//document.rootElement.addFiglio(e);
        			elementi.add(new Elemento(tag.toString(), null, null, currentElement));
        		}
        	}
        }
        System.out.println(elementi.toString());
        

		
		return document;
	}
	
	public static void main(String[] args) throws IOException {
		parse("/temp/test_parser1.xml");
	}
	
}
