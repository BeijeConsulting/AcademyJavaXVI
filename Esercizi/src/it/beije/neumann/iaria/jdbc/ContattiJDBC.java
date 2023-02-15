package it.beije.neumann.iaria.jdbc;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.beije.neumann.iaria.rubrica.Contatto;

public class ContattiJDBC {
	
	//Metodo che legge db
	public static void leggiContatti() throws ClassNotFoundException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connection = null;
		Statement statement = null; 
		ResultSet rs = null;
				
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/neumann?serverTimezone=CET&useSSL=false", "root", "beije2023");
			statement = connection.createStatement();
		
			rs = statement.executeQuery("SELECT id, email, telefono, cognome, nome, note FROM contatti");
			while (rs.next()) {
				System.out.println("id : " + rs.getInt("id"));
				System.out.println("cognome : " + rs.getString("cognome"));
				System.out.println("nome : " + rs.getString("nome"));
				System.out.println("email : " + rs.getString("email"));
				System.out.println("telefono : " + rs.getString("telefono"));
				System.out.println("note : " + rs.getString("note"));
				System.out.println("--------");
			}
			
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			try {
				rs.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	//Metodo che importa il file csv su db
	public static void importaContattiCSV(String pathfile) throws FileNotFoundException, IOException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = null;
		Statement statement = null; 
		ResultSet rs = null;
		int righeInserite = 0;
		
		FileReader fileReader = new FileReader(pathfile);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		try {
			String r = null;
			String[] fields = null;
			Contatto contatto = null;
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/neumann?serverTimezone=CET&useSSL=false", "root", "beije2023");			
			statement = connection.createStatement();
			
			while (bufferedReader.ready()) {
				r = bufferedReader.readLine();
				fields = r.split(";");
				
				righeInserite++;
				contatto = new Contatto();
				contatto.setSurname(fields[0]);
				contatto.setName(fields[1]);
				contatto.setTelephone(fields[2]);
				contatto.setEmail(fields[3]);
				contatto.setNote(fields[4]);	
				
				//Se si trova alla seconda riga (quindi salto NOME;COGNOME;TELEFONO;EMAIL;NOTE)
				if(righeInserite > 1) {
					//INSERT
					statement.executeUpdate("INSERT INTO contatti(nome, cognome, telefono, email, note) VALUES ('" + contatto.getName() + "', '" + contatto.getSurname() + "', '" + contatto.getTelephone() + "', '" + contatto.getEmail() + "', '" + contatto.getNote() + "')");
				}
				
				//UPDATE
				/*statement.executeUpdate("UPDATE contatti SET nome = NULL WHERE nome = ''");
				statement.executeUpdate("UPDATE contatti SET cognome = NULL WHERE cognome = ''");
				statement.executeUpdate("UPDATE contatti SET telefono = NULL WHERE telefono = ''");
				statement.executeUpdate("UPDATE contatti SET email = NULL WHERE email = ''");
				statement.executeUpdate("UPDATE contatti SET note = NULL WHERE note = ''");*/
				statement.executeUpdate("UPDATE contatti set nome = case when nome in('null','') then null else nome end, cognome = case when cognome in('null','') then null else cognome end, telefono = case when telefono in('null','') then null else telefono end, email = case when email in('null','') then null else email end, note = case when note in('null','') then null else note end");
				
			}
			
			//Salto NOME;COGNOME;TELEFONO;EMAIL;NOTE togliendo 1 da righeInserite che contiene il numero di cicli effettuati
			System.out.println("Sono state inserite "+ (righeInserite-1) +" righe");
			
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} catch (IOException ioEx) {
			ioEx.printStackTrace();
			throw ioEx;
		} finally {
			bufferedReader.close();
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
	}

	//Metodo che importa il file xml su db
	public static void importaContattiXML(String pathfile) throws FileNotFoundException, IOException, ClassNotFoundException {
		//
	}
	
	public static void main(String[] args) throws ClassNotFoundException, FileNotFoundException, IOException {
		
		String pathfile = "/Users/gianf/Desktop/rubrica.csv";
		//importaContattiCSV(pathfile);
		leggiContatti();
				


	}

}