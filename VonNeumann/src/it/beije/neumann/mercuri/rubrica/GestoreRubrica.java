package it.beije.neumann.mercuri.rubrica;

import java.util.Scanner;

public class GestoreRubrica {

	static void addContatto() {}
	
	static void deleteContatto() {}
	
	static void modifyContatto() {}
	
	static void searchContatto () {}
	
	static void viewContatti () {}
	
	static void searchCopie() {
		// TODO Auto-generated method stub
		
	}
	private static void mergeCopie() {
		// TODO Auto-generated method stub
		
	}
	
	private static void importFile() {
		// TODO Auto-generated method stub
		
	}
	
	private static void exportDB() {
		// TODO Auto-generated method stub
		
	}

	static void menuRubrica () {
		
		System.out.println("digita 'help' per i comandi");
		
		Scanner sc = new Scanner(System.in);
		String azione = null;
		while (azione != "exit") {
					
			System.out.println("cosa vuoi fare?");
			
			if (azione == "help") {
				System.out.println("view -> visualizza i contatti");
				System.out.println("add -> aggiunge un contatto");
				System.out.println("delete -> cancella un contatto");
//				System.out.println("view -> visualizza i contatti");
//				System.out.println("view -> visualizza i contatti");
//				System.out.println("view -> visualizza i contatti");
			}
			
			azione = sc.next();
			
			switch (azione) {
			
				case "view" : viewContatti(); 
				break;
				case "search": searchContatto(); 
				break;
				case "delete": deleteContatto(); 
				break;
				case "update": modifyContatto(); 
				break;
				case "add": addContatto();
				break;
				case "search duplicates": searchCopie();
				break;
				case "merge duplicates": mergeCopie();
				break;
				case "import": importFile();
				break;
				case "export": exportDB();
				break;
				case "exit": System.out.println("chiusura gestore rubrica..."); return;
				default: System.out.println("non ho capito, riprova");
			
			}
		}
		
		sc.close();
	}
	

	public static void main(String[] args) {
	
		menuRubrica();
	}

}
