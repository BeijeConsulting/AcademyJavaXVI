package it.beije.neumann.mercuri.eserciziMail8Feb;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class TransacReader {

	public static List<String> transacReader(String filePath)  throws FileNotFoundException {
		
		List<String> transactions = new ArrayList<>();
		FileReader fileReader = new FileReader(filePath);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		try {
						
			String transaction = null;
			String[] fields = null;
			
			double importoVendite = 0;
			double importoAcquisti = 0;
			int transCounter = 0;
			
			while (bufferedReader.ready()) {
				
				transCounter ++;				
				transaction = bufferedReader.readLine();				
				transactions.add(transaction);				
				fields = transaction.split(" " , -1);
				
				if (fields[3].equals("B"))
					importoAcquisti += Double.parseDouble(fields[1])* Double.parseDouble(fields[2]);
				else
					importoVendite += Double.parseDouble(fields[1])* Double.parseDouble(fields[2]);
			}
			
			System.out.println("Op: " + transCounter + " Buy: " + importoAcquisti + " Sell: " + importoVendite);
			
		} catch (IOException ioEx) {
			ioEx.printStackTrace();

		} finally {
			
			try {
				bufferedReader.close();
			}  
			catch (IOException ioEx) {
				ioEx.printStackTrace();
			}
		}
		
		return transactions;
	}
	public static void main(String[] args)  throws FileNotFoundException {

		List<String> transactions = transacReader("/temp/transactions.csv");
		
		for (String s: transactions) {
			System.out.println(s);
		}
	}

}
