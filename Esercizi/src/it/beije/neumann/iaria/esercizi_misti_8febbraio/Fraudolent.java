package it.beije.neumann.iaria.esercizi_misti_8febbraio;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import it.beije.neumann.iaria.rubrica.Contatto;
import it.beije.neumann.iaria.rubrica.LoadWriteCsvXml;

public class Fraudolent {
	int nn = 0;
	int bb = 0;
	int ss = 0;
	
	public List<Agent> loadFraudolentCSV(String pathFile, String separator) throws FileNotFoundException, IOException{
		List<Agent> agenti = new ArrayList<Agent>();
		FileReader fileReader = new FileReader(pathFile);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		try {

			String r = null;
			String[] fields = null;
			Agent agente = null;
			
			//Per ogni riga
			while (bufferedReader.ready()) {
				nn++; //Per contare le operazioni
				r = bufferedReader.readLine();
				fields = r.split(separator);
				
				//Aggiungi i fields
				agente = new Agent();
				agente.setAction(fields[0]);
				agente.setAmount(fields[1]);
				agente.setQuantity(fields[2]);
				agente.setOperation(fields[3]);
				
				if(fields[3].equals("B")) {
					bb++;
				} else if(fields[3].equals("S")) {
					ss++;
				}
					
				agenti.add(agente);
				
				//Ogni iterazione stampo i contatti e le varie operazioni
				System.out.println(agente);
				System.out.println("Op: "+(nn)+" Buy: "+(bb)+" Sell: "+(ss));
			}
			
		} catch (IOException ioEx) {
			ioEx.printStackTrace();
			throw ioEx;
		} finally {
			bufferedReader.close();
		}
		
		return agenti;
	}
	

	public static void main(String[] args) throws FileNotFoundException, IOException{
		Fraudolent fraudolent = new Fraudolent();
		String path = "/Users/gianf/Desktop/Fraudolent.csv";
		
		fraudolent.loadFraudolentCSV(path," ");
	}

}
