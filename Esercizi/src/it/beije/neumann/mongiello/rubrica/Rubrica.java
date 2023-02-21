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
		Scanner s = new Scanner(System.in);
		

		String pathFileCsv = "/temp/rubrica.csv";
		String pathFileXml = "/temp/rubrica.xml";
		File fileCsv = new File(pathFileCsv);
		File fileXml = new File(pathFileXml);
		
	if(!fileCsv.exists()) {
			RubricaCsv.creaFile(fileCsv);
		}
		
		
		//memorizza i contatti presenti in un file CSV in una lista
	//	List<Contatto> contatti = RubricaCsv.loadRubricaFromCSV(pathFileCsv, ";");
		
		//System.out.println("Aggiungi contatti");
		//aggiunge ad una lista di contatti i valori presi in input
		//Contatto.inputRubrica(contatti);
		
		//RubricaCsv.writeRubricaCSV(contatti, pathFileCsv, ";" );
		
		//RubricaXml.writeRubricaXML( contatti, pathFileXml );
				
		//List<Contatto> contattiXml = RubricaXml.loadRubricaFromXML(pathFileXml);
		
		
		
	//	RubricaCsv.searchRubrica(  pathFileCsv ,";", "Mongiello" );
		
		
	//	RubricaCsv.editRubrica( pathFileCsv ,";","EMAIL" , "moraglia", "0803745" );

	//	contatti = RubricaCsv.loadRubricaFromCSV(pathFileCsv, ";");
	//	Contatto.stampaRubrica(contatti);
		
	//	RubricaCsv.deleteContact( pathFileCsv, ";", "moraglia" );
	//	Contatto.inputRubrica(contatti);
		
	//	RubricaCsv.writeRubricaCSV(contatti, pathFileCsv, ";" );
		
		int scelta = 0;
		boolean checkScelta = false;
		List<Contatto> contatti = RubricaCsv.loadRubricaFromCSV(pathFileCsv, ";");
		
		try {
			do {
				System.out.println("Quale operazione vuoi eseguire?");
				System.out.println("1) Stampa rubrica");
				System.out.println("2) Aggiungi contatto");
				System.out.println("3) Modifica contatto");
				System.out.println("4) Elimina contatto");
				System.out.println("5) Ordina rubrica");
				scelta = s.nextInt();
				checkScelta = Check.checkScelta(scelta);
				
				switch( scelta ) {
					case 1:
						Contatto.stampaRubrica(contatti);
						break;
					case 2:
						System.out.println("Aggiungi contatto");
						Contatto.inputRubrica(contatti);
						RubricaCsv.writeRubricaCSV(contatti, pathFileCsv, ";");
						break;
					case 3:
						
						System.out.println("Inserisci il cognome del contatto da modificare");
						String surnameToEdit = s.next();
						
						System.out.println("Quale campo vuoi modicare? ");
						String field = s.next();
						
						System.out.println("Inserisci il nuovo valore");
						String newField = s.next();
						RubricaCsv.editRubrica(pathFileCsv, ";", field.toUpperCase() , surnameToEdit, newField);
						
						contatti = RubricaCsv.loadRubricaFromCSV(pathFileCsv, ";");
						break;
					case 4:
						System.out.println("Inserisci il cognome del contatto da eliminare");
						String surnameToDelete = s.next();
						RubricaCsv.deleteContact( pathFileCsv, ";", surnameToDelete );
						
						contatti = RubricaCsv.loadRubricaFromCSV(pathFileCsv, ";");
						break;
					case 5:
						//ordinamento
						break;
				}
			}while( checkScelta );
			}catch( IOException ioEx ){
				ioEx.printStackTrace();
			}
		
		
		
		
	}
	

}
