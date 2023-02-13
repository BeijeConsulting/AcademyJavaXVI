package it.beije.neumann.parserxml.andreotti_mongiello;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class XmlParser {
	
	
	//metodo che legge da un file tutti i caratteri e ritorna una stringBuilder
	public static StringBuilder fromFileToString(String path) throws IOException {
		
		//variabile sulla quale memorizzare il contenuto del file 
		StringBuilder contenuto = new StringBuilder();
		FileReader fileReader = new FileReader(path);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		while( bufferedReader.ready() ) {
			contenuto.append(bufferedReader.readLine());
			contenuto.append("\n");
		}
		
		return contenuto;
	}
	
	
	public static boolean isHeadingTag(String row) {
//        if( ( (row.charAt(0) == '<') && (row.charAt(1) == '?')) || (row.substring(0, 4).equals("?xml")) )  {
//            return true;
//        }else {
//            return false;
//        }
		
		return ((row.charAt(0) == '<') && (row.charAt(1) == '?')) || (row.substring(0, 4).equals("?xml"));
    }
	
	public static  List<String> listTag( String path ) throws IOException{
		StringBuilder stringFile = fromFileToString(path);
		StringBuilder element = new StringBuilder();
		
		List<String> listTag = new ArrayList<>();
		
		boolean isInsideTag = false;
		
		for( int i = 0; i< stringFile.length(); i++ ) {
			 switch(stringFile.charAt(i)) {
             case '<':
                 element.delete(0, element.length() );
                 isInsideTag = true;
                 break;

             case '>':
                 isInsideTag = false;
                 listTag.add(element.toString());
                 break;

             default:
                 if(isInsideTag) element.append(stringFile.charAt(i));
                 break;
			 }
		}
		
        if( isHeadingTag(listTag.get(0)) ){
            listTag.remove(0);
        }
        
	return listTag;	
	}
	
	public static String getRootElement( List<String> listTag ) {
		String rootElement = listTag.get(0).toString();
		
		return rootElement;
	}

	public static List<String> getChildElements(String path,String parent) throws IOException{
		
			
		
		return null;
		
	}

	
	public static List<String> getChildNodes(String path, String parent) throws IOException {
		List<String> listTag = XmlParser.listTag( path );
		//List<String> listAppoggio = new ArrayList<>();
		
		List<String> listChildElement = new ArrayList<>();
		
		boolean aggiungo = false;
		
		for( int i = 0; i < listTag.size() ; i++){
			if( listTag.get(i).equalsIgnoreCase(parent) ) {
				aggiungo = true;
				i++;
			}	
			if(aggiungo) listChildElement.add( listTag.get(i));
		}
		
		
		System.out.println(listChildElement);	
		//Controllo se il parametro in in ingresso ha figli
		if( listChildElement.get(0).contains("/")) {
			return null;
		}
			
		for( int i = 0; i < listChildElement.size() ; i++ ) {
			
			if( listChildElement.get(i).indexOf('/') != -1  ){
				listChildElement.remove(i);
					i=0;
			}		
		}
		
	
		
		
		System.out.println(listChildElement);	
		return listChildElement;
	}
	
//	public static List<String> getChildElements(List<String> elements, String name) {
//		List<String> childElements = new ArrayList<String>();
//
//		outerloop:
//		for (int i = 0; i < elements.size(); i++) {
//			if(elements.get(i).equals(name)) {
//				for(int k = 0; k < elements.size(); k++) {
//					i++;
//					if(isEndTag(elements.get(i), name)) {
//						break outerloop;
//					}
//					childElements.add(elements.get(i));
//				}
//				
//			}
//		}
//		return childElements;
//	}
	
	public static boolean isEndTag(String tag, String primaryElement) {
		String[] splitted = tag.split("");
		splitted[0] = "";
		tag = String.join("", splitted);
		return tag.equals(primaryElement);
	}
	
}
