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

	static void addContatto() {}
	
	static void deleteContatto() {}
	
	static void modifyContatto() {}
	
	
	static void searchContatto () {}
	
	static void viewContatti (Scanner sc) {
		
		System.out.println("vuoi ordinarli per nome o cognome?");
		Connection connection = ConnectionPool.getConnection();
		PreparedStatement preparedStatement = null;
		String orderField = sc.next();
		ResultSet rs = null;
		
		try {
			preparedStatement = connection.prepareStatement("Select * from Contatti order by ?");
			preparedStatement.setString(1, orderField);
			
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
	
	static void searchCopie() {
		// TODO Auto-generated method stub
		
	}
	private static void mergeCopie() {
		// TODO Auto-generated method stub
		
	}
	
	private static void importFile() {
		// TODO Auto-generated method stub
		
	}
	
	private static void exportDB() {
		// TODO Auto-generated method stub
		
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
			
			azione = sc.next();
			
			switch (azione) {
			
				case "view" : viewContatti(sc); 
				break;
				case "search": searchContatto(); 
				break;
				case "delete": deleteContatto(); 
				break;
				case "update": modifyContatto(); 
				break;
				case "add": addContatto();
				break;
				case "search duplicates": searchCopie();
				break;
				case "merge duplicates": mergeCopie();
				break;
				case "import": importFile();
				break;
				case "export": exportDB();
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
