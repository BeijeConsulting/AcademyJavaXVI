package it.beije.neumann.nicole.rubricajdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

/**
 * importo il metodo per inserire i contatti nell'arraylist
 * @author nverz
 *
 */
import it.beije.neumann.nicole.rubrica.*;

public class ContattiJDBC 
{
	/**
	 * Creo un metodo che legge i contatti da un file xml
	 * e poi li inserisce all'interno di un database
	 * @throws ClassNotFoundException 
	 * @throws TransformerException 
	 * @throws IOException 
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 */
	
	
	
	public static void insertContactsFromXML(String pathFile) throws ClassNotFoundException, SAXException, IOException, TransformerException, ParserConfigurationException
	{
        Class.forName("com.mysql.cj.jdbc.Driver");
		List<Contatto> contatti= new ArrayList<>();
		Connection connection = null;
		Statement statement = null; 
		ResultSet rs = null;
		
		XMLManager2.readRubricaXML(pathFile, contatti);
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/neumann?serverTimezone=CET", "root", "Current-Root-Password");
			statement = connection.createStatement();
			
			
			for (Contatto c : contatti)
			{
				
				statement.executeUpdate("INSERT INTO contatti(nome, cognome, telefono, email, note) VALUES ('" + c.getName() + "', '" + c.getSurname() + "', '"+c.getTelephone()+"', '"+ c.getEmail()+"','"+c.getNote()+"')");
			
				
			}
			
		}
		catch(SQLException sqlE)
		{
			sqlE.printStackTrace();
		}
		
	}
	
	
	/**
	 * Creo un metodo che legge i contatti da file csv e 
	 * li salva su un database
	 * @param pathFile
	 * @throws ClassNotFoundException
	 * @throws ParserConfigurationException
	 * @throws IOException
	 * @throws SAXException
	 */
	public static void insertContactsFromCSV(String pathFile) throws ClassNotFoundException, ParserConfigurationException, IOException, SAXException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		List<Contatto> contatti= CSVManager.readRubrica(pathFile);
		Connection connection = null;
		Statement statement = null; 
		ResultSet rs = null;
		
				try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/neumann?serverTimezone=CET", "root", "Current-Root-Password");
			statement = connection.createStatement();
			
			
			for (Contatto c : contatti)
			{
				
				statement.executeUpdate("INSERT INTO contatti(cognome, nome, telefono, email) VALUES ('" + c.getSurname() + "', '" + c.getName() + "', '"+c.getTelephone()+"', '"+ c.getEmail()+"')");
			
			
			}
			
		}
		catch(SQLException sqlE)
		{
			sqlE.printStackTrace();
		}
	}
	

	/**
	 * il metodo legge i contatti sul database rubrica e li salva in un file xml
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public static List<Contatto> importContactsFromDB() throws ClassNotFoundException, SQLException
	{
	
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = null;
	    ResultSet rs = null;
		List<Contatto> contatti=null;	
		try {
		
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/neumann?serverTimezone=CET&useSSL=FALSE", "root", "Current-Root-Password");
		
			PreparedStatement statement1=connection.prepareStatement("SELECT * FROM contatti");
			contatti=new ArrayList<>();
			
			rs=statement1.executeQuery();
			while (rs.next()) {
				
				Contatto c= new Contatto();
				
				c.setName(rs.getString("nome"));
				c.setSurname(rs.getString("cognome"));
				c.setEmail(rs.getString("email"));
				c.setTelephone(rs.getString("telefono"));
				c.setNote(rs.getString("note"));

				contatti.add(c);
				
				
			}
			//System.out.println(contatti);
		
		
		
		}catch(SQLException sqlEx) {
			sqlEx.printStackTrace();
			
		}finally {
			rs.close();
			connection.close();
		}
		
		return contatti;
		
	}
	
	
	
	
	
	
	
	public static void main(String [] args) throws ClassNotFoundException, SAXException, IOException, TransformerException, ParserConfigurationException, SQLException
	{
		insertContactsFromXML("C:\\Users\\nverz\\Music\\esercizio.\\rubrica.xml");
		//insertContactsFromCSV("C:\\Users\\nverz\\Music\\esercizio.\\rubrica.csv");
		
		//System.out.println(importContactsFromDB());
	}

}
