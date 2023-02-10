/*
 * Gli agenti di borsa della banca Fraudolent compiono operazioni
 * finanziare quotidianamente ed annotano le operazioni su un file,
 * nel seguente formato: “ABC 50.0 210 B”, dove
 * - “ABC” è il nome dell’azione acquistata/venduta
 * - 50.0 è l’importo della singola azione
 * - 210 è la quantità
 * - ‘B’ è l’operazione, che può valere ‘B’ (Buy) o ‘S’ (Sell)
 * 
 * Si vuole quindi un programma che:
 * - legga il file inviato dagli agenti e lo restituisca come array (o List) di stringhe
 * - per ogni riga calcoli l’importo dell’operazione ed alla fine produca una semplice riga:
 * 		“Op: (nn) Buy: (bb) Sell: (ss)”
 * 	 dove al posto di (nn) ho ul numero di operazioni lette, al posto di (bb) l’importo totale
 * 	 delle operazioni di acquisto ed in (ss) l’importo totale delle operazioni di vendita.
 * 
 * Complicazione (opzionale):
 * alcuni agenti commettono errori nello scrivere il file, pertanto alcune righe potranno
 * non rispondere allo standard (che è molto rigido!). Le righe “sbagliate” non vanno considerate,
 * ma vanno elencate alla fine del processo, dopo la riga di output del programma, in questo modo:
 * 		Op: (nn) Buy: (bb) Sell: (ss)
 * 		Err: (ee)
 * 		(riga sbagliata 1)
 * 		(riga sbagliata 2)
 * 		(riga sbagliata 3)
 * 		…
 */
package it.beije.neumann.nido.esercizicompleti;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Fraudolent {

	public static final String FILE = "./src/assignments/completi/fraudolent.csv";

	public static List<FraudolentOperation> readFile(String path) throws FileNotFoundException, IOException {
		List<FraudolentOperation> operations = new ArrayList<>();

		FileReader fRead = new FileReader(path);
		BufferedReader bufRead = new BufferedReader(fRead);

		try {
			String row = null;
			String[] fields = null;
			FraudolentOperation operation = null;

			while (bufRead.ready()) {
				row = bufRead.readLine();
				fields = row.split(" ");

				operation = new FraudolentOperation();

				operation.setAction(fields[0]);
				operation.setCost(Double.parseDouble(fields[1]));
				operation.setQuantity(Integer.parseInt(fields[2]));
				operation.setOperation(fields[3].charAt(0));

				operations.add(operation);
			}
		} catch (IOException ioEx) {
			ioEx.printStackTrace();
		} finally {
			bufRead.close();
		}

		return operations;
	}

	public static String calculateImport(List<FraudolentOperation> operations) {
		String result = "Op: (nn) Buy: (bb) Sell: (ss)";
		double totalImportB = 0.0;
		double totalImportS = 0.0;

		for (FraudolentOperation op : operations) {
			switch (op.getOperation()) {
			case 'S':
				totalImportS += op.getCost();
				break;

			case 'B':
				totalImportB += op.getCost();
				break;
			}
		}

		result = result.replace("(nn)", Integer.toString(operations.size()));
		result = result.replace("(bb)", Double.toString(totalImportB));
		result = result.replace("(ss)", Double.toString(totalImportS));

		return result;
	}

	public static void main(String[] args) {
		
		//fillFile();

		try {
			List<FraudolentOperation> fraudolent = readFile(FILE);
			System.out.println("Operazioni lette:\n"+fraudolent);

			System.out.println(calculateImport(fraudolent));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// Utilità: scrittura su file
	public static void writeOnFile(String path, List<FraudolentOperation> operations) throws IOException {

		File file = new File(path);
		FileWriter fW = null;

		if (file.exists()) {
			fW = new FileWriter(file, true); // Append
		} else {
			fW = new FileWriter(file); // Riscrive
		}

		for (FraudolentOperation operation : operations) {
			fW.write(operation.toString() + "\n");
		}

		fW.flush();
		fW.close();

	}

	public static FraudolentOperation createOperation() {
		FraudolentOperation frOp = new FraudolentOperation();
		String line = null;

		Scanner in = new Scanner(System.in);

		System.out.print("Inserisci l'azione: ");
		line = in.nextLine();
		frOp.setAction(line.toUpperCase());

		System.out.print("Inserisci l'importo: ");
		line = in.nextLine();
		frOp.setCost(Double.parseDouble(line));

		System.out.print("Inserisci la quantità: ");
		line = in.nextLine();
		frOp.setQuantity(Integer.parseInt(line));

		System.out.print("Inserisci l'operazione (B/S): ");
		line = in.nextLine();
		frOp.setOperation(line.toUpperCase().charAt(0));

		System.out.println();

		return frOp;
	}

	public static List<FraudolentOperation> addOperations(int number) {
		List<FraudolentOperation> operations = new ArrayList<>();
		FraudolentOperation operation = null;

		for (int i = 0; i < number; i++) {
			operation = createOperation();
			operations.add(operation);
		}

		return operations;
	}

	public static void fillFile() {
		List<FraudolentOperation> fraudList = addOperations(4);

		try {
			writeOnFile(FILE, fraudList);
		} catch (IOException ioEx) {
			ioEx.printStackTrace();
		}

		System.out.println(fraudList);
	}

}
