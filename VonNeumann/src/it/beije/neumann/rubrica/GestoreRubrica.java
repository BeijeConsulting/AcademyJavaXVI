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
	            	vediListaContatti();
	                modificaContatto();
	                break;
	            case 5:
	            	vediListaContatti();
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
		    	int id = rs.getInt("Id");
		        String nome = rs.getString("nome");
		        String cognome = rs.getString("cognome");
		        String telefono = rs.getString("telefono");
		        String email = rs.getString("email");
		        String note = rs.getString("note");

		        System.out.println("---------------------------------------------------------------------");
		        System.out.println(id + " " + nome + " " + cognome + ", " + telefono + ", " + email + ", " + note);
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
	        	int id = rs.getInt("id");
	            String nome = rs.getString("nome");
	            String cognome = rs.getString("cognome");
	            String telefono = rs.getString("telefono");
	            String email = rs.getString("email");
	            String note = rs.getString("note");

	            System.out.println("---------------------------------------------------------------------");
	            System.out.println(id + " " + nome + " " + cognome + ", " + telefono + ", " + email + ", " + note);
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
	
	private static void inserisciNuovoContatto() {
	    Connection connection = null;
	    PreparedStatement statement = null;

	    try {
	        Scanner scanner = new Scanner(System.in); 

	        System.out.print("Inserisci il nome: ");
	        String nome = scanner.nextLine();

	        System.out.print("Inserisci il cognome: ");
	        String cognome = scanner.nextLine();

	        System.out.print("Inserisci il numero di telefono: ");
	        String telefono = scanner.nextLine();

	        System.out.print("Inserisci l'indirizzo email: ");
	        String email = scanner.nextLine();

	        System.out.print("Inserisci una nota: ");
	        String note = scanner.nextLine();
	        scanner.close();
	        
	        
	        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/neumann?serverTimezone=CET&useSSL=false", "root", "root");
	        statement = connection.prepareStatement("INSERT INTO contatti (nome, cognome, telefono, email, note) VALUES (?, ?, ?, ?, ?)");
	        statement.setString(1, nome);
	        statement.setString(2, cognome);
	        statement.setString(3, telefono);
	        statement.setString(4, email);
	        statement.setString(5, note);
	        statement.executeUpdate();

	        System.out.println("Contatto aggiunto.");

	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
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
	
	private static void modificaContatto() {
	    Connection connection = null;
	    PreparedStatement statement = null;
	    ResultSet rs = null;
	    Scanner scanner = new Scanner(System.in);

	    try {
	        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/neumann?serverTimezone=CET&useSSL=false", "root", "root");

	        System.out.print("ID del contatto da modificare: ");
	        int id = scanner.nextInt();

	        statement = connection.prepareStatement("SELECT * FROM contatti WHERE id = ?");
	        statement.setInt(1, id);
	        rs = statement.executeQuery();

	        if (!rs.next()) {
	            System.out.println("Il contatto con ID " + id + " non esiste.");
	            return;
	        }

	        scanner.nextLine();
	        System.out.print("Inserisci il nuovo nome: ");
	        String nome = scanner.nextLine();

	        System.out.print("Inserisci il nuovo cognome: ");
	        String cognome = scanner.nextLine();

	        System.out.print("Inserisci il nuovo numero di telefono: ");
	        String telefono = scanner.nextLine();

	        System.out.print("Inserisci la nuova email: ");
	        String email = scanner.nextLine();

	        System.out.print("Inserisci la nuova nota: ");
	        String nota = scanner.nextLine();

	        statement = connection.prepareStatement("UPDATE contatti SET nome = ?, cognome = ?, telefono = ?, email = ?, note = ? WHERE id = ?");
	        statement.setString(1, nome);
	        statement.setString(2, cognome);
	        statement.setString(3, telefono);
	        statement.setString(4, email);
	        statement.setString(5, nota);
	        statement.setInt(6, id);

	        int result = statement.executeUpdate();

	        if (result > 0) {
	            System.out.println("Il contatto con ID " + id + " è stato modificato.");
	        } else {
	            System.out.println("Errore." + id);
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
	
	private static void cancellaContatto() {
	    Connection connection = null;
	    PreparedStatement statement = null;

	    Scanner scanner = new Scanner(System.in);
	    System.out.println("Inserisci l'ID del contatto da cancellare: ");
	    int id = scanner.nextInt();

	    try {
	        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/neumann?serverTimezone=CET&useSSL=false", "root", "root");
	        statement = connection.prepareStatement("DELETE FROM contatti WHERE id = ?");
	        statement.setInt(1, id);
	        int numeroRigheEliminite = statement.executeUpdate();

	        if (numeroRigheEliminite > 0) {
	            System.out.println("Contatto cancellato.");
	        } else {
	            System.out.println("Nessun contatto trovato con ID " + id + ".");
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
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

	


	
}
