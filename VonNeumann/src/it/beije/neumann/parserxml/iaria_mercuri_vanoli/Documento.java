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
	
	public Elemento getRootElement() {
		return rootElement;
	}

	public static Documento parse(String file) throws IOException {
		Documento document = new Documento();
		FileReader reader = new FileReader(file);
		StringBuilder tag = null;
		StringBuilder textContext = null;
		List<Elemento> elementi = new ArrayList<>();
		List<String> attributi = null;
		Elemento currentElement = null;
		StringBuilder attributeSB = null;
		String[] attributiEValori = null;
		
        int content = 0;
        while (content != -1) {
        	if(content == '<' && (content = reader.read()) != '?') {
        		tag = new StringBuilder();
        		tag.append((char)content);
        		while((content = reader.read()) != '>' && content != ' ') {
        			tag.append((char)content);
        		}
        		attributi = new ArrayList<>();
        		attributeSB = new StringBuilder();
        		attributiEValori = null;
        		if(content == ' ') {
	        		while(content != '>') {
	        			attributeSB.append((char)content);
	        			content = reader.read();
	        		}
	        		attributiEValori = attributeSB.toString().split("\"");
	        		for(int i=0; i<attributiEValori.length; i++) {
	        			if(i%2==0) {
	        				attributiEValori[i] = attributiEValori[i].replace(" ", "").replace("=", "");
	        			}
	        		}
        		}
        		textContext = new StringBuilder();
        		while((content = reader.read()) != '<' && content != -1) {
        			textContext.append((char)content);
        		}
        		if(tag.charAt(0) == '/') {
        			if(currentElement.getParent() == null)
        				document.rootElement = currentElement;
        			currentElement = currentElement.getParent();
        		} else {
        			elementi.add(new Elemento(tag.toString(), textContext.toString(), attributiEValori, currentElement)); //Lista test momentaneo
        			Elemento e = new Elemento(tag.toString(), textContext.toString(), attributiEValori, currentElement);
        			if(currentElement != null)
        				currentElement.addFiglio(e);
        			currentElement = e;
        		}
        	} else {
        		content = reader.read();
        	}
        }
//        System.out.println(document.rootElement);
//        for (Elemento e: elementi) {
//        	if(e.getParent() != null)
//        		System.out.println(e.getTag() + " e' figlio di " + e.getParent().getTag() + " con context: " + e.getTextContext());
//        }
        //System.out.println(elementi.toString());
        

		
		return document;
	}
	
	public static void main(String[] args) throws IOException {
		
		Documento document = parse("/temp/test_parser1.xml");
		document.getRootElement().stampaAlbero();
		//for(Elemento e: document.getRootElement().getChildElements())
			//System.out.println(e.getChildElements());
	}
	
}
