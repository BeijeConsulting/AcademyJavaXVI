package it.beije.neumann.mongiello.rubrica;
import org.hibernate.query.Query;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.hibernate.Session;
import org.hibernate.Transaction;


public class RubricaHBM {

	public  List<Contatto> contactById(int id){
		Transaction transaction = Rubrica.session.beginTransaction();
		Query<Contatto> query = Rubrica.session.createQuery("SELECT c FROM Contatto as c WHERE id = :i");
		query.setParameter("i",id);
		List<Contatto> contatti = query.getResultList();
		transaction.commit();
		return  contatti;
	}
	
	public void stampaDb() {
		Transaction transaction = Rubrica.session.beginTransaction();
		Query<Contatto> query = Rubrica.session.createQuery("Select c from Contatto as c ");
		List<Contatto> contatti = query.getResultList();
		Contatto.stampaRubrica(contatti);
		transaction.commit();
	}

	public void inserisciContatto(Contatto contatto) {

		Transaction transaction = Rubrica.session.beginTransaction();
		Rubrica.session.save(contatto);
		transaction.commit();	
	}
	
	public  void editContatto( int id, String fieldToEdit, String newField ) {

		Transaction transaction = Rubrica.session.beginTransaction();
		List<Contatto> contatti = contactById(id);
		
		for( Contatto c: contatti ) {
			switch( fieldToEdit ) {
			case "cognome":
				c.setSurname(newField);
				break;
			case "nome":
				c.setName(newField);
				break;
			case "telefono":
				c.setTelephone(newField);
				break;
			case "email":
				c.setEmail(newField);
				break;
			case "note":
				c.setNote(newField);
				break;
			}
			//Rubrica.session.save(c);
		}
		transaction.commit();		
	}

	public  void deleteContact(int id) {
		
		Transaction transaction = Rubrica.session.beginTransaction();
		List<Contatto> contatti = contactById(id);
		Rubrica.session.delete(contatti.get(0));
		//Rubrica.session.save(  );
		transaction.commit();	

	}
	
	public  void order(String valore) {
		Transaction transaction = Rubrica.session.beginTransaction();
		StringBuilder sb = new StringBuilder("SELECT c From Contatto as c ORDER BY ");
		sb.append(valore);
		Query<Contatto> query = Rubrica.session.createQuery( sb.toString() );
		List<Contatto> contatti = query.getResultList();
		Contatto.stampaRubrica(contatti);	
		transaction.commit();
	}
	
	public void search( String cognome ) {
		Transaction transaction = Rubrica.session.beginTransaction();
		Query<Contatto> query = Rubrica.session.createQuery("SELECT c FROM Contatto as c WHERE cognome = :c");
		query.setParameter("c", cognome);
		List<Contatto> contatti = query.getResultList();
		
		Contatto.stampaRubrica(contatti);
		transaction.commit();
		
	}
	
	public void duplicate() {
		Transaction transaction = Rubrica.session.beginTransaction();
		Query<Contatto> query = Rubrica.session.createQuery("select c from Contatto as c");
		List<Contatto> contatti = query.getResultList();
		List<Contatto> duplicati = new ArrayList<>();
		duplicati = this.findDuplicates(contatti);
		Contatto.stampaRubrica(duplicati);
		transaction.commit();
		
	}
	
	 public  ArrayList<Contatto> findDuplicates(List<Contatto> list) {
	        ArrayList<Contatto> duplicates = new ArrayList<>();
	        HashMap<String, Integer> countMap = new HashMap<>();

	        for (Contatto contatto : list) {
	            String key = contatto.getSurname() + " " + contatto.getName();
	            countMap.put(key, countMap.getOrDefault(key, 0) + 1);
	        }

	        for (Contatto contatto : list) {
	        	 String key = contatto.getSurname() + " " + contatto.getName();
	            if (countMap.get(key) > 1 && !duplicates.contains(contatto)) {
	                duplicates.add(contatto);
	            }
	        }

	        return duplicates;
	    }
	
	 public  void exportCsv() throws  ClassNotFoundException, IOException {

		 	Query<Contatto> query = Rubrica.session.createQuery("Select c from Contatto as c ");
		 	List<Contatto> contatti = query.getResultList();
			
			File file = new File("/temp/export.csv");
			FileWriter fileWriter = new FileWriter(file,true);
			
			if(file.exists()) {
				fileWriter.write("id;cognome;nome;telefono;email;note");
				fileWriter.write("\n");
			}
			for(Contatto c: contatti) {	

				fileWriter.write( Integer.valueOf(c.getId()).toString() );
				fileWriter.write(";");
				fileWriter.write(  c.getSurname() );
				fileWriter.write(";");
				fileWriter.write( c.getName());
				fileWriter.write(";");
				fileWriter.write( c.getTelephone());
				fileWriter.write(";");
				fileWriter.write( c.getEmail());
				fileWriter.write(";");
				fileWriter.write( c.getNote());
				fileWriter.write("\n");
			}

			fileWriter.flush();
		


	 }
	 
		public  void exportXml() throws ClassNotFoundException, ParserConfigurationException, TransformerException  {
			
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.newDocument();
		
			Element documentElement = document.createElement("rubrica");
			document.appendChild(documentElement);

			Query<Contatto> query = Rubrica.session.createQuery("Select c from Contatto as c ");
		 	List<Contatto> contatti = query.getResultList();
			
		 	for(Contatto c: contatti) {
					Element contatto = document.createElement("contatto");
					documentElement.appendChild(contatto);

					Element id = document.createElement("id");
					id.setTextContent(Integer.valueOf(c.getId()).toString() );
					contatto.appendChild(id);

					Element surname = document.createElement("cognome");
					surname.setTextContent(Check.isNull(c.getSurname()) );
					contatto.appendChild(surname);

					Element name = document.createElement("nome");
					name.setTextContent(Check.isNull(c.getName()) );
					contatto.appendChild(name);

					Element telephone = document.createElement("telefono");
					telephone.setTextContent(Check.isNull(c.getTelephone()) );
					contatto.appendChild(telephone);

					Element email = document.createElement("email");
					email.setTextContent(Check.isNull(c.getEmail()) );
					contatto.appendChild(email);

					Element note = document.createElement("note");
					note.setTextContent(Check.isNull(c.getNote()));
					contatto.appendChild(note);
				}

				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();
				DOMSource source = new DOMSource(document);

				StreamResult result = new StreamResult(new File("/temp/export.xml"));

				// Output to console for testing
				StreamResult syso = new StreamResult(System.out);

				transformer.transform(source, result);
				//	transformer.transform(source, syso);

		}
		
		
		public static void importCsv() throws IOException, ClassNotFoundException, SQLException {

			
			String separator = ";";
			File file = new File("/temp/export.csv");
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
				
				String r = null;
				String rigaIntestazione = null;
				String[] fields = null;

				String[] dynamicFields = null;
				String surname = null;
				String name = null;
				String telephone = null;
				String email = null;
				String note = null;
				
				
				while( bufferedReader.ready() ) {
					Transaction transaction = Rubrica.session.beginTransaction();
					r = bufferedReader.readLine();
					if(r.equalsIgnoreCase("id"+separator +"cognome"+separator +"nome"+separator+"telefono"+separator +"email"+separator+"note")) continue;
					fields = r.split(separator, -1);
					Contatto contatto = new Contatto();
					if( fields[0] == "" ) {
						contatto.setSurname(fields[1]);
						contatto.setName(fields[2]);
						contatto.setTelephone(fields[3]);
						contatto.setEmail(fields[4]);
						contatto.setNote(fields[5]);
						Rubrica.session.save(contatto);
						transaction.commit();
					}else {
						contatto.setId(  Integer.parseInt(fields[0])  );
						contatto.setSurname(fields[1]);
						contatto.setName(fields[2]);
						contatto.setTelephone(fields[3]);
						contatto.setEmail(fields[4]);
						contatto.setNote(fields[5]);
						Rubrica.session.save(contatto);
						transaction.commit();
					}
				}
		}

}
