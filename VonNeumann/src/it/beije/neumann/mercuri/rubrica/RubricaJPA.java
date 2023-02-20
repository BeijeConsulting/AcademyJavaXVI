package it.beije.neumann.mercuri.rubrica;

import java.util.List;
//Implementare un gestore di rubrica a linea di comando, con le seguenti funzionalità:
//
//vedi lista contatti (con possibilità di ordinare per nome e cognome a scelta)
//cerca contatto
//inserisci nuovo contatto
//modifica contatto
//cancella contatto
//trova contatti duplicati
//unisci contatti duplicati
//
//La rubrica deve essere memorizzata su DB e devo esserci la possibilità di importare ed esportare contatti da/in file XML e CSV
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import it.beije.neumann.rubrica.Contatto;

public class RubricaJPA {

	static void addContatto(Scanner sc) {
		
		System.out.println("inserisci nome, cognome, telefono, email e note; scrivere 'stop' se non si vogliono inserire altre info o 'null' per lasciare campi vuoti");
		String [] fields = {"nome", "cognome", "telefono", "email", "note"};
		String [] values = new String[5];
		
		for (int i = 0; i < fields.length; i++) {
			
			String value = sc.nextLine();
			System.out.println(i);
			
			if (value.equals("stop")) break;
			
			values[i] = value;
			
		}
		
		sqlCommand("Select c from Contatto as c", "insert", values);
	}
	
	static void deleteContatto(Scanner sc) {
		System.out.println("Per quale campo vuoi eliminare il contatto?");
		String field = sc.nextLine();
		System.out.println("quale valore?");
		String value = sc.nextLine();
		
		sqlCommand("Select c from Contatto as c where " + field + " = ?1","delete", value);
	}
	
	static void modifyContatto(Scanner sc) {}
		
	static void searchContatto (Scanner sc) {
		System.out.println("Per quale campo vuoi filtrare il contatto?");
		String field = sc.nextLine();
		System.out.println("quale valore?");
		String value = sc.nextLine();
		
		sqlCommand("Select c from Contatto as c where " + field + " = ?1","select", value);
	}
	
	static void viewContatti (Scanner sc) {
		
		System.out.println("vuoi ordinarli per nome o cognome?");
		String orderField = sc.nextLine();
		
		sqlCommand("SELECT c FROM Contatto as c order by " + orderField ,"select" );
						
	}
	
	static void searchCopie(Scanner sc) {
		
		EntityManager entityManager = JPAEntityManagerFactory.createEntityManager();
		
		EntityTransaction transaction = entityManager.getTransaction();
		
		transaction.begin();
		
		Class className = null;
		String classPath = "it.beije.neumann.rubrica.Contatto";
		try {
			className = Class.forName(classPath);
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

		Query query = entityManager.createNativeQuery("select c.* from contatti as c,"
				+ " (Select nome, cognome from contatti group by nome, cognome having count(*) > 1)  a "
				+ " where c.nome = a.nome and c.cognome = a.cognome",className);
	
		System.out.println(query.getResultList());
//		sqlCommand("select c.* from contatti c,"
//				+ " (Select nome, cognome from contatti group by nome, cognome having count(*) > 1)  a "
//				+ " where c.nome = a.nome and c.cognome = a.cognome", true);
	}
	private static void mergeCopie(Scanner sc) {
		// TODO Auto-generated method stub
		
	}
	
	private static void importFile(Scanner sc) {
		// TODO Auto-generated method stub
		
	}
	
	private static void exportDB(Scanner sc) {
		// TODO Auto-generated method stub
		
	}

	static void sqlCommand(String sqlCommand, String typeCommand, String... parameters) {
		
		EntityManager entityManager = JPAEntityManagerFactory.createEntityManager();
		
		EntityTransaction transaction = entityManager.getTransaction();
		
		transaction.begin();
		
		Query query = entityManager.createQuery(sqlCommand);		
		
	
		if(typeCommand.equals("select")) {
			
			for(int i = 0; i < parameters.length; i++) 	
				query.setParameter(i+1, parameters[i]);
			
			List<Contatto> contattiJPA = query.getResultList();
			System.out.println(contattiJPA);
		}
		else if (typeCommand.equals("delete")) {
			
			for(int i = 0; i < parameters.length; i++) 		
				query.setParameter(i+1, parameters[i]);
			
			List<Contatto> contattiJPA = query.getResultList();
			
			for(Contatto c: contattiJPA)
				entityManager.remove(c);
			
		}else if (typeCommand.equals("insert")) {
			
			Contatto c = new Contatto();
			
			c.setName(parameters[0]);
			c.setSurname(parameters[1]);
			c.setTelephone(parameters[2]);
			c.setEmail(parameters[3]);
			c.setNote(parameters[4]);
			
			entityManager.persist(c);
			
		}

		transaction.commit();

		entityManager.close();
	}

	static void menuRubrica () {
		
		System.out.println("digita 'help' per i comandi");

		Scanner sc = new Scanner(System.in);
		String azione = "";
		while (!azione.equals("exit")){
					
			System.out.println("cosa vuoi fare?");
			
			if (azione.equals("help")) {
				System.out.println("view -> visualizza i contatti");
				System.out.println("add -> aggiunge un contatto");
				System.out.println("delete -> cancella un contatto");
			}
			
			azione = sc.nextLine();
			
			switch (azione) {
			
				case "view" : viewContatti(sc); 
				break;
				case "search": searchContatto(sc); 
				break;
				case "delete": deleteContatto(sc); 
				break;
				case "update": modifyContatto(sc); 
				break;
				case "add": addContatto(sc);
				break;
				case "view duplicates": searchCopie(sc);
				break;
				case "merge duplicates": mergeCopie(sc);
				break;
				case "import": importFile(sc);
				break;
				case "export": exportDB(sc);
				break;
				case "exit": System.out.println("chiusura gestore rubrica..."); return;
				default: System.out.println("non ho capito, riprova");
			
			}
		}
		
		sc.close();
	}
	

	public static void main(String[] args) {
	
		menuRubrica();
	}

}
