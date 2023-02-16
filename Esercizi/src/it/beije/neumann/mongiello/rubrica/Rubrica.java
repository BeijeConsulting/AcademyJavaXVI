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
		
		int scelta = 0;
		boolean checkScelta = false;

		List<Contatto> contatti = new ArrayList<>();
		do {
			try {
				System.out.println("Quale operazione vuoi eseguire?");
				System.out.println("1) Stampa rubrica");
				System.out.println("2) Aggiungi contatto");
				System.out.println("3) Modifica contatto");
				System.out.println("4) Elimina contatto");
				System.out.println("5) Ordina rubrica");
				System.out.println("6) Cerca contatto");
				scelta = s.nextInt();
				checkScelta = Check.checkScelta(scelta);

				switch( scelta ) {
				case 1:
					RubricaJdbc.stampaDb();
					break;
				case 2:
					System.out.println("Aggiungi contatto");
					Contatto.inputRubrica(contatti);
					RubricaJdbc.writeContatto( contatti.get(contatti.size()-1) );
					break;
				case 3:
					System.out.println("Inserisci il cognome del contatto da modificare");
					String surnameToEdit = s.next();
					
					RubricaJdbc.search( surnameToEdit );
					
					System.out.println("Quale id vuoi modificare ? ");
					int  id = s.nextInt();

					System.out.println("Quale campo vuoi modificare ?");
					String fieldToEdit = s.next();
					
					System.out.println("Inserisci il nuovo valore");
					String newField = s.next();
				
					RubricaJdbc.editDb( id,fieldToEdit,newField );
					break;
				case 4:
					System.out.println("Inserisci il cognome del contatto da eliminare");
					String surname = s.next();
					RubricaJdbc.search( surname );
					System.out.println("Quale id vuoi eliminare ? ");
					id = s.nextInt();
					
					RubricaJdbc.deleteContact( id );

					contatti = RubricaCsv.loadRubricaFromCSV(pathFileCsv, ";");
					break;
				case 5:
					//ordinamento
					break;
					
				case 6:
					System.out.println("Inserisci il cognome del contatto da cercare");
					 surname = s.next();
					RubricaJdbc.search( surname );
					
					break;
				}	
			}catch( IOException ioEx ){
				checkScelta = true;
				ioEx.printStackTrace();
			}
		}while( checkScelta );


	}
}