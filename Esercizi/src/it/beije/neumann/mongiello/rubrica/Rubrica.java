package it.beije.neumann.mongiello.rubrica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;


public class Rubrica {

	public static void main( String[] args ) throws FileNotFoundException, IOException, Exception, TransformerException {

		String pathFileCsv = "/temp/rubricaCsv.csv";
		String pathFileXml = "/temp/rubricaXml.xml";
		File file = new File(pathFileCsv);
		if(!file.exists()) System.out.println("Non esiste");
		
		List<Contatto> contatti = RubricaCsv.loadRubricaFromCSV(pathFileCsv, ";");
			
		System.out.println("Aggiungi contatti");
	//	Contatto.inputRubrica( contatti );
		
		RubricaCsv.writeRubricaCSV(contatti, pathFileCsv, ";" );
		
		RubricaXml.writeRubricaXML( contatti, pathFileXml );
		
	}
	

}
