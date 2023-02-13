package it.beije.neumann.parserxml.elassl_verzaschi;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class progParser { // gestisci /> 
	//public static Element readElement()
	public static Element readName(String str) {
		Element current = null;
		String[] split=str.split(">");
		String first=split[0];
		String text=split.length==2?split[1]:"";
		if (first=="") return null;
		if(first.charAt(0)=='/') {
			//System.out.println("	Chiusura "+first.substring(1,first.length()));
			String tagName= first.split(" ")[0];
		}
		else {
			//System.out.println("	Apertura "+first);
			String tagName= first.split(" ")[0];
			String allAttributes= first.substring(tagName.length());
			//System.out.println("	tagname: "+tagName);
			Attribute [] attributes = {};
			if(allAttributes!="" && allAttributes.split(" ").length>1) { // se ha attributi
				
				String [] arrs = allAttributes.split("=\"|\"");
				attributes= new Attribute[arrs.length/2];
				boolean isKey = true;
				String key="";
				String value="";
				for(int i=0; i<arrs.length; i++) {
					
					Attribute attribute= new Attribute();
					if (isKey) {
						key=arrs[i].strip();
					}
					else {
						value=arrs[i].strip();
						attribute.setKey(key);
						attribute.setValue(value);
						attributes[i/2]=attribute;
						//System.out.println("	"+attribute);
					}
					isKey=!isKey;
					
				}
			}
			current = new Element(tagName, text, attributes);
		
		}
		
		
		return current;
		
	}
	public static DocumentEV parse(String file)  throws FileNotFoundException, IOException { 
		DocumentEV result = new DocumentEV();
		String s="";
		try(FileReader fileReader = new FileReader(file); BufferedReader bufferedReader = new BufferedReader(fileReader);){
			while (bufferedReader.ready()) {
				s+=bufferedReader.readLine();
			}
		}catch (IOException ioEx) {
			ioEx.printStackTrace();
			throw ioEx;
		}
		String[] split=s.split("<");
		List<Element> fifo = new ArrayList<>();
		Element current=null;
		boolean ignore=false;
		boolean isClosed=false; //true if it's closed in place
		for(String str : split) {
			//System.out.println(" ");
			if (str.length()>2 && str.substring(0,3).equals("!--")) ignore=true;
			if (str.length()>2 && str.endsWith("-->")) {
				ignore=false;
				continue;
			}
			if (ignore) continue;
			if(str.equals("")) continue;
			String str2= str.strip();
			//System.out.println("Str: "+str);
			if (str2.length()>3 && !str2.substring(0,4).equals("?xml")) { 
				//System.out.println(str2);
				current = readName(str2);
			}
			
			if (current!=null && str2.strip().endsWith("/>") && str2.strip().charAt(0)!='/') { //closed in place
				isClosed=true;
				current.setTagName(current.getTagName().replace("/", ""));
			}
			
			if (result.getRootElement()==null && current!=null) { //initialize root element
				//System.out.println("#ROOT:"+current);
				result.setRootElement(current);
			}
			if (current!=null){
				if (fifo.size()==0) fifo.add(current); //add current to empty list
				else { //aggiorno figlio dell'ultimo elemento in coda e aggiungo current
					fifo.get(fifo.size()-1).addChildNode(current);
					//System.out.println("#TAG PARENT:"+fifo.get(fifo.size()-1));
					fifo.add(current);
					//System.out.println("#APERTURA TAG:"+fifo.get(fifo.size()-1));
				}
			}
			if((result.getRootElement()!=null && current==null) || isClosed && result.getRootElement()!=null) { //closed tag
				//System.out.println("#CHIUSURA TAG:"+fifo.get(fifo.size()-1));
				fifo.remove(fifo.size()-1);
			}
			isClosed=false;
		}
		if (!fifo.isEmpty()) {
			throw new IllegalArgumentException("Invalid XML format"); 
		}
		return result;
	}
	public static void expandDocument(DocumentEV document) {
		List<Element> fifo = new ArrayList<>();
		fifo.add(document.getRootElement());
		String depth="";
		System.out.println("Document structure:");
		while(!fifo.isEmpty()) {
			Element current = fifo.remove(fifo.size()-1);
			if(current==null) {
				depth = depth.substring(0,depth.length()-2);
				continue;
			}
			System.out.println(depth+current);
			depth+="  ";
			List<Element> childrenElements = current.getChildElements();
			Collections.reverse(childrenElements);
			if(!(childrenElements.size()>0)) {
				depth.substring(0,depth.length()-2);
			}
			fifo.add(null);
			for(Element child: childrenElements) {
				fifo.add(child);
			}
		}
	}
	
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		DocumentEV document = parse("C:\\Users\\mm\\git\\AcademyJavaXVI\\VonNeumann\\src\\it\\beije\\neumann\\parserxml\\elassl_verzaschi\\test_parser6.xml");
		Element root = document.getRootElement();
		List<Node> childNodes = root.getChildNodes();
		List<Element> childElements = root.getChildElements();
		Element[] contatto = root.getElementsByTagName("contatto");
		String rootTagName = root.getTagName();
		String toorText = root.getTextContent();
		Attribute[] rootAttributes= root.getAttributes();
		String rootAttribute = root.getAttribute("");
		expandDocument(document);
		
	}

}
