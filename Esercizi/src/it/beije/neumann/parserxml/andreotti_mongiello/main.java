package it.beije.neumann.parserxml.andreotti_mongiello;

import java.io.IOException;

public class main {

	public static void main(String[] args) {
		String path = "/temp/test_parser1.xml";
		
		try {
			StringBuilder fileContent = XmlParser.fromFileToString(path);
			System.out.println(fileContent);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}




	}


