package it.beije.neumann.nido.gestorerubrica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RubricaDBManager implements RubricaQLManager {

	private static RubricaDBManager rubricaDBManager;

	private Connection connection = null;

	private final String URL = "jdbc:mysql://localhost:3306/neumann?serverTimezone=CET&useSSL=false";
	private final String USER = "root";
	private final String PSW = "Mary23BeijeSQL";

	private RubricaDBManager() {
	}

	public static RubricaDBManager getDBManager() {

		if (rubricaDBManager == null)
			rubricaDBManager = new RubricaDBManager();

		return rubricaDBManager;
	}

	private Connection openConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PSW);
	}

	private void closeConnection() throws SQLException {
		connection.close();
	}

	public void showRubrica(String orderBy, String onWhat) {
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
				contact.setTelephone(rs.getString("telephone"));
				contact.setEmail(rs.getString("email"));
				contact.setNote(rs.getString("note"));

				System.out.println(contact + "\n");

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

	public List<Contact> searchContact(String name, String surname) {

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

	public void addContact(Contact contact) {
		String queryInsert = "INSERT INTO rubricacompleta(surname, name, telephone, email, note) VALUES (?,?,?,?,?)";

		PreparedStatement prepStatement = null;

		try {
			connection = openConnection();
			prepStatement = connection.prepareStatement(queryInsert);

			prepStatement.setString(1, FilesUtils.formatPeakDB(contact.getSurname()));
			prepStatement.setString(2, FilesUtils.formatPeakDB(contact.getName()));
			prepStatement.setString(3, contact.getTelephone());
			prepStatement.setString(4, contact.getEmail());
			prepStatement.setString(5, FilesUtils.formatPeakDB(contact.getNote()));

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

	public void editContact(Contact contact) {
		String queryUpdate = "UPDATE rubricacompleta SET name=?, surname=?, telephone=?, email=?, note=? WHERE id=?";

		PreparedStatement prepStatement = null;
		ResultSet rs = null;

		try {
			connection = openConnection();
			prepStatement = connection.prepareStatement(queryUpdate);

			prepStatement.setString(1, contact.getName());
			prepStatement.setString(2, contact.getSurname());
			prepStatement.setString(3, contact.getTelephone());
			prepStatement.setString(4, contact.getEmail());
			prepStatement.setString(5, contact.getNote());

			prepStatement.setInt(6, contact.getId());

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

	public void deleteContact(Contact contact) {
		String deleteQuery = "DELETE FROM rubricacompleta WHERE id=?";

		PreparedStatement prepStatement = null;

		try {
			connection = openConnection();
			prepStatement = connection.prepareStatement(deleteQuery);

			prepStatement.setInt(1, contact.getId());

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

	public List<Contact> searchDuplicate() {
		List<Contact> duplicates = new ArrayList<>();

		String innerQuery = "SELECT surname, name FROM rubricacompleta GROUP BY surname, name HAVING COUNT(*)>1";
		String getDuplicateQuery = "SELECT * FROM rubricacompleta AS rc JOIN (" + innerQuery
				+ ") AS rd ON rc.name=rd.name AND rc.surname=rd.surname ORDER BY rc.surname ASC, rc.id ASC";

		PreparedStatement prepStatement = null;
		ResultSet rs = null;

		try {
			connection = openConnection();
			prepStatement = connection.prepareStatement(getDuplicateQuery);

			rs = prepStatement.executeQuery();

			while (rs.next()) {
				Contact dup = new Contact();

				dup.setId(rs.getInt("id"));
				dup.setSurname(rs.getString("surname"));
				dup.setName(rs.getString("name"));
				dup.setTelephone(rs.getString("telephone"));
				dup.setEmail(rs.getString("email"));
				dup.setNote(rs.getString("note"));

				duplicates.add(dup);
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

		return duplicates;
	}

	public void mergeDuplicate(Contact base, Contact dup) {
		String newVal = null;

		// Telephone
		if (!base.getTelephone().contains(dup.getTelephone())) {
			newVal = FilesUtils.formatNewField(base.getTelephone(), dup.getTelephone());
			base.setTelephone(newVal);
		}

		// Email
		if (!base.getEmail().contains(dup.getEmail())) {
			newVal = FilesUtils.formatNewField(base.getEmail(), dup.getEmail());
			base.setEmail(newVal);
		}

		// Note
		if (!base.getNote().contains(dup.getNote())) {
			newVal = FilesUtils.formatNewField(base.getNote(), dup.getNote());
			base.setNote(newVal);
		}

		this.deleteContact(dup);
		this.editContact(base);

	}
}
