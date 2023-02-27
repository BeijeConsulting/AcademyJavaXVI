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

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.hibernate.Session;

public class Rubrica {
	public static Session session = HBMsessionFactory.openSession();
	
	
	private static Scanner s;
	
	public static void main( String[] args ) throws FileNotFoundException, IOException, Exception, TransformerException {
		
	
		RubricaHBM hbm = new RubricaHBM();
		RubricaJPA rJpa = new RubricaJPA();	
		RubricaCriteria rCriteria = new RubricaCriteria();
		
		s = new Scanner(System.in);

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
				System.out.println("7) Export csv");
				System.out.println("8) Export xml");
				System.out.println("9) Import csv");
				System.out.println("10) Import Xml");
				System.out.println("11) Trova duplicati");
				scelta = s.nextInt();
				checkScelta = Check.checkScelta(scelta);

				switch( scelta ) {
				case 1:
					//RubricaJdbc.stampaDb();
					//hbm.stampaDb();
					rJpa.stampaDb();
				//	rCriteria.stampaDb();
					break;
				case 2:
					System.out.println("Aggiungi contatto");
					Contatto.inputRubrica(contatti);
					//RubricaJdbc.writeContatto( contatti.get(contatti.size()-1) );
					//hbm.inserisciContatto( contatti.get(contatti.size()-1));
					rJpa.inserisciContatto( contatti.get(contatti.size()-1) );
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
				
					//RubricaJdbc.editDb( id,fieldToEdit,newField );
					//hbm.editContatto( id,fieldToEdit,newField );
					//rJpa.editContatto( id,fieldToEdit,newField );
					rCriteria.editContatto(id, fieldToEdit, newField);
					break;
				case 4:
					System.out.println("Inserisci il cognome del contatto da eliminare");
					String surname = s.next();
					RubricaJdbc.search( surname );
					System.out.println("Quale id vuoi eliminare ? ");
					id = s.nextInt();
					
					//RubricaJdbc.deleteContact( id );
					//hbm.deleteContact( id );
					//rJpa.deleteContact(id);
					rCriteria.deleteContact(id);
					break;
				case 5:
					System.out.println("Vuoi ordinare per Nome o per Cognome ?");
					String valore = s.next();
					
					//hbm.order(valore);
					//RubricaJdbc.order(valore);
//					rJpa.order(valore);
					rCriteria.order(valore);
					break;
					
				case 6:
					System.out.println("Inserisci il cognome del contatto da cercare");
					surname = s.next();
					//RubricaJdbc.search( surname );
					//rJpa.search(surname);
					rCriteria.search(surname);
					break;
				case 7:
					//RubricaJdbc.exportCsv();
					hbm.exportCsv();
					break;
				case 8:
					//RubricaJdbc.exportXml();
					hbm.exportXml();
					break;
				case 9:
					hbm.importCsv();
					//RubricaJdbc.importCsv();
					break;
				case 10:
					//RubricaJdbc.importXml();
					rJpa.importXml();
					break;
				case 11:
					System.out.println("Duplicati");
					//RubricaJdbc.trovaDuplicati();
					//hbm.duplicate();
					rJpa.duplicate();
//					RubricaHBM.duplicate();
					rCriteria.duplicate();
					break;
					
			}
			}catch( IOException ioEx ){
				checkScelta = true;
				ioEx.printStackTrace();
			}finally {
				
			}
		}while( checkScelta );


	}
}