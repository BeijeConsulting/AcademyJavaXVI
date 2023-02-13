package it.beije.neumann.parserxml.andreotti_mongiello;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class main {

	public static void main(String[] args) {
		String path = "/temp/test_parser1.xml";
		
		try {
			StringBuilder fileContent = XmlParser.fromFileToString(path);
			//System.out.println(fileContent);
			List<String> listTag = XmlParser.listTag( path );
			String rootElement = XmlParser.getRootElement( listTag );
			System.out.println("Root element: " + rootElement);
			System.out.println(listTag);
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}




	}


