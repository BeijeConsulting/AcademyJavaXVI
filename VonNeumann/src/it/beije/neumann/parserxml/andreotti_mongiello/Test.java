package it.beije.neumann.parserxml.andreotti_mongiello;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) throws IOException {
		String path = "/Users/francescoandreotti/git/AcademyJavaXVI/Esercizi/src/it/beije/neumann/parserxml/andreotti_mongiello/test_parser1.xml";
		File file = new File(path);
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String xml = "";
			String st;
			while ((st = br.readLine()) != null) {
				xml = xml + st;
				System.out.println(st);
			}
      
			getRootElement(xml);
			try {
				StringBuilder fileContent = XmlParser.fromFileToString(path);
				List<String> listTag = XmlParser.listTag( path );
				XmlParser.getRootElement( listTag );
				getChildElements(listTag,"contatto");
				
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		isEndTag("contatto", "contatto");
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
		return root;
	}
	
	public static void getChildNodes(List<String> elements, String name) {
		List<String> childElements = new ArrayList<String>();
		outerloop:
		for (int i = 0; i < elements.size(); i++) {
			if(elements.get(i).equals(name)) {
				for(int k = 0; k < elements.size(); k++) {
					i++;
					if(isEndTag(elements.get(i), name)) {
						break outerloop;
					}
					childElements.add(elements.get(i));
				}
				
			}
		}
		System.out.println(childElements);
	}
	
	public static void getChildElements(List<String> elements, String parent) {
		List<String> childElements = new ArrayList<String>();
		
		outerloop:
			for(int i = 0; i < elements.size(); i++) {
				
			}
	}
	
	
	
	
	public static boolean isEndTag(String tag, String primaryElement) {
		String[] splitted = tag.split("");
		splitted[0] = "";
		tag = String.join("", splitted);
		return tag.equals(primaryElement);
	}
	
	public static List<String> getChildNodes(String path, String parent) throws IOException {
		List<String> listTag = XmlParser.listTag( path );
		//List<String> listAppoggio = new ArrayList<>();
		
		List<String> listChildElement = new ArrayList<>();
		
		boolean aggiungo = false;
		String currentTag = "";
		for( int i = 0; i < listTag.size() ; i++){
			if( listTag.get(i).equalsIgnoreCase(parent) ) {
				aggiungo = true;
				i++;
			}	
			if(Test.isEndTag(listTag.get(i), currentTag)) {
				
				currentTag = "";
			}
			if(aggiungo && currentTag.equals("")) { 
				if(listTag.get(i).charAt(0) != '/') {
					currentTag = listTag.get(i);	
				}
				listChildElement.add( listTag.get(i));
			}
		}
		
		
		System.out.println(listChildElement);	
		
		for( int i = 0; i < listChildElement.size() ; i++ ) {
			if( listChildElement.get(i).indexOf('/') != -1  ){
				listChildElement.remove(i);
					i=0;
			}		
		}
		
	
		
		
		System.out.println(listChildElement);	
		return listChildElement;
	}
}
