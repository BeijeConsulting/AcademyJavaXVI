package it.beije.neumann.nicole.rubricajdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * Implementare un gestore di rubrica a linea di comando, con le seguenti funzionalità:

-vedi lista contatti (con possibilità di ordinare per nome e cognome a scelta)
-cerca contatto
-inserisci nuovo contatto
-modifica contatto
-cancella contatto
-trova contatti duplicati
-unisci contatti duplicati

-La rubrica deve essere memorizzata su DB e devo esserci la possibilità di importare ed esportare contatti da/in file XML e CSV
 * @author nverz
 *
 */
public class GestoreDiContatto 
{
	/**
	 * la classe deve inserire il testo da linea di comando: 
	 * quindi utilizzo uno Scanner 
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	
	public static void vediListaContatti() throws ClassNotFoundException, SQLException
	{
        Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connection = null;
		Statement statement = null; 
		Statement statement1=null;
		ResultSet rs = null;
		ResultSet rs1=null;
		
		
		try {
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/neumann?serverTimezone=CET&useSSL=FALSE", "root", "Current-Root-Password");
			statement = connection.createStatement();
		
			statement1=connection.createStatement();
			rs = statement.executeQuery("SELECT id, email, telefono, cognome, nome, note FROM contatti ORDER BY nome");
			rs1=statement1.executeQuery("SELECT id, email, telefono, cognome, nome, note FROM contatti ORDER BY cognome");
			
			System.out.println("avvio scanner...");
			
			Scanner s = new Scanner(System.in);
			String st = s.next();
		
			if(st.equalsIgnoreCase("nome"))
			{
				while (rs.next()) {
					
					System.out.println("id : " + rs.getInt("id"));
					System.out.println("cognome : " + rs.getString("cognome"));
					System.out.println("nome : " + rs.getString("nome"));
					System.out.println("email : " + rs.getString("email"));
					System.out.println("telefono : " + rs.getString("telefono"));
					System.out.println("note : " + rs.getString("note"));
					System.out.println("--------");
				
				}
				s.close();
			}

			
			if(st.equalsIgnoreCase("cognome"))
			{
				while (rs1.next()) {
					
					System.out.println("id : " + rs1.getInt("id"));
					System.out.println("cognome : " + rs1.getString("cognome"));
					System.out.println("nome : " + rs1.getString("nome"));
					System.out.println("email : " + rs1.getString("email"));
					System.out.println("telefono : " + rs1.getString("telefono"));
					System.out.println("note : " + rs1.getString("note"));
					System.out.println("--------");
				
				}
				s.close();
			}
			
			
			
			
			
		}catch(SQLException sql)
		{
			sql.printStackTrace();
		}	finally {
			try {
				rs.close();
				rs1.close();
				
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		}
			
				
	public static void cercaContatto() throws SQLException, ClassNotFoundException
	{
        Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connection = null;
		Statement statement = null; 
		ResultSet rs = null;
				
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/neumann?serverTimezone=CET", "root", "beije");
			
			statement = connection.createStatement();
			Scanner s=new Scanner(System.in);
			String st=s.next();
			
			
			
		}catch(SQLException sql)
		{
			sql.printStackTrace();
		}finally
		{
			rs.close();
		}
			
		
	}
	
	
	
	public static void main (String [] args) throws ClassNotFoundException, SQLException
	{
		vediListaContatti();
	}

}
