package it.beije.neumann.nido.gestorerubrica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RubricaDBManager {

	private static RubricaDBManager rubricaDBManager;

	private static Connection connection = null;

	private static final String URL = "jdbc:mysql://localhost:3306/neumann?serverTimezone=CET&useSSL=false";
	private static final String USER = "root";
	private static final String PSW = "Mary23BeijeSQL";

	private RubricaDBManager() {
	}

	public static RubricaDBManager getDBManager() {

		if (rubricaDBManager == null)
			rubricaDBManager = new RubricaDBManager();

		return rubricaDBManager;
	}

	private static Connection openConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PSW);
	}

	private static void closeConnection() throws SQLException {
		connection.close();
	}

	public static void showRubrica(String orderBy, String onWhat) {
		PreparedStatement prepStatement = null;
		ResultSet rs = null;

		String querySelect = "SELECT * FROM rubricacompleta ORDER BY " + onWhat + " " + orderBy;

		try {
			connection = openConnection();

			// Preparazione query
			prepStatement = connection.prepareStatement(querySelect);

			rs = prepStatement.executeQuery();

			while (rs.next()) {
				Contact contact = new Contact();

				contact.setId(rs.getInt("id"));
				contact.setSurname(rs.getString("surname"));
				contact.setName(rs.getString("name"));
				contact.setAge(rs.getInt("age"));
				contact.setTelephone(rs.getString("telephone"));
				contact.setEmail(rs.getString("email"));
				contact.setNote(rs.getString("note"));

				System.out.println(contact);

			}

		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			try {
				rs.close();
				prepStatement.close();
				closeConnection();
			} catch (SQLException sqlEx2) {
				sqlEx2.printStackTrace();
			}

		}
	}

	public static List<Contact> searchContact(String name, String surname) {

		List<Contact> contactsFound = new ArrayList<>();

		PreparedStatement prepStatement = null;
		ResultSet rs = null;

		String querySelect = "SELECT * FROM rubricacompleta ";

		try {
			connection = openConnection();

			if (!surname.isEmpty() && !name.isEmpty()) {
				querySelect += "WHERE name=? AND surname=?";
				prepStatement = connection.prepareStatement(querySelect);
				prepStatement.setString(1, name);
				prepStatement.setString(2, surname);
			} else if (!surname.isEmpty()) {
				querySelect += "WHERE surname=?";
				prepStatement = connection.prepareStatement(querySelect);
				prepStatement.setString(1, surname);
			} else if (!name.isEmpty()) {
				querySelect += "WHERE name=?";
				prepStatement = connection.prepareStatement(querySelect);
				prepStatement.setString(1, name);
			}

			rs = prepStatement.executeQuery();

			while (rs.next()) {
				Contact contact = new Contact();

				contact.setId(rs.getInt("id"));
				contact.setSurname(rs.getString("surname"));
				contact.setName(rs.getString("name"));
				contact.setAge(rs.getInt("age"));
				contact.setTelephone(rs.getString("telephone"));
				contact.setEmail(rs.getString("email"));
				contact.setNote(rs.getString("note"));

				contactsFound.add(contact);
			}

		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			try {
				rs.close();
				prepStatement.close();
				closeConnection();
			} catch (SQLException sqlEx2) {
				sqlEx2.printStackTrace();
			}

		}

		return contactsFound;
	}

	public static void addContact(Contact contact) {
		String queryInsert = "INSERT INTO rubricacompleta(surname, name, age, telephone, email, note) VALUES (?,?,?,?,?,?)";

		PreparedStatement prepStatement = null;
		ResultSet rs = null;

		try {
			connection = openConnection();
			prepStatement = connection.prepareStatement(queryInsert);

			prepStatement.setString(1, FilesUtils.formatPeakDB(contact.getSurname()));
			prepStatement.setString(2, FilesUtils.formatPeakDB(contact.getName()));
			prepStatement.setInt(3, contact.getAge());
			prepStatement.setString(4, contact.getTelephone());
			prepStatement.setString(5, contact.getEmail());
			prepStatement.setString(6, FilesUtils.formatPeakDB(contact.getNote()));

			prepStatement.executeUpdate();

		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			try {
				prepStatement.close();
				closeConnection();
			} catch (SQLException sqlEx2) {
				sqlEx2.printStackTrace();
			}
		}
	}

	/*
	 * System.out.println("4.Modifica un contatto esistente");
	 * System.out.println("5.Cancella un contatto");
	 * System.out.println("6.Trova duplicati");
	 * System.out.println("7.Unisci duplicati");
	 */

	public static void editContact(String name, String surname) {
		String queryUpdate = "UPDATE contatti SET note = 'siamo Bianchi' WHERE cognome = 'Bianchi'";
		// Se ci sono più corrispondenze, vai su id
		System.out.println("editContact() on its way for implementation");
	}

	public static void deleteContact() {
		System.out.println("deleteContact() on its way for implementation");
	}

	public static void searchDuplicate() {
		System.out.println("searchDuplicate() on its way for implementation");
	}

	public static void mergeDuplicate() {
		System.out.println("mergeDuplicate() on its way for implementation");
	}

}
