package it.beije.neumann.parserxml.andreotti_mongiello;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) throws IOException {
//		String path = "/Users/francescoandreotti/git/AcademyJavaXVI/Esercizi/src/it/beije/neumann/parserxml/andreotti_mongiello/test_parser1.xml";
//		File file = new File(path);
//		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
//			String xml = "";
//			String st;
//			while ((st = br.readLine()) != null) {
//				xml = xml + st;
//				System.out.println(st);
//			}
//      
//			getRootElement(xml);
//			try {
//				StringBuilder fileContent = XmlParser.fromFileToString(path);
//				//System.out.println(fileContent);
//				List<String> listTag = XmlParser.listTag( path );
//				String rootElement = XmlParser.getRootElement( listTag );
//				System.out.println("Root element: " + rootElement);
//				System.out.println(listTag);
//				getChildElements(listTag,"contatto");
//				
//				
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
		boolean test = isEndTag("contatto", "contatto");
		System.out.println(test);
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
	
	public static void getChildElements(List<String> elements, String name) {
//		List<String> childElements = new ArrayList<String>();
		outerloop:
		for (int i = 0; i < elements.size(); i++) {
			if(elements.get(i).equals(name)) {
				for(int k = 0; k < elements.size(); k++) {
					
				}
				break outerloop;
			}
		}
	}
	
	public static boolean isEndTag(String tag, String primaryElement) {
		String[] splitted = tag.split("");
		splitted[0] = "";
		tag = String.join("", splitted);
		return tag.equals(primaryElement);
	}
}
