package nicole;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/neumann?serverTimezone=CET", "root", "Current-Root-Password");
	}
	
	
	
	
	
	
	
	public static void vediListaContatti() throws ClassNotFoundException, SQLException
	{
        Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connection = null;
		//Statement statement = null; 
		//Statement statement1=null;
		ResultSet rs1 = null;
		ResultSet rs2=null;
		
		
		try {
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/neumann?serverTimezone=CET&useSSL=FALSE", "root", "Current-Root-Password");
			//statement = connection.createStatement();
		
			PreparedStatement statement1= connection.prepareStatement("SELECT id, email, telefono, cognome, nome, note FROM contatti ORDER BY nome");
			PreparedStatement statement2= connection.prepareStatement("SELECT id, email, telefono, cognome, nome, note FROM contatti ORDER BY cognome");
			//statement1=connection.createStatement();
			//rs = statement.executeQuery("SELECT id, email, telefono, cognome, nome, note FROM contatti ORDER BY nome");
			//rs1=statement1.executeQuery("SELECT id, email, telefono, cognome, nome, note FROM contatti ORDER BY cognome");
			rs1=statement1.executeQuery();
			rs2=statement2.executeQuery();
			System.out.println("avvio scanner...");
			
			Scanner s = new Scanner(System.in);
			String st = s.next();
		
			if(st.equalsIgnoreCase("nome"))
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

			
			if(st.equalsIgnoreCase("cognome"))
			{
				while (rs2.next()) {
					
					System.out.println("id : " + rs2.getInt("id"));
					System.out.println("cognome : " + rs2.getString("cognome"));
					System.out.println("nome : " + rs2.getString("nome"));
					System.out.println("email : " + rs2.getString("email"));
					System.out.println("telefono : " + rs2.getString("telefono"));
					System.out.println("note : " + rs2.getString("note"));
					System.out.println("--------");
				
				}
				s.close();
			}
			
			
			
			
			
		}catch(SQLException sql)
		{
			sql.printStackTrace();
		}	finally {
			try {
				rs1.close();
				rs2.close();
				
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
		//Statement statement = null; 
		ResultSet rs = null;
				
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/neumann?serverTimezone=CET&useSSL=FALSE", "root", "Current-Root-Password");
			
			PreparedStatement prep= connection.prepareStatement("SELECT id,nome,cognome,telefono,email,note FROM contatti WHERE nome= ? AND cognome=? ");
			
			
			System.out.print("Avvio Scanner... ");
			Scanner s=new Scanner(System.in);
			String st=s.next();
			String nomeContatto = null;
			String cognomeContatto = null;
			
		while(!st.equalsIgnoreCase("exit"))
		{
		
			System.out.print("Inserisci nome contatto: ");
			nomeContatto=s.next();
			prep.setString(1, nomeContatto);
			
			
			System.out.println("Inserisci cognome contatto : ");
			cognomeContatto=s.next();
			prep.setString(2, cognomeContatto);
			
			rs=prep.executeQuery();
			
			while (rs.next()) {
				
				System.out.println("id : " + rs.getInt("id"));
				System.out.println("cognome : " + rs.getString("cognome"));
				System.out.println("nome : " + rs.getString("nome"));
				System.out.println("email : " + rs.getString("email"));
				System.out.println("telefono : " + rs.getString("telefono"));
				System.out.println("note : " + rs.getString("note"));
				System.out.println("--------");
			}
			break;
			
		}
		s.close();
			
		}catch(SQLException sql)
		{
			sql.printStackTrace();
		}finally
		{
			rs.close();
			
			connection.close();
		}
			
		
	}
	
	/**
	 * metodo che prende l'id del contatto dato a riga di comando e lo elimina dai contatti
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void cancellaContatto() throws ClassNotFoundException, SQLException
	{
		  Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection connection = null;
			ResultSet rs = null;
			int rs1=0;
			try {
				
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/neumann?serverTimezone=CET&useSSL=FALSE", "root", "Current-Root-Password");
				
				PreparedStatement statement1= connection.prepareStatement("SELECT id FROM contatti WHERE nome=?  and cognome=? ");
				
				
				
				//Creo uno Scanner per far inserire da linea di comando il nome e il cognome

				System.out.print("Avvio scanner...");
				Scanner s=new Scanner(System.in);
				String nomeContatto=null;
				String cognomeContatto=null;
				String st=s.next();
				int id=0;
				while(!st.equalsIgnoreCase("exit"))
				{
				
					System.out.print("Inserisci nome contatto: ");
					nomeContatto=s.next();
					statement1.setString(1, nomeContatto);
					
					
					System.out.println("Inserisci cognome contatto : ");
					cognomeContatto=s.next();
					statement1.setString(2, cognomeContatto);
					
					rs=statement1.executeQuery();
					
					while(rs.next())
					{
						
						id=rs.getInt("id");
						System.out.println("Sto eliminando il contatto con id= "+id);
					}
					
					break;
				}
				s.close();
				
				
				PreparedStatement statement2= connection.prepareStatement("DELETE FROM contatti WHERE id='"+id+"'");
				rs1=statement2.executeUpdate();
				
				
			}catch(SQLException sql)
			{
				sql.printStackTrace();
			}finally {
				rs.close();
				connection.close();
			}
	}
	
	
	public static void trovaContattiDuplicati() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		//Connection connection=null;
		
		//PreparedStatement statement =null;
		
	
		List<Contatto> contatti= ContattiJDBC.importContactsFromDB();
	    List<Contatto> duplicati=new ArrayList<>();
	    //List<Integer> idDuplicati=new ArrayList<>();
		int conta=1;
		//int rows=0;
		
		for(Contatto c : contatti)
		{
			for(int i=conta; i<contatti.size();i++)
			{
				if(c.getName().equals(contatti.get(i).getName()))
				{
					if(c.getSurname().equals(contatti.get(i).getSurname())) duplicati.add(contatti.get(i));
				}
				
			}
			conta++;
		}
	
		System.out.println(duplicati);
	
		
//		if(!(duplicati.isEmpty())) {
//		
//			for(Contatto c : duplicati)
//		{
//			idDuplicati.add(c.getId());
//		}
		
//		System.out.println(idDuplicati);
	
//		connection= getConnection();
		
		
		
		
		//Query per eliminare i duplicati da DB tramite id
		
			//for(int i=0;i<idDuplicati.size();i++) {
			//statement=connection.prepareStatement("DELETE FROM contatti WHERE id= '"+idDuplicati.get(i)+"'");
			//rows=statement.executeUpdate();
			//}
	}
	
		
			
		
		
		
		
		
	
	
	public static void unisciContattiDuplicati() throws SQLException, ClassNotFoundException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=null;
		
		PreparedStatement statement =null;
		
		try {
	
		List<Contatto> contatti= ContattiJDBC.importContactsFromDB();
	    List<Contatto> duplicati=new ArrayList<>();
	    List<Integer> idDuplicati=new ArrayList<>();
		int conta=1;
		int rows=0;
		
		for(Contatto c : contatti)
		{
			for(int i=conta; i<contatti.size();i++)
			{
				if(c.getName().equals(contatti.get(i).getName()))
				{
					if(c.getSurname().equals(contatti.get(i).getSurname())) {
						duplicati.add(contatti.get(i));
						duplicati.add(c);
					}
				}
				
			}
			conta++;
		}
	
		System.out.println(duplicati);
	
		
		
		
		}catch(SQLException sql)
		{
			sql.printStackTrace();
		}finally
		{
			connection.close();
		}
	}
	
	public static void main (String [] args) throws ClassNotFoundException, SQLException
	{
		//vediListaContatti();
		//cercaContatto();
		//cancellaContatto();
		
		
		unisciContattiDuplicati();
		//trovaContattiDuplicati();
	}

}
