package it.beije.neumann.mongiello.rubrica;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;


public class RubricaHBM {

	public static List<Contatto> contactById(int id){
		Transaction transaction = Rubrica.session.beginTransaction();
		Query<Contatto> query = Rubrica.session.createQuery("SELECT c FROM Contatto as c WHERE id = :i");
		query.setParameter("i",id);
		List<Contatto> contatti = query.getResultList();
		transaction.commit();
		return  contatti;
	}
	
	public static void stampaDb() {
		Transaction transaction = Rubrica.session.beginTransaction();
		
		Query<Contatto> query = Rubrica.session.createQuery("Select c from Contatto as c ");
		List<Contatto> contatti = query.getResultList();
		Contatto.stampaRubrica(contatti);
		transaction.commit();
	}

	public static void inserisciContatto(Contatto contatto) {

		Transaction transaction = Rubrica.session.beginTransaction();
		Rubrica.session.save(contatto);
		transaction.commit();	
	}
	
	public static void editContatto( int id, String fieldToEdit, String newField ) {

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

	public static void deleteContact(int id) {
		
		Transaction transaction = Rubrica.session.beginTransaction();
		List<Contatto> contatti = contactById(id);
		Rubrica.session.delete(contatti.get(0));
		//Rubrica.session.save(  );
		transaction.commit();	

	}
	
	public static void order(String valore) {
		Transaction transaction = Rubrica.session.beginTransaction();
		StringBuilder sb = new StringBuilder("SELECT c From Contatto as c ORDER BY ");
		sb.append(valore);
		Query<Contatto> query = Rubrica.session.createQuery( sb.toString() );
		List<Contatto> contatti = query.getResultList();
		Contatto.stampaRubrica(contatti);	
		transaction.commit();
	}
	
	public static void search( String cognome ) {
		Transaction transaction = Rubrica.session.beginTransaction();
		Query<Contatto> query = Rubrica.session.createQuery("SELECT c FROM Contatto as c WHERE cognome = :c");
		query.setParameter("c", cognome);
		List<Contatto> contatti = query.getResultList();
		Contatto.stampaRubrica(contatti);
		transaction.commit();
	}
	
	public static void duplicate() {
		Transaction transaction = Rubrica.session.beginTransaction();
		Query<Contatto> query = Rubrica.session.createQuery("select c from Contatto as c");
		
		List<Contatto> contatti = query.getResultList();
		List<Contatto> duplicati = new ArrayList<>();
		duplicati = findDuplicates(contatti);
		
		Contatto.stampaRubrica(duplicati);
		transaction.commit();
		
	}
	
	 public static ArrayList<Contatto> findDuplicates(List<Contatto> list) {
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
	
	
	
	
	
}
