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


		String pathFileCsv = "/temp/rubrica.csv";
		String pathFileXml = "/temp/rubrica.xml";
		File fileCsv = new File(pathFileCsv);
		File fileXml = new File(pathFileXml);
		
		if(!fileCsv.exists()) System.out.println("Non esiste");
		

		//memorizza i contatti presenti in un file CSV in una lista
		List<Contatto> contatti = RubricaCsv.loadRubricaFromCSV(pathFileCsv, ";");

		System.out.println("Aggiungi contatti");
		//aggiunge ad una lista di contatti i valori presi in input
		Contatto.inputRubrica(contatti);
	
		RubricaCsv.writeRubricaCSV(contatti, pathFileCsv, ";" );
		
		RubricaXml.writeRubricaXML( contatti, pathFileXml );
		
		
		List<Contatto> contattiXml = RubricaXml.loadRubricaFromXML(pathFileXml);
			
		
		
	
	}
	

}
