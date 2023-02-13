package it.beije.neumann.parserxml.andreotti_mongiello;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Test {

	public static void main(String[] args) throws IOException {
		File file = new File("/Users/francescoandreotti/git/AcademyJavaXVI/Esercizi/src/it/beije/neumann/parserxml/andreotti_mongiello/test_parser1.xml");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String xml = "";
        String st;
        while ((st = br.readLine()) != null) {
        	xml = xml + st;
        	System.out.println(st);
        }
       
        getRootElement(xml);
	}
	
	public static String getRootElement(String st) {
		String root = "";
		String[] arr = st.split("");
		outerloop: 
		for (int i = 0; i < st.length(); i++) {
			if(arr[i].equals("<") && !arr[i + 1].equals("?")) {
				for (int k = 0; k < st.length(); k++){
					if(arr[i + 1].equals(">")) {
						break outerloop;
					}
					i++;
					root = root + arr[i];
				}
			}
		}
		System.out.println("Root: " + root);
		return root;
	}
}
