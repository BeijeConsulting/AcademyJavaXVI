package it.beije.neumann.rubrica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class GestoreRubrica {
	
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int scelta = 0;

	    do {
	        System.out.println("1. Vedi lista contatti");
	        System.out.println("2. Cerca contatto");
	        System.out.println("3. Inserisci nuovo contatto");
	        System.out.println("4. Modifica contatto");
	        System.out.println("5. Cancella contatto");
	        System.out.println("6. Trova contatti duplicati");
	        System.out.println("7. Unisci contatti duplicati");
	        System.out.println("0. Esci");

	        System.out.print("Scegli un'operazione: ");
	        scelta = scanner.nextInt();

	        switch (scelta) {
	            case 1:
	                vediListaContatti();
	                break;
	            case 2:
	            	System.out.println("Inserisci il nome per la ricerca: ");
	            	String ricerca = scanner.next();
	            	System.out.println();
	                cercaContatto(ricerca);
	                break;
	            case 3:
	                inserisciNuovoContatto();
	                break;
	            case 4:
	                modificaContatto();
	                break;
	            case 5:
	                cancellaContatto();
	                break;
	            case 6:
	                trovaContattiDuplicati();
	                break;
	            case 7:
	                unisciContattiDuplicati();
	                break;
	            case 0:
	                System.out.println("Grazie per aver usato il gestore di rubrica!");
	                break;
	            default:
	                System.out.println("Scelta non valida. Riprova.");
	        }

	    } while (scelta != 0);

	    scanner.close();

	}
	
	private static void vediListaContatti() {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;

		try {
		    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/neumann?serverTimezone=CET&useSSL=false", "root", "root");
		    statement = connection.prepareStatement("SELECT * FROM contatti ORDER BY nome, cognome");
		    rs = statement.executeQuery();

		    System.out.println("Elenco contatti:");

		    while (rs.next()) {
		        String nome = rs.getString("nome");
		        String cognome = rs.getString("cognome");
		        String telefono = rs.getString("telefono");
		        String email = rs.getString("email");
		        String note = rs.getString("note");

		        System.out.println("---------------------------------------------------------------------");
		        System.out.println(nome + " " + cognome + ", " + telefono + ", " + email + ", " + note);
		        System.out.println("---------------------------------------------------------------------");
		    }

		} catch (SQLException e) {
		    e.printStackTrace();
		} finally {
		    try {
		        if (rs != null) {
		            rs.close();
		        }
		        if (statement != null) {
		            statement.close();
		        }
		        if (connection != null) {
		            connection.close();
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}
	}

	private static void cercaContatto(String nomeStringa) {
	    Connection connection = null;
	    PreparedStatement statement = null;
	    ResultSet rs = null;

	    try {
	        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/neumann?serverTimezone=CET&useSSL=false", "root", "root");
	        statement = connection.prepareStatement("SELECT * FROM contatti WHERE nome LIKE ? ORDER BY cognome");
	        statement.setString(1, "%" + nomeStringa + "%");
	        rs = statement.executeQuery();

	        System.out.println("Risultati della ricerca per nome \"" + nomeStringa + "\":");

	        while (rs.next()) {
	            String nome = rs.getString("nome");
	            String cognome = rs.getString("cognome");
	            String telefono = rs.getString("telefono");
	            String email = rs.getString("email");
	            String note = rs.getString("note");

	            System.out.println("---------------------------------------------------------------------");
	            System.out.println(nome + " " + cognome + ", " + telefono + ", " + email + ", " + note);
	            System.out.println("---------------------------------------------------------------------");
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) {
	                rs.close();
	            }
	            if (statement != null) {
	                statement.close();
	            }
	            if (connection != null) {
	                connection.close();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	
	}
	
	private static void unisciContattiDuplicati() {
		
	}

	private static void trovaContattiDuplicati() {
		// TODO Auto-generated method stub
		
	}

	private static void cancellaContatto() {
		// TODO Auto-generated method stub
		
	}

	private static void modificaContatto() {
		// TODO Auto-generated method stub
		
	}

	private static void inserisciNuovoContatto() {
		// TODO Auto-generated method stub
		
	}


	
}
