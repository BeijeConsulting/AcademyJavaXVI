package it.beije.neumann.parserxml.iaria_mercuri_vanoli;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Documento {
	
	private Documento() {
		
	}
	
	//private Elemento rootElement;
	private String rootElement = "";

	public static Documento parse(String file) throws IOException {
		Documento document = new Documento();
		FileReader reader = new FileReader(file);
		StringBuilder tag = null;
		
        int content;
        while ((content = reader.read()) != -1) {
        	if(content == '<' && (content = reader.read()) != '?') {
        		tag = new StringBuilder();
        		tag.append((char)content);
        		while((content = reader.read()) != '>') {
        			tag.append((char)content);
        		}
        	}
        }
        System.out.println(tag);
        
        //root
        
		
		return document;
	}
	
	public static void main(String[] args) throws IOException {
		parse("/temp/test_parser1.xml");
	}
	
}
