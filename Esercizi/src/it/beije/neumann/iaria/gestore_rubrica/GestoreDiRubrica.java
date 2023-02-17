package it.beije.neumann.iaria.gestore_rubrica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class GestoreDiRubrica {
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/neumann?serverTimezone=CET&useSSL=false", "root", "beije2023");
	}
	
	//Metodo che legge db
	public void vediListaContatti() throws ClassNotFoundException, SQLException {

		Connection connection = null;
		Statement statement = null; 
		ResultSet rs = null;
				
		try {
			connection = getConnection();
			statement = connection.createStatement();
		
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT id, email, telefono, cognome, nome, note FROM contatti");
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				System.out.println("id : " + rs.getInt("id"));
				System.out.println("cognome : " + rs.getString("cognome"));
				System.out.println("nome : " + rs.getString("nome"));
				System.out.println("email : " + rs.getString("email"));
				System.out.println("telefono : " + rs.getString("telefono"));
				System.out.println("note : " + rs.getString("note"));
				System.out.println("------------------");
			}
			
		} catch (ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace(); 
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
	
	//Metodo che cerca contatto corrispondente
	public String cercaContatto() throws ClassNotFoundException, SQLException {
		
		String stringaContatto = "Esito: ";
		String contattoTrovato = "";
		int riga = 0;
		int count = 0;
		boolean confronto;
		
		Connection connection = null;
		Statement statement = null; 
		ResultSet rs = null;
		ResultSet rs2 = null;
		
		System.out.println("Inserisci i dati da cercare:");
		Scanner s = new Scanner(System.in);	
		System.out.println("Nome:");
		String nomeScanner = s.nextLine();
		System.out.println("Cognome:");
		String cognomeScanner = s.nextLine();
		
		try {
			connection = getConnection();
			statement = connection.createStatement();
			
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM contatti");
			rs = preparedStatement.executeQuery();
			while (rs.next()) {
				riga++;//Conteggio le rige ogni iterazione per poi stampare la corrispondente
				
				//Confronta i fields
				if(!nomeScanner.isEmpty() && !cognomeScanner.isEmpty()) { //Se il nome ed il cognome non sono nulli
					if(nomeScanner.contains(rs.getString("nome")) && cognomeScanner.contains(rs.getString("cognome"))) { //E contiene corrispondente del db
						PreparedStatement preparedStatement2 = connection.prepareStatement("SELECT * FROM contatti WHERE nome = ? AND cognome = ?");
						rs2 = preparedStatement.executeQuery();
						while (rs.next()) {
							System.out.println("id : " + rs2.getInt("id"));
							System.out.println("cognome : " + rs2.getString("cognome"));
							System.out.println("nome : " + rs2.getString("nome"));
							System.out.println("email : " + rs2.getString("email"));
							System.out.println("telefono : " + rs2.getString("telefono"));
							System.out.println("note : " + rs2.getString("note"));
							System.out.println("------------------");
						}
					} else {
						System.out.println(count);
						count = 0; //Altrimenti count=0, è inutile verificare gli altri
					}
				} else if(nomeScanner.isEmpty() || cognomeScanner.isEmpty()){
					count++; //Aumento il conteggio anche se UNA stringa è vuota (la considero come corrispondenza da non cercare)
				} else if(nomeScanner.isEmpty() && cognomeScanner.isEmpty()) {
					System.out.println("Non puoi lasciare entrambi i campi vuoti!");
					break;
				}
				
				//Ad ogni iterazione vedo se c'è corrispondenza (cioè count = 2) altrimenti reset di count
				if(count>1) {
					contattoTrovato = "Contatto trovato alla riga "+riga;
				} else {
					count = 0;		
				}
							
				/*Se alla fine del ciclo, la Stringa "contattoTrovato" è vuota, vuol dire che non c'è stata corrispondenza
				quindi stampa "Nessuna corrispondenza trovata"*/
				if(contattoTrovato.isEmpty()) {
					contattoTrovato = "Nessuna corrispondenza trovata";
				}
				
			}
		} catch (ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace(); 
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			try {
				rs.close();
				rs2.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return contattoTrovato;
	}
	
	//Metodo che chiede all'utente i dati per creare un nuovo contatto e lo inserisce nel db
	public void creaNuovoContatto() throws ClassNotFoundException, SQLException{
		
		Connection connection = null;
		Statement statement = null; 
		
		try {
			connection = getConnection();
			statement = connection.createStatement();
		
			System.out.println("Inserisci il contatto:");
			Scanner s = new Scanner(System.in);
			
			Contatto contattoInput = new Contatto();
			
			System.out.print("Nome: ");
			contattoInput.setName(s.nextLine());
			
			System.out.print("Cognome: ");
			contattoInput.setSurname(s.nextLine());
			
			System.out.print("Telefono: ");
			contattoInput.setTelephone(s.nextLine());
			
			System.out.print("Email: ");
			contattoInput.setEmail(s.nextLine());
				
			System.out.print("Note: ");
			contattoInput.setNote(s.nextLine());
				
			System.out.println("Contatto salvato con successo!");
			
			//INSERT
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO contatti(nome, cognome, telefono, email, note) VALUES (?, ?, ?, ?, ?)");//('" + contattoInput.getName() + "', '" + contattoInput.getSurname() + "', '" + contattoInput.getTelephone() + "', '" + contattoInput.getEmail() + "', '" + contattoInput.getNote() + "')");
			preparedStatement.setString(1, contattoInput.getName());
			preparedStatement.setString(2, contattoInput.getSurname());
			preparedStatement.setString(3, contattoInput.getTelephone());
			preparedStatement.setString(4, contattoInput.getEmail());
			preparedStatement.setString(5, contattoInput.getNote());
			int row = preparedStatement.executeUpdate();
			
			//UPDATE IN CASO DI VALORI VUOTI
			preparedStatement = connection.prepareStatement("UPDATE contatti set nome = case when nome in('null','') then null else nome end, cognome = case when cognome in('null','') then null else cognome end, telefono = case when telefono in('null','') then null else telefono end, email = case when email in('null','') then null else email end, note = case when note in('null','') then null else note end");
			row = preparedStatement.executeUpdate();
			
		} catch (ClassNotFoundException cnfEx) {
			cnfEx.printStackTrace(); 
		} catch (SQLException sqlEx) {
			sqlEx.printStackTrace();
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	//Metodo che modifica un contatto
	public void modificaContatto(String pathFile, String separator) throws FileNotFoundException, IOException, ClassNotFoundException{
//		List<Contatto> contatti = new ArrayList<Contatto>();
//		FileReader fileReader = new FileReader(pathFile);
//		BufferedReader bufferedReader = new BufferedReader(fileReader);
//		
//		int numeroRigaWhile = 0;
//		vediListaContatti();
//		System.out.println("Inserisci il numero corrispondente alla riga da modificare: ");
//		Scanner s = new Scanner(System.in);
//		int numeroRigaScanner = s.nextInt();
//		System.out.println();
//		
//		try {
//			
//			String r = null;
//			String[] fields = null;
//			Contatto contatto = null;
//			
//			//Lista con solo il nuovo contatto da inserire
//			List<Contatto> contattiCSV = creaNuovoContatto();
//			System.out.println();
//			
//			//Per ogni riga leggi e inserisci i dati nella lista
//			while (bufferedReader.ready()) {
//				r = bufferedReader.readLine();
//				fields = r.split(separator);
//				contatto = new Contatto();
//				
//				if(numeroRigaWhile == numeroRigaScanner) {
//					for (Contatto persona : contattiCSV) {
//						contatto.setNome(persona.getNome());
//						contatto.setCognome(persona.getCognome());
//						contatto.setNote(persona.getNote());
//						contatto.setTelefono(persona.getTelefono());
//					}
//				} else {
//					//Aggiungi i fields
//					contatto.setNome(fields[0]);
//					contatto.setCognome(fields[1]);
//					contatto.setNote(fields[2]);
//					contatto.setTelefono(fields[3]);
//				}
//	            contatti.add(contatto);
//	            numeroRigaWhile++;
//			} 
//			//Fine lettura
//			//Una volta aggiornati i dati li riscriviamo sul file
//			sovrascriviContatti(contatti,pathFile,separator);
//			System.out.println("Contatti dopo l'aggiornamento: ");
//			vediListaContatti();
//			System.out.println();
//			
//		} catch (IOException ioEx) {
//			ioEx.printStackTrace();
//			throw ioEx;
//		} finally {
//			bufferedReader.close();
//		}
//		
//		return contatti;
	}
	
	//Metodo per scrivere un nuovo contatto (append)
	public void scriviContatto(List<Contatto> contatti, String pathFile, String separator) throws FileNotFoundException, IOException{
	/*	File rubrica = new File(pathFile);
		FileWriter fileWriter = new FileWriter(pathFile, true);
		
		try {
			
			for (Contatto persona : contatti) {
				fileWriter.write(persona.getNome() + separator);
				fileWriter.write(persona.getCognome() + separator);
				fileWriter.write(persona.getNote() + separator);
				fileWriter.write(persona.getTelefono() + "\n");
			}

		} catch (IOException ioEx) {
			ioEx.printStackTrace();
			throw ioEx;
		} finally {
			fileWriter.close(); //Chiudo il file per salvare modifiche
		}
	}
	
	//Metodo per sovrascrivere il file (nel caso di modifica o rimozione di un contatto)
	public void sovrascriviContatti(List<Contatto> contatti, String pathFile, String separator) throws FileNotFoundException, IOException{
		File rubrica = new File(pathFile);
		FileWriter fileWriter = new FileWriter(pathFile);
		
		try {
			
			for (Contatto persona : contatti) {
				fileWriter.write(persona.getNome() + separator);
				fileWriter.write(persona.getCognome() + separator);
				fileWriter.write(persona.getNote() + separator);
				fileWriter.write(persona.getTelefono() + "\n");
			}

		} catch (IOException ioEx) {
			ioEx.printStackTrace();
			throw ioEx;
		} finally {
			fileWriter.close(); //Chiudo il file per salvare modifiche
		}
	}
	

	//Metodo che elimina un contatto
	public void eliminaContatto(String pathFile, String separator) throws FileNotFoundException, IOException, ClassNotFoundException{
//		List<Contatto> contatti = new ArrayList<Contatto>();
//		FileReader fileReader = new FileReader(pathFile);
//		BufferedReader bufferedReader = new BufferedReader(fileReader);
//		
//		int numeroRigaWhile = 0;
//		vediListaContatti();
//		System.out.println("Inserisci il numero corrispondente alla riga da eliminare: ");
//		Scanner s = new Scanner(System.in);
//		int numeroRigaScanner = s.nextInt();
//		System.out.println();
//		
//		try {
//			
//			String r = null;
//			String[] fields = null;
//			Contatto contatto = null;
//			
//			//Per ogni riga leggi e inserisci i dati nella lista
//			while (bufferedReader.ready()) {
//				r = bufferedReader.readLine();
//				fields = r.split(separator);
//				contatto = new Contatto();
//				
//				if(numeroRigaWhile == numeroRigaScanner) {
//					numeroRigaWhile++; //Se ci troviamo nella riga da eliminare, saltiamo all'iterazione successiva
//				} else {
//					//Aggiungi i fields
//					contatto.setNome(fields[0]);
//					contatto.setCognome(fields[1]);
//					contatto.setNote(fields[2]);
//					contatto.setTelefono(fields[3]);
//					contatti.add(contatto);
//					numeroRigaWhile++;
//				}
//			} 
//			//Fine lettura
//			//Una volta aggiornati i dati li riscriviamo sul file
//			sovrascriviContatti(contatti,pathFile,separator);
//			System.out.println();
//			System.out.println("Contatti dopo l'aggiornamento: ");
//			vediListaContatti();
//			System.out.println();
//			
//		} catch (IOException ioEx) {
//			ioEx.printStackTrace();
//			throw ioEx;
//		} finally {
//			bufferedReader.close();
//		}
//		
//		return contatti;
	}
	
	//Metodo che trova duplicati
	public void trovaDuplicati(String pathFile, String separator) throws FileNotFoundException, IOException{
		/*List<Contatto> contatti = new ArrayList<Contatto>();
		List<Contatto> contattiTrovati = new ArrayList<Contatto>();
		ArrayList<Integer> deleteDuplicati = new ArrayList<Integer>();
		FileReader fileReader = new FileReader(pathFile);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		int rigaLetta = 0;
		int contattoLetto = 0;
		
		System.out.println("Contatti: ");
		/List<Contatto> contattiLetti = vediListaContatti(pathFile,separator);
		System.out.println();
		
		try {
			
			String r = null;
			String[] fields = null;
			Contatto contatto = null;
			
			//Per ogni riga
			while (bufferedReader.ready()) {
				r = bufferedReader.readLine();
				fields = r.split(separator);
				rigaLetta++;
				
				if(rigaLetta != 1) {
					//Aggiungi i fields
					contatto = new Contatto();
					contatto.setNome(fields[0]);
					contatto.setCognome(fields[1]);
					contatto.setNote(fields[2]);
					contatto.setTelefono(fields[3]);
					for(Contatto contattiL : contattiLetti) {
						contattoLetto++;
						if(contattoLetto != rigaLetta - 1 && contattiL != null) { //Per non rileggere la stessa riga di contatto con contattiL
							if(contatto.getNome().contains(contattiL.getNome()) && contatto.getCognome().contains(contattiL.getCognome())) {
								contattiTrovati.add(contattiL); //Se trova contatti simili, crea una nuova lista solo con i contatti simili
								System.out.println(rigaLetta-1 + " nome letto: "+contattoLetto);
								contattiLetti.set(rigaLetta-1,null); //-2 perchè inizia da Giovanni che è indice 0
							}
						}
					} if(!contattiTrovati.isEmpty()) { //A questo punto se la lista di contatti simili non è vuota, stampali
						System.out.println("Trovati duplicati della riga: "+(rigaLetta-1)+":\n"
								 	+"Nome: "+contatto.getNome()
									+", Cognome: "+contatto.getCognome()
									+", Note: "+contatto.getNote()
									+", Telefono: "+contatto.getTelefono()); //-1 perché inizia da NOME-COGNOME... che è indice 0
						for(Contatto contattiT : contattiTrovati) {
							System.out.println("Nome: "+contattiT.getNome()
									+ ", Cognome: "+contattiT.getCognome()
									+ ", Note: "+contattiT.getNote()
									+ ", Telefono: "+contattiT.getTelefono()
									);
						}
					}
					
					contattiTrovati.clear();
					contattoLetto = 0;
				}
				
			}
			
		} catch (IOException ioEx) {
			ioEx.printStackTrace();
			throw ioEx;
		} finally {
			bufferedReader.close();
		}*/
	}
	
	//Metodo che unisce duplicati
		public void unisciDuplicati(String pathFile, String separator) throws FileNotFoundException, IOException{
			/*List<Contatto> contatti = new ArrayList<Contatto>();
			FileReader fileReader = new FileReader(pathFile);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			int rigaLetta = 0;
			int contattoLetto = 0;
			
			System.out.println("Contatti: ");
			List<Contatto> contattiLetti = vediListaContatti(pathFile,separator);
			System.out.println();
			
			try {
				
				String r = null;
				String[] fields = null;
				Contatto contatto = null;
				
				//Per ogni riga
				while (bufferedReader.ready()) {
					r = bufferedReader.readLine();
					fields = r.split(separator);
					rigaLetta++;
					
					if(rigaLetta != 1) {
						//Aggiungi i fields
						contatto = new Contatto();
						contatto.setNome(fields[0]);
						contatto.setCognome(fields[1]);
						contatto.setNote(fields[2]);
						contatto.setTelefono(fields[3]);
						for(Contatto contattiL : contattiLetti) {
							contattoLetto++;
							if(contattoLetto != rigaLetta - 1 && contattiL != null) { //Per non rileggere la stessa riga di contatto con contattiL
								if(contatto.getNome().contains(contattiL.getNome()) && contatto.getCognome().contains(contattiL.getCognome())) {
									System.out.println("Trovati duplicati alla riga: "+(rigaLetta-1)+" e "+contattoLetto+", i dati sono:\n "  //-1 perché inizia da NOME-COGNOME... che è indice 0
											+ "Nome: "+contatto.getNome()
											+", Cognome: "+contatto.getCognome()
											+", Note: "+contatto.getNote()
											+", Telefono: "+contatto.getTelefono()+"\n "
											+ "Nome: "+contattiL.getNome()
											+ ", Cognome: "+contattiL.getCognome()
											+ ", Note: "+contattiL.getNote()
											+ ", Telefono: "+contattiL.getTelefono()
											);
									contattiLetti.set(rigaLetta-2,null); //-2 perchè inizia da Giovanni che è indice 0
								}
							}
						}
						contattoLetto = 0;
					}
					
				}
				
			} catch (IOException ioEx) {
				ioEx.printStackTrace();
				throw ioEx;
			} finally {
				bufferedReader.close();
			}*/
		}
	
	public static void main(String[] args) throws ClassNotFoundException, FileNotFoundException, IOException, ParserConfigurationException, SAXException, SQLException {
		String pathForCSV = "/Users/gianf/Desktop/contatti.csv";
		String pathForXml = "/Users/gianf/Desktop/rubrica.xml";
		String separator = "-";
		int scelta = 0;
		GestoreDiRubrica gestoreRubrica = new GestoreDiRubrica();
		
		System.out.println("Azioni che è possibile svolgere:");
		System.out.println("- Inserisci 1 per vedere la lista contatti \n- Inserisci 2 per cercare il contatto \n- Inserisci 3 per inserire un nuovo contatto \n- Inserisci 4 per modificare un contatto \n- Inserisci 5 per cancellare un contatto \n- Inserisci 6 per cercare un duplicato \n- Inserisci 7 per unire un duplicato \n- Inserisci 8 per uscire");
		System.out.println("Inserisci il numero corrispondente per avviare l'azione desiderata:");
		Scanner s = new Scanner(System.in);
		scelta = s.nextInt(); //Prendo il valore inserito dall'utente
		System.out.println();
		
		if(scelta <= 0 || scelta > 8) {
			System.out.println("Scelta non presente");
			gestoreRubrica.main(args); //Se non è presente rilancia il programma
		} else {
			switch(scelta) {
				case 1:
					gestoreRubrica.vediListaContatti(); //Se 1 chiama metodo che fa visualizzare i contatti
					System.out.println();
					gestoreRubrica.main(args); //Richiama il programma così si può continuare ad usare, dato che l'utente non ha ancora fatto l'exit
					break;
				case 2:
					String risultato = gestoreRubrica.cercaContatto();
					System.out.println(risultato);
					System.out.println();
					gestoreRubrica.main(args);
					break;
				case 3:
					gestoreRubrica.creaNuovoContatto();
					System.out.println();
					gestoreRubrica.main(args);
					break;
				case 4:
					//gestoreRubrica.modificaContatto();
					gestoreRubrica.main(args); //Richiama il programma così si può continuare ad usare, dato che l'utente non ha ancora fatto l'exit
					break;
				case 5:
					//gestoreRubrica.eliminaContatto();
					gestoreRubrica.main(args);
					break;
				case 6:
					//gestoreRubrica.trovaDuplicati();
					System.out.println();
					gestoreRubrica.main(args);
					break;
				case 7:
					//gestoreRubrica.unisciDuplicati();
					System.out.println();
					gestoreRubrica.main(args);
					break;
				case 8:
					System.out.println("Programma terminato");
					break; //Ferma il programma per l'exit
					
			}
		}
		
	
	
	}

}
