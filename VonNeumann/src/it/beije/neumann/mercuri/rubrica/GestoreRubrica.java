package it.beije.neumann.mercuri.rubrica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

public class GestoreRubrica {

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
		
		sqlCommand("insert into contatti (nome, cognome, telefono, email, note) values (?,?,?,?,?)", false, values);
	}
	
	static void deleteContatto(Scanner sc) {
		System.out.println("Per quale campo vuoi eliminare il contatto?");
		String field = sc.nextLine();
		System.out.println("quale valore?");
		String value = sc.nextLine();
		
		sqlCommand("delete from Contatti where " + field + " = ?",false, value);
	}
	
	static void modifyContatto(Scanner sc) {}
		
	static void searchContatto (Scanner sc) {
		System.out.println("Per quale campo vuoi filtrare il contatto?");
		String field = sc.nextLine();
		System.out.println("quale valore?");
		String value = sc.nextLine();
		
		sqlCommand("Select * from Contatti where " + field + " = ?",true, value);
	}
	
	static void viewContatti (Scanner sc) {
		
		System.out.println("vuoi ordinarli per nome o cognome?");
		String orderField = sc.nextLine();
		
		sqlCommand("Select * from Contatti order by " + orderField ,true );
						
	}
	
	static void searchCopie(Scanner sc) {
		
		sqlCommand("select c.* from contatti c,"
				+ " (Select nome, cognome from contatti group by nome, cognome having count(*) > 1)  a "
				+ " where c.nome = a.nome and c.cognome = a.cognome", true);
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

	static void sqlCommand(String sqlCommand, boolean isSelect, String... parameters) {
		
		Connection connection = ConnectionPool.getConnection();
		PreparedStatement preparedStatement = null;
		
		ResultSet rs = null;
		
		try {
			preparedStatement = connection.prepareStatement(sqlCommand);
			
			for(int i = 0; i < parameters.length; i++) {
				
				preparedStatement.setString(i+1, parameters[i]);
				
			}
			
			System.out.println(preparedStatement.toString());
			
			if(isSelect) {
				rs = preparedStatement.executeQuery();
				
				//order by non funziona con i set giustamente
				while (rs.next()) {
	
					System.out.println("Id: " + rs.getInt("id")); 
					System.out.println("Cognome: " + rs.getString("cognome")); 
					System.out.println("Nome: " + rs.getString("nome")); 
					System.out.println("Telefono: " + rs.getString("telefono")); 
					System.out.println("Email: " + rs.getString("email")); 
					System.out.println("Note: " + rs.getString("note")); 
					System.out.println("-------");
	
				}
			}
			else {
				preparedStatement.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			
			try {
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	static void menuRubrica () {
		
		System.out.println("digita 'help' per i comandi");
		
		ConnectionPool.getInstance();

		Scanner sc = new Scanner(System.in);
		String azione = null;
		while (azione != "exit") {
					
			System.out.println("cosa vuoi fare?");
			
			if (azione == "help") {
				System.out.println("view -> visualizza i contatti");
				System.out.println("add -> aggiunge un contatto");
				System.out.println("delete -> cancella un contatto");
//				System.out.println("view -> visualizza i contatti");
//				System.out.println("view -> visualizza i contatti");
//				System.out.println("view -> visualizza i contatti");
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
